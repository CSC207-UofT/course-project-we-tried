package UI;
import Controller.LoginController;
import Controller.PickupSystem;
import Entities.Item;
import UseCase.ItemManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationExtraction implements ActionListener{
    private JFrame frame = new JFrame();
    private JLabel ID = new JLabel();
    private JLabel Sender = new JLabel();
    private JLabel Receiver = new JLabel();
    private JLabel Description = new JLabel();
    private JLabel Location = new JLabel();
    private JLabel Processor = new JLabel();
    private JLabel StgReq = new JLabel();
    private JButton Pickup = new JButton();
    private JButton Menu = new JButton();
    private String id = new String();
    private JLabel DepTime = new JLabel();
    private JLabel DDL = new JLabel();
    private JLabel StorageFee = new JLabel();
    private PickupSystem pckSys = new PickupSystem();
    private LoginController lgctrol = new LoginController();
    private String pkgId = new String();
    private ArrayList<String> ltlt = new ArrayList<>();

    public OperationExtraction(String id, String pkgId,PickupSystem pckSys, LoginController lgctrol) throws IOException {
        this.id = id;
        this.lgctrol = lgctrol;
        this.pkgId = pkgId;
        this.ltlt = (ArrayList<String>) pckSys.search(pkgId);

        ID = new JLabel("Package ID: " + ltlt.get(0));
        ID.setBounds(100, 50, 300, 25);
        ID.setFont(new Font(null,Font.PLAIN, 13));
        ID.setForeground(Color.white);
        frame.add(ID);

        Sender = new JLabel("Sender: " + ltlt.get(1));
        Sender.setBounds(100, 75, 300, 25);
        Sender.setFont(new Font(null,Font.PLAIN, 13));
        Sender.setForeground(Color.white);
        frame.add(Sender);

        Receiver = new JLabel("Receiver: " + ltlt.get(2));
        Receiver.setBounds(100, 100, 300, 25);
        Receiver.setFont(new Font(null,Font.PLAIN, 13));
        Receiver.setForeground(Color.white);
        frame.add(Receiver);

        Description = new JLabel("Description: " + ltlt.get(3));
        Description.setBounds(100, 125, 300, 25);
        Description.setFont(new Font(null,Font.PLAIN, 13));
        Description.setForeground(Color.white);
        frame.add(Description);

        Location = new JLabel("Location: " + ltlt.get(4));
        Location.setBounds(100, 150, 300, 25);
        Location.setFont(new Font(null,Font.PLAIN, 13));
        Location.setForeground(Color.white);
        frame.add(Location);

        StgReq = new JLabel("Storage Requirement: " + ltlt.get(6));
        StgReq.setBounds(100, 175, 300, 25);
        StgReq.setFont(new Font(null,Font.PLAIN, 13));
        StgReq.setForeground(Color.white);
        frame.add(StgReq);

        Processor = new JLabel("Processor: " + ltlt.get(5));
        Processor.setBounds(100, 200, 300, 25);
        Processor.setFont(new Font(null,Font.PLAIN, 13));
        Processor.setForeground(Color.white);
        frame.add(Processor);

        DepTime = new JLabel("Deposit Time: " + ltlt.get(6));
        DepTime.setBounds(100, 225, 300, 25);
        DepTime.setFont(new Font(null,Font.PLAIN, 13));
        DepTime.setForeground(Color.white);
        frame.add(DepTime);

        DDL = new JLabel("Free Storage EXPIRED at: " + ltlt.get(7));
        DDL.setBounds(100, 250, 300, 25);
        DDL.setFont(new Font(null,Font.PLAIN, 13));
        DDL.setForeground(Color.white);
        frame.add(DDL);

        StorageFee = new JLabel("Additional fee needed: " + ltlt.get(8));
        StorageFee.setBounds(100, 275, 300, 25);
        StorageFee.setFont(new Font(null,Font.PLAIN, 13));
        StorageFee.setForeground(Color.white);
        frame.add(StorageFee);

        //iteminfo = new JLabel(pckSys.search(id));
        //panel.add(iteminfo);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Pickup){
            try {
                //pckSys.pickup(pkgId);
                pckSys.pickup(this.ltlt.get(0));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Package successfully removed");
        }
        if (e.getSource()==Menu) {
            frame.dispose();
            try {
                MenuPage menu = new MenuPage(id, pckSys, lgctrol);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
