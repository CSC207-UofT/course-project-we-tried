package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class LoginPage implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton loginButton = new JButton("Login");
    private final JButton registerButton = new JButton("Register");
    private final JTextField userIDField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel messageLabel = new JLabel();
    private final PickupSystem pickupSystem;
    private final LoginController loginController;

    /**
     * Construct the LoginPage UI.
     * @param pckSys input PickupSystem.
     * @param lgcontrol input LoginController.
     */


    public LoginPage(PickupSystem pckSys, LoginController lgcontrol) throws IOException, ClassNotFoundException {
        this.pickupSystem = pckSys;
        this.loginController = lgcontrol;

        JLabel welcome = new JLabel("<html>" + "Polar Bear" + "<br>" + "Pickup Station" + "<html>");
        welcome.setBounds(190, 50, 150, 85);
        welcome.setFont(new Font(null,Font.PLAIN, 17));
        welcome.setBackground(Color.darkGray);
        welcome.setForeground(Color.white);

        ImageIcon packageIcon = new ImageIcon("src/bear1.png");
        JLabel packageIconLabel = new JLabel(packageIcon);
        packageIconLabel.setBounds(90,50,85,85);
        ImageIcon user = new ImageIcon("src/user-24.png");
        JLabel userIDLabel = new JLabel(user);
        userIDLabel.setBounds(50, 170, 75, 25);
        ImageIcon password = new ImageIcon("src/lock-24.png");
        JLabel userPasswordLabel = new JLabel(password);
        userPasswordLabel.setBounds(50, 220, 75, 25);

        userIDField.setBounds(125,170,200,25);
        userPasswordField.setBounds(125,220,200,25);

        messageLabel.setBounds(100, 305, 300, 40);
        messageLabel.setFont(new Font(null,Font.PLAIN, 13));
        messageLabel.setForeground(Color.lightGray);

        loginButton.setBounds(110,270,100,25);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white));
        loginButton.setOpaque(true);
        loginButton.setBackground(Color.white);
        loginButton.setForeground(Color.darkGray);
        loginButton.addActionListener(this);

        registerButton.setBounds(220,270,100,25);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.white));
        registerButton.setForeground(Color.white);
        registerButton.setBackground(Color.darkGray);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(packageIconLabel);
        frame.add(welcome);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Please Login");
    }
    /**
     * Make correspondent response toward different button click.
     * @param e input button click
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userIDField.getText();
        String password = String.valueOf(userPasswordField.getPassword());

        if(e.getSource()==registerButton) {
            try {
                if(this.loginController.userRegister(userID, password)){
                    JOptionPane.showMessageDialog(null, "Register Succeed! Please Login",
                            "Register Succeed",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    try {
                        if(!this.loginController.userRegister(userID, password)){
                            JOptionPane.showMessageDialog(null,
                                    "Invalid Username or Username already Exist.",
                                    "Register Failure",JOptionPane.INFORMATION_MESSAGE);
                            messageLabel.setText("<html>"+ "Create username and password between " +"<br>"+
                                    "4-12 characters without special symbols"+ "<html>");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==loginButton) {
            if (this.loginController.userLogin(userID, password)) {
                frame.dispose();
                try {
                    new MenuPage(userID, this.pickupSystem, this.loginController);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setText("Incorrect Username or Password");
            }
        }
    }
}

