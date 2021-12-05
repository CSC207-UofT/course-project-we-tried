package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FreezerVisualization implements ActionListener {
    private JFrame frame = new JFrame();
    private ImageIcon LockerImage = new ImageIcon("src/Locker.png");
    private JButton Menu = new JButton("Menu");
    private JButton Search = new JButton("Search");
    private JButton Container = new JButton("Return");
    private ImageIcon VImage = new ImageIcon("src/VerticalF.png");
    private ImageIcon HImage = new ImageIcon("src/Horizontal.png");
    private ImageIcon Vb = new ImageIcon("src/VerticalborderF.png");
    private JLabel Vertivcalline1 = new JLabel(VImage);
    private JLabel Vertivcalline2 = new JLabel(VImage);
    private JLabel Horizontalline1 = new JLabel(HImage);
    private JLabel Horizontalline3 = new JLabel(HImage);
    private JLabel Horizontalline4 = new JLabel(HImage);
    private JLabel VerticalBorder1 = new JLabel(Vb);
    private JLabel VerticalBorder2 = new JLabel(Vb);
    private PickupSystem pickupSystem;
    private LoginController loginController;
    private String userID = new String();
    private JLabel L01 = new JLabel("F01");
    private JLabel L02 = new JLabel("F02");
    private JLabel L03 = new JLabel("F03");
    private JLabel L04 = new JLabel("F04");
    private JLabel L05 = new JLabel("F05");
    private JLabel L06 = new JLabel("F06");
    private JLabel L1 = new JLabel();
    private JLabel L2 = new JLabel();
    private JLabel L3 = new JLabel();
    private JLabel L4 = new JLabel();
    private JLabel L5 = new JLabel();
    private JLabel L6 = new JLabel();


    public FreezerVisualization(String username, PickupSystem pckSys, LoginController loginC) {
        this.pickupSystem = pckSys;
        this.loginController = loginC;
        this.userID = username;

        Map<String,String> f_list = pckSys.get_package("freezer");

        Horizontalline1.setBounds(0, 20, 800, 20);
        frame.add(Horizontalline1);

        VerticalBorder1.setBounds(29, 2, 40, 348);
        frame.add(VerticalBorder1);

        VerticalBorder2.setBounds(731, 2, 40, 348);
        frame.add(VerticalBorder2);

        Vertivcalline1.setBounds(263, 2, 40, 348);
        frame.add(Vertivcalline1);

        Vertivcalline2.setBounds(497, 2, 40, 348);
        frame.add(Vertivcalline2);

        Horizontalline3.setBounds(0, 168, 800, 10);
        frame.add(Horizontalline3);

        Horizontalline4.setBounds(0, 316, 800, 12);
        frame.add(Horizontalline4);


        L01.setBounds(143, 4, 100, 100);
        L01.setFont(new Font(null, Font.PLAIN, 30));
        L01.setForeground(Color.white);
        frame.add(L01);

        if (f_list.get("F01") != null) {
            L1 = new JLabel(f_list.get("F01"));
            L1.setBounds(110, 63, 200, 100);
            L1.setFont(new Font(null, Font.PLAIN, 20));
            L1.setForeground(Color.white);
            frame.add(L1);
        }

        L02.setBounds(377, 4, 100, 100);
        L02.setFont(new Font(null, Font.PLAIN, 30));
        L02.setForeground(Color.white);
        frame.add(L02);

        if(f_list.get("F02") != null) {
            L2 = new JLabel((String) f_list.get("F02"));
            L2.setBounds(344, 63, 200, 100);
            L2.setFont(new Font(null, Font.PLAIN, 20));
            L2.setForeground(Color.white);
            frame.add(L2);

        }

        L03.setBounds(611, 4, 100, 100);
        L03.setFont(new Font(null, Font.PLAIN, 30));
        L03.setForeground(Color.white);
        frame.add(L03);
        if(f_list.get("F03") != null) {
            L3 = new JLabel((String) f_list.get("F03"));
            L3.setBounds(578, 63, 200, 100);
            L3.setFont(new Font(null, Font.PLAIN, 20));
            L3.setForeground(Color.white);
            frame.add(L3);
        }


        L04.setBounds(143, 152, 100, 100);
        L04.setFont(new Font(null, Font.PLAIN, 30));
        L04.setForeground(Color.white);
        frame.add(L04);

        if(f_list.get("F04") != null) {
            L4 = new JLabel((String) f_list.get("F04"));
            L4.setBounds(110, 211, 200, 100);
            L4.setFont(new Font(null, Font.PLAIN, 20));
            L4.setForeground(Color.white);
            frame.add(L4);
        }

        L05.setBounds(377, 152, 100, 100);
        L05.setFont(new Font(null, Font.PLAIN, 30));
        L05.setForeground(Color.white);
        frame.add(L05);

        if(f_list.get("F05") != null) {
            L5 = new JLabel((String) f_list.get("F05"));
            L5.setBounds(344, 211, 200, 100);
            L5.setFont(new Font(null, Font.PLAIN, 20));
            L5.setForeground(Color.white);
            frame.add(L5);
        }

        L06.setBounds(611, 152, 100, 100);
        L06.setFont(new Font(null, Font.PLAIN, 30));
        L06.setForeground(Color.white);
        frame.add(L06);
        if(f_list.get("F06") != null) {
            L6 = new JLabel((String) f_list.get("F06"));
            L6.setBounds(578, 211, 200, 100);
            L6.setFont(new Font(null, Font.PLAIN, 20));
            L6.setForeground(Color.white);
            frame.add(L6);

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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Menu) {
            frame.dispose();
            try {
                MenuPage menuPage = new MenuPage(userID, pickupSystem, loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Container){
            frame.dispose();
            try {
                ContainerMap Cmap = new ContainerMap(userID, pickupSystem, loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == Search) {
            frame.dispose();
            try {
                OperationSearch operationSearch = new OperationSearch(userID, this.pickupSystem, this.loginController);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}
