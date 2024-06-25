package org.example.BusinessRuler;

import org.example.entities.Funcionario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ler_Arquivo {

    public static List<Funcionario> lerArquivo()throws Exception {
        {
            String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Leonardo\\IdeaProjects\\Iniflex\\src\\main\\resources\\demo.json")));
            //format the date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //read as json array
            JSONArray jsonArray = new JSONArray(data);
            List<Funcionario> listaDeFuncionario = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {

                String str = jsonArray.get(i).toString();
                JSONObject object1 = new JSONObject(str);

                listaDeFuncionario.add(new Funcionario(object1.getString("nome"),
                        LocalDate.parse(object1.getString("dataNascimento"), formatter),
                        object1.getBigDecimal("salario"),
                        object1.getString("funcao")));
            }
            return listaDeFuncionario;
        }
    }
}
