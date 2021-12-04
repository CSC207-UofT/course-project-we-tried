package UI;
import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPage implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton depositButton = new JButton( "<html>" + "DEPOSIT" + "<br>" + "PACKAGE" + "<html>" );
    private JButton pickupButton = new JButton("<html>" + "PICKUP" + "<br>" + "PACKAGE" + "<html>");
    private JButton logoutButton = new JButton("》logout");
    private JLabel userLabel = new JLabel();
    private String userID;
    private PickupSystem pickupSystem;
    private LoginController loginController;
    private JButton lookupButton = new JButton("Lookup Processed Items");

    MenuPage(String username, PickupSystem pckSys, LoginController loginC) throws IOException, ClassNotFoundException {
        this.userID = username;
        this.pickupSystem = pckSys;
        this.loginController = loginC;

        userLabel.setBounds(20,0,100,50);
        userLabel.setFont(new Font(null, Font.PLAIN,12));
        userLabel.setText("Hello " + userID + "!");
        userLabel.setForeground(Color.white);

        depositButton.setBounds(70,120,125,70);
        depositButton.setFont(new Font(null, Font.PLAIN,17));
        depositButton.setBorder(BorderFactory.createLineBorder(Color.white));
        depositButton.setForeground(Color.white);
        depositButton.setBackground(Color.darkGray);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);

        pickupButton.setBounds(220, 120, 125, 70);
        pickupButton.setFont(new Font(null, Font.PLAIN,17));
        pickupButton.setBorder(BorderFactory.createLineBorder(Color.white));
        pickupButton.setForeground(Color.white);
        pickupButton.setBackground(Color.darkGray);
        pickupButton.setFocusable(false);
        pickupButton.addActionListener(this);

        logoutButton.setBounds(270, 210,100,20);
        logoutButton.setFont(new Font(null, Font.PLAIN,12));
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        logoutButton.setForeground(Color.white);
        logoutButton.setBackground(Color.darkGray);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        lookupButton.setBounds(220, 330,200,25);
        lookupButton.setFont(new Font(null, Font.PLAIN,12));
        lookupButton.setForeground(Color.darkGray);
        lookupButton.setFocusable(false);
        lookupButton.addActionListener(this);

        frame.add(userLabel);
        frame.add(depositButton);
        frame.add(pickupButton);
        frame.add(logoutButton);
        frame.add(lookupButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositButton) {
            frame.dispose();
            OperationStore operationStore = null;
            try {
                operationStore = new OperationStore(userID, this.pickupSystem, this.loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==pickupButton) {
            frame.dispose();
            try {
                OperationSearch operationSearch = new OperationSearch(userID, this.pickupSystem, this.loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==logoutButton) {
            this.loginController.userLogout();
            frame.dispose();
            try {
                LoginPage loginPage = new LoginPage(this.pickupSystem, this.loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==lookupButton){
            //todo:exception

            String info = String.join("<br>", this.pickupSystem.get_processor_item(userID));
            JOptionPane.showMessageDialog(null, "<html>" + "Item ID:" +
                    "<br>" + info +"<html>");
        }
    }
}
