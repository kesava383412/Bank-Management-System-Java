package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    // Labels
    JLabel label1, label2, label3;

    // Input Fields
    JTextField textfield;
    JPasswordField passwordfield;

    // Buttons
    JButton button1, button2, button3;

    // Constructor
    Login() {
        super("WELCOME TO BANK MANAGEMENT SYSTEM");

        // ---------------- BANK LOGO ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        // ---------------- CARD IMAGE ----------------
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel card = new JLabel(ii3);
        card.setBounds(650, 300, 100, 100);
        add(card);

        // ---------------- HEADING ----------------
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 38));
        label1.setBounds(220, 120, 450, 40);
        add(label1);

        // ---------------- CARD NUMBER ----------------
        label2 = new JLabel("Card No:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 28));
        label2.setBounds(150, 190, 150, 30);
        add(label2);

        textfield = new JTextField();
        textfield.setBounds(325, 190, 230, 30);
        textfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(textfield);

        // ---------------- PIN ----------------
        label3 = new JLabel("PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 28));
        label3.setBounds(150, 250, 150, 30);
        add(label3);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(325, 250, 230, 30);
        passwordfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordfield);

        // ---------------- SIGN IN BUTTON ----------------
        button1 = new JButton("SIGN IN");
        button1.setBounds(330, 300, 100, 30);
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.addActionListener(this);
        add(button1);

        // ---------------- CLEAR BUTTON ----------------
        button2 = new JButton("CLEAR");
        button2.setBounds(450, 300, 100, 30);
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.addActionListener(this);
        add(button2);

        // ---------------- SIGN UP BUTTON ----------------
        button3 = new JButton("SIGN UP");
        button3.setBounds(330, 350, 220, 30);
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.addActionListener(this);
        add(button3);

        // ---------------- BACKGROUND IMAGE ----------------
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("Icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel back = new JLabel(iii3);
        back.setBounds(0, 0, 850, 480);
        add(back);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        setSize(850, 480);
        setLocation(250, 100);
        setUndecorated(false);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- BUTTON ACTIONS ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // ---------------- SIGN IN ----------------
            if (e.getSource() == button1) {

                String cardno = textfield.getText().trim();
                String pin = new String(passwordfield.getPassword()).trim();

                // Validation
                if (cardno.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Card Number and PIN");
                    return;
                }

                Conn c = new Conn();

                // Correct SQL Query
                String sql = "SELECT * FROM login WHERE card_no = '" + cardno + "' AND pin = '" + pin + "'";

                ResultSet resultset = c.statement.executeQuery(sql);

                if (resultset.next()) {

                    JOptionPane.showMessageDialog(null, "Login Successful");

                    setVisible(false);
                    new Main_Class(pin);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            }

            // ---------------- CLEAR ----------------
            else if (e.getSource() == button2) {

                textfield.setText("");
                passwordfield.setText("");
            }

            // ---------------- SIGN UP ----------------
            else if (e.getSource() == button3) {

                setVisible(false);
                new SignUp();
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        new Login();
    }
}