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

    // Skapar en "pop up" av winning screen
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

    // Länkar med TheGrids array
    public void setButtonArray(JButton[][] array) {
        buttonArray = array;
    }

    // Loopar igenom buttonArray och medan texten är tom på knapparna så ger vi alla knappar en random siffra förutom den sista knappen.
    // När man hamnar på sista knappen så bryts for loopen.
    public void newGame() {
        setAllEmpty();
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (buttonArray[3][3] == buttonArray[row][column]) {
                    break;
                }
                while (buttonArray[row][column].getText().isEmpty()) {
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

    // Loopar igenom buttonArray och kollar ifall våra nya random siffra finns i arrayen eller inte.
    // Om siffran redan finns returnerar den false annars returnerar den true
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

    // Loopar igenom buttonArray och sätter alla knappar förutom knapp 16 till en tom text och röd bakgrund
    private void setAllEmpty() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {

                buttonArray[row][column].setText("");
                buttonArray[row][column].setBackground(Color.red);
            }
        }
        buttonArray[3][3].setBackground(Color.BLACK);

    }

    // Sätter alla knappar till false
    public void setAllFalse() {
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                buttonArray[row][column].setEnabled(false);
            }
        }
    }

    // Loopar igenom buttonArray och kollar ifall siffrorna är i rätt ordning
    public boolean solved() {
        int count = 0;
        int count2 = 1;
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                if (!buttonArray[row][column].getText().equalsIgnoreCase(String.valueOf(count2++))) {
                   break;
                }
                else {
                    count++;
                }
            }
        }
        return count == 15;
    }

    // Visar vinst gifen
    public void winningScreen() {
        frame.setVisible(true);
    }

    // Tar in siffran som klickades på och byter text/bakgrund på den tomma och den klickade knappen
    public void changeButton(int pos) {
        String newButton = getClickedButton(pos);
        String lastButton = getEmptyButton();
        updateButtons(pos, newButton);    // Uppdaterar och gör till en tom knapp
        updateButtons(pos, lastButton);   // Uppdaterar och ger den tomma knappen siffran som man tidigare klickat på
        enableButtons();
    }

    // Byter plats på siffrorna och sätter motsvarande bakgrundsfärg
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

    // Loopar igenom buttonArray och letar efter den knapp som inte har någon text
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

    // Loopar igenom buttonArray och kollar vilken knapp(siffra) man klickade på och returnerar vilken position i arrayen knappen är i
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

    // Loopar igenom buttonArray och letar efter den tomma knappen och enablar närliggande knappar
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

    // Ställer klick räknaren till 0
    public int resetClickCounter(JLabel counter){
        counter.setText("Clicks: 0");
        return 0;
    }

    // Sätter alla siffror i ordning så att man kan vinna genom att flytta på knapp 15
    public void cheatButton (){
        int counter = 1;
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length ; column++) {
                buttonArray[row][column].setText(String.valueOf(counter++));
                buttonArray[row][column].setBackground(Color.RED);
            }
        }

        buttonArray[3][3].setText("15");
        buttonArray[3][3].setBackground(Color.RED);
        buttonArray[3][2].setText("");
        buttonArray[3][2].setBackground(Color.BLACK);
        enableButtons();
    }
}