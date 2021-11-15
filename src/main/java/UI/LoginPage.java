package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class LoginPage implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private ImageIcon user = new ImageIcon("src/user-24.png");
    private ImageIcon password = new ImageIcon("src/lock-24.png");
    private JLabel userIDLabel = new JLabel(user);
    private JLabel userPasswordLabel = new JLabel(password);
    private JLabel messageLabel = new JLabel();
    private PickupSystem pickupSystem;
    private LoginController loginController;

    public LoginPage(PickupSystem pckSys, LoginController lgcontrol) throws IOException, ClassNotFoundException {
        this.pickupSystem = pckSys;
        this.loginController = lgcontrol;

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        messageLabel.setBounds(140, 250, 250, 35);
        messageLabel.setFont(new Font(null,Font.PLAIN, 13));
        messageLabel.setForeground(Color.lightGray);

        loginButton.setBounds(110,200,100,25);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white));
        loginButton.setOpaque(true);
        loginButton.setBackground(Color.white);
        loginButton.setForeground(Color.darkGray);
        loginButton.addActionListener(this);

        registerButton.setBounds(220,200,100,25);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.white));
        registerButton.setForeground(Color.white);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String password = String.valueOf(userPasswordField.getPassword());

        if(e.getSource()==registerButton) {
            try {
                loginController.userRegister(userID, password);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Register Succeed! Please Login");
        }
        if(e.getSource()==loginButton) {
            if (loginController.userLogin(userID, password)) {
                frame.dispose();
                try {
                    MenuPage menuPage = new MenuPage(userID, this.pickupSystem, loginController);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setText("Incorrect Username or Password");
            }
        }
    }
}

