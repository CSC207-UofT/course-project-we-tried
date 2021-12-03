package UI;

import Controller.LoginController;
import Controller.PickupSystem;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClosetVisualization {
    private JFrame frame = new JFrame();
    private ImageIcon LockerImage= new ImageIcon("src/Locker.png");
    private JButton Locker = new JButton("Locker");
    private JButton Menu = new JButton("Menu");
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

    public ClosetVisualization(){
//        this.pickupSystem = pckSys;
//        this.loginController = lgcontrol;


        ArrayList friends = new ArrayList(100);
        friends.add("11111111111");
        friends.add("22222222222");
        friends.add("33333333333");

//        LockerLocker.setBounds(0, -100, 800, 1000);
//        frame.add(LockerLocker);

//        L1 = new JLabel((String) friends.get(0));
//        L1.setBounds(30, 90, 50, 50);
//        L1.setFont(new Font(null,Font.PLAIN, 17));
//        L1.setForeground(Color.white);
//        frame.add(L1);

        Horizontalline1.setBounds(0, 20, 800, 20);
        frame.add(Horizontalline1);

        Horizongtalline2.setBounds(0, 760, 800,20);
        frame.add(Horizongtalline2);

        VerticalBorder1.setBounds(29, 2, 40,800);
        frame.add(VerticalBorder1);

        VerticalBorder2.setBounds(731, 2, 40,800);
        frame.add(VerticalBorder2);

        Vertivcalline1.setBounds(263,2,40,800);
        frame.add(Vertivcalline1);

        Vertivcalline2.setBounds(497,2,40,800);
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
        L01.setFont(new Font(null,Font.PLAIN, 30));
        L01.setForeground(Color.white);
        frame.add(L01);

        L1 = new JLabel((String) friends.get(0));
        L1.setBounds(110, 63, 200, 100);
        L1.setFont(new Font(null,Font.PLAIN, 20));
        L1.setForeground(Color.white);
        frame.add(L1);

        L02.setBounds(377, 4, 100, 100);
        L02.setFont(new Font(null,Font.PLAIN, 30));
        L02.setForeground(Color.white);
        frame.add(L02);

        L2 = new JLabel((String) friends.get(1));
        L2.setBounds(344, 63, 200, 100);
        L2.setFont(new Font(null,Font.PLAIN, 20));
        L2.setForeground(Color.white);
        frame.add(L2);

        L03.setBounds(611, 4, 100, 100);
        L03.setFont(new Font(null,Font.PLAIN, 30));
        L03.setForeground(Color.white);
        frame.add(L03);

        L3 = new JLabel((String) friends.get(2));
        L3.setBounds(578, 63, 200, 100);
        L3.setFont(new Font(null,Font.PLAIN, 20));
        L3.setForeground(Color.white);
        frame.add(L3);

        L04.setBounds(143, 152, 100, 100);
        L04.setFont(new Font(null,Font.PLAIN, 30));
        L04.setForeground(Color.white);
        frame.add(L04);

        L05.setBounds(377, 152, 100, 100);
        L05.setFont(new Font(null,Font.PLAIN, 30));
        L05.setForeground(Color.white);
        frame.add(L05);

        L06.setBounds(611, 152, 100, 100);
        L06.setFont(new Font(null,Font.PLAIN, 30));
        L06.setForeground(Color.white);
        frame.add(L06);

        L07.setBounds(143, 300, 100, 100);
        L07.setFont(new Font(null,Font.PLAIN, 30));
        L07.setForeground(Color.white);
        frame.add(L07);

        L08.setBounds(377, 300, 100, 100);
        L08.setFont(new Font(null,Font.PLAIN, 30));
        L08.setForeground(Color.white);
        frame.add(L08);

        L09.setBounds(611, 300, 100, 100);
        L09.setFont(new Font(null,Font.PLAIN, 30));
        L09.setForeground(Color.white);
        frame.add(L09);

        L010.setBounds(143, 448, 100, 100);
        L010.setFont(new Font(null,Font.PLAIN, 30));
        L010.setForeground(Color.white);
        frame.add(L010);

        L011.setBounds(377, 448, 100, 100);
        L011.setFont(new Font(null,Font.PLAIN, 30));
        L011.setForeground(Color.white);
        frame.add(L011);

        L012.setBounds(611, 448, 100, 100);
        L012.setFont(new Font(null,Font.PLAIN, 30));
        L012.setForeground(Color.white);
        frame.add(L012);

        L013.setBounds(143, 596, 100, 100);
        L013.setFont(new Font(null,Font.PLAIN, 30));
        L013.setForeground(Color.white);
        frame.add(L013);

        L014.setBounds(377, 596, 100, 100);
        L014.setFont(new Font(null,Font.PLAIN, 30));
        L014.setForeground(Color.white);
        frame.add(L014);

        L015.setBounds(611, 596, 100, 100);
        L015.setFont(new Font(null,Font.PLAIN, 30));
        L015.setForeground(Color.white);
        frame.add(L015);





        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setSize(1200, 1420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        ClosetVisualization ccc = new ClosetVisualization();
    }
}
