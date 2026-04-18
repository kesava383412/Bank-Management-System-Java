package Bank.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {

    // Buttons
    JButton b1, b2, b3, b4, b5, b6, b7;

    // User PIN
    String pin;

    // Constructor
    Main_Class(String pin) {

        this.pin = pin;

        // ---------------- ATM IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1300, 700);
        add(background);

        // ---------------- TITLE ----------------
        JLabel label = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label.setBounds(380, 180, 450, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(label);

        // ---------------- LEFT SIDE BUTTONS ----------------
        b1 = createButton("DEPOSIT", 340, 230, background);
        b2 = createButton("CASH WITHDRAWAL", 340, 270, background);
        b3 = createButton("FAST CASH", 340, 310, background);

        // ---------------- RIGHT SIDE BUTTONS ----------------
        b4 = createButton("MINI STATEMENT", 555, 230, background);
        b5 = createButton("PIN CHANGE", 555, 270, background);
        b6 = createButton("BALANCE ENQUIRY", 555, 310, background);

        // ---------------- EXIT BUTTON ----------------
        b7 = createButton("EXIT", 555, 350, background);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        setSize(1300, 700);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- BUTTON CREATOR ----------------
    public JButton createButton(String text, int x, int y, JLabel panel) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 160, 30);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(65, 125, 128));
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.addActionListener(this);

        panel.add(button);

        return button;
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            new Deposit(pin);
            setVisible(false);

        } else if (e.getSource() == b2) {

            new Withdraw(pin);
            setVisible(false);

        } else if (e.getSource() == b3) {

            new FastCash(pin);
            setVisible(false);

        } else if (e.getSource() == b4) {

            new Mini(pin);

        } else if (e.getSource() == b5) {

            new Pin(pin);
            setVisible(false);

        } else if (e.getSource() == b6) {

            new BalanceEnquiry(pin);
            setVisible(false);

        } else if (e.getSource() == b7) {

            System.exit(0);
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new Main_Class("");
    }
}