package org.example.entities;

import org.example.entities.enuns.HistoricoEnum;

import java.time.LocalDate;

public class Historico {

    HistoricoEnum historicoEnum;
    LocalDate dataHora;
    String operacao;

    public Historico(HistoricoEnum historicoEnum, LocalDate dataHora, String operacao) {
        this.historicoEnum = historicoEnum;
        this.dataHora = dataHora;
        this.operacao = operacao;
    }

    public Historico() {
    }

    public HistoricoEnum getHistoricoEnum() {
        return historicoEnum;
    }

    public void setHistoricoEnum(HistoricoEnum historicoEnum) {
        this.historicoEnum = historicoEnum;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "historicoEnum=" + historicoEnum +
                ", dataHora=" + dataHora +
                ", operacao='" + operacao + '\'' +
                '}';
    }
}
