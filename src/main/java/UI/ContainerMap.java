package UI;

import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContainerMap implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton lockerMap = new JButton("Locker");
    private JButton refrigeratorMap = new JButton("Refrigerator");
    private JButton freezerMap = new JButton("Freezer");
    private JButton menu = new JButton("》Menu");
    private String userID;
    private PickupSystem pickupSystem;
    private LoginController loginController;

    ContainerMap(String username, PickupSystem pckSys, LoginController loginC) throws IOException, ClassNotFoundException{
        this.userID = username;
        this.pickupSystem = pckSys;
        this.loginController = loginC;

        lockerMap.setBounds(45,120,90,60);
        lockerMap.setFont(new Font(null, Font.PLAIN,17));
        lockerMap.setBorder(BorderFactory.createLineBorder(Color.white));
        lockerMap.setForeground(Color.white);
        lockerMap.setBackground(Color.darkGray);
        lockerMap.setFocusable(false);
        lockerMap.addActionListener(this);

        refrigeratorMap.setBounds(140,120,135,60);
        refrigeratorMap.setFont(new Font(null, Font.PLAIN,17));
        refrigeratorMap.setBorder(BorderFactory.createLineBorder(Color.white));
        refrigeratorMap.setForeground(Color.white);
        refrigeratorMap.setBackground(Color.darkGray);
        refrigeratorMap.setFocusable(false);
        refrigeratorMap.addActionListener(this);

        freezerMap.setBounds(280,120,90,60);
        freezerMap.setFont(new Font(null, Font.PLAIN,17));
        freezerMap.setBorder(BorderFactory.createLineBorder(Color.white));
        freezerMap.setForeground(Color.white);
        freezerMap.setBackground(Color.darkGray);
        freezerMap.setFocusable(false);
        freezerMap.addActionListener(this);

        menu.setBounds(270, 210,100,20);
        menu.setFont(new Font(null, Font.PLAIN,12));
        menu.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu.setForeground(Color.white);
        menu.setBackground(Color.darkGray);
        menu.setFocusable(false);
        menu.addActionListener(this);

        frame.add(lockerMap);
        frame.add(refrigeratorMap);
        frame.add(freezerMap);
        frame.add(menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==lockerMap){
            frame.dispose();
            LockerVisualization lockerVisualization = new LockerVisualization(userID,this.pickupSystem,this.loginController);
        }
        if (e.getSource()==refrigeratorMap){
            frame.dispose();
            RefridgeratorVisualization refridgeratorVisualization =
                    new RefridgeratorVisualization(userID,this.pickupSystem,this.loginController);
        }
        if (e.getSource()==freezerMap){
            frame.dispose();
            FreezerVisualization freezerVisualization = new FreezerVisualization(userID,this.pickupSystem,this.loginController);
        }
        if (e.getSource()==menu){
            frame.dispose();
            try {
                MenuPage menuPage = new MenuPage(userID, this.pickupSystem,this.loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
