package com.company;
import com.company.inc.*;
import com.company.inc.Menu;
import com.company.telas.TelaInicial;

import javax.swing.*;
import java.awt.*;

/**
 * Defines the main frame that will be suporting each window content,
 * this way we will use only one JFrame to support everything
 */
public class Main extends JFrame {
    private String menuStrings[] = {"Início", "Contatos", "Negociações", "Relacionamento"};

    public Main () {
        super.setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBackground(Color.DARK_GRAY);
        //drag topbar
        ComponentMover cm = new ComponentMover(this ,top);
        //Create minimize button
        JButton m = new customBtn("-", Color.white, Color.DARK_GRAY);
        m.addActionListener(e -> {
            super.setState(Frame.ICONIFIED);
        });
        //Create close button
        JButton closeBtn = new customBtn("X", Color.white, Color.DARK_GRAY);
        closeBtn.addActionListener(e -> System.exit(0));

        // Definição da barra de título
        JPanel titleContainer = new JPanel(new FlowLayout());
        JLabel title = new JLabel("REAL CRM");

        title.setForeground(Color.white);
        titleContainer.add(title);
        titleContainer.setBackground(Color.DARK_GRAY);
        titleContainer.setPreferredSize(new Dimension(600, 30));

        top.add(titleContainer);
        top.add(m);
        top.add(closeBtn);

        // Adicionando componentes a janela principal
        super.add("North", top);
        super.setUndecorated(true);
        super.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        super.setSize(800, 500);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private  void setTelaInicial () {
        JPanel content = new JPanel(new BorderLayout());
        content.add("North", new Menu(menuStrings, 0));
        content.add("Center", new TelaInicial());
        this.add("Center", content);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        Main tela = new Main();
        tela.setTelaInicial();
    }
}
