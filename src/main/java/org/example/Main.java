import org.example.BusinessRuler.Ler_Arquivo;
import org.example.BusinessRuler.OperacaoListaService;
import org.example.Telas.TelaInicial.Tela_inicial;
import org.example.entities.Funcionario;
import org.example.entities.Historico;

import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) throws Exception {
    List<Funcionario> listaDeFuncionario = new ArrayList<>(Ler_Arquivo.lerArquivo());
    List<Historico> historicos = new ArrayList<>();
    OperacaoListaService.odenar(listaDeFuncionario);
    new Tela_inicial(listaDeFuncionario,historicos);
}
