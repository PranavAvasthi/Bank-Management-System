import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pin;
    JLabel l2;
    JButton b1;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("images/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1315, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1315, 700);
        add(label);
        
        JLabel l1 = new JLabel("Your Current Balance is Rs.");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(395, 150, 400, 35);
        l1.setForeground(Color.WHITE);
        label.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 14));
        l2.setBounds(395, 180, 400, 35);
        l2.setForeground(Color.WHITE);
        label.add(l2);

        b1 = new JButton("BACK");
        b1.setBounds(570, 344, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        label.add(b1);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet res = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(res.next()) {
                if(res.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(res.getString("amount"));
                } else {
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        l2.setText(""+balance);

        setLayout(null);
        setSize(1500, 800);
        setLocation(0,0);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}