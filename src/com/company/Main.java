package com.company;
import com.company.inc.ComponentMover;
import com.company.inc.customBtn;
import com.company.telas.TelaContatos;
import com.company.telas.TelaInicial;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

/**
 * Defines the main frame that will be suporting each window content,
 * this way we will use only one JFrame to support everything
 */
public class Main extends JFrame {
    protected final String menuStrings[] = {"Início", "Contatos", "Negociações", "Relacionamento"};
    private JPanel content = new JPanel(new BorderLayout());
    private JLabel[] label = new JLabel[menuStrings.length];
    private JPanel menu = new JPanel();
    private int current = 0;

    public Main () {
        super.setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBackground(Color.DARK_GRAY);
        //drag topbar
        ComponentMover cm = new ComponentMover(this ,top);
        //Create minimize button
        JButton m = new customBtn("-", Color.black, Color.darkGray);
        m.addActionListener(e -> {
            super.setState(Frame.ICONIFIED);
        });
        //Create close button
        JButton closeBtn = new customBtn("X", Color.black, Color.DARK_GRAY);
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

        //criando menu
        createMenu(menu);
        content.add(menu, BorderLayout.NORTH);


        // Adicionando componentes a janela principal

        super.add("North", top);
        super.setUndecorated(true);
        super.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.darkGray));
        super.setSize(800, 500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private void reloadTela(){
        content = new JPanel(new BorderLayout());
        createMenu(menu);
        content.add(menu, BorderLayout.NORTH);
    }

    private  void setTelaInicial () {
        //reloadTela();
        content.add("Center", new TelaInicial());
        this.add("Center", content);
        super.setVisible(true);
    }

    private  void setTelaContatos () {
        //reloadTela();
        content.add("Center", new TelaContatos());
        this.add("Center", content);
        super.setVisible(true);
    }

    //Menu Mouse Listener
    private MouseListener ml = new MouseListener() {

        private void refreshColors(MouseEvent e){
            for (int i = 0; i < menuStrings.length; i++) {
                if((e.getSource() != label[i]) && (i != current)) {
                    label[i].setForeground(Color.black);
                } else if (i == current) {
                    label[i].setForeground(Color.GRAY);
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int k = 0; k < menuStrings.length; k++) {
                if(e.getSource() == label[k]) {
                    current = k;
                    refreshColors(e);
                    switch (k) {
                        case 0:     //Inicial
                            setTelaInicial();
                            break;
                        case 1:
                            setTelaContatos();
                            break;
                        default:
                            setTelaInicial();
                            break;
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            refreshColors(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            refreshColors(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < menuStrings.length; i++) {
                if(e.getSource() == label[i]) {
                    label[i].setForeground(new Color(0x424345));
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            refreshColors(e);
        }
    };

    //Create Menu
    private void createMenu(JPanel m) {
        m.setLayout( new FlowLayout(FlowLayout.RIGHT));
        for (int i = 0; i < menuStrings.length; i++) {
            label[i] = new JLabel();
            label[i].setText(menuStrings[i]);
            label[i].setForeground(Color.BLACK);
            label[i].setHorizontalAlignment(JLabel.CENTER);
            //Começa na página inicial
            if (i == current) {
                label[i].setForeground(Color.GRAY);
            }

            label[i].setPreferredSize(new Dimension(110, 30));
            //label[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            label[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            label[i].addMouseListener(ml);
            m.add(label[i]);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Main tela = new Main();
        tela.setTelaInicial();
    }
}
