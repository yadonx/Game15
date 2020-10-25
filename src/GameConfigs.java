import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;

public class GameConfigs {
    private Random random = new Random();
    private JButton[][] buttonArray;
    private JFrame frame = new JFrame();
    private ImageIcon image = new ImageIcon("src/files/winner.jpg");
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
        setLastButton(pos);
        setClickedButton(pos).setText("");

//        int oldPos = getLastButton();
//        buttonArray[oldPos].setText(buttonArray[pos].getText());
//        buttonArray[oldPos].setBackground(Color.red);
//        buttonArray[pos].setText("");
//        buttonArray[pos].setBackground(Color.BLACK);
//        int minusFour = pos - 4;
//        int minusOne = pos - 1;
//        int addOne = pos + 1;
//        int addFour = pos + 4;

//        switch (pos) {
//            case 15:
//                buttonArray[minusFour].setEnabled(true);
//                buttonArray[minusOne].setEnabled(true);
//                break;
//            case 12:
//                buttonArray[minusFour].setEnabled(true);
//                buttonArray[addOne].setEnabled(true);
//                break;
//            case 0:
//                buttonArray[addOne].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                break;
//            case 3:
//                buttonArray[minusOne].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                break;
//            case 13:
//            case 14:
//                buttonArray[minusOne].setEnabled(true);
//                buttonArray[addOne].setEnabled(true);
//                buttonArray[minusFour].setEnabled(true);
//                break;
//            case 11:
//            case 7:
//                buttonArray[minusOne].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                buttonArray[minusFour].setEnabled(true);
//                break;
//            case 1:
//            case 2:
//                buttonArray[minusOne].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                buttonArray[addOne].setEnabled(true);
//                break;
//            case 8:
//            case 4:
//                buttonArray[minusFour].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                buttonArray[addOne].setEnabled(true);
//                break;
//            case 5:
//            case 6:
//            case 9:
//            case 10:
//                buttonArray[minusFour].setEnabled(true);
//                buttonArray[minusOne].setEnabled(true);
//                buttonArray[addFour].setEnabled(true);
//                buttonArray[addOne].setEnabled(true);
//                break;
//            default:
//                break;
//        }

    }

    private void setLastButton(int pos) {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().isEmpty()) {
                    buttonArray[row][column].setText(String.valueOf(pos));
                    buttonArray[row][column].setBackground(Color.RED);
                }

            }
        }

    }

    private JButton setClickedButton(int pos) {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[row][column].getText().equalsIgnoreCase(String.valueOf(pos))) {
                    buttonArray[row][column].setBackground(Color.BLACK);
                    return buttonArray[row][column];
                }
            }
        }
        return null;
    }
}

