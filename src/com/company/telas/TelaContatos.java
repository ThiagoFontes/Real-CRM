package com.company.telas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 04/08/2018.
 */
public class TelaContatos extends JPanel {
    String[] contatos = { "Bird", "Cat", "Dog", "Rabbittttttttttttttttttttttttttttttttttttttttttttttttt", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig" };
    JScrollPane scrollPane;
    public TelaContatos ()  {
        super.setLayout(new BorderLayout());

        JList contatoList = new JList(contatos);

        scrollPane = new JScrollPane(contatoList);
        scrollPane.setPreferredSize(new Dimension(200, 300));

        super.add(scrollPane, BorderLayout.WEST);
        super.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, UIManager.getColor ( "Panel.background" )));
        //super.add(sub, BorderLayout.PAGE_END);
    }
}
