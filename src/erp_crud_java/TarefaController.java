package erp_crud_java;

import java.util.List; 

public class TarefaController {
    private TarefaModel modelo;

    public TarefaController() {
        modelo = new TarefaModel();
    }

    public void adicionarTarefa(String tarefa) {
        modelo.adicionarTarefa(tarefa);
    }

    public List<String> obterTarefas() {
        return modelo.obterTarefas();
    }

    public void removerTarefa(int indice) {
        modelo.removerTarefa(indice);
    }
}
