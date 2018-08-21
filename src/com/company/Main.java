package com.company;
import com.company.inc.ComponentMover;
import com.company.inc.CustomBtn;
import com.company.inc.SQLiteJDBCDriverConnection;
import com.company.telas.TelaContatos;
import com.company.telas.TelaInicial;
import com.company.telas.TelaNegociacoes;
import com.company.telas.TelaRelacionamentos;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.pushingpixels.substance.api.skin.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            try {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            } catch (UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
            }
        }
//        try {
//            UIManager.setLookAndFeel(new WindowsLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    try {
////                    UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
//                        UIManager.setLookAndFeel(new SubstanceCeruleanLookAndFeel());
//                    } catch (UnsupportedLookAndFeelException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
        super.setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBackground(Color.DARK_GRAY);
        //drag topbar
        ComponentMover cm = new ComponentMover(this ,top);
        //Create minimize button
        CustomBtn m = new CustomBtn("-", Color.WHITE, Color.darkGray.brighter());
        m.setOpaque(false);
        m.addActionListener(e -> {
            super.setState(Frame.ICONIFIED);
        });
        //Create close button
        JButton closeBtn = new CustomBtn("X", Color.WHITE, Color.darkGray.brighter());
        closeBtn.addActionListener(e -> System.exit(0));
        closeBtn.setOpaque(false);
        // Definição da barra de título
        JPanel titleContainer = new JPanel(new FlowLayout());
        JLabel title = new JLabel("<html>" +
                "<body style=\"text-align:left;\">" +
                "REAL CRM</body></html>", SwingConstants.LEFT);

        title.setForeground(Color.white);
        titleContainer.add(title);
        titleContainer.setBackground(Color.DARK_GRAY);
        titleContainer.setPreferredSize(new Dimension(600, 30));

        top.add(titleContainer);
        top.add(m);
        top.add(closeBtn);

        //criando menu
        createMenu(menu);
        //super.getContentPane().setBackground(new Color(229, 233,242));
        // Adicionando componentes a janela principal
        super.add("North", top);
        super.add(BorderLayout.CENTER,this.content);
        super.setUndecorated(true);
        super.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.darkGray));
        super.setSize(800, 500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private  void setTelaInicial () {
        //super.setVisible(false);
        content.removeAll();
        content.add(menu, BorderLayout.NORTH);
        content.setBackground(new Color(229, 233,242));
        content.add("Center", new TelaInicial());
        super.add(BorderLayout.CENTER,this.content);
        content.validate();
        content.repaint();
        super.setVisible(true);
    }

    private  void setTelaContatos () {
        //super.setVisible(false);
        content.removeAll();
        content.add(menu, BorderLayout.NORTH);
        content.add("Center", new TelaContatos());
        super.add(BorderLayout.CENTER,this.content);
        content.validate();
        content.repaint();
        super.setVisible(true);
    }

    private  void setTelaRelacionamentos () {
        //super.setVisible(false);
        content.removeAll();
        content.add(menu, BorderLayout.NORTH);
        content.add("Center", new TelaRelacionamentos());
        super.add(BorderLayout.CENTER,this.content);
        content.validate();
        content.repaint();
        super.setVisible(true);
    }

    private  void setTelaNegociacoes() {
        content.removeAll();
        content.add(menu, BorderLayout.NORTH);
        content.add("Center", new TelaNegociacoes());
        super.add(BorderLayout.CENTER,this.content);
        content.validate();
        content.repaint();
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
                        case 2:
                            setTelaNegociacoes();
                            break;
                        case 3:
                            setTelaRelacionamentos();
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
        m.setOpaque(false);
    }

//    public static void createNewDatabase(String fileName) {
//
//        String url = "jdbc:sqlite:G:/Real-CRM/src/com/company/database" + fileName;
//
//        try (Connection conn = DriverManager.getConnection(url)) {
//            if (conn != null) {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static void main(String[] args) {
//        createNewDatabase("local.db");
        SQLiteJDBCDriverConnection con = new SQLiteJDBCDriverConnection();
        con.connect();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main tela = new Main();
                tela.setTelaInicial();
            }
        });
    }
}
