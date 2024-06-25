package org.example.Telas.TelasDeSalarios;

import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.entities.Funcionario;
import org.example.entities.Historico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OperacoesComSalario extends JFrame implements ActionListener {
    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    public OperacoesComSalario(List<Funcionario> listaDeFuncionario, List<Historico> historicos){
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("imagens/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("imagens/background.png"));
        Image bg2 = bg.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel background = new JLabel(bg3);
        background.setBounds(0, 0, 1120, 630);
        add(background);

        JLabel headiang = new JLabel("Operações com salário");
        headiang.setBounds(540, 100, 500, 40);
        headiang.setFont(new Font("Releway", Font.BOLD,40));
        headiang.setForeground(new Color(1, 170, 211));
        background.add(headiang);

        JButton reajustar = new JButton("Reajustar 10% do salario");
        reajustar.setBounds(500, 170, 250, 40);
        reajustar.setForeground(new Color(1, 170, 211));
        reajustar.setBackground(Color.black);
        reajustar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReajustarSalario(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(reajustar);

        JButton totalSalario = new JButton("Somatorio dos salarios");
        totalSalario.setBounds(820, 170, 250, 40);
        totalSalario.setForeground(new Color(1, 170, 211));
        totalSalario.setBackground(Color.black);
        totalSalario.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SalarioTotal(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(totalSalario);

        JButton qtdDeSalarios = new JButton("Quantidade de salarios minimos");
        qtdDeSalarios.setBounds(500, 270, 250, 40);
        qtdDeSalarios.setForeground(new Color(1, 170, 211));
        qtdDeSalarios.setBackground(Color.black);
        qtdDeSalarios.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuantidadeSalariosMinimos(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(qtdDeSalarios);

        JButton menu = new JButton("Menu");
        menu.setBounds(500, 370, 250, 40);
        menu.setForeground(new Color(1, 170, 211));
        menu.setBackground(Color.black);
        background.add(menu);
        menu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        new Tela_inicial(listaDeFuncionario, historicos);
                        setVisible(false);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
            }
        });

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
