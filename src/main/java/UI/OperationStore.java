package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class OperationStore implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JTextField IDID = new JTextField();
    private final JTextField SenderText = new JTextField();
    private final JTextField ReceiverText = new JTextField();
    private final JTextField DescriptionText = new JTextField();
    private final JButton Store = new JButton("Store");
    private final JButton Menu = new JButton("Menu");
    private final PickupSystem pckSys;
    private final String UserID;
    private final LoginController loginController;

    static {
        try {
            new LoginController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final String[] Choice = {"Locker", "Refrigerator", "Freezer"};
    private final JComboBox<String> Choices = new JComboBox<>(Choice);

    public OperationStore(String userID, PickupSystem pckSys, LoginController lgcontrol) throws IOException, ClassNotFoundException {
        this.pckSys = pckSys;
        this.UserID = userID;
        this.loginController = lgcontrol;

        JLabel instruction = new JLabel("Please enter Package ID and Item Information");
        instruction.setBounds(85, 50, 300, 20);
        instruction.setFont(new Font(null, Font.PLAIN, 13));
        instruction.setForeground(Color.white);

        JLabel pkgID = new JLabel("ID:");
        pkgID.setBounds(105, 90, 80, 24);
        pkgID.setFont(new Font(null, Font.PLAIN, 13));
        pkgID.setForeground(Color.white);

        IDID.setBounds(185, 90, 150, 24);

        JLabel sender = new JLabel("Sender:");
        sender.setBounds(105, 125, 80, 24);
        sender.setFont(new Font(null, Font.PLAIN, 13));
        sender.setForeground(Color.white);

        SenderText.setBounds(185, 125, 150, 24);

        JLabel receiver = new JLabel("Receiver:");
        receiver.setBounds(105, 160, 80, 24);
        receiver.setFont(new Font(null, Font.PLAIN, 13));
        receiver.setForeground(Color.white);

        ReceiverText.setBounds(185, 160, 150, 24);

        JLabel description = new JLabel("Description:");
        description.setBounds(105, 195, 80, 24);
        description.setFont(new Font(null, Font.PLAIN, 13));
        description.setForeground(Color.white);

        DescriptionText.setBounds(185, 195, 150, 24);

        JLabel stgRequire = new JLabel("Storage Requirement:");
        stgRequire.setBounds(105, 230, 150, 24);
        stgRequire.setFont(new Font(null, Font.PLAIN, 13));
        stgRequire.setForeground(Color.white);

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

        frame.add(instruction);
        frame.add(pkgID);
        frame.add(IDID);
        frame.add(sender);
        frame.add(SenderText);
        frame.add(receiver);
        frame.add(ReceiverText);
        frame.add(description);
        frame.add(DescriptionText);
        frame.add(stgRequire);
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
            if (Objects.equals(Choices.getSelectedItem(), "Freezer")){
                pointer = "F";
            }
            else if(Objects.equals(Choices.getSelectedItem(), "Refrigerator")){
                pointer = "R";
            }
            else{
                pointer = "L";
            }

            try {
                stored_item = pckSys.storeItem(IDID.getText(), infoinfo,pointer, UserID);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }


            if (stored_item != null){
                if(stored_item.equals("*")){
                    JOptionPane.showMessageDialog(null, "Item already Exist with same ID.",
                            "Alert!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Deposit succeed "+"Stored in:"+ stored_item);
                }
            }

            else {
                if (Objects.equals(Choices.getSelectedItem(), "Freezer")){
                    JOptionPane.showMessageDialog(null, "The Freezer is currently full.",
                            "Alert!", JOptionPane.INFORMATION_MESSAGE);
                }
                else  if (Objects.equals(Choices.getSelectedItem(), "Locker")){
                    JOptionPane.showMessageDialog(null, "The Locker is currently full.",
                            "Alert!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Objects.equals(Choices.getSelectedItem(), "Refrigerator")){
                    JOptionPane.showMessageDialog(null,
                            "The Refrigerator is currently full.",
                            "Alert!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (e.getSource()==Menu) {
            frame.dispose();
            //JFrame add the menu function;
            try {
                new MenuPage(UserID, pckSys, loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
