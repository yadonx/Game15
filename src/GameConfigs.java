import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;

public class GameConfigs {
    private Random random = new Random();
    private JButton[][] buttonArray;
    private JFrame frame = new JFrame();
    private ImageIcon image = new ImageIcon("src/files/winning.gif");
    private JLabel popUp = new JLabel(image);

    public GameConfigs() {
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

    public void setButtonArray(JButton[][] array) {
        buttonArray = array;
    }

    public void newGame() {
        setAllEmpty();
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                while (buttonArray[row][column].getText().isEmpty()) {
                    if (buttonArray[3][3] == buttonArray[row][column]) {
                        break;
                    }
                    int randomNumber = random.nextInt(15) + 1;
                    boolean randomExist = checkIfRandomExist(randomNumber);
                    if (randomExist) {
                        buttonArray[row][column].setText(String.valueOf(randomNumber));
                        break;
                    }
                }
            }
        }
        buttonArray[2][3].setEnabled(true);
        buttonArray[3][2].setEnabled(true);
    }

    private boolean checkIfRandomExist(int randomNumber) {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().equalsIgnoreCase(String.valueOf(randomNumber))) {
                    return false;
                } else if (buttonArray[row][column].getText().isEmpty()) {
                    return true;
                }
            }
        }
        return true;
    }

    private void setAllEmpty() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {

                buttonArray[row][column].setText("");
                buttonArray[row][column].setBackground(Color.red);
            }
        }
        buttonArray[3][3].setBackground(Color.BLACK);

    }

    public void setAllFalse() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                buttonArray[row][column].setEnabled(false);
            }
        }
    }

    public boolean solved() {
        int count = 0;
        int count2 = 1;
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().equalsIgnoreCase(String.valueOf(count2++))) {
                    count++;
                }
            }
        }
        return count == 15;
    }

    public void winningScreen() {
        frame.setVisible(true);
    }

    public void changeButton(int pos) {
        String newButton = getClickedButton(pos);
        String lastButton = getEmptyButton();
        updateButtons(pos, newButton);
        updateButtons(pos, lastButton);
        enableButtons();
    }

    private void updateButtons(int pos, String arrayPosition) {
        int row = Integer.parseInt(arrayPosition.substring(0, arrayPosition.indexOf(" ")));
        int column = Integer.parseInt(arrayPosition.substring(arrayPosition.indexOf(" ") + 1));
        if (buttonArray[row][column].getText().isEmpty()) {
            buttonArray[row][column].setText(String.valueOf(pos));
            buttonArray[row][column].setBackground(Color.RED);
        } else {
            buttonArray[row][column].setBackground(Color.BLACK);
            buttonArray[row][column].setText("");
        }
    }

    private String getEmptyButton() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().isEmpty()) {
                    return row + " " + column;
                }
            }
        }
        return null;
    }


    private String getClickedButton(int pos) {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().equalsIgnoreCase(String.valueOf(pos))) {
                    return row + " " + column;
                }
            }
        }
        return null;
    }

    private void enableButtons() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().isEmpty()) {

                    if (row - 1 >= 0) {
                        buttonArray[row - 1][column].setEnabled(true);
                    }
                    if (row + 1 <= 3) {
                        buttonArray[row + 1][column].setEnabled(true);
                    }
                    if (column - 1 >= 0) {
                        buttonArray[row][column - 1].setEnabled(true);
                    }
                    if (column + 1 <= 3) {
                        buttonArray[row][column + 1].setEnabled(true);
                    }
                }

            }
        }
    }



    public int resetCounter(JLabel counter){
        counter.setText("Clicks: 0");
        return 0;
    }
}