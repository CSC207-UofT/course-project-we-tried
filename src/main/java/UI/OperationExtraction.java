package UI;
import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OperationExtraction implements ActionListener{
    private final JFrame frame = new JFrame();
    private JButton Pickup = new JButton();
    private JButton Menu = new JButton();
    private final String id;
    private PickupSystem pckSys = new PickupSystem();
    private LoginController logincontrol = new LoginController();
    private ArrayList<String> SearchInfoList = new ArrayList<>();

    public OperationExtraction(String id, String pkgId,PickupSystem pckSys, LoginController lgctrol) throws IOException {
        this.id = id;
        this.logincontrol = lgctrol;
        this.SearchInfoList = (ArrayList<String>) pckSys.search(pkgId);
        this.pckSys = pckSys;

        JLabel ID = new JLabel("Package ID: " + SearchInfoList.get(0));
        ID.setBounds(100, 50, 300, 25);
        ID.setFont(new Font(null,Font.PLAIN, 13));
        ID.setForeground(Color.white);
        frame.add(ID);

        JLabel sender = new JLabel("Sender: " + SearchInfoList.get(1));
        sender.setBounds(100, 75, 300, 25);
        sender.setFont(new Font(null,Font.PLAIN, 13));
        sender.setForeground(Color.white);
        frame.add(sender);

        JLabel receiver = new JLabel("Receiver: " + SearchInfoList.get(2));
        receiver.setBounds(100, 100, 300, 25);
        receiver.setFont(new Font(null,Font.PLAIN, 13));
        receiver.setForeground(Color.white);
        frame.add(receiver);

        JLabel description = new JLabel("Description: " + SearchInfoList.get(3));
        description.setBounds(100, 125, 300, 25);
        description.setFont(new Font(null,Font.PLAIN, 13));
        description.setForeground(Color.white);
        frame.add(description);

        JLabel location = new JLabel("Location: " + SearchInfoList.get(4));
        location.setBounds(100, 150, 300, 25);
        location.setFont(new Font(null,Font.PLAIN, 13));
        location.setForeground(Color.white);
        frame.add(location);

        JLabel stgReq = new JLabel("Storage Requirement: " + SearchInfoList.get(6));
        stgReq.setBounds(100, 175, 300, 25);
        stgReq.setFont(new Font(null,Font.PLAIN, 13));
        stgReq.setForeground(Color.white);
        frame.add(stgReq);

        JLabel processor = new JLabel("Processor: " + SearchInfoList.get(5));
        processor.setBounds(100, 200, 300, 25);
        processor.setFont(new Font(null,Font.PLAIN, 13));
        processor.setForeground(Color.white);
        frame.add(processor);

        JLabel depositTime = new JLabel("Deposit Time: " + SearchInfoList.get(7));
        depositTime.setBounds(100, 225, 300, 25);
        depositTime.setFont(new Font(null,Font.PLAIN, 13));
        depositTime.setForeground(Color.white);
        frame.add(depositTime);

        JLabel DDL = new JLabel("Free Storage EXPIRED at: " + SearchInfoList.get(8));
        DDL.setBounds(100, 250, 300, 25);
        DDL.setFont(new Font(null,Font.PLAIN, 13));
        DDL.setForeground(Color.white);
        frame.add(DDL);

        JLabel storageFee = new JLabel("Additional fee needed: " + SearchInfoList.get(9));
        storageFee.setBounds(100, 275, 300, 25);
        storageFee.setFont(new Font(null,Font.PLAIN, 13));
        storageFee.setForeground(Color.white);
        frame.add(storageFee);

        Pickup = new JButton("Pick up the item");
        Pickup.setBounds(90, 305, 150, 30);
        Pickup.setFont(new Font(null, Font.PLAIN, 13));
        Pickup.setForeground(Color.darkGray);
        Pickup.setFocusable(false);
        Pickup.addActionListener(this);
        frame.add(Pickup);

        Menu = new JButton("Menu");
        Menu.setBounds(250, 305, 70, 30);
        Menu.setFont(new Font(null, Font.PLAIN, 13));
        Menu.setForeground(Color.darkGray);
        Menu.setFocusable(false);
        Menu.addActionListener(this);
        frame.add(Menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Pick-up");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Pickup){
            try {
                //pckSys.pickup(pkgId);
                pckSys.pickup(this.SearchInfoList.get(0));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Package successfully removed",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource()==Menu) {
            frame.dispose();
            try {
                MenuPage menu = new MenuPage(id, pckSys, logincontrol);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
