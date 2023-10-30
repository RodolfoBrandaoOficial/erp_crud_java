package erp_crud_java;

import java.util.List;
import java.util.Scanner;

public class TarefaView {
    private TarefaController controlador;
    private Scanner scanner;

    public TarefaView(TarefaController controlador) {
        this.controlador = controlador;
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha;
        do {
            System.out.println("ERP de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    controlador.adicionarTarefa(tarefa);
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa a ser removida: ");
                    int id = scanner.nextInt();
                    controlador.removerTarefa(id);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);
    }

    public void listarTarefas() {
        List<String> tarefas = controlador.obterTarefas();
        System.out.println("Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(i + 1 + ". " + tarefas.get(i));
        }
    }
}
