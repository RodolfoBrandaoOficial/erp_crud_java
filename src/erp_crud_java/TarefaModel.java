package erp_crud_java; 

import java.util.ArrayList;
import java.util.List;

public class TarefaModel {
    private List<String> tarefas;

    public TarefaModel() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
    }

    public List<String> obterTarefas() {
        return tarefas;
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        }
    }
}
