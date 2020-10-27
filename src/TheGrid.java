
import javax.swing.*;
import java.awt.event.*;
/**
 * Created by Emil Johansson, Liliana Montini Pitra, Christoffer Grännby
 * Date: 2020-10-21
 * Time: 18:11
 * Project: Game15
 */
public class TheGrid extends JFrame {
    private JPanel grid;
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
    private JLabel timeCounter;
    private JLabel clickCounter;
    private int count = 0;
    public int seconds;
    public int minutes;
    private Timer timer;

    private JButton[][] buttonArray = new JButton[][]{{button1, button2, button3, button4},
                                                      {button5, button6, button7, button8},
                                                      {button9,button10,button11,button12},
                                                      {button13, button14, button15, button16}};

    public TheGrid() {
        GameConfigs gameConfigs = new GameConfigs();
        gameConfigs.setButtonArray(buttonArray);
        Music music = new Music();
        music.addMusic();

        // ActionListener för alla knappar med siffror
        ActionListener gameTileListener = e -> {
            int buttonPos = Integer.parseInt(e.getActionCommand()); // Tar texten från knappen som man klickar på och parsar
            gameConfigs.setAllFalse();
            gameConfigs.changeButton(buttonPos);
            if (gameConfigs.solved()) {
                timer.stop();
                gameConfigs.winningScreen();
            }
            count++;
            clickCounter.setText("Clicks: " + count);
        };

        // Lägger till actionListener för alla knappar med siffror
        for (int row = 0; row < buttonArray.length; row++) {
            for (int column = 0; column < buttonArray[row].length; column++) {
                buttonArray[row][column].addActionListener(gameTileListener);
            }
        }



        newGameButton.addActionListener(e -> {
            gameConfigs.setAllFalse();
            gameConfigs.newGame();
            count = gameConfigs.resetClickCounter(clickCounter);
            count = gameConfigs.resetClickCounter(clickCounter);
            startTimeCounter();

        });

        cheatButton.addActionListener(e -> {
            count = gameConfigs.resetClickCounter(clickCounter);
            gameConfigs.setAllFalse();
            gameConfigs.cheatButton();

        });

        musicRadioButton.addActionListener(e -> {
            if (musicRadioButton.isSelected()) {
                music.startMusic();
            } else {
                music.stopMusic();
            }
        });

        // Tidräknare för spelad tid
        ActionListener countingTime = e -> {
            String zero = "";
            if (seconds < 59) {
                seconds++;
                if (seconds < 10)
                    zero = "0";
            } else {
                zero = "0";
                seconds = 0;
                minutes++;
            }
            timeCounter.setText("Time: " + minutes + ":" + zero + seconds);
        };
        timer = new Timer(1000, countingTime);
    }

    // Startmetod för tidräknaren
    private void startTimeCounter (){
        seconds = 0;
        minutes = 0;
        timer.start();
    }

    // Startar programmet
    public void run() {
        setContentPane(new TheGrid().grid);
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
