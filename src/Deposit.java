import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    String pin;
    JTextField textField;
    JButton b1, b2;

    Deposit(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("images/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1315, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1315, 700);
        add(label);
        
        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(395, 150, 400, 35);
        l1.setForeground(Color.WHITE);
        label.add(l1);

        textField = new JTextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(395, 200, 280, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(570, 300, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        label.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(570, 344, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        label.add(b2);

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
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource() == b1) {
                if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Deposit");
                } else {
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            } else if(e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
