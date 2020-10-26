
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
    private JRadioButton musicRadioButton;
    private JButton cheatButton;
    private JButton newGameButton;
    private JLabel counter;
    private int count = 0;

    private JButton[][] buttonArray = new JButton[][]{{button1, button2, button3, button4},
                                                      {button5, button6, button7, button8},
                                                      {button9,button10,button11,button12},
                                                      {button13, button14, button15, button16}};


    public TheGrid() {
        GameConfigs gameConfigs = new GameConfigs();
        gameConfigs.setButtonArray(buttonArray);
        Music music = new Music();
        music.addMusic();

        ActionListener listener = e -> {
            int buttonPos = Integer.parseInt(e.getActionCommand());

            gameConfigs.setAllFalse();
            gameConfigs.changeButton(buttonPos);
            if (gameConfigs.solved()){
                gameConfigs.winningScreen();
            }
            count++;
            counter.setText("Clicks: " + count);
        };

        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                buttonArray[row][column].addActionListener(listener);
            }

        }


        newGameButton.addActionListener(e -> {
            gameConfigs.setAllFalse();
            gameConfigs.newGame();
            count = gameConfigs.resetCounter(counter);
        });

        cheatButton.addActionListener(e -> {
            count = gameConfigs.resetCounter(counter);
            gameConfigs.cheatButton();
            gameConfigs.setAllFalse();
        });

        musicRadioButton.addActionListener(e -> {
            if (musicRadioButton.isSelected()){
                music.startMusic();
            }
            else{
                music.stopMusic();
            }
        });
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
