package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener {

    // Input Field
    TextField t1;

    // Buttons
    JButton d, b;

    // User PIN
    String pin;

    // Constructor
    Deposit(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1300, 700);
        add(l1);

        // ---------------- HEADING ----------------
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setBounds(350, 130, 400, 30);
        l1.add(label1);

        // ---------------- AMOUNT FIELD ----------------
        t1 = new TextField();
        t1.setBounds(370, 170, 300, 30);
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(t1);

        // ---------------- DEPOSIT BUTTON ----------------
        d = new JButton("DEPOSIT");
        d.setBounds(610, 310, 100, 30);
        d.setBackground(new Color(65, 125, 128));
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Arial", Font.BOLD, 12));
        d.addActionListener(this);
        l1.add(d);

        // ---------------- CANCEL BUTTON ----------------
        b = new JButton("CANCEL");
        b.setBounds(610, 350, 100, 30);
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

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // ---------------- DEPOSIT ----------------
            if (e.getSource() == d) {

                String amount = t1.getText().trim();

                // Validation
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter amount.");
                    return;
                }

                double amt = Double.parseDouble(amount);

                if (amt <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter valid amount.");
                    return;
                }

                Date date = new Date();

                Conn conn = new Conn();

                String sql = "INSERT INTO bank VALUES ('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')";

                conn.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully.");

                t1.setText("");

                setVisible(false);
                
             // ---------------- OPENING MAIN CLASS AFTER DEPOSITING MONEY ----------------
                
                
                new Main_Class(pin);
                
                
            }

            // ---------------- CANCEL ----------------
            else if (e.getSource() == b) {

                setVisible(false);
                
             // ---------------- RETURNING TO MAIN_CLASS ----------------
                
                new Main_Class(pin);
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Please enter numbers only.");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new Deposit("");
    }
}