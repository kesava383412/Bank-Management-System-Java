package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdraw extends JFrame implements ActionListener {

    // Input Field
    TextField t1;

    // Buttons
    JButton d, b;

    // User PIN
    String pin;

    // Constructor
    Withdraw(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1300, 700);
        add(l1);

        // ---------------- LABELS ----------------
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS. 10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        label1.setBounds(390, 130, 300, 30);
        l1.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        label2.setBounds(400, 160, 300, 30);
        l1.add(label2);

        // ---------------- AMOUNT FIELD ----------------
        t1 = new TextField();
        t1.setBounds(370, 200, 300, 30);
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(t1);

        // ---------------- WITHDRAW BUTTON ----------------
        d = new JButton("WITHDRAW");
        d.setBounds(610, 310, 110, 30);
        d.setBackground(new Color(65, 125, 128));
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Arial", Font.BOLD, 12));
        d.addActionListener(this);
        l1.add(d);

        // ---------------- CANCEL BUTTON ----------------
        b = new JButton("CANCEL");
        b.setBounds(610, 350, 110, 30);
        b.setBackground(new Color(65, 125, 128));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 12));
        b.addActionListener(this);
        l1.add(b);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        setSize(1300, 700);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- ACTION EVENT ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // ---------------- CANCEL ----------------
            if (e.getSource() == b) {
                setVisible(false);
                return;
            }

            // ---------------- WITHDRAW ----------------
            String amount = t1.getText().trim();

            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter withdrawal amount.");
                return;
            }

            int withdrawAmount = Integer.parseInt(amount);

            if (withdrawAmount <= 0) {
                JOptionPane.showMessageDialog(null, "Enter valid amount.");
                return;
            }

            if (withdrawAmount > 10000) {
                JOptionPane.showMessageDialog(null, "Maximum withdrawal limit is Rs. 10,000.");
                return;
            }

            Conn con = new Conn();

            ResultSet resultSet = con.statement.executeQuery(
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

            if (balance < withdrawAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                return;
            }

            Date date = new Date();

            con.statement.executeUpdate(
                    "INSERT INTO bank VALUES ('" + pin + "','" + date + "','Withdrawal','" + withdrawAmount + "')");

            JOptionPane.showMessageDialog(null,
                    "Rs. " + withdrawAmount + " Withdrawn Successfully.");

            t1.setText("");
            setVisible(false);
            new Main_Class(pin);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Please enter numbers only.");

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new Withdraw("");
    }
}