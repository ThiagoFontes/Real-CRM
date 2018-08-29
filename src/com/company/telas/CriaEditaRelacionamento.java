package com.company.telas;

import com.company.inc.CustomBtn;
import com.company.inc.HintTextFieldUI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by Thiago Fontes on 21/08/2018.
 */
public class CriaEditaRelacionamento extends JPanel {
    private final Color azulClaro = new Color(229, 233,242);
    private final Color azulMedio = new Color(219, 224,233);
    private final Color azulEscuro = new Color(71,82,94);
    private final Color corTitulo = new Color(0x47525E);
    private final MatteBorder bordaCampos = BorderFactory.createMatteBorder(2, 5, 2, 5,azulMedio);
    private JPanel c1;
    private JLabel title;
    private JComboBox status;
    private String strStatus[] = { "agendado", "cancelado", "concluído" };
    private JTextField data;
    private JTextField padroes;
    private JComboBox tipo;
    private String strTipos[] = { "captação", "reclamação", "sugestão", "elogio"};
    private JTextField acao;
    private JPanel c2;
    private JButton save;

    public CriaEditaRelacionamento( String texto) {
        super.setLayout(new BorderLayout());
        c1 = new JPanel();
        c1.setLayout(new BoxLayout(c1,BoxLayout.Y_AXIS));
        title = new JLabel(texto,JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 30));
        title.setBackground(azulMedio);
        title.setForeground(corTitulo);
        title.setBorder(bordaCampos);

        title.setOpaque(true);

        status = new JComboBox(strStatus);
        status.setBorder(bordaCampos);
        //Setando Opção no index
        status.setSelectedIndex(2);

        data = new JTextField();
        data.setUI(new HintTextFieldUI("Data", true));
        data.setPreferredSize(new Dimension(200,30));
        data.setBorder(bordaCampos);

        padroes = new JTextField();
        padroes.setUI(new HintTextFieldUI("Padrões", true));
        padroes.setPreferredSize(new Dimension(200,30));
        padroes.setBorder(bordaCampos);

        tipo = new JComboBox(strTipos);
        tipo.setBorder(bordaCampos);
        //Setando Opção no index
        tipo.setSelectedIndex(2);

        acao = new JTextField();
        acao.setUI(new HintTextFieldUI("Ação", true));
        acao.setPreferredSize(new Dimension(200,30));
        acao.setBorder(bordaCampos);

        c2 = new JPanel();
        c2.setLayout(new BorderLayout());

        save = new CustomBtn("Salvar",Color.WHITE, azulEscuro);
        save.setMaximumSize(new Dimension(getWidth(),30));
        save.setPreferredSize(new Dimension(getWidth(),30));

        c1.setBackground(azulMedio);
        c1.add(title);
        c1.add(status);
        c1.add(data);
        c1.add(padroes);
        c1.add(tipo);
        c1.add(acao);
        c1.setPreferredSize(new Dimension(300,200));
        c1.setMaximumSize(new Dimension(300,200));
        c1.setBackground(azulMedio);
        c1.setBorder(BorderFactory.createMatteBorder(50, 250, 100, 250,azulClaro));
        c2.add(save, BorderLayout.NORTH);

        super.add(c1,BorderLayout.CENTER);
        super.add(c2,BorderLayout.SOUTH);
        super.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30,azulClaro));
        super.setBackground(azulClaro);
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }
}
