package org.example.BusinessRuler;


import org.example.entities.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class OperacoesComSalario {
    public static void AumentoDeSalario(List<Funcionario> listaDeFuncionario, float valor){
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            float numero = listaDeFuncionario.get(i).getSalario().floatValue();
            float aumento = numero * valor/100;
            listaDeFuncionario.get(i).setSalario(BigDecimal.valueOf(numero+aumento));
        }
    }

    public static void somarSalario(List<Funcionario> listaDeFuncionario){
        float somatorio = 0;
        float valor = 0;
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            valor = listaDeFuncionario.get(i).getSalario().floatValue();
            somatorio = somatorio + valor;
        }
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
        String somatorioFormatado = df.format(somatorio);
        System.out.println("R$ "+somatorioFormatado);
    }

    public static void quantidadeDesalariosMinimos(List<Funcionario> listaDeFuncionario){
        float salario = 0;
        double quantidadeDeSalarios = 0;
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            salario = listaDeFuncionario.get(i).getSalario().floatValue();
            quantidadeDeSalarios = salario/1212.00;
            System.out.printf(listaDeFuncionario.get(i).getNome()
                    +" ganha a quantidade de: "
                    + String.format("%.2f", quantidadeDeSalarios)+"\n");
        }
    }
}
