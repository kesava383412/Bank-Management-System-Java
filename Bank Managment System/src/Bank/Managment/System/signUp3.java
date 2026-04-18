package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class signUp3 extends JFrame implements ActionListener {

    // Radio Buttons
    JRadioButton r1, r2, r3, r4;

    // Check Boxes
    JCheckBox c1, c2, c3, c4, c5, c6, c7;

    // Buttons
    JButton c, s;

    // Form Number
    String formNo;

    signUp3(String formNo) {

        this.formNo = formNo;

        // ---------------- BANK IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(30, 10, 100, 100);
        add(image);

        // ---------------- HEADINGS ----------------
        JLabel label1 = new JLabel("Page 3 : Account Details");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(280, 30, 350, 30);
        add(label1);

        JLabel labelform = new JLabel("Form No : " + formNo);
        labelform.setFont(new Font("Arial", Font.BOLD, 18));
        labelform.setBounds(620, 30, 200, 30);
        add(labelform);

        // ---------------- ACCOUNT TYPE ----------------
        JLabel label2 = new JLabel("Account Type:");
        label2.setFont(new Font("Arial", Font.BOLD, 18));
        label2.setBounds(100, 140, 200, 30);
        add(label2);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        r1.setBounds(150, 180, 200, 30);
        r2.setBounds(450, 180, 220, 30);
        r3.setBounds(150, 220, 200, 30);
        r4.setBounds(450, 220, 220, 30);

        r1.setBackground(new Color(215, 252, 252));
        r2.setBackground(new Color(215, 252, 252));
        r3.setBackground(new Color(215, 252, 252));
        r4.setBackground(new Color(215, 252, 252));

        add(r1);
        add(r2);
        add(r3);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        // ---------------- CARD NUMBER ----------------
        JLabel label3 = new JLabel("Card Number:");
        label3.setFont(new Font("Arial", Font.BOLD, 18));
        label3.setBounds(100, 280, 200, 30);
        add(label3);

        JLabel label4 = new JLabel("XXXX-XXXX-XXXX-1234");
        label4.setBounds(400, 280, 250, 30);
        add(label4);

        // ---------------- PIN ----------------
        JLabel label5 = new JLabel("PIN:");
        label5.setFont(new Font("Arial", Font.BOLD, 18));
        label5.setBounds(100, 340, 200, 30);
        add(label5);

        JLabel label6 = new JLabel("XXXX");
        label6.setBounds(400, 340, 150, 30);
        add(label6);

        // ---------------- SERVICES ----------------
        JLabel label7 = new JLabel("Services Required:");
        label7.setFont(new Font("Arial", Font.BOLD, 18));
        label7.setBounds(100, 400, 250, 30);
        add(label7);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        c1.setBounds(150, 440, 200, 30);
        c2.setBounds(450, 440, 200, 30);
        c3.setBounds(150, 470, 200, 30);
        c4.setBounds(450, 470, 200, 30);
        c5.setBounds(150, 500, 200, 30);
        c6.setBounds(450, 500, 200, 30);

        c1.setBackground(new Color(215, 252, 252));
        c2.setBackground(new Color(215, 252, 252));
        c3.setBackground(new Color(215, 252, 252));
        c4.setBackground(new Color(215, 252, 252));
        c5.setBackground(new Color(215, 252, 252));
        c6.setBackground(new Color(215, 252, 252));

        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above details are correct.");
        c7.setBounds(100, 550, 500, 30);
        c7.setBackground(new Color(215, 252, 252));
        add(c7);

        // ---------------- BUTTONS ----------------
        c = new JButton("CANCEL");
        c.setBounds(220, 610, 120, 30);
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.addActionListener(this);
        add(c);

        s = new JButton("SUBMIT");
        s.setBounds(500, 610, 120, 30);
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.addActionListener(this);
        add(s);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        getContentPane().setBackground(new Color(215, 252, 252));
        setSize(850, 720);
        setLocation(250, 10);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- ACTION EVENTS ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        // -------- ACCOUNT TYPE --------
        String Atype = "";

        if (r1.isSelected())
            Atype = "Saving Account";
        else if (r2.isSelected())
            Atype = "Fixed Deposit Account";
        else if (r3.isSelected())
            Atype = "Current Account";
        else if (r4.isSelected())
            Atype = "Recurring Deposit Account";

        // -------- RANDOM CARD NUMBER --------
        Random random = new Random();

        long first12 = (Math.abs(random.nextLong()) % 900000000000L) + 1409963000000000L;
        String cardNo = String.valueOf(first12);

        int first4 = random.nextInt(9000) + 1000;
        String pin = String.valueOf(first4);

        // -------- SERVICES --------
        String fac = "";

        if (c1.isSelected())
            fac += "ATM Card, ";
        if (c2.isSelected())
            fac += "Internet Banking, ";
        if (c3.isSelected())
            fac += "Mobile Banking, ";
        if (c4.isSelected())
            fac += "Email Alerts, ";
        if (c5.isSelected())
            fac += "Cheque Book, ";
        if (c6.isSelected())
            fac += "E-Statement, ";

        try {

            // -------- SUBMIT --------
            if (e.getSource() == s) {

                if (Atype.equals("") || !c7.isSelected()) {

                    JOptionPane.showMessageDialog(null,
                            "Please select Account Type and accept declaration.");

                } else {

                    Conn conn = new Conn();

                    String sql1 = "insert into signUpthree values('" + formNo + "','" + Atype + "','" + cardNo
                            + "','" + pin + "','" + fac + "')";

                    String sql2 = "insert into login values('" + formNo + "','" + cardNo + "','" + pin + "')";

                    conn.statement.executeUpdate(sql1);
                    conn.statement.executeUpdate(sql2);

                    JOptionPane.showMessageDialog(null,
                            "Card Number: " + cardNo + "\nPIN: " + pin);

                    setVisible(false);
                    new Deposit(pin);
                }
            }

            // -------- CANCEL --------
            else if (e.getSource() == c) {

                System.exit(0);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new signUp3("");
    }
}