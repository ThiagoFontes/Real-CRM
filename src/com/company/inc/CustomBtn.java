package com.company.inc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Thiago Fontes on 30/07/2018.
 */
public class CustomBtn extends JButton implements MouseListener {
    public CustomBtn(String text)
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
     * @param background background Color
     */
    public CustomBtn(String text, Color foreground, Color background){
        super(text);
        setForeground(foreground);
        setBackground(background);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusPainted(false);
        addMouseListener(this);
        setVisible(true);
    }

    public CustomBtn(String text, Dimension preferredSize, Color foreground, Color background){
        super(text);
        setPreferredSize(preferredSize);
        setFont(new Font("Sans", Font.PLAIN, 5));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(foreground);
        setBackground(background);
        setFocusPainted(false);
        addMouseListener(this);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(getBackground());
        g2.setPaint(new GradientPaint(new Point(0, 0), getBackground(), new Point(0,getHeight()),getBackground()));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 3, 3);
        g2.setPaint(getForeground());
        FontMetrics metrics = g.getFontMetrics();

        g2.drawString(getText(),(getWidth()-metrics.stringWidth(getText()))/2 ,(metrics.getHeight()));
        g2.dispose();
    }

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
