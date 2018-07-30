package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    private static JButton createButton (String text) {
        JButton b = new JButton(text);
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.setFocusPainted(false);
        b.addActionListener(e -> System.exit(0));
        return b;
    }
    private static JButton closeBtn() {
        JButton b = new customBtn("X");
        b.setFocusPainted(false);
        b.addActionListener(e -> System.exit(0));
        return b;
    }

    public static void createWindow() {
        JFrame frame = new JFrame("");

        frame.setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBackground(Color.DARK_GRAY);
        //drag topbar
        ComponentMover cm = new ComponentMover(frame, top);
        //Create minimize buton
        JButton m = new customBtn("-");
        m.setFocusPainted(false);
        m.addActionListener(e -> {
            frame.setState(Frame.ICONIFIED);
        });

        JPanel titleContainer = new JPanel(new FlowLayout());
        JLabel title = new JLabel("REAL CRM");
        title.setForeground(Color.white);
        titleContainer.add(title);
        titleContainer.setBackground(Color.DARK_GRAY);
        titleContainer.setPreferredSize(new Dimension(600, 30));


        top.add(titleContainer);
        top.add(m);
        top.add(closeBtn());

        frame.add(BorderLayout.NORTH, top);
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello!");
        createWindow();
    }
}
