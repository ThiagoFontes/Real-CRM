package com.company;
import com.company.inc.ComponentMover;
import com.company.inc.customBtn;
import com.company.telas.TelaContatos;
import com.company.telas.TelaInicial;
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
    private String menuStrings[] = {"Início", "Contatos", "Negociações", "Relacionamento"};
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

        //criando menu
        menu.setLayout( new FlowLayout(FlowLayout.RIGHT));
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
            menu.add(label[i]);
        }
        content.add(menu, BorderLayout.NORTH);


        // Adicionando componentes a janela principal

        super.add("North", top);
        super.setUndecorated(true);
        super.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        super.setSize(800, 500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private  void setTelaInicial () {
        content.add("Center", new TelaInicial());
        this.add("Center", content);
        super.setVisible(true);
    }

    private  void setTelaContatos () {
        content.add("Center", new TelaContatos());
        this.add("Center", content);
        super.setVisible(true);
    }
    MouseListener ml = new MouseListener() {

        private void refreshColors(MouseEvent e){
            for (int i = 0; i < menuStrings.length; i++) {
                if((e.getSource() == label[i]) && (i != current)) {
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
                    setTelaContatos();
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

    public static void main(String[] args) {
        Main tela = new Main();
        tela.setTelaInicial();
    }
}
