package com.company.inc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 31/07/2018.
 */
public class Menu extends JPanel {
    /**
     * Creates the app top menu
     * @param items Vector of strings with the menu entries
     * @param current Current page the menu is showing up
     */
    public Menu(String items[], int current) {
        JLabel label;
        for (int i = 0; i < items.length; i++) {
            label = new JLabel();
            label.setText(items[i]);
            label.setForeground(Color.BLACK);
            label.setHorizontalAlignment(JLabel.CENTER);
            if (i == current) {
                label.setForeground(Color.GRAY);
            }

            label.setPreferredSize(new Dimension(110, 30));
            //label.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
            super.add(label);
        }
        super.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
}
