import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("images/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1315, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1315, 700);
        add(label);

        JLabel l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setBounds(400, 150, 400, 35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 17));
        label.add(l1);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(350, 225, 150, 35);
        b1.addActionListener(this);
        label.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(570, 225, 150, 35);
        b2.addActionListener(this);
        label.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(350, 268, 150, 35);
        b3.addActionListener(this);
        label.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(570, 268, 150, 35);
        b4.addActionListener(this);
        label.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(350, 311, 150, 35);
        b5.addActionListener(this);
        label.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Arial", Font.BOLD, 11));
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(570, 311, 150, 35);
        b6.addActionListener(this);
        label.add(b6);

        b7 = new JButton("BACK");
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
        if(e.getSource() == b7) {
            setVisible(false);
            new main_Class(pin);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            Date date = new Date();
            try {
                ResultSet res = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(res.next()) {
                    if(res.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(res.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(res.getString("amount"));
                    }
                }

                if(e.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                } 

                c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'withdraw', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+"Withdrawed Successfully");
            } catch(Exception E) {
                E.printStackTrace();
            }

            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }   
}