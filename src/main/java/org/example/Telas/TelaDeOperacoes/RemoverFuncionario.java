package org.example.Telas.TelaDeOperacoes;

import org.example.BusinessRuler.OperacaoListaService;
import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.Telas.TelasDeSalarios.OperacoesComSalario;
import org.example.entities.Funcionario;
import org.example.entities.Historico;
import org.example.entities.enuns.HistoricoEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemoverFuncionario extends JFrame implements ActionListener {

    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    Choice choiceEMP;
    JButton delete, menu;
    int index = 0;

    public RemoverFuncionario(List<Funcionario> listaDeFuncionario, List<Historico> historicos){
        listaDeFuncionarioLocal.addAll(listaDeFuncionario);
        historicosLocal.addAll(historicos);
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("imagens/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        getContentPane().setBackground(new Color(1, 170, 211));
        JLabel buscar = new JLabel("Remover Funcionario");
        buscar.setBounds(20,20,150,20);
        add(buscar);

        for(int i = 0; i< listaDeFuncionario.size(); i++){
            choiceEMP.add(listaDeFuncionario.get(i).getNome());
        }

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(50,100,100,30);
        labelNome.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelNome);

        JLabel textNome = new JLabel();
        textNome.setBounds(200,100,100,30);
        add(textNome);

        JLabel labelFuncao = new JLabel("Função");
        labelFuncao.setBounds(50,150,100,30);
        labelFuncao.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelFuncao);

        JLabel textFuncao = new JLabel();
        textFuncao.setBounds(200,150,100,30);
        add(textFuncao);


        textNome.setText(listaDeFuncionario.get(index).getNome());
        textFuncao.setText(listaDeFuncionario.get(index).getFuncao());

        choiceEMP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                index = OperacaoListaService.buscarIndex(listaDeFuncionario,choiceEMP.getSelectedItem());
                textNome.setText(listaDeFuncionario.get(index).getNome());
                textFuncao.setText(listaDeFuncionario.get(index).getFuncao());
            }
        });

        delete = new JButton("Deletar");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        menu = new JButton("Voltar");
        menu.setBounds(220,300,100,30);
        menu.setBackground(Color.black);
        menu.setForeground(Color.WHITE);
        menu.addActionListener(this);
        add(menu);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            Date d = new Date();
            historicosLocal.add(new Historico(HistoricoEnum.ATUALIZACAO,d.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate(), "remover funcionario " + choiceEMP.getSelectedItem()));
            index = OperacaoListaService.buscarIndex(listaDeFuncionarioLocal,choiceEMP.getSelectedItem());
            listaDeFuncionarioLocal.remove(index);
            setVisible(false);
            try {
                new Tela_inicial(listaDeFuncionarioLocal, historicosLocal);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == menu){
            try {
                new Tela_inicial(listaDeFuncionarioLocal, historicosLocal);
                setVisible(false);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
