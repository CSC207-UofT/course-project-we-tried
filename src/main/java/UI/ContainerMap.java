package UI;

import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContainerMap implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton lockerMap = new JButton("Locker");
    private final JButton refrigeratorMap = new JButton("Refrigerator");
    private final JButton freezerMap = new JButton("Freezer");
    private final JButton menu = new JButton("》Menu");
    private final String userID;
    private final PickupSystem pickupSystem;
    private final LoginController loginController;

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
        frame.setTitle("Closet Menu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==lockerMap){
            frame.dispose();
            new LockerVisualization(userID, this.pickupSystem, this.loginController);
        }
        if (e.getSource()==refrigeratorMap){
            frame.dispose();
            new RefridgeratorVisualization(userID, this.pickupSystem, this.loginController);
        }
        if (e.getSource()==freezerMap){
            frame.dispose();
            new FreezerVisualization(userID, this.pickupSystem, this.loginController);
        }
        if (e.getSource()==menu){
            frame.dispose();
            try {
                new MenuPage(userID, this.pickupSystem, this.loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
