import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Emil Johansson, Liliana Montini Pitra, CRIBB CRIBBSSON, Steffe Steffsson
 * Date: 2020-10-21
 * Time: 18:11
 * Project: Game15
 * Package: PACKAGE_NAME
 */
public class TheGrid extends JFrame {
    private JPanel grid1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button3;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JPanel grid2;
    private JRadioButton musicRadioButton;
    private JButton cheatButton;
    private JButton newGameButton;


    private JButton[] buttonArray = new JButton[]{button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13, button14, button15, button16};

    public TheGrid() {
        GameConfigs gameConfigs = new GameConfigs();
        gameConfigs.setButtonArray(buttonArray);

        Music music = new Music();
        music.addMusic();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int buttonPos = Integer.parseInt(e.getActionCommand());
                buttonPos = getClickedButton(buttonPos);
                setAllFalse();
                changeButton(buttonPos);

            }
        };

        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button9.addActionListener(listener);
        button13.addActionListener(listener);
        button14.addActionListener(listener);
        button10.addActionListener(listener);
        button11.addActionListener(listener);
        button16.addActionListener(listener);
        button12.addActionListener(listener);
        button8.addActionListener(listener);
        button15.addActionListener(listener);


        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllFalse();
                gameConfigs.newGame();
            }
        });

        cheatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        musicRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (musicRadioButton.isSelected()){
                    music.startMusic();
                }
                else{
                    music.stopMusic();
                }
            }
        });
    }


    private void changeButton(int pos) {

        int oldPos = getLastButton();
        buttonArray[oldPos].setText(buttonArray[pos].getText());
        buttonArray[oldPos].setBackground(Color.red);
        buttonArray[pos].setText("");
        buttonArray[pos].setBackground(Color.BLACK);
        int minusFour = pos - 4;
        int minusOne = pos - 1;
        int addOne = pos + 1;
        int addFour = pos + 4;

        switch (pos) {
            case 15:
                buttonArray[minusFour].setEnabled(true);
                buttonArray[minusOne].setEnabled(true);
                break;
            case 12:
                buttonArray[minusFour].setEnabled(true);
                buttonArray[addOne].setEnabled(true);
                break;
            case 0:
                buttonArray[addOne].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                break;
            case 3:
                buttonArray[minusOne].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                break;
            case 13:
            case 14:
                buttonArray[minusOne].setEnabled(true);
                buttonArray[addOne].setEnabled(true);
                buttonArray[minusFour].setEnabled(true);
                break;
            case 11:
            case 7:
                buttonArray[minusOne].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                buttonArray[minusFour].setEnabled(true);
                break;
            case 1:
            case 2:
                buttonArray[minusOne].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                buttonArray[addOne].setEnabled(true);
                break;
            case 8:
            case 4:
                buttonArray[minusFour].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                buttonArray[addOne].setEnabled(true);
                break;
            case 5:
            case 6:
            case 9:
            case 10:
                buttonArray[minusFour].setEnabled(true);
                buttonArray[minusOne].setEnabled(true);
                buttonArray[addFour].setEnabled(true);
                buttonArray[addOne].setEnabled(true);
                break;
            default:
                break;
        }

    }

    private void setAllFalse() {
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setEnabled(false);
        }
    }

    private int getLastButton() {
        for (int i = 0; i < buttonArray.length; i++) {
            if (buttonArray[i].getText().isEmpty())
                return i;
        }
        return 0;
    }

    private int getClickedButton(int pos) {
        for (int i = 0; i < buttonArray.length; i++) {
            if (buttonArray[i].getText().equalsIgnoreCase(String.valueOf(pos)))
                return i;
        }
        return 0;
    }

    public void run() {
        setContentPane(new TheGrid().grid1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public static void main(String[] args) {
        TheGrid tg = new TheGrid();
        tg.run();

    }
}
