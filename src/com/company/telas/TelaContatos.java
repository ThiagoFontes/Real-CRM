package com.company.telas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 04/08/2018.
 */
public class TelaContatos extends JPanel {
    private String[] contatos = { "Bird", "Cat", "Dog", "Rabbittttttttttttttttttttttttttttttttttttttttttttttttt", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig" };
    private String conteudoContato = "nome: aaaa\nTelefone: 00000\n.\n.\n.\n";
    private JScrollPane scrollPane;
    private JTextArea texto;

    public TelaContatos ()  {
        super.setLayout(new BorderLayout());

        JList contatoList = new JList(contatos);

        scrollPane = new JScrollPane(contatoList);
        scrollPane.setPreferredSize(new Dimension(200, 300));

        texto = new JTextArea(conteudoContato);
        texto.setPreferredSize(new Dimension(300,200));

        super.add(scrollPane, BorderLayout.WEST);
        super.add(texto, BorderLayout.CENTER);
        super.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, UIManager.getColor ( "Panel.background" )));

        //super.add(sub, BorderLayout.PAGE_END);
    }
}
