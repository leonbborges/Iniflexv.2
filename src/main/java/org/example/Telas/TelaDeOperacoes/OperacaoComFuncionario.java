package org.example.Telas.TelaDeOperacoes;

import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.Telas.TelasDeSalarios.OperacoesComSalario;
import org.example.Telas.TelasDeSalarios.QuantidadeSalariosMinimos;
import org.example.Telas.TelasDeSalarios.ReajustarSalario;
import org.example.Telas.TelasDeSalarios.SalarioTotal;
import org.example.entities.Funcionario;
import org.example.entities.Historico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OperacaoComFuncionario extends JFrame implements ActionListener {
    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();

    public OperacaoComFuncionario(List<Funcionario> listaDeFuncionario, List<Historico> historicos) {
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("imagens/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("imagens/background.png"));
        Image bg2 = bg.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel background = new JLabel(bg3);
        background.setBounds(0, 0, 1120, 630);
        add(background);

        JLabel headiang = new JLabel("Operações com Funcionários");
        headiang.setBounds(500, 100, 600, 40);
        headiang.setFont(new Font("Releway", Font.BOLD, 40));
        headiang.setForeground(new Color(1, 170, 211));
        background.add(headiang);

        JButton maiorIdade = new JButton("Maior idade de funcionário");
        maiorIdade.setBounds(500, 170, 250, 40);
        maiorIdade.setForeground(new Color(1, 170, 211));
        maiorIdade.setBackground(Color.black);
        maiorIdade.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MaiorIdade(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(maiorIdade);

        JButton aniOutDez = new JButton("Aniversariantes dos meses 10 e 12");
        aniOutDez.setBounds(820, 170, 250, 40);
        aniOutDez.setForeground(new Color(1, 170, 211));
        aniOutDez.setBackground(Color.black);
        aniOutDez.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AniversarioOutDez(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(aniOutDez);

        JButton agrupamento = new JButton("Agrupamento de Funcionarios");
        agrupamento.setBounds(500, 270, 250, 40);
        agrupamento.setForeground(new Color(1, 170, 211));
        agrupamento.setBackground(Color.black);
        agrupamento.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Agrupamento(listaDeFuncionario, historicos);
                setVisible(false);
            }
        });
        background.add(agrupamento);

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
