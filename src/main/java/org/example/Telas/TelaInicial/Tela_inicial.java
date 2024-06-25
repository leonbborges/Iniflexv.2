package org.example.Telas.TelaInicial;

import org.example.Telas.TelaDeOperacoes.OperacaoComFuncionario;
import org.example.Telas.TelasDeListar.Listar_Funcionario;
import org.example.Telas.TelasDeSalarios.OperacoesComSalario;
import org.example.Telas.TelasHistorico.Tela_Historico;
import org.example.entities.Funcionario;
import org.example.entities.Historico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;


public class Tela_inicial extends JFrame {
    public Tela_inicial(List<Funcionario> listaDeFuncionario, List<Historico> historicos) throws Exception {

        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("images/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("images/background.png"));
        Image bg2 = bg.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel background = new JLabel(bg3);
        background.setBounds(0, 0, 1120, 630);
        add(background);

        JLabel headiang = new JLabel("Sistema da Iniflex V2.0");
        headiang.setBounds(540, 100, 500, 40);
        headiang.setFont(new Font("Releway", Font.BOLD,40));
        headiang.setForeground(new Color(1, 170, 211));
        background.add(headiang);

        JButton listar = new JButton("Listar funcionarios");
        listar.setBounds(500, 170, 250, 40);
        listar.setForeground(new Color(1, 170, 211));
        listar.setBackground(Color.black);
        listar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Listar_Funcionario(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(listar);

        JButton salario = new JButton("Salario dos funcionarios");
        salario.setBounds(820, 170, 250, 40);
        salario.setForeground(new Color(1, 170, 211));
        salario.setBackground(Color.black);
        salario.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OperacoesComSalario(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(salario);

        JButton operacao = new JButton("Operação com os funcionarios");
        operacao.setBounds(500, 270, 250, 40);
        operacao.setForeground(new Color(1, 170, 211));
        operacao.setBackground(Color.black);
        background.add(operacao);
        operacao.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OperacaoComFuncionario(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });

        JButton historico = new JButton("Historico de operçoes");
        historico.setBounds(820, 270, 250, 40);
        historico.setForeground(new Color(1, 170, 211));
        historico.setBackground(Color.black);
        background.add(historico);
        historico.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Tela_Historico(listaDeFuncionario, historicos);
               setVisible(false);
            }
        });

        JButton sair = new JButton("Sair");
        sair.setBounds(500, 370, 250, 40);
        sair.setForeground(new Color(1, 170, 211));
        sair.setBackground(Color.black);
        background.add(sair);
        sair.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

}