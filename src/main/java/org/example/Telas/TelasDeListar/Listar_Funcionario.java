package org.example.Telas.TelasDeListar;

import org.example.Telas.TelaDeOperacoes.RemoverFuncionario;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Listar_Funcionario extends JFrame implements ActionListener {

    List<Funcionario> listaDeFuncionarioLocal = new ArrayList<>();
    List<Historico> historicosLocal = new ArrayList<>();
    JTable tabela;
    Choice choiceEMP;
    JButton buscabtn, print, remover, back;
    public Listar_Funcionario(List<Funcionario> listaDeFuncionario, List<Historico> historicos)  {
        listaDeFuncionarioLocal.addAll(listaDeFuncionario);
        historicosLocal.addAll(historicos);
        ImageIcon Icone = new ImageIcon(ClassLoader.getSystemResource("images/iniflexLogo.jpg"));
        setIconImage(Icone.getImage());

    getContentPane().setBackground(new Color(1, 170, 211));
    JLabel buscar = new JLabel("lista dos funcionarios");
    buscar.setBounds(20,20,150,20);
    add(buscar);

    choiceEMP = new Choice();
    choiceEMP.setBounds(180,20,150,20);
    add(choiceEMP);

    FuncionarioTableModel model = new FuncionarioTableModel(listaDeFuncionario);
    tabela = new JTable();
    tabela.setModel(model);

    Date d = new Date();
    historicosLocal.add(new Historico(HistoricoEnum.OBSERVACAO,d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), "operação de listagem"));

    for(int i = 0; i< listaDeFuncionario.size(); i++){
        choiceEMP.add(listaDeFuncionario.get(i).getNome());
        }
        JScrollPane jp = new JScrollPane(tabela);
        jp.setBounds(0,100,900,600);
        add(jp);

        buscabtn = new JButton("Buscar");
        buscabtn.setBounds(20,70,80,20);
        buscabtn.addActionListener(this);
        add(buscabtn);

        print = new JButton("Imprimir");
        print.setBounds(120,70,120,20);
        print.addActionListener(this);
        add(print);

        remover = new JButton("Remover");
        remover.setBounds(260,70,120,20);
        remover.addActionListener(this);
        add(remover);

        back = new JButton("Voltar");
        back.setBounds(400,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscabtn){
            int index = 0;
            for(int i = 0; i< listaDeFuncionarioLocal.size(); i++){
                if(listaDeFuncionarioLocal.get(i).getNome().equals(choiceEMP.getSelectedItem())){
                    index = listaDeFuncionarioLocal.indexOf(listaDeFuncionarioLocal.get(i));
                }
            }
            List<Funcionario> lista = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            lista.add(new Funcionario(listaDeFuncionarioLocal.get(index).getNome(),
                    listaDeFuncionarioLocal.get(index).getDataNascimento(),
                    listaDeFuncionarioLocal.get(index).getSalario(),
                    listaDeFuncionarioLocal.get(index).getFuncao()));
            FuncionarioTableModel model = new FuncionarioTableModel(lista);
            tabela.setModel(model);

        } else if (e.getSource() == print) {
            try {
                tabela.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }  else if(e.getSource() == remover) {
            new RemoverFuncionario(listaDeFuncionarioLocal, historicosLocal);
            setVisible(false);
        }else {
            setVisible(false);
            try {
                new Tela_inicial(listaDeFuncionarioLocal,historicosLocal);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }  }
    }

