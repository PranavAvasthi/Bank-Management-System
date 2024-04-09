import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener{
    String pin;
    JButton b1,b2;
    JPasswordField p1,p2;
    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("images/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1315, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1315, 700);
        add(label);
        
        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(395, 150, 400, 35);
        l1.setForeground(Color.WHITE);
        label.add(l1);

        JLabel l2 = new JLabel("New PIN : ");
        l2.setFont(new Font("System", Font.BOLD, 14));
        l2.setBounds(395, 190, 150, 25);
        l2.setForeground(Color.WHITE);
        label.add(l2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(530, 190, 150, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(p1);

        JLabel l3 = new JLabel("Re-Enter New PIN : ");
        l3.setFont(new Font("System", Font.BOLD, 14));
        l3.setBounds(395, 220, 400, 25);
        l3.setForeground(Color.WHITE);
        label.add(l3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(530, 220, 150, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(p2);

        b1 = new JButton("CHANGE");
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
        setLocation(0, 0);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = String.valueOf(p1.getPassword());
            String pin2 = String.valueOf(p2.getPassword());

            if(!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(e.getSource() == b1) {
                if(String.valueOf(p1.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if(String.valueOf(p2.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new main_Class(pin);
            } else if(e.getSource() == b2) {
                new main_Class(pin);
                setVisible(false);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }   
}