package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class LockerVisualization implements ActionListener{
    private JFrame frame = new JFrame();
    private ImageIcon LockerImage= new ImageIcon("src/Locker.png");
    private JButton Menu = new JButton("Menu");
    private JButton Search = new JButton("Search");
    private JButton Container = new JButton("Return");
    private JLabel LockerLocker = new JLabel(LockerImage);
    private ImageIcon VImage= new ImageIcon("src/Vertical.png");
    private ImageIcon HImage= new ImageIcon("src/Horizontal.png");
    private ImageIcon Vb = new ImageIcon("src/Verticalborder.png");
    private JLabel Vertivcalline1 = new JLabel(VImage);
    private JLabel Vertivcalline2 = new JLabel(VImage);
    private JLabel Horizontalline1 = new JLabel(HImage);
    private JLabel Horizongtalline2 = new JLabel(HImage);
    private JLabel Horizontalline3 = new JLabel(HImage);
    private JLabel Horizontalline4 = new JLabel(HImage);
    private JLabel Horizontalline5 = new JLabel(HImage);
    private JLabel Horizontalline6 = new JLabel(HImage);
    private JLabel VerticalBorder1 = new JLabel(Vb);
    private JLabel VerticalBorder2 = new JLabel(Vb);
    private PickupSystem pickupSystem;
    private LoginController loginController;
    private String userID = new String();
    private JLabel L01 = new JLabel("L01");
    private JLabel L02 = new JLabel("L02");
    private JLabel L03 = new JLabel("L03");
    private JLabel L04 = new JLabel("L04");
    private JLabel L05 = new JLabel("L05");
    private JLabel L06 = new JLabel("L06");
    private JLabel L07 = new JLabel("L07");
    private JLabel L08 = new JLabel("L08");
    private JLabel L09 = new JLabel("L09");
    private JLabel L010 = new JLabel("L10");
    private JLabel L011 = new JLabel("L11");
    private JLabel L012 = new JLabel("L12");
    private JLabel L013 = new JLabel("L13");
    private JLabel L014 = new JLabel("L14");
    private JLabel L015 = new JLabel("L15");
    private JLabel L1 = new JLabel();
    private JLabel L2= new JLabel();
    private JLabel L3 = new JLabel();
    private JLabel L4 = new JLabel();
    private JLabel L5 = new JLabel();
    private JLabel L6 = new JLabel();
    private JLabel L7 = new JLabel();
    private JLabel L8 = new JLabel();
    private JLabel L9 = new JLabel();
    private JLabel L10 = new JLabel();
    private JLabel L11 = new JLabel();
    private JLabel L12 = new JLabel();
    private JLabel L13 = new JLabel();
    private JLabel L14 = new JLabel();
    private JLabel L15 = new JLabel();

    public LockerVisualization(String username, PickupSystem pckSys, LoginController loginC) {
        this.pickupSystem = pckSys;
        this.loginController = loginC;
        this.userID = username;

        ArrayList<String> f_list = pckSys.get_package("locker");

        Horizontalline1.setBounds(0, 20, 800, 20);
        frame.add(Horizontalline1);

        Horizongtalline2.setBounds(0, 760, 800, 20);
        frame.add(Horizongtalline2);

        VerticalBorder1.setBounds(29, 2, 40, 800);
        frame.add(VerticalBorder1);

        VerticalBorder2.setBounds(731, 2, 40, 800);
        frame.add(VerticalBorder2);

        Vertivcalline1.setBounds(263, 2, 40, 800);
        frame.add(Vertivcalline1);

        Vertivcalline2.setBounds(497, 2, 40, 800);
        frame.add(Vertivcalline2);

        Horizontalline3.setBounds(0, 168, 800, 10);
        frame.add(Horizontalline3);

        Horizontalline4.setBounds(0, 316, 800, 10);
        frame.add(Horizontalline4);

        Horizontalline5.setBounds(0, 464, 800, 10);
        frame.add(Horizontalline5);

        Horizontalline6.setBounds(0, 612, 800, 10);
        frame.add(Horizontalline6);


        L01.setBounds(143, 4, 100, 100);
        L01.setFont(new Font(null, Font.PLAIN, 30));
        L01.setForeground(Color.white);
        frame.add(L01);

        if (f_list != null) {
            if (f_list.size() > 0) {
                L1 = new JLabel((String) f_list.get(0));
                L1.setBounds(110, 63, 200, 100);
                L1.setFont(new Font(null, Font.PLAIN, 20));
                L1.setForeground(Color.white);
                frame.add(L1);
            }
        }

        L02.setBounds(377, 4, 100, 100);
        L02.setFont(new Font(null, Font.PLAIN, 30));
        L02.setForeground(Color.white);
        frame.add(L02);

        if(f_list != null) {
            if (f_list.size() > 1) {
                L2 = new JLabel((String) f_list.get(1));
                L2.setBounds(344, 63, 200, 100);
                L2.setFont(new Font(null, Font.PLAIN, 20));
                L2.setForeground(Color.white);
                frame.add(L2);
            }
        }

        L03.setBounds(611, 4, 100, 100);
        L03.setFont(new Font(null, Font.PLAIN, 30));
        L03.setForeground(Color.white);
        frame.add(L03);
        if(f_list != null) {
            if (f_list.size() > 2) {
                L3 = new JLabel((String) f_list.get(2));
                L3.setBounds(578, 63, 200, 100);
                L3.setFont(new Font(null, Font.PLAIN, 20));
                L3.setForeground(Color.white);
                frame.add(L3);
            }
        }


        L04.setBounds(143, 152, 100, 100);
        L04.setFont(new Font(null, Font.PLAIN, 30));
        L04.setForeground(Color.white);
        frame.add(L04);

        if(f_list != null) {
            if (f_list.size() > 3) {
                L4 = new JLabel((String) f_list.get(3));
                L4.setBounds(110, 211, 200, 100);
                L4.setFont(new Font(null, Font.PLAIN, 20));
                L4.setForeground(Color.white);
                frame.add(L4);
            }
        }

        L05.setBounds(377, 152, 100, 100);
        L05.setFont(new Font(null, Font.PLAIN, 30));
        L05.setForeground(Color.white);
        frame.add(L05);

        if(f_list != null) {
            if (f_list.size() > 4) {
                L5 = new JLabel((String) f_list.get(4));
                L5.setBounds(344, 211, 200, 100);
                L5.setFont(new Font(null, Font.PLAIN, 20));
                L5.setForeground(Color.white);
                frame.add(L5);
            }
        }

        L06.setBounds(611, 152, 100, 100);
        L06.setFont(new Font(null, Font.PLAIN, 30));
        L06.setForeground(Color.white);
        frame.add(L06);
        if(f_list != null) {
            if (f_list.size() > 5) {
                L6 = new JLabel((String) f_list.get(5));
                L6.setBounds(578, 211, 200, 100);
                L6.setFont(new Font(null, Font.PLAIN, 20));
                L6.setForeground(Color.white);
                frame.add(L6);
            }
        }


        L07.setBounds(143, 300, 100, 100);
        L07.setFont(new Font(null, Font.PLAIN, 30));
        L07.setForeground(Color.white);
        frame.add(L07);

        if(f_list != null) {
            if (f_list.size() > 6) {
                L7 = new JLabel((String) f_list.get(6));
                L7.setBounds(110, 359, 200, 100);
                L7.setFont(new Font(null, Font.PLAIN, 20));
                L7.setForeground(Color.white);
                frame.add(L7);
            }
        }

        L08.setBounds(377, 300, 100, 100);
        L08.setFont(new Font(null, Font.PLAIN, 30));
        L08.setForeground(Color.white);
        frame.add(L08);

        if(f_list != null) {
            if (f_list.size() > 7) {
                L8 = new JLabel((String) f_list.get(7));
                L8.setBounds(344, 359, 200, 100);
                L8.setFont(new Font(null, Font.PLAIN, 20));
                L8.setForeground(Color.white);
                frame.add(L8);
            }
        }


        L09.setBounds(611, 300, 100, 100);
        L09.setFont(new Font(null, Font.PLAIN, 30));
        L09.setForeground(Color.white);
        frame.add(L09);

        if(f_list != null) {
            if (f_list.size() > 8) {
                L9 = new JLabel((String) f_list.get(8));
                L9.setBounds(578, 359, 200, 100);
                L9.setFont(new Font(null, Font.PLAIN, 20));
                L9.setForeground(Color.white);
                frame.add(L9);
            }
        }

        L010.setBounds(143, 448, 100, 100);
        L010.setFont(new Font(null, Font.PLAIN, 30));
        L010.setForeground(Color.white);
        frame.add(L010);

        if(f_list != null) {
            if (f_list.size() > 9) {
                L10 = new JLabel((String) f_list.get(9));
                L10.setBounds(110, 507, 200, 100);
                L10.setFont(new Font(null, Font.PLAIN, 20));
                L10.setForeground(Color.white);
                frame.add(L10);
            }
        }

        L011.setBounds(377, 448, 100, 100);
        L011.setFont(new Font(null, Font.PLAIN, 30));
        L011.setForeground(Color.white);
        frame.add(L011);

        if(f_list != null) {
            if (f_list.size() > 10) {
                L11 = new JLabel((String) f_list.get(10));
                L11.setBounds(344, 507, 200, 100);
                L11.setFont(new Font(null, Font.PLAIN, 20));
                L11.setForeground(Color.white);
                frame.add(L11);
            }
        }


        L012.setBounds(611, 448, 100, 100);
        L012.setFont(new Font(null, Font.PLAIN, 30));
        L012.setForeground(Color.white);
        frame.add(L012);

        if(f_list != null) {
            if (f_list.size() > 11) {
                L12 = new JLabel((String) f_list.get(11));
                L12.setBounds(578, 507, 200, 100);
                L12.setFont(new Font(null, Font.PLAIN, 20));
                L12.setForeground(Color.white);
                frame.add(L12);
            }
        }

        L013.setBounds(143, 596, 100, 100);
        L013.setFont(new Font(null, Font.PLAIN, 30));
        L013.setForeground(Color.white);
        frame.add(L013);

        if(f_list != null) {
            if (f_list.size() > 12) {
                L13 = new JLabel((String) f_list.get(12));
                L13.setBounds(110, 655, 200, 100);
                L13.setFont(new Font(null, Font.PLAIN, 20));
                L13.setForeground(Color.white);
                frame.add(L13);
            }
        }

        L014.setBounds(377, 596, 100, 100);
        L014.setFont(new Font(null, Font.PLAIN, 30));
        L014.setForeground(Color.white);
        frame.add(L014);

        if(f_list != null) {
            if (f_list.size() > 13) {
                L14 = new JLabel((String) f_list.get(13));
                L14.setBounds(344, 655, 200, 100);
                L14.setFont(new Font(null, Font.PLAIN, 20));
                L14.setForeground(Color.white);
                frame.add(L14);
            }
        }

        L015.setBounds(611, 596, 100, 100);
        L015.setFont(new Font(null, Font.PLAIN, 30));
        L015.setForeground(Color.white);
        frame.add(L015);

        if(f_list != null) {
            if (f_list.size() > 14) {
                L15 = new JLabel((String) f_list.get(14));
                L15.setBounds(578, 655, 200, 100);
                L15.setFont(new Font(null, Font.PLAIN, 20));
                L15.setForeground(Color.white);
                frame.add(L15);
            }
        }

        Search.setBounds(850, 200, 200, 100);
        Search.setFont(new Font(null, Font.PLAIN, 30));
        Search.setBorder(BorderFactory.createLineBorder(Color.white));
        Search.setOpaque(true);
        Search.setBackground(Color.white);
        Search.setForeground(Color.darkGray);
        Search.addActionListener(this);
        frame.add(Search);

        Container.setBounds(850, 400, 200, 100);
        Container.setFont(new Font(null, Font.PLAIN, 30));
        Container.setBorder(BorderFactory.createLineBorder(Color.white));
        Container.setOpaque(true);
        Container.setBackground(Color.white);
        Container.setForeground(Color.darkGray);
        Container.addActionListener(this);
        frame.add(Container);

        Menu.setBounds(850, 600, 200, 100);
        Menu.setFont(new Font(null, Font.PLAIN, 30));
        Menu.setBorder(BorderFactory.createLineBorder(Color.white));
        Menu.setForeground(Color.white);
        Menu.setBackground(Color.darkGray);
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
