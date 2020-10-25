import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;

public class GameConfigs {
    private Random random = new Random();
    private JButton[] buttonArray;
    private JFrame frame = new JFrame();
    private ImageIcon image = new ImageIcon("src/files/winner.jpg");
    private JLabel popUp = new JLabel(image);

    public GameConfigs(){
        frame.setUndecorated(true);
        frame.getContentPane().add(popUp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                frame.setVisible(false);
            }
        });
    }
    public void setButtonArray(JButton[] array) {
        buttonArray = array;
    }

    public void newGame() {
        setAllEmpty();
        for (int i = 0; i < buttonArray.length - 1; i++) {
            while (buttonArray[i].getText().isEmpty()) {
                int randomNumber = random.nextInt(buttonArray.length - 1) + 1;
                boolean randomExist = checkIfRandomExist(i, randomNumber);
                if (randomExist) {
                    buttonArray[i].setText(String.valueOf(randomNumber));
                    break;
                }
            }
        }
        buttonArray[11].setEnabled(true);
        buttonArray[14].setEnabled(true);
    }

    private boolean checkIfRandomExist(int lenght, int randomNumber) {
        for (int j = 0; j < lenght; j++) {
            if (buttonArray[j].getText().equalsIgnoreCase(String.valueOf(randomNumber))) {
                return false;
            }
        }
        return true;
    }

    private void setAllEmpty() {
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setText("");
            if (i != buttonArray.length - 1) {
                buttonArray[i].setBackground(Color.red);
                buttonArray[i + 1].setBackground(Color.BLACK);
            }
        }
    }

    public void setAllFalse() {
        for (JButton jButton : buttonArray) {
            jButton.setEnabled(false);
        }
    }

    public boolean solved(){
        int count = 0;
        for (int i = 0; i < buttonArray.length - 1; i++) {
            if (buttonArray[i].getText().equalsIgnoreCase(String.valueOf(i+1)))
                count++;
        }
        return count == 15;
    }

    public void winningScreen() {
        frame.setVisible(true);
    }

}