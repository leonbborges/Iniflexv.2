package org.example.BusinessRuler;


import org.example.entities.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class OperacoesComSalarioService {
    public static void AumentoDeSalario(List<Funcionario> listaDeFuncionario, float valor){
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            float numero = listaDeFuncionario.get(i).getSalario().floatValue();
            float aumento = numero * valor/100;
            listaDeFuncionario.get(i).setSalario(BigDecimal.valueOf(numero+aumento));
        }
    }

    public static String somarSalario(List<Funcionario> listaDeFuncionario){
        float somatorio = 0;
        float valor = 0;
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            valor = listaDeFuncionario.get(i).getSalario().floatValue();
            somatorio = somatorio + valor;
        }
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
        String somatorioFormatado = df.format(somatorio);
        return "R$ "+ somatorioFormatado;
    }

    public static String quantidadeDeSalariosMinimos(Funcionario funcionario){
        float salario = 0;
        double quantidadeDeSalarios = 0;
            salario = funcionario.getSalario().floatValue();
            quantidadeDeSalarios = salario/1212.00;
            String valor = String.format("%.2f", quantidadeDeSalarios);
        return valor;
    }
}
