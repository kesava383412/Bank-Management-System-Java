package Bank.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    // User PIN
    String pin;

    // Button
    JButton button;

    // Labels
    JLabel labelTransactions, labelCard, labelBalance;

    // Constructor
    Mini(String pin) {

        this.pin = pin;

        // ---------------- FRAME SETTINGS ----------------
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(420, 620);
        setLocation(20, 20);
        setLayout(null);
        setResizable(false);

        // ---------------- BANK NAME ----------------
        JLabel labelTitle = new JLabel("BANK MANAGEMENT SYSTEM");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 16));
        labelTitle.setBounds(90, 20, 250, 25);
        add(labelTitle);

        // ---------------- CARD NUMBER ----------------
        labelCard = new JLabel();
        labelCard.setFont(new Font("Arial", Font.BOLD, 13));
        labelCard.setBounds(20, 70, 350, 20);
        add(labelCard);

        // ---------------- TRANSACTIONS ----------------
        labelTransactions = new JLabel();
        labelTransactions.setFont(new Font("Arial", Font.PLAIN, 12));
        labelTransactions.setBounds(20, 120, 360, 300);
        add(labelTransactions);

        // ---------------- BALANCE ----------------
        labelBalance = new JLabel();
        labelBalance.setFont(new Font("Arial", Font.BOLD, 14));
        labelBalance.setBounds(20, 450, 350, 20);
        add(labelBalance);

        // ---------------- EXIT BUTTON ----------------
        button = new JButton("EXIT");
        button.setBounds(20, 520, 100, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        // ---------------- LOAD DATA ----------------
        loadCardDetails();
        loadTransactions();

        setVisible(true);
    }

    // ---------------- LOAD CARD NUMBER ----------------
    public void loadCardDetails() {

        try {

            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM login WHERE pin = '" + pin + "'");

            if (rs.next()) {

                String cardNo = rs.getString("card_no");

                String maskedCard = cardNo.substring(0, 4)
                        + "XXXXXXXX"
                        + cardNo.substring(12);

                labelCard.setText("Card Number : " + maskedCard);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            labelCard.setText("Card Number : Not Available");
        }
    }

    // ---------------- LOAD TRANSACTIONS ----------------
    public void loadTransactions() {

        try {

            int balance = 0;
            String data = "<html>";

            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pin + "'");

            while (rs.next()) {

                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                data += date + " &nbsp;&nbsp; "
                        + type + " &nbsp;&nbsp; Rs. "
                        + amount + "<br><br>";

                int amt = Integer.parseInt(amount);

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amt;
                } else {
                    balance -= amt;
                }
            }

            data += "</html>";

            labelTransactions.setText(data);
            labelBalance.setText("Total Balance : Rs. " + balance);

        } catch (Exception ex) {

            ex.printStackTrace();
            labelTransactions.setText("No Transactions Found");
        }
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new Mini("");
    }
}