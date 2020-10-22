import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameConfigs {
    private Random random = new Random();
    private JButton[] buttonArray;

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

}
