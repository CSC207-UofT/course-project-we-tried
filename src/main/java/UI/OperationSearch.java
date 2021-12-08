package UI;

import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OperationSearch implements ActionListener{
    private final JFrame frame = new JFrame();
    private final JButton Search;

    static {
        new JButton();
    }

    private final JButton Menu;

    static {
        new JButton();
    }

    private final JTextField EnterID;

    static {
        new JTextField();
    }

    private final PickupSystem pckSys;
    private final LoginController loginController;

    static {
        try {
            new LoginController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final String userID;

    /**
     * Construct the OperationSearch UI.
     * @param username input username.
     * @param pckSys input PickupSystem.
     * @param loginC input LoginController.
     */


    public OperationSearch(String username, PickupSystem pckSys, LoginController loginC) throws IOException, ClassNotFoundException {
        this.pckSys = pckSys;
        this.loginController = loginC;
        this.userID = username;

        JLabel instruction = new JLabel("Enter the ID of the package you want to search for...");
        instruction.setBounds(30, 100, 420, 50);
        instruction.setFont(new Font(null, Font.PLAIN, 14));
        instruction.setForeground(Color.white);

        JLabel pkgID = new JLabel("ID:");
        pkgID.setBounds(135, 150, 75, 25);
        pkgID.setFont(new Font(null,Font.PLAIN, 13));
        pkgID.setForeground(Color.lightGray);

        EnterID = new JTextField(10);
        EnterID.setBounds(160, 150, 100, 25);

        Search = new JButton("Search");
        Search.setBounds(105, 200, 100, 25);
        Search.setBorder(BorderFactory.createLineBorder(Color.white));
        Search.setOpaque(true);
        Search.setBackground(Color.white);
        Search.setForeground(Color.darkGray);
        Search.addActionListener(this);

        Menu = new JButton("Menu");
        Menu.setBounds(210, 200, 100, 25);
        Menu.setBorder(BorderFactory.createLineBorder(Color.white));
        Menu.setForeground(Color.white);
        Menu.setBackground(Color.darkGray);
        Menu.setFocusable(false);
        Menu.addActionListener(this);

        frame.add(instruction);
        frame.add(pkgID);
        frame.add(EnterID);
        frame.add(Search);
        frame.add(Menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Search");
    }
    /**
     * Make correspondent response toward different button click.
     * @param e input button click
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = EnterID.getText();
        ArrayList<String> option = (ArrayList<String>) pckSys.search(id);

        if (e.getSource()==Search){
            if (option == null){
                JOptionPane.showMessageDialog(null, "Item not found", "Alert!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                frame.dispose();
                try {
                    new OperationExtraction(userID, id, pckSys, loginController);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource()==Menu){
            frame.dispose();
            try {
                new MenuPage(userID, pckSys, loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
