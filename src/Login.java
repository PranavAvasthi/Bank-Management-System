import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JLabel label1, label2, label3;
    JTextField text;
    JPasswordField pass;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(getClass().getResource("images/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bank = new JLabel(i3);
        bank.setBounds(350, 10, 100, 100);
        add(bank);

        ImageIcon ii1 = new ImageIcon(getClass().getResource("images/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel card = new JLabel(ii3);
        card.setBounds(630, 350, 100, 100);
        add(card);

        label1 = new JLabel("WELCOME TO BANK");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        label2 = new JLabel("CARD :");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        text = new JTextField(15);
        text.setBounds(325, 190, 230, 30);
        text.setFont(new Font("Arial", Font.BOLD, 14));
        text.setBorder(null);
        add(text);

        label3 = new JLabel("PIN :");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        pass = new JPasswordField(15);
        pass.setBounds(325, 250, 230, 30);
        pass.setFont(new Font("Arial", Font.BOLD, 14));
        pass.setBorder(null);
        add(pass);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 300, 100, 30);
        button1.setBorder(null);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 300, 100, 30);
        button2.setBorder(null);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300, 350, 230, 30);
        button3.setBorder(null);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(getClass().getResource("/images/background.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel bg = new JLabel(iii3);
        bg.setBounds(0, 0, 850, 480);
        add(bg);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 480);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == button1) {
                Conn c = new Conn();
                String cardno = text.getText();
                String pin = String.valueOf(pass.getPassword());
                
                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet res = c.statement.executeQuery(q);
                if(res.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } else if(e.getSource() == button2) {
                text.setText("");
                pass.setText("");
            } else if(e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}