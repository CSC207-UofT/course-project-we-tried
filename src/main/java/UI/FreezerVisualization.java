package UI;

import Controller.LoginController;
import Controller.PickupSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class FreezerVisualization implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton Menu = new JButton("Menu");
    private final JButton Search = new JButton("Search");
    private final JButton Container = new JButton("Return");
    private final PickupSystem pickupSystem;
    private final LoginController loginController;
    private final String userID;


    public FreezerVisualization(String username, PickupSystem pckSys, LoginController loginC) {
        this.pickupSystem = pckSys;
        this.loginController = loginC;
        this.userID = username;

        Map<String,String> f_list = pckSys.get_package("freezer");

        ImageIcon HImage = new ImageIcon("src/Horizontal.png");
        JLabel horizontalline1 = new JLabel(HImage);
        horizontalline1.setBounds(0, 20, 800, 20);
        frame.add(horizontalline1);

        ImageIcon verticalBorder = new ImageIcon("src/VerticalborderF.png");
        JLabel verticalBorder1 = new JLabel(verticalBorder);
        verticalBorder1.setBounds(29, 2, 40, 348);
        frame.add(verticalBorder1);

        JLabel verticalBorder2 = new JLabel(verticalBorder);
        verticalBorder2.setBounds(731, 2, 40, 348);
        frame.add(verticalBorder2);

        ImageIcon VImage = new ImageIcon("src/VerticalF.png");
        JLabel vertivcalline1 = new JLabel(VImage);
        vertivcalline1.setBounds(263, 2, 40, 348);
        frame.add(vertivcalline1);

        JLabel vertivcalline2 = new JLabel(VImage);
        vertivcalline2.setBounds(497, 2, 40, 348);
        frame.add(vertivcalline2);

        JLabel horizontalline3 = new JLabel(HImage);
        horizontalline3.setBounds(0, 168, 800, 10);
        frame.add(horizontalline3);

        JLabel horizontalline4 = new JLabel(HImage);
        horizontalline4.setBounds(0, 316, 800, 12);
        frame.add(horizontalline4);


        JLabel l01 = new JLabel("F01");
        l01.setBounds(143, 4, 100, 100);
        l01.setFont(new Font(null, Font.PLAIN, 30));
        l01.setForeground(Color.white);
        frame.add(l01);

        if (f_list.get("F01") != null) {
            JLabel l1 = new JLabel(f_list.get("F01"));
            l1.setBounds(110, 63, 200, 100);
            l1.setFont(new Font(null, Font.PLAIN, 20));
            l1.setForeground(Color.white);
            frame.add(l1);
        }

        JLabel l02 = new JLabel("F02");
        l02.setBounds(377, 4, 100, 100);
        l02.setFont(new Font(null, Font.PLAIN, 30));
        l02.setForeground(Color.white);
        frame.add(l02);

        if(f_list.get("F02") != null) {
            JLabel l2 = new JLabel(f_list.get("F02"));
            l2.setBounds(344, 63, 200, 100);
            l2.setFont(new Font(null, Font.PLAIN, 20));
            l2.setForeground(Color.white);
            frame.add(l2);

        }

        JLabel l03 = new JLabel("F03");
        l03.setBounds(611, 4, 100, 100);
        l03.setFont(new Font(null, Font.PLAIN, 30));
        l03.setForeground(Color.white);
        frame.add(l03);
        if(f_list.get("F03") != null) {
            JLabel l3 = new JLabel(f_list.get("F03"));
            l3.setBounds(578, 63, 200, 100);
            l3.setFont(new Font(null, Font.PLAIN, 20));
            l3.setForeground(Color.white);
            frame.add(l3);
        }


        JLabel l04 = new JLabel("F04");
        l04.setBounds(143, 152, 100, 100);
        l04.setFont(new Font(null, Font.PLAIN, 30));
        l04.setForeground(Color.white);
        frame.add(l04);

        if(f_list.get("F04") != null) {
            JLabel l4 = new JLabel(f_list.get("F04"));
            l4.setBounds(110, 211, 200, 100);
            l4.setFont(new Font(null, Font.PLAIN, 20));
            l4.setForeground(Color.white);
            frame.add(l4);
        }

        JLabel l05 = new JLabel("F05");
        l05.setBounds(377, 152, 100, 100);
        l05.setFont(new Font(null, Font.PLAIN, 30));
        l05.setForeground(Color.white);
        frame.add(l05);

        if(f_list.get("F05") != null) {
            JLabel l5 = new JLabel(f_list.get("F05"));
            l5.setBounds(344, 211, 200, 100);
            l5.setFont(new Font(null, Font.PLAIN, 20));
            l5.setForeground(Color.white);
            frame.add(l5);
        }

        JLabel l06 = new JLabel("F06");
        l06.setBounds(611, 152, 100, 100);
        l06.setFont(new Font(null, Font.PLAIN, 30));
        l06.setForeground(Color.white);
        frame.add(l06);
        if(f_list.get("F06") != null) {
            JLabel l6 = new JLabel(f_list.get("F06"));
            l6.setBounds(578, 211, 200, 100);
            l6.setFont(new Font(null, Font.PLAIN, 20));
            l6.setForeground(Color.white);
            frame.add(l6);

        }

        Search.setBounds(850, 200, 200, 100);
        Search.setFont(new Font(null, Font.PLAIN, 30));
        Search.setBorder(BorderFactory.createLineBorder(Color.white));
        Search.setBackground(Color.darkGray);
        Search.setForeground(Color.white);
        Search.addActionListener(this);
        Search.setFocusable(false);
        frame.add(Search);

        Container.setBounds(850, 400, 200, 100);
        Container.setFont(new Font(null, Font.PLAIN, 30));
        Container.setBorder(BorderFactory.createLineBorder(Color.white));
        Container.setOpaque(true);
        Container.setBackground(Color.darkGray);
        Container.setForeground(Color.white);
        Container.addActionListener(this);
        Container.setFocusable(false);
        frame.add(Container);

        Menu.setBounds(850, 600, 200, 100);
        Menu.setFont(new Font(null, Font.PLAIN, 30));
        Menu.setBorder(BorderFactory.createLineBorder(Color.white));
        Menu.setBackground(Color.darkGray);
        Menu.setForeground(Color.white);
        Menu.setFocusable(false);
        Menu.addActionListener(this);
        frame.add(Menu);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(1200, 1420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Freezer");
    }

    public void actionPerformed(ActionEvent e) {
        LockerVisualization.getsource(e, Menu, frame, userID, pickupSystem, loginController, Container, Search);
    }

}
