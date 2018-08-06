package com.company.inc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Thiago Fontes on 30/07/2018.
 */
public class customBtn extends JButton implements MouseListener {
    public customBtn(String text)
    {
        super(text);
        //setBorder(new LineBorder(Color.LIGHT_GRAY, 0, true));
        setForeground(Color.white);
        setBackground(Color.black);
        //setContentAreaFilled(false);
        setFocusPainted(false);
        addMouseListener(this);
        setVisible(true);
    }

    /**
     * Constructor to define text and background/foreground colors
     * @param text Text that goes into the button
     * @param foreground Foreground Color
     * @param Background Background Color
     */
    public customBtn (String text, Color foreground, Color Background){
        super(text);
        setForeground(foreground);
        setBackground(Background);
        setFocusPainted(false);
        addMouseListener(this);
        setVisible(true);
    }

    public customBtn(String text, Dimension preferredSize, Color foreground, Color Background){
        super(text);
        setPreferredSize(preferredSize);
        setFont(new Font("Sans", Font.PLAIN, 5));
        setForeground(foreground);
        setBackground(Background);
        setFocusPainted(false);
        addMouseListener(this);
        setVisible(true);
    }

    /*
    @Override
      protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(new Point(0, 0), Color.WHITE, new Point(0,
                getHeight()), Color.PINK.darker()));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.setPaint(Color.BLACK);
        g2.drawString(getText(), 30, 12);
        g2.dispose();
    }*/

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
