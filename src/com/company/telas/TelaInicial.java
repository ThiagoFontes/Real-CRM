package com.company.telas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 31/07/2018.
 */
public class TelaInicial extends JPanel {
    public TelaInicial ()  {
        super.setLayout(new BorderLayout());
        JLabel title = new JLabel("REAL CRM", JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 70));

        JLabel sub = new JLabel("World Cup Edition", JLabel.CENTER);
        sub.setVerticalAlignment(JLabel.NORTH);
        sub.setPreferredSize( new Dimension(100, 100));

        super.add(title, BorderLayout.CENTER);
        super.add(sub, BorderLayout.PAGE_END);
    }
}
