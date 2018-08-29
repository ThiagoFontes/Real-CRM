package com.company.telas;

import com.company.inc.CustomBtn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thiago Fontes on 04/08/2018.
 */
public class TelaContatos extends JPanel {
    private String[] lista = { "Bird", "Cat", "Dog", "Rabbittttttttttttttttttttttttttttttttttttttttttttttttt", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig" };
    private String conteudo = "nome: aaaa\nTelefone: 00000\n.\n.\n.\n";
    private JScrollPane scrollPane;
    private JTextArea texto;
    private JPanel bounds;
    private JButton edit;
    private JButton delete;
    private JPanel editPanel;
    private CustomBtn create;

    public TelaContatos (CustomBtn edit, CustomBtn delete, CustomBtn create)  {
        super.setLayout(new BorderLayout());

        JList contatoList = new JList(lista);

        scrollPane = new JScrollPane(contatoList);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        scrollPane.setBorder(BorderFactory.createMatteBorder(10, 0, 20, 30, new Color(229, 233,242)));

        texto = new JTextArea(conteudo);
        texto.setEditable(false);
        texto.setPreferredSize(new Dimension(500,300));
        texto.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(219, 224,233)));

        //edit = new CustomBtn("Editar",Color.WHITE, new Color(71,82,94));
        //delete = new CustomBtn("Excluir",Color.WHITE, new Color(71,82,94));

        editPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        editPanel.setOpaque(false);
        editPanel.add(edit);
        editPanel.add(delete);
        editPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(229, 233,242)));

        //create = new CustomBtn("Criar",Color.WHITE, new Color(71,82,94));

        bounds = new JPanel(new BorderLayout());
        bounds.setBackground(new Color(219, 224,233));
        bounds.add(BorderLayout.NORTH,texto);
        bounds.add(BorderLayout.CENTER, editPanel);
        //bounds.add(BorderLayout.SOUTH, create);

        super.setBackground(new Color(229, 233,242));
        super.add(scrollPane, BorderLayout.WEST);
        super.add(bounds, BorderLayout.CENTER);
        super.add(create, BorderLayout.SOUTH);
        super.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, new Color(229, 233,242)));
    }
}
