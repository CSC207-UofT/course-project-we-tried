package UI;
import Controller.LoginController;
import Controller.PickupSystem;
import Entities.Item;
import UseCase.ItemManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OperationExtraction extends JFrame{
    private JLabel ID = new JLabel();
    private JLabel Sender = new JLabel();
    private JLabel Receiver = new JLabel();
    private JLabel Description = new JLabel();
    private JLabel Location = new JLabel();
    private JLabel Processor = new JLabel();
    private JLabel StgReq = new JLabel();
    private JButton Pickup = new JButton();
    private JButton Menu = new JButton();
    private JPanel panel = new JPanel();
    private String id = new String();
    final int FRAME_HEIGHT = 1000;
    final int FRAME_LENGTH = 500;
    private PickupSystem pckSys = new PickupSystem();
    private LoginController lgctrol = new LoginController();

    public OperationExtraction(String id, PickupSystem pckSys, LoginController lgctrol){
        this.id = id;
        this.lgctrol = lgctrol;
        panel = new JPanel();
        ArrayList<String> ltlt = (ArrayList<String>) pckSys.search(id);

        ID = new JLabel(ltlt.get(0));
        panel.add(ID);

        Sender = new JLabel(ltlt.get(1));
        panel.add(Sender);

        Receiver = new JLabel(ltlt.get(2));
        panel.add(Receiver);

        Description = new JLabel(ltlt.get(3));
        panel.add(Description);

        Location = new JLabel(ltlt.get(4));
        panel.add(Location);

        Processor = new JLabel(ltlt.get(5));
        panel.add(Processor);

        StgReq = new JLabel(ltlt.get(6));
        panel.add(StgReq);


        //iteminfo = new JLabel(pckSys.search(id));
        //panel.add(iteminfo);

        Pickup = new JButton("Pick up the item");
        panel.add(Pickup);

        Menu = new JButton("Menu");
        panel.add(Menu);

        Pickup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pckSys.pickup(id);
                JOptionPane.showMessageDialog(null, "Package successfully removed");
            }
        });

        this.setLayout(null);
        panel.setSize(800,800);
        panel.setLocation((FRAME_HEIGHT - 800)/2, (FRAME_LENGTH - 150)/2);
        this.add(panel);
        this.setSize(FRAME_HEIGHT, FRAME_LENGTH);
        this.setTitle("Extract Item");


    }


}
