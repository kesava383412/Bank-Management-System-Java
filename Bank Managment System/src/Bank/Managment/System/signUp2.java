package Bank.Managment.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signUp2 extends JFrame implements ActionListener {

    // Form Number
    String formNo;

    // Combo Boxes
    JComboBox<String> combobox1, combobox2, combobox3, combobox4, combobox5;

    // Radio Buttons
    JRadioButton r1, r2, e1, e2;

    // Button
    JButton next;

    // Text Fields
    JTextField textpan, textaadhar;

    // Constructor
    signUp2(String formNo) {

        super("Signup Page 2");
        this.formNo = formNo;

        // ---------------- BANK IMAGE ----------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(30, 10, 100, 100);
        add(image);

        // ---------------- HEADINGS ----------------
        JLabel label1 = new JLabel("Page 2 : Additional Details");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(260, 30, 350, 30);
        add(label1);

        JLabel labelForm = new JLabel("Form No : " + formNo);
        labelForm.setFont(new Font("Arial", Font.BOLD, 18));
        labelForm.setBounds(620, 30, 200, 30);
        add(labelForm);

        // ---------------- RELIGION ----------------
        addLabel("Religion :", 150, 130);
        String religion[] = { "Hindu", "Muslim", "Christian", "Sikh", "Others" };
        combobox1 = new JComboBox<>(religion);
        setCombo(combobox1, 400, 130);

        // ---------------- CATEGORY ----------------
        addLabel("Category :", 150, 180);
        String category[] = { "SC", "ST", "OBC", "General", "Others" };
        combobox2 = new JComboBox<>(category);
        setCombo(combobox2, 400, 180);

        // ---------------- INCOME ----------------
        addLabel("Income :", 150, 230);
        String income[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
        combobox3 = new JComboBox<>(income);
        setCombo(combobox3, 400, 230);

        // ---------------- EDUCATION ----------------
        addLabel("Education :", 150, 280);
        String education[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others" };
        combobox4 = new JComboBox<>(education);
        setCombo(combobox4, 400, 280);

        // ---------------- OCCUPATION ----------------
        addLabel("Occupation :", 150, 330);
        String occupation[] = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others" };
        combobox5 = new JComboBox<>(occupation);
        setCombo(combobox5, 400, 330);

        // ---------------- PAN ----------------
        addLabel("PAN Number :", 150, 380);
        textpan = new JTextField();
        setTextField(textpan, 400, 380);

        // ---------------- AADHAR ----------------
        addLabel("Aadhar Number :", 150, 430);
        textaadhar = new JTextField();
        setTextField(textaadhar, 400, 430);

        // ---------------- SENIOR CITIZEN ----------------
        addLabel("Senior Citizen :", 150, 480);

        r1 = new JRadioButton("YES");
        r2 = new JRadioButton("NO");

        setRadio(r1, 400, 485);
        setRadio(r2, 520, 485);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        // ---------------- EXISTING ACCOUNT ----------------
        addLabel("Existing Account :", 150, 530);

        e1 = new JRadioButton("YES");
        e2 = new JRadioButton("NO");

        setRadio(e1, 400, 535);
        setRadio(e2, 520, 535);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(e1);
        bg2.add(e2);

        // ---------------- NEXT BUTTON ----------------
        next = new JButton("NEXT");
        next.setBounds(650, 610, 120, 35);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        // ---------------- FRAME SETTINGS ----------------
        setLayout(null);
        getContentPane().setBackground(new Color(252, 208, 76));
        setSize(850, 720);
        setLocation(250, 10);
        setResizable(false);
        setVisible(true);
    }

    // ---------------- LABEL METHOD ----------------
    public void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(x, y, 220, 30);
        add(label);
    }

    // ---------------- COMBOBOX METHOD ----------------
    public void setCombo(JComboBox<String> box, int x, int y) {
        box.setBounds(x, y, 300, 30);
        box.setBackground(Color.WHITE);
        box.setFont(new Font("Arial", Font.BOLD, 13));
        add(box);
    }

    // ---------------- TEXTFIELD METHOD ----------------
    public void setTextField(JTextField field, int x, int y) {
        field.setBounds(x, y, 300, 30);
        field.setFont(new Font("Arial", Font.BOLD, 14));
        add(field);
    }

    // ---------------- RADIO METHOD ----------------
    public void setRadio(JRadioButton radio, int x, int y) {
        radio.setBounds(x, y, 80, 30);
        radio.setBackground(new Color(252, 208, 76));
        radio.setFont(new Font("Arial", Font.BOLD, 14));
        add(radio);
    }

    // ---------------- BUTTON ACTION ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String rel = (String) combobox1.getSelectedItem();
            String cat = (String) combobox2.getSelectedItem();
            String income = (String) combobox3.getSelectedItem();
            String edu = (String) combobox4.getSelectedItem();
            String occ = (String) combobox5.getSelectedItem();

            String pan = textpan.getText().trim();
            String aadhar = textaadhar.getText().trim();

            String seniorCitizen = "";
            String existingAccount = "";

            if (r1.isSelected())
                seniorCitizen = "YES";
            else if (r2.isSelected())
                seniorCitizen = "NO";

            if (e1.isSelected())
                existingAccount = "YES";
            else if (e2.isSelected())
                existingAccount = "NO";

            // Validation
            if (pan.equals("") || aadhar.equals("") || seniorCitizen.equals("") || existingAccount.equals("")) {

                JOptionPane.showMessageDialog(null, "Please fill all fields.");
                return;
            }

            Conn conn = new Conn();

            String sql = "INSERT INTO signUptwo VALUES('" + formNo + "','" + rel + "','" + cat + "','" + income
                    + "','" + edu + "','" + occ + "','" + pan + "','" + aadhar + "','" + seniorCitizen + "','"
                    + existingAccount + "')";

            conn.statement.executeUpdate(sql);

            setVisible(false);
            new signUp3(formNo);

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        new signUp2("");
    }
}