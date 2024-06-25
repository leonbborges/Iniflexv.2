package org.example.Telas.TelasHistorico;

import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.entities.Funcionario;
import org.example.entities.Historico;
import org.example.entities.TableModels.HistoricoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tela_Historico extends JFrame implements ActionListener {

    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    JTable tabela;
    JButton  back;

    public Tela_Historico(List<Funcionario> listaDeFuncionario, List<Historico> historicos)  {
        listaDeFuncionarioLocal.addAll(listaDeFuncionario);
        historicosLocal.addAll(historicos);
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("images/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        getContentPane().setBackground(new Color(1, 170, 211));
        JLabel buscar = new JLabel("Historico");
        buscar.setBounds(20,20,150,20);
        add(buscar);


        HistoricoTableModel model = new HistoricoTableModel(historicos);
        tabela = new JTable();
        tabela.setModel(model);

        JScrollPane jp = new JScrollPane(tabela);
        jp.setBounds(0,100,900,600);
        add(jp);

        back = new JButton("Voltar");
        back.setBounds(20,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new Tela_inicial(listaDeFuncionarioLocal, historicosLocal);
            setVisible(false);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
