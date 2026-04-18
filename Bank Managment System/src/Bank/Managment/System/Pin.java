package Bank.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    // Buttons
    JButton b1, b2;

    // Password Fields
    JPasswordField p1, p2;

    // Current PIN
    String pin;

    // Constructor
    Pin(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1300, 700);
        add(background);

        // ---------------- TITLE ----------------
        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setBounds(430, 140, 250, 30);
        background.add(label1);

        // ---------------- NEW PIN ----------------
        JLabel label2 = new JLabel("New PIN:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setBounds(350, 200, 150, 25);
        background.add(label2);

        p1 = new JPasswordField();
        p1.setBounds(500, 200, 180, 25);
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(p1);

        // ---------------- RE-ENTER PIN ----------------
        JLabel label3 = new JLabel("Re-Enter New PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        label3.setBounds(350, 250, 170, 25);
        background.add(label3);

        p2 = new JPasswordField();
        p2.setBounds(500, 250, 180, 25);
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(p2);

        // ---------------- CHANGE BUTTON ----------------
        b1 = new JButton("CHANGE");
        b1.setBounds(610, 310, 100, 30);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        background.add(b1);

        // ---------------- BACK BUTTON ----------------
        b2 = new JButton("BACK");
        b2.setBounds(610, 350, 100, 30);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        background.add(b2);

        // ---------------- FRAME SETTINGS ----------------
        setSize(1300, 700);
        setLayout(null);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // BACK BUTTON
            if (e.getSource() == b2) {

                setVisible(false);
                new Main_Class(pin);
                return;
            }

            // Get PIN values
            String pin1 = String.valueOf(p1.getPassword()).trim();
            String pin2 = String.valueOf(p2.getPassword()).trim();

            // Empty Validation
            if (pin1.equals("")) {

                JOptionPane.showMessageDialog(null, "Enter New PIN");
                return;
            }

            if (pin2.equals("")) {

                JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                return;
            }

            // Only 4 digits
            if (!pin1.matches("\\d{4}")) {

                JOptionPane.showMessageDialog(null, "PIN must be 4 digits");
                return;
            }

            // Match Validation
            if (!pin1.equals(pin2)) {

                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            // Update PIN in Database
            Conn c = new Conn();

            String q1 = "UPDATE bank SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
            String q2 = "UPDATE login SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
            String q3 = "UPDATE signupthree SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";

            c.statement.executeUpdate(q1);
            c.statement.executeUpdate(q2);
            c.statement.executeUpdate(q3);

            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

            setVisible(false);
            new Main_Class(pin1);

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to Change PIN");
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new Pin("");
    }
}