package Bank.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    // Buttons
    JButton b1, b2, b3, b4, b5, b6, b7;

    // User PIN
    String pin;

    // Constructor
    FastCash(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1300, 700);
        add(background);

        // ---------------- TITLE ----------------
        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(390, 150, 350, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(label);

        // ---------------- BUTTONS ----------------
        b1 = createButton("Rs. 100", 340, 230, background);
        b2 = createButton("Rs. 500", 565, 230, background);

        b3 = createButton("Rs. 1000", 340, 270, background);
        b4 = createButton("Rs. 2000", 565, 270, background);

        b5 = createButton("Rs. 5000", 340, 310, background);
        b6 = createButton("Rs. 10000", 565, 310, background);

        b7 = createButton("BACK", 565, 350, background);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        setSize(1300, 700);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- CREATE BUTTON ----------------
    public JButton createButton(String text, int x, int y, JLabel panel) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 35);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(65, 125, 128));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.addActionListener(this);
        panel.add(button);

        return button;
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        // ---------------- BACK ----------------
        if (e.getSource() == b7) {

            setVisible(false);
            new Main_Class(pin);
            return;
        }

        try {

            // Get Selected Amount
            String amount = ((JButton) e.getSource()).getText().replace("Rs. ", "").trim();

            int withdrawAmount = Integer.parseInt(amount);

            Conn c = new Conn();

            ResultSet resultSet = c.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pin + "'");

            int balance = 0;

            while (resultSet.next()) {

                String type = resultSet.getString("type");
                int dbAmount = Integer.parseInt(resultSet.getString("amount"));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += dbAmount;
                } else {
                    balance -= dbAmount;
                }
            }

            // Check Balance
            if (balance < withdrawAmount) {

                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // Insert Transaction
            Date date = new Date();

            c.statement.executeUpdate(
                    "INSERT INTO bank VALUES ('" + pin + "','" + date + "','Withdrawal','" + withdrawAmount + "')");

            JOptionPane.showMessageDialog(null,
                    "Rs. " + withdrawAmount + " Debited Successfully");

            setVisible(false);
            new Main_Class(pin);

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Transaction Failed");
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new FastCash("");
    }
}