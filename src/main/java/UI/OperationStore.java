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

public class OperationStore extends JFrame {
    private JLabel Instruction = new JLabel();
    private JLabel pkgID = new JLabel();
    private JButton Menu = new JButton();
    private JButton Store = new JButton();
    private JLabel pkginfo = new JLabel();
    private JTextField IDID = new JTextField();
    private JTextField infoinfo = new JTextField();
    private JLabel StgRequire = new JLabel();
    private JTextField ReqReq = new JTextField();
    final int FRAME_HEIGHT = 500;
    final int FRAME_LENGTH = 500;
    private JPanel panel = new JPanel();
    private PickupSystem pckSys = new PickupSystem();
    private JLabel Sender = new JLabel();
    private JLabel Receiver = new JLabel();
    private JTextField sdsd = new JTextField();
    private JTextField rere = new JTextField();
    private JLabel Description = new JLabel();
    private JTextField dede = new JTextField();
    private String UserID = new String();
    private LoginController lgcontrol = new LoginController();

    public OperationStore(String userID, PickupSystem pckSys, LoginController lgcontrol){
        this.pckSys = pckSys;
        this.UserID = userID;
        this.lgcontrol = lgcontrol;
        panel = new JPanel();

        Instruction = new JLabel("Please enter Package ID and Item Info");
        panel.add(Instruction);

        pkgID = new JLabel("ID: ");
        panel.add(pkgID);

        IDID = new JTextField(20);
        panel.add(IDID);

        Sender = new JLabel("Sender:");
        panel.add(Sender);

        sdsd = new JTextField(20);
        panel.add(sdsd);

        Receiver = new JLabel("Receiver:");
        panel.add(Receiver);

        rere = new JTextField(20);
        panel.add(rere);

        Description = new JLabel("Description:");
        panel.add(Description);

        dede = new JTextField(20);
        panel.add(dede);

        StgRequire = new JLabel("Storage Requirement:");
        panel.add(StgRequire);

        ReqReq = new JTextField(10);
        panel.add(ReqReq);

        //pkginfo = new JLabel("Scanned info");
        //panel.add(pkginfo);

        //infoinfo = new JTextField(50);
        //panel.add(infoinfo);

        Store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> infoinfo = new ArrayList<>(3);
                infoinfo.add(sdsd.getText());
                infoinfo.add(rere.getText());
                infoinfo.add(dede.getText());
                if (pckSys.storeItem(IDID.getText(), infoinfo,ReqReq.getText(), userID) != null){
                    JOptionPane.showMessageDialog(null, "Deposit succeed");
                }

                else{
                    JOptionPane.showMessageDialog(null, "The" + ReqReq.getText()
                            + "is currently full.");
                }


            }
        });


        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationStore.this.setVisible(false);
                //JFrame add the menu function;
                MenuPage menuPage = new MenuPage(UserID, pckSys, lgcontrol);
            }
        });

        this.setLayout(null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_HEIGHT - 250)/2, (FRAME_LENGTH - 250)/2);
        this.add(panel);
        this.setSize(FRAME_HEIGHT, FRAME_LENGTH);
        this.setTitle("Store Packages");
    }
}
