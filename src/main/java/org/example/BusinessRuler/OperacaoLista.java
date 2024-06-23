package org.example.BusinessRuler;


import org.example.entities.Funcionario;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;

public class OperacaoLista {

    public static void imiprimir(List<Funcionario> listaDeFuncionario){
        System.out.println("Nome | Data Nascimento | Salário | Função\n");
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            System.out.println(listaDeFuncionario.get(i).toString());
        }
    }

    public static void apagarFuncionario(List<Funcionario> listaDeFuncionario, String nome){
        int index = 0;
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            if(listaDeFuncionario.get(i).getNome().equals(nome)){
                index = listaDeFuncionario.indexOf(listaDeFuncionario.get(i));
            }
        }
        listaDeFuncionario.remove(index);
    }
    public static void imiprimirOutDezAniversario(List<Funcionario> listaDeFuncionario){
        System.out.println("Nome | Data Nascimento | Salário | Função\n");
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            String dataDoFuncionario = listaDeFuncionario.get(i).getDataNascimento().
                    format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
            String [] dateParts = dataDoFuncionario.split("/");
            String month = dateParts[1];
            if(month.equals("10") ||month.equals("12")) {
                System.out.println(listaDeFuncionario.get(i).toString());
            }
        }
    }

    public static void imprimirFuncionariomaiorIdade(List<Funcionario> listaDeFuncionario) {
        System.out.println("Nome | Data Nascimento | Salário | Função\n");
        int maioridade = 0;
        Funcionario funcionario = new Funcionario();
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            int idadeFuncionario = Period.between(listaDeFuncionario.get(i).getDataNascimento(),
                    LocalDate.now()).getYears();
           if(idadeFuncionario > maioridade){
               maioridade = idadeFuncionario;
               funcionario.setNome(listaDeFuncionario.get(i).getNome());
               funcionario.setDataNascimento(listaDeFuncionario.get(i).getDataNascimento());
               funcionario.setSalario(listaDeFuncionario.get(i).getSalario());
               funcionario.setFuncao(listaDeFuncionario.get(i).getFuncao());
           }
        }
        System.out.println(funcionario.toString());
    }

    public static void odenar(List<Funcionario> listaDeFuncionario){
        listaDeFuncionario.sort(new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }
}
