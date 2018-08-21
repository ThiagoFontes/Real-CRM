package com.company.telas;

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
    private final MatteBorder bordaCampos = BorderFactory.createMatteBorder(5, 1, 2, 1,azulMedio);
    private JPanel c1;
    private JComboBox status;
    private String strStatus[] = { "agendado", "cancelado", "concluído" };
    private JTextField data;
    private JTextField padroes;
    private JComboBox tipo;
    private String strTipos[] = { "captação", "reclamação", "sugestão", "elogio"};
    private JTextField acao;

    public CriaEditaRelacionamento() {
        c1 = new JPanel();
        c1.setLayout(new BoxLayout(c1,BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Cria/Edita", JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 30));
        title.setBorder(bordaCampos);
        title.setBackground(azulMedio);

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

        c1.add(title);
        c1.add(status);
        c1.add(data);
        c1.add(padroes);
        c1.add(tipo);
        c1.add(acao);
        super.add(c1);
        super.setBorder(BorderFactory.createMatteBorder(30, 250, 30, 250,azulClaro));
        super.setBackground(azulMedio);
        //super.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
}
