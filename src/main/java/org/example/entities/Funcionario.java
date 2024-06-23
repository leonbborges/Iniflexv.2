package org.example.entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Funcionario extends Pessoa{

    BigDecimal salario;

    String funcao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        String formattedDate = dataNascimento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
        String salarioFormatado = df.format(salario);
        return nome +
               " | " + formattedDate +
               " | " +"R$ "+salarioFormatado +
               " | " + funcao +"\n";

    }
}
