import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener{
    String formno;
    JComboBox<String> combo1, combo2, combo3, combo4, combo5;
    JTextField textPan, textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;

    Signup2(String formno) {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bank = new JLabel(i3);
        bank.setBounds(150, 5, 100, 100);
        add(bank);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 :- Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Religion :");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 120, 100, 30);
        add(l2);

        String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        combo1 = new JComboBox<>(religion);
        combo1.setBackground(new Color(252, 208, 76));
        combo1.setFont(new Font("Raleway", Font.BOLD, 14));
        combo1.setBounds(350, 120, 320, 30);
        add(combo1);

        JLabel l3 = new JLabel("Category :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 170, 100, 30);
        add(l3);

        String[] category = {"General", "OBC", "SC", "ST", "Other"};
        combo2 = new JComboBox<>(category);
        combo2.setBackground(new Color(252, 208, 76));
        combo2.setFont(new Font("Raleway", Font.BOLD, 14));
        combo2.setBounds(350, 170, 320, 30);
        add(combo2);

        JLabel l4 = new JLabel("Income :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 220, 100, 30);
        add(l4);

        String[] income = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        combo3 = new JComboBox<>(income);
        combo3.setBackground(new Color(252, 208, 76));
        combo3.setFont(new Font("Raleway", Font.BOLD, 14));
        combo3.setBounds(350, 220, 320, 30);
        add(combo3);

        JLabel l5 = new JLabel("Educational :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 270, 150, 30);
        add(l5);

        String[] educational = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        combo4 = new JComboBox<>(educational);
        combo4.setBackground(new Color(252, 208, 76));
        combo4.setFont(new Font("Raleway", Font.BOLD, 14));
        combo4.setBounds(350, 270, 320, 30);
        add(combo4);

        JLabel l6 = new JLabel("Occupation :");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 320, 150, 30);
        add(l6);

        String[] occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        combo5 = new JComboBox<>(occupation);
        combo5.setBackground(new Color(252, 208, 76));
        combo5.setFont(new Font("Raleway", Font.BOLD, 14));
        combo5.setBounds(350, 320, 320, 30);
        add(combo5);

        JLabel l7 = new JLabel("PAN Number :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 370, 150, 30);
        add(l7);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 18));
        textPan.setBounds(350, 370, 320, 30);
        add(textPan);

        JLabel l8 = new JLabel("Aadhar Number :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 420, 200, 30);
        add(l8);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        textAadhar.setBounds(350, 420, 320, 30);
        add(textAadhar);

        JLabel l9 = new JLabel("Senior Citizen :");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 470, 200, 30);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(252, 208, 76));
        r1.setBounds(350, 470, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(252, 208, 76));
        r2.setBounds(460, 470, 100, 30);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel l10 = new JLabel("Existing Account :");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 520, 200, 30);
        add(l10);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBackground(new Color(252, 208, 76));
        e1.setBounds(350, 520, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBackground(new Color(252, 208, 76));
        e2.setBounds(460, 520, 100, 30);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l11 = new JLabel("Form No : ");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700, 10, 100, 30);
        add(l11);

        JLabel l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770, 10, 60, 30);
        add(l12);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setBounds(570, 600, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(252, 208, 76));
        setLayout(null);
        setSize(850, 750);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) combo1.getSelectedItem();
        String cat = (String) combo2.getSelectedItem();
        String inc = (String) combo3.getSelectedItem();
        String edu = (String) combo4.getSelectedItem();
        String occ = (String) combo5.getSelectedItem();
        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = null;
        if(r1.isSelected()) {
            scitizen = "Yes";
        } else if(r2.isSelected()) {
            scitizen = "No";
        }

        String eaccount = null;
        if(e1.isSelected()) {
            eaccount = "Yes";
        } else if(e2.isSelected()) {
            eaccount = "No";
        }

        try {
            if(textPan.getText().equals("") || textAadhar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the Fields");
            } else {
                Conn c1 = new Conn();
                String q = "insert into signuptwo values('"+formno+"', '"+rel+"', '"+cat+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eaccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch(Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}