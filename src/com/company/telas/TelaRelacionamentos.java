package com.company.telas;

import com.company.inc.CustomBtn;
import com.company.inc.HintTextFieldUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Thiago Fontes on 21/08/2018.
 */
public class TelaRelacionamentos extends JPanel {
    private final Color azulClaro = new Color(229, 233,242);
    private final Color azulMedio = new Color(219, 224,233);
    private final Color azulEscuro = new Color(71,82,94);
    private final Color corTitulo = new Color(0x47525E);
    private String[] lista = { "Bird", "Cat", "Dog", "Rabbittttttttttttttttttttttttttttttttttttttttttttttttt", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig", "Cat", "Dog", "Rabbit", "Pig" };
    private String conteudo = "nome: aaaa\nTelefone: 00000\n.\n.\n.\n";
    private JPanel sidePanel;
    private JTextField filtro;
    private JScrollPane scrollPane;
    private JTextArea texto;
    private JPanel bounds;
    private JButton edit;
    private JButton delete;
    private JPanel editPanel;
    private CustomBtn create;

    public TelaRelacionamentos(CustomBtn edit, CustomBtn delete, CustomBtn create) {
        super.setLayout(new BorderLayout());


        JList contatoList = new JList(lista);

        scrollPane = new JScrollPane(contatoList);
        scrollPane.setPreferredSize(new Dimension(200, 300));

        filtro = new JTextField();
        filtro.setUI(new HintTextFieldUI("Contato", true));

        sidePanel = new JPanel(new BorderLayout());
        sidePanel.add(filtro, BorderLayout.NORTH);
        sidePanel.add(scrollPane, BorderLayout.CENTER);
        sidePanel.setBorder(BorderFactory.createMatteBorder(10, 0, 20, 30,azulClaro));

        texto = new JTextArea(conteudo);
        texto.setEditable(false);
        texto.setPreferredSize(new Dimension(500,300));
        texto.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,azulMedio));

        //edit = new CustomBtn("Editar",Color.WHITE, azulEscuro);
        //delete = new CustomBtn("Excluir",Color.WHITE, azulEscuro);

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
        super.add(sidePanel, BorderLayout.WEST);
        super.add(bounds, BorderLayout.CENTER);
        super.add(create, BorderLayout.SOUTH);
        super.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, new Color(229, 233,242)));
    }
}
