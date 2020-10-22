import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Emil Johansson
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

    private JButton[] buttonArray = new JButton[]{button1,button2,button3,button4,button5,button6,
        button7,button8,button9,button10,button11,button12,button13,button14,button15,button16};

    public TheGrid() {


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int button = Integer.parseInt(e.getActionCommand());
                System.out.println(button);

                if (!buttonArray[16].isEnabled()){
                    buttonArray[12].setEnabled(true);
                    buttonArray[15].setEnabled(true);
                }

//                JButton button = tempButton(e);
//                if (!button16.isEnabled()){
//                    button16.setText(button.getText());
//                    button16.setBackground(Color.red);
//                    button16.setEnabled(true);
//                    button12.setEnabled(false);
//                    button15.setEnabled(false);
//                }
//                if (!button15.isEnabled()){
//                    button15.setText(button.getText());
//                    button15.setBackground(Color.red);
//                    button15.setEnabled(true);
//                    button11.setEnabled(true);
//                    button14.setEnabled(true);
//                    button16.setEnabled(false);
//                }
//
//                button.setEnabled(false);
//                button.setBackground(Color.black);
//                button.setText("");

            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button9.addActionListener(listener);
        button13.addActionListener(listener);
        button14.addActionListener(listener);
        button10.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button11.addActionListener(listener);
        button16.addActionListener(listener);
        button12.addActionListener(listener);
        button8.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button15.addActionListener(listener);
        button5.addActionListener(listener);

    }

    private JButton tempButton(ActionEvent e){
        JButton temp = (JButton) e.getSource();
        JButton newButton = new JButton();
        newButton.setText(temp.getText());
        newButton.setBackground(temp.getBackground());
        newButton.setFont(temp.getFont());
        return newButton;
    } // skit

    private void changeButton(int pos){
        JButton temp = buttonArray[pos-1];
        buttonArray[pos-1] = buttonArray[3];
        buttonArray[3] = temp;
    }

    private void run() {
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
