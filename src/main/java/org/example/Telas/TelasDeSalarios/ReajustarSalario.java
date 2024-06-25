package org.example.Telas.TelasDeSalarios;

import org.example.BusinessRuler.OperacoesComSalarioService;
import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.entities.Funcionario;
import org.example.entities.TableModels.FuncionarioTableModel;
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

public class ReajustarSalario extends JFrame implements ActionListener {
    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    JTable tabela;
    JButton voltar, menu, imprimir;
    public ReajustarSalario(List<Funcionario> listaDeFuncionario, List<Historico> historicos)  {
        listaDeFuncionarioLocal.addAll(listaDeFuncionario);
        historicosLocal.addAll(historicos);
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("images/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        getContentPane().setBackground(new Color(1, 170, 211));
        JLabel buscar = new JLabel("lista dos funcionarios");
        buscar.setBounds(20,20,150,20);
        add(buscar);

        OperacoesComSalarioService.AumentoDeSalario(listaDeFuncionario, 10);

        FuncionarioTableModel model = new FuncionarioTableModel(listaDeFuncionario);
        tabela = new JTable();
        tabela.setModel(model);

        Date d = new Date();
        historicosLocal.add(new Historico(HistoricoEnum.ATUALIZACAO,d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), "operação de reajuste salarial"));

        JScrollPane jp = new JScrollPane(tabela);
        jp.setBounds(0,100,900,600);
        add(jp);

        menu = new JButton("Menu");
        menu.setBounds(20,70,80,20);
        menu.addActionListener(this);
        add(menu);

        voltar = new JButton("Voltar");
        voltar.setBounds(120,70,120,20);
        voltar.addActionListener(this);
        add(voltar);

        imprimir = new JButton("Imprimir");
        imprimir.setBounds(260,70,120,20);
        imprimir.addActionListener(this);
        add(imprimir);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu){
            try {
                new Tela_inicial(listaDeFuncionarioLocal, historicosLocal);
                setVisible(false);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource() == imprimir){
            try {
                tabela.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            new OperacoesComSalario(listaDeFuncionarioLocal, historicosLocal);
            setVisible(false);
        }
    }
}
