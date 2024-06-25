package org.example.entities;

import java.util.ArrayList;

public class MapPrint {

    String chave;
    String valor;
    private  ArrayList<String> lista = new ArrayList<>();

    public MapPrint(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public MapPrint() {
    }

    public MapPrint(String chave, ArrayList<String> lista) {
        this.chave = chave;
        this.lista = lista;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "MapPrint{" +
                "chave='" + chave + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
