package org.example.BusinessRuler;

import org.example.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MapCreation {
    public static void criacaoDeMap(List<Funcionario> listaDeFuncionario,
                                    Map<String, ArrayList<String>> mapDeFuncionarios) {
        for(int i = 0; i< listaDeFuncionario.size(); i++){
            if(!mapDeFuncionarios.containsKey(listaDeFuncionario.get(i).getFuncao())){
                mapDeFuncionarios.put(listaDeFuncionario.get(i).getFuncao()
                        , new ArrayList<String>());
                mapDeFuncionarios.get(listaDeFuncionario.get(i).getFuncao())
                        .add(listaDeFuncionario.get(i).getNome());
            }
            else if(mapDeFuncionarios.containsKey(listaDeFuncionario.get(i).getFuncao())){
                mapDeFuncionarios.get(listaDeFuncionario.get(i).getFuncao())
                        .add(listaDeFuncionario.get(i).getNome());
            }
        }
    }

    public static void imprimirMap(Map<String, ArrayList<String>> mapDeFuncionarios) {
        System.out.println("Profissão | Lista de Funcionarios");
        mapDeFuncionarios.forEach((key, value)
                -> System.out.println(key + ":" + value));
    }
}
