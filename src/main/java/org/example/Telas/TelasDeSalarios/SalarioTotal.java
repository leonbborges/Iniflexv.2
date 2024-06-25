package org.example.Telas.TelasDeSalarios;

import org.example.BusinessRuler.OperacoesComSalarioService;
import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.entities.Funcionario;
import org.example.entities.Historico;
import org.example.entities.enuns.HistoricoEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalarioTotal extends JFrame implements ActionListener {
    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    public SalarioTotal(List<Funcionario> listaDeFuncionario, List<Historico> historicos){
        listaDeFuncionarioLocal.addAll(listaDeFuncionario);
        historicosLocal.addAll(historicos);
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("imagens/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

       setBackground(new Color(255,255,255));

        JLabel headiang = new JLabel("Salário Total é:");
        headiang.setBounds(140, 100, 700, 80);
        headiang.setFont(new Font("Releway", Font.BOLD,80));
        headiang.setForeground(new Color(1, 170, 211));
        headiang.setBackground(Color.WHITE);
        add(headiang);

        String valor = OperacoesComSalarioService.somarSalario(listaDeFuncionario);
        Date d = new Date();
        historicos.add(new Historico(HistoricoEnum.OBSERVACAO,d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), "operação de somar todos os salários"));

        JLabel total = new JLabel(valor);
        total.setBounds(140, 170, 700, 80);
        total.setFont(new Font("Releway", Font.BOLD,80));
        total.setForeground(new Color(1, 170, 211));
        total.setBackground(Color.WHITE);
        add(total);

        JButton voltar = new JButton("Voltar");
        voltar.setBounds(500, 270, 250, 40);
        voltar.setForeground(new Color(1, 170, 211));
        voltar.setBackground(Color.black);
        add(voltar);
        voltar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OperacoesComSalario(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });

        JButton menu = new JButton("Menu");
        menu.setBounds(500, 370, 250, 40);
        menu.setForeground(new Color(1, 170, 211));
        menu.setBackground(Color.black);
        add(menu);
        menu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Tela_inicial(listaDeFuncionario, historicos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
