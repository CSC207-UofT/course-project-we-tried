package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OperationStore implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel Instruction = new JLabel("Please enter Package ID and Item Information");
    private JLabel pkgID = new JLabel("ID:");
    private JTextField IDID = new JTextField();
    private JLabel Sender = new JLabel("Sender:");
    private JTextField SenderText = new JTextField();
    private JLabel Receiver = new JLabel("Receiver:");
    private JTextField ReceiverText = new JTextField();
    private JLabel Description = new JLabel("Description:");
    private JTextField DescriptionText = new JTextField();
    private JLabel StgRequire = new JLabel("Storage Requirement:");
    private JButton Store = new JButton("Store");
    private JButton Menu = new JButton("Menu");
    private PickupSystem pckSys;
    private String UserID = new String();
    private LoginController loginController = new LoginController();
    private String[] Choice = {"Locker", "Refrigerator", "Freezer"};
    private JComboBox<String> Choices = new JComboBox<>(Choice);

    public OperationStore(String userID, PickupSystem pckSys, LoginController lgcontrol) throws IOException, ClassNotFoundException {
        this.pckSys = pckSys;
        this.UserID = userID;
        this.loginController = lgcontrol;

        Instruction.setBounds(85, 50, 300, 20);
        Instruction.setFont(new Font(null, Font.PLAIN, 13));
        Instruction.setForeground(Color.white);

        pkgID.setBounds(105, 90, 80, 24);
        pkgID.setFont(new Font(null, Font.PLAIN, 13));
        pkgID.setForeground(Color.white);

        IDID.setBounds(185, 90, 150, 24);

        Sender.setBounds(105, 125, 80, 24);
        Sender.setFont(new Font(null, Font.PLAIN, 13));
        Sender.setForeground(Color.white);

        SenderText.setBounds(185, 125, 150, 24);

        Receiver.setBounds(105, 160, 80, 24);
        Receiver.setFont(new Font(null, Font.PLAIN, 13));
        Receiver.setForeground(Color.white);

        ReceiverText.setBounds(185, 160, 150, 24);

        Description.setBounds(105, 195, 80, 24);
        Description.setFont(new Font(null, Font.PLAIN, 13));
        Description.setForeground(Color.white);

        DescriptionText.setBounds(185, 195, 150, 24);

        StgRequire.setBounds(105, 230, 150, 24);
        StgRequire.setFont(new Font(null, Font.PLAIN, 13));
        StgRequire.setForeground(Color.white);

        Choices.setBounds(250, 230, 85, 24);

        Store.setBounds(145, 280, 70, 30);
        Store.setFont(new Font(null, Font.PLAIN, 13));
        Store.setForeground(Color.darkGray);
        Store.setBackground(Color.white);
        Store.setFocusable(false);
        Store.addActionListener(this);

        Menu.setBounds(225, 280, 70, 30);
        Menu.setFont(new Font(null, Font.PLAIN, 13));
        Menu.setForeground(Color.darkGray);
        Menu.setBackground(Color.white);
        Menu.setFocusable(false);
        Menu.addActionListener(this);

        frame.add(Instruction);
        frame.add(pkgID);
        frame.add(IDID);
        frame.add(Sender);
        frame.add(SenderText);
        frame.add(Receiver);
        frame.add(ReceiverText);
        frame.add(Description);
        frame.add(DescriptionText);
        frame.add(StgRequire);
        frame.add(Choices);
        frame.add(Store);
        frame.add(Menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Store");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Store) {
            ArrayList<String> infoinfo = new ArrayList<>(3);
            infoinfo.add(SenderText.getText());
            infoinfo.add(ReceiverText.getText());
            infoinfo.add(DescriptionText.getText());
            String stored_item = null;
            String pointer;
            if (Choices.getSelectedItem().equals("Freezer")){
                pointer = "F";
            }
            else if(Choices.getSelectedItem().equals("Refrigerator")){
                pointer = "R";
            }
            else{
                pointer = "L";
            }

            try {
                stored_item = pckSys.storeItem(IDID.getText(), infoinfo,pointer, UserID);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }


            if (stored_item != null){
                if(stored_item.equals("*")){
                    JOptionPane.showMessageDialog(null, "Item already Exist with same ID.");
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Deposit succeed "+"Stored in:"+ stored_item);
                }
            }

            else {
                if (Choices.getSelectedItem().equals("Freezer")){
                    JOptionPane.showMessageDialog(null, "The Freezer is currently full.");
                }
                else  if (Choices.getSelectedItem().equals("Locker")){
                    JOptionPane.showMessageDialog(null, "The Locker is currently full.");
                }
                else if(Choices.getSelectedItem().equals("Refrigerator")){
                    JOptionPane.showMessageDialog(null,
                            "The Refrigerator is currently full.");
                }
            }
        }

        if (e.getSource()==Menu) {
            frame.dispose();
            //JFrame add the menu function;
            try {
                MenuPage menuPage = new MenuPage(UserID, pckSys, loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
