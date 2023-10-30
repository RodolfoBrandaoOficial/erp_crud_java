/**
 *
 * @author rodolfobrandao
 */
package erp_crud_java;

public class Erp_crud_java {

    public static void main(String[] args) {
        TarefaController controlador = new TarefaController();
        TarefaView view = new TarefaView(controlador);

        view.exibirMenu();
    }

}
