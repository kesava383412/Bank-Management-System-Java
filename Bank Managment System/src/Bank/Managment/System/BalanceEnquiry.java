package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry extends JFrame implements ActionListener {

    // Labels
    JLabel labelBalance;

    // Button
    JButton back;

    // User PIN
    String pin;

    // Constructor
    public BalanceEnquiry(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1300, 700);
        add(background);

        // ---------------- TITLE ----------------
        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setBounds(390, 130, 300, 30);
        background.add(label1);

        // --------------- BALANCE LABEL ---------------
        labelBalance = new JLabel();
        labelBalance.setForeground(Color.WHITE);
        labelBalance.setFont(new Font("Arial", Font.BOLD, 18));
        labelBalance.setBounds(390, 170, 300, 30);
        background.add(labelBalance);

        // ---------------- BACK BUTTON ----------------
        back = new JButton("BACK");
        back.setBounds(630, 310, 80, 30);
        back.setBackground(new Color(65, 125, 128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.addActionListener(this);
        background.add(back);

        // ---------------- FETCH BALANCE ----------------
        loadBalance();

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        setSize(1300, 700);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- LOAD BALANCE ----------------
    public void loadBalance() {

        int balance = 0;

        try {

            Conn con = new Conn();

            ResultSet resultSet = con.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pin + "'");

            while (resultSet.next()) {

                String type = resultSet.getString("type");
                int amount = Integer.parseInt(resultSet.getString("amount"));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            labelBalance.setText("Rs. " + balance);

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading balance.");
        }
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Main_Class(pin);
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new BalanceEnquiry("");
    }
}
