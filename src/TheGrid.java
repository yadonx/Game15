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


    public TheGrid() {


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b1 = (JButton) e.getSource();
                if (!button16.isEnabled()){
                    button16.setText(b1.getText());
                    button16.setBackground(Color.red);
                    button16.setEnabled(true);
                    button12.setEnabled(false);
                    button15.setEnabled(false);
                }
                if (!button15.isEnabled()){
                    button15.setText(b1.getText());
                    button15.setBackground(Color.red);
                    button15.setEnabled(true);
                    button11.setEnabled(true);
                    button14.setEnabled(true);
                    button16.setEnabled(false);
                }
                b1.setEnabled(false);
                b1.setBackground(Color.black);
                b1.setText("");
            }
        };
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
        button1.addActionListener(listener);
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
