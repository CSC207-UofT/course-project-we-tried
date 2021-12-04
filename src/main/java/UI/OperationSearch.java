package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import UseCase.ItemManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OperationSearch implements ActionListener{
    private JFrame frame = new JFrame();
    private JLabel Instruction = new JLabel();
    private JLabel pkgID = new JLabel();
    private JButton Search = new JButton();
    private JButton Menu = new JButton();
    private JTextField EnterID = new JTextField();
    private JButton pickup = new JButton();
    private PickupSystem pckSys;
    private LoginController loginController = new LoginController();
    private String userID = new String();


    public OperationSearch(String username, PickupSystem pckSys, LoginController loginC) throws IOException, ClassNotFoundException {
        this.pckSys = pckSys;
        this.loginController = loginC;
        this.userID = username;

        Instruction = new JLabel("Enter the ID of the package you want to search for...");
        Instruction.setBounds(30, 100, 420, 50);
        Instruction.setFont(new Font(null, Font.PLAIN, 14));
        Instruction.setForeground(Color.white);

        pkgID = new JLabel("ID:");
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
        Menu.setFocusable(false);
        Menu.addActionListener(this);

        frame.add(Instruction);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = EnterID.getText();
        ArrayList<String> option = (ArrayList<String>) pckSys.search(id);

        if (e.getSource()==Search){
            if (option == null){
                JOptionPane.showMessageDialog(null, "Item not found");
            }
            else{
                frame.dispose();
                OperationExtraction operationExtraction = null;
                try {
                    operationExtraction = new OperationExtraction(userID, id,pckSys, loginController);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                operationExtraction.setVisible(true);
            }
        }
        if (e.getSource()==Menu){
            frame.dispose();
            try {
                MenuPage menuPage = new MenuPage(userID, pckSys, loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
