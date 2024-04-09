import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Mini extends JFrame implements ActionListener{
    String pin;
    JButton button;

    Mini(String pin) {
        this.pin = pin;

        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLayout(null);
        // setResizable(false);
        // setLocationRelativeTo();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);

        JLabel l2 = new JLabel("MINI - STATEMENT");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setBounds(130, 20, 200, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {
            Conn c = new Conn();
            ResultSet res = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(res.next()) {
                l3.setText("Card Number:  " + res.getString("card_number").substring(0,4) + "XXXXXXXX" + res.getString("card_number".substring(12)));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn c = new Conn();
            ResultSet res = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(res.next()) {
                l1.setText(l1.getText() + "<html>" + res.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + res.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + res.getString("amount") + "<br><br><html>");

                if(res.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(res.getString("amount"));
                } else {
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }

            l4.setText("Your Total Balance is Rs " + balance);
                
        } catch(Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }   
}