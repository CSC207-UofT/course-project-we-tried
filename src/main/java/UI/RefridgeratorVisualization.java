package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class RefridgeratorVisualization implements ActionListener{
    private final JFrame frame = new JFrame();
    private final JButton Menu = new JButton("Main Menu");
    private final JButton Search = new JButton("Search");
    private final JButton Container = new JButton("Return");
    private final PickupSystem pickupSystem;
    private final LoginController loginController;
    private final String userID;

    /**
     * Construct the RefrigeratorVisualization UI.
     * @param username input username.
     * @param pckSys input PickupSystem.
     * @param loginC input LoginController.
     */

    public RefridgeratorVisualization(String username, PickupSystem pckSys, LoginController loginC) {
        this.pickupSystem = pckSys;
        this.loginController = loginC;
        this.userID = username;

        Map<String,String>  f_list = pckSys.get_package("refrigerator");

        ImageIcon HImage = new ImageIcon("src/Horizontal.png");
        JLabel horizontalline1 = new JLabel(HImage);
        horizontalline1.setBounds(0, 20, 800, 20);
        frame.add(horizontalline1);

        ImageIcon verticalborder = new ImageIcon("src/VerticalborderR.png");
        JLabel verticalBorder1 = new JLabel(verticalborder);
        verticalBorder1.setBounds(29, 2, 40, 635);
        frame.add(verticalBorder1);

        JLabel verticalBorder2 = new JLabel(verticalborder);
        verticalBorder2.setBounds(731, 2, 40, 635);
        frame.add(verticalBorder2);

        ImageIcon VImage = new ImageIcon("src/VerticalR.png");
        JLabel vertivcalline1 = new JLabel(VImage);
        vertivcalline1.setBounds(263, 2, 40, 635);
        frame.add(vertivcalline1);

        JLabel vertivcalline2 = new JLabel(VImage);
        vertivcalline2.setBounds(497, 2, 40, 635);
        frame.add(vertivcalline2);

        JLabel horizontalline3 = new JLabel(HImage);
        horizontalline3.setBounds(0, 168, 800, 10);
        frame.add(horizontalline3);

        JLabel horizontalline4 = new JLabel(HImage);
        horizontalline4.setBounds(0, 316, 800, 10);
        frame.add(horizontalline4);

        JLabel horizontalline5 = new JLabel(HImage);
        horizontalline5.setBounds(0, 464, 800, 10);
        frame.add(horizontalline5);

        JLabel horizontalline6 = new JLabel(HImage);
        horizontalline6.setBounds(0, 607, 800, 10);
        frame.add(horizontalline6);


        JLabel l01 = new JLabel("R01");
        l01.setBounds(143, 4, 100, 100);
        l01.setFont(new Font(null, Font.PLAIN, 30));
        l01.setForeground(Color.white);
        frame.add(l01);

        if (f_list.get("R01") != null) {
            JLabel l1 = new JLabel(f_list.get("R01"));
            l1.setBounds(110, 63, 200, 100);
            l1.setFont(new Font(null, Font.PLAIN, 20));
            l1.setForeground(Color.white);
            frame.add(l1);

        }

        JLabel l02 = new JLabel("R02");
        l02.setBounds(377, 4, 100, 100);
        l02.setFont(new Font(null, Font.PLAIN, 30));
        l02.setForeground(Color.white);
        frame.add(l02);

        if(f_list.get("R02") != null) {
            JLabel l2 = new JLabel(f_list.get("R02"));
            l2.setBounds(344, 63, 200, 100);
            l2.setFont(new Font(null, Font.PLAIN, 20));
            l2.setForeground(Color.white);
            frame.add(l2);

        }

        JLabel l03 = new JLabel("R03");
        l03.setBounds(611, 4, 100, 100);
        l03.setFont(new Font(null, Font.PLAIN, 30));
        l03.setForeground(Color.white);
        frame.add(l03);
        if(f_list.get("R03") != null) {
            JLabel l3 = new JLabel(f_list.get("R03"));
            l3.setBounds(578, 63, 200, 100);
            l3.setFont(new Font(null, Font.PLAIN, 20));
            l3.setForeground(Color.white);
            frame.add(l3);
        }


        JLabel l04 = new JLabel("R04");
        l04.setBounds(143, 152, 100, 100);
        l04.setFont(new Font(null, Font.PLAIN, 30));
        l04.setForeground(Color.white);
        frame.add(l04);

        if(f_list.get("R04") != null) {
            JLabel l4 = new JLabel(f_list.get("R04"));
            l4.setBounds(110, 211, 200, 100);
            l4.setFont(new Font(null, Font.PLAIN, 20));
            l4.setForeground(Color.white);
            frame.add(l4);
        }

        JLabel l05 = new JLabel("R05");
        l05.setBounds(377, 152, 100, 100);
        l05.setFont(new Font(null, Font.PLAIN, 30));
        l05.setForeground(Color.white);
        frame.add(l05);

        if(f_list.get("R05") != null) {
            JLabel l5 = new JLabel(f_list.get("R05"));
            l5.setBounds(344, 211, 200, 100);
            l5.setFont(new Font(null, Font.PLAIN, 20));
            l5.setForeground(Color.white);
            frame.add(l5);
        }

        JLabel l06 = new JLabel("R06");
        l06.setBounds(611, 152, 100, 100);
        l06.setFont(new Font(null, Font.PLAIN, 30));
        l06.setForeground(Color.white);
        frame.add(l06);
        if(f_list.get("R06") != null) {
            JLabel l6 = new JLabel(f_list.get("R06"));
            l6.setBounds(578, 211, 200, 100);
            l6.setFont(new Font(null, Font.PLAIN, 20));
            l6.setForeground(Color.white);
            frame.add(l6);
        }


        JLabel l07 = new JLabel("R07");
        l07.setBounds(143, 300, 100, 100);
        l07.setFont(new Font(null, Font.PLAIN, 30));
        l07.setForeground(Color.white);
        frame.add(l07);

        if(f_list.get("R07") != null) {
            JLabel l7 = new JLabel(f_list.get("R07"));
            l7.setBounds(110, 359, 200, 100);
            l7.setFont(new Font(null, Font.PLAIN, 20));
            l7.setForeground(Color.white);
            frame.add(l7);
        }

        JLabel l08 = new JLabel("R08");
        l08.setBounds(377, 300, 100, 100);
        l08.setFont(new Font(null, Font.PLAIN, 30));
        l08.setForeground(Color.white);
        frame.add(l08);

        if(f_list.get("R08") != null) {
            JLabel l8 = new JLabel(f_list.get("R08"));
            l8.setBounds(344, 359, 200, 100);
            l8.setFont(new Font(null, Font.PLAIN, 20));
            l8.setForeground(Color.white);
            frame.add(l8);
        }


        JLabel l09 = new JLabel("R09");
        l09.setBounds(611, 300, 100, 100);
        l09.setFont(new Font(null, Font.PLAIN, 30));
        l09.setForeground(Color.white);
        frame.add(l09);

        if(f_list.get("R09") != null) {
            JLabel l9 = new JLabel(f_list.get("R09"));
            l9.setBounds(578, 359, 200, 100);
            l9.setFont(new Font(null, Font.PLAIN, 20));
            l9.setForeground(Color.white);
            frame.add(l9);
        }

        JLabel l010 = new JLabel("R10");
        l010.setBounds(143, 448, 100, 100);
        l010.setFont(new Font(null, Font.PLAIN, 30));
        l010.setForeground(Color.white);
        frame.add(l010);

        if(f_list.get("R10") != null) {
            JLabel l10 = new JLabel(f_list.get("R10"));
            l10.setBounds(110, 507, 200, 100);
            l10.setFont(new Font(null, Font.PLAIN, 20));
            l10.setForeground(Color.white);
            frame.add(l10);
        }

        JLabel l011 = new JLabel("R11");
        l011.setBounds(377, 448, 100, 100);
        l011.setFont(new Font(null, Font.PLAIN, 30));
        l011.setForeground(Color.white);
        frame.add(l011);

        if(f_list.get("R11") != null) {
            JLabel l11 = new JLabel(f_list.get("R11"));
            l11.setBounds(344, 507, 200, 100);
            l11.setFont(new Font(null, Font.PLAIN, 20));
            l11.setForeground(Color.white);
            frame.add(l11);
        }


        JLabel l012 = new JLabel("R12");
        l012.setBounds(611, 448, 100, 100);
        l012.setFont(new Font(null, Font.PLAIN, 30));
        l012.setForeground(Color.white);
        frame.add(l012);

        if(f_list.get("R12") != null) {
            JLabel l12 = new JLabel(f_list.get("R12"));
            l12.setBounds(578, 507, 200, 100);
            l12.setFont(new Font(null, Font.PLAIN, 20));
            l12.setForeground(Color.white);
            frame.add(l12);
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
        frame.setTitle("Refrigerator");
    }
    /**
     * Record correspondent response toward different button click.
     * @param e input button click
     */

    public void actionPerformed(ActionEvent e) {
        actionperfomed(e, Menu, frame, userID, pickupSystem, loginController, Container);
        if (e.getSource() == Search) {
            frame.dispose();
            try {
                new OperationSearch(userID, this.pickupSystem, this.loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Make correspondent response toward different button click.
     * @param e input button click.
     * @param container input click on container.
     * @param frame input frame.
     * @param userID input user ID.
     * @param loginController input LoginController.
     * @param menu input click on menu.
     * @param pickupSystem input PickupSystem.
     */
    static void actionperfomed(ActionEvent e, JButton menu, JFrame frame, String userID, PickupSystem pickupSystem, LoginController loginController, JButton container) {
        if (e.getSource() == menu) {
            frame.dispose();
            try {
                new MenuPage(userID, pickupSystem, loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == container){
            frame.dispose();
            try {
                new ContainerMap(userID, pickupSystem, loginController);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}
