package erp_crud_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TarefaModel {
    private Connection connection;

    public TarefaModel() {
        try {
            // Carregue o driver JDBC do PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Estabeleça a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:postgresql://10.211.55.5:5434/postcrud", "postcrudp",
                    "SLEFrNGjmxFzA");
            if (connection != null) {
                criarTabelaTarefas();
            } else {
                System.err.println("Falha ao estabelecer a conexão com o banco de dados.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaTarefas() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS tarefas (" +
                    "id serial PRIMARY KEY," +
                    "descricao VARCHAR (255) NOT NULL)," +
                    "preco VARCHAR (255) NOT NULL)";
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarTarefa(String tarefa) {
        try {
            String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tarefa);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obterTarefas() {
        List<String> tarefas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tarefas";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                tarefas.add(resultSet.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    public void removerTarefa(int id) {
        try {
            String sql = "DELETE FROM tarefas WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
