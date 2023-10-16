package principal.ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Classes.Conexao;
import principal.Classes.Destino;



public class DestinoDAO {

    private Connection conexao;

    public DestinoDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Destino buscarDestino(int destinoId) {
        Destino destino = null;
        String sql = "SELECT * FROM destinos WHERE Cod_destino = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, destinoId);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                destino = new Destino();
                destino.setCod_destino(resultado.getInt("Cod_destino"));
                destino.setNome(resultado.getString("nome"));
                destino.setEndereco(resultado.getString("Endereco"));
                destino.setTelefone(resultado.getString("Telefone"));
                destino.setQuantidade(resultado.getInt("Quantidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destino;
    }

    public void criarDestino(Destino destino) {
        String sql = "INSERT INTO destinos (nome, Endereco, Telefone, Quantidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, destino.getNome());
            stmt.setString(2, destino.getEndereco());
            stmt.setString(3, destino.getTelefone());
            stmt.setInt(4, destino.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Destino> listarDestinos() {
        List<Destino> destinos = new ArrayList<>();
        String sql = "SELECT * FROM destinos";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Destino destino = new Destino();
                destino.setCod_destino(resultado.getInt("Cod_destino"));
                destino.setNome(resultado.getString("nome"));
                destino.setEndereco(resultado.getString("Endereco"));
                destino.setTelefone(resultado.getString("Telefone"));
                destino.setQuantidade(resultado.getInt("Quantidade"));
                destinos.add(destino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinos;
    }

    public void excluirDestino(int id) {
        String sql = "DELETE FROM destinos WHERE Cod_destino = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarDestino(Destino destino) {
        String sql = "UPDATE destinos SET nome = ?, Endereco = ?, Telefone = ?, Quantidade = ? WHERE Cod_destino = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, destino.getNome());
            stmt.setString(2, destino.getEndereco());
            stmt.setString(3, destino.getTelefone());
            stmt.setInt(4, destino.getQuantidade());
            stmt.setInt(5, destino.getCod_destino());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
