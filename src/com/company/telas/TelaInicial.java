package com.company.telas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 31/07/2018.
 */
public class TelaInicial extends JPanel {
    public TelaInicial ()  {
        JLabel title = new JLabel("REAL CRM");
        title.setFont(new Font("Sans", Font.PLAIN, 70));
        super.add(BorderLayout.CENTER, title);
    }
}
