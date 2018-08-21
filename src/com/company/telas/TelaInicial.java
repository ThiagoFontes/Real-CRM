package com.company.telas;

import org.pushingpixels.substance.api.UiThreadingViolationException;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 31/07/2018.
 */
public class TelaInicial extends JPanel {
    public TelaInicial () {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("<html>" +
                "<body style=\"text-align:center;padding-right:56px;padding-top:40px;\">" +
                "REAL CRM<br>WORLD CUP EDITION</body></html>", JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 50));

        //JLabel sub = new JLabel("World Cup Edition", JLabel.CENTER);
        //sub.setVerticalAlignment(JLabel.NORTH);
        //sub.setPreferredSize( new Dimension(100, 100));
        JPanel btnComponent = new JPanel( new FlowLayout());
        JButton button = new JButton("Login");
        //button.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnComponent.add(button);
        super.add(title);
        super.add(btnComponent);
    }
}
