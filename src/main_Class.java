import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main_Class extends JFrame implements ActionListener{
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7;

    main_Class(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("images/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1315, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1315, 700);
        add(label);

        JLabel l1 = new JLabel("Please Select Your Transaction");
        l1.setBounds(375, 150, 400, 35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 22));
        label.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(350, 225, 150, 35);
        b1.addActionListener(this);
        label.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(570, 225, 150, 35);
        b2.addActionListener(this);
        label.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(350, 268, 150, 35);
        b3.addActionListener(this);
        label.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(570, 268, 150, 35);
        b4.addActionListener(this);
        label.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(350, 311, 150, 35);
        b5.addActionListener(this);
        label.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Arial", Font.BOLD, 11));
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(570, 311, 150, 35);
        b6.addActionListener(this);
        label.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(570, 354, 150, 35);
        b7.addActionListener(this);
        label.add(b7);

        setLayout(null);
        setSize(1500, 800);
        setLocation(0,0);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == b1) {
                new Deposit(pin);
                setVisible(false);
            } else if(e.getSource() == b7) {
                System.exit(0);
            } else if(e.getSource() == b2) {
                new Withdrawl(pin);
                setVisible(false);
            } else if(e.getSource() == b6) {
                new BalanceEnquiry(pin);
                setVisible(false);
            } else if(e.getSource() == b3) {
                new FastCash(pin);
                setVisible(false);
            } else if(e.getSource() == b5) {
                new Pin(pin);
                setVisible(false);
            } else if(e.getSource() == b4) {
                new Mini(pin);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
