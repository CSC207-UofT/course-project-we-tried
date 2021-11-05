package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    ImageIcon user = new ImageIcon("src/user-24.png");
    ImageIcon password = new ImageIcon("src/lock-24.png");
    JLabel userIDLabel = new JLabel(user);
    JLabel userPasswordLabel = new JLabel(password);
    JLabel messageLabel = new JLabel();

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginPage(HashMap<String, String> login){
        loginInfo = login;

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
        if(e.getSource()==registerButton) {
            //todo: register userID and password
        }
        if(e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(password)) {
                    frame.dispose();
                    MenuPage menuPage = new MenuPage(userID);
                } else {
                    messageLabel.setText("Incorrect Password");
                }
            } else {
                messageLabel.setText("Username Not Found");
            }
        }
    }
}
