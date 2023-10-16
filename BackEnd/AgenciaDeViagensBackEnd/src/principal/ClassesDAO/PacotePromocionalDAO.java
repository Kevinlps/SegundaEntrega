package principal.ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Classes.Conexao;
import principal.Classes.PacotePromocional;


public class PacotePromocionalDAO {

    private Connection conexao;
    DestinoDAO destinoDAO = new DestinoDAO();
    
    public PacotePromocionalDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PacotePromocional buscarPacotePromocional(int pacoteId) {
        PacotePromocional pacote = null;
        String sql = "SELECT * FROM pacotesViagens WHERE Cod_pacote = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pacoteId);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                pacote = new PacotePromocional();

                pacote.setCod_pacote(resultado.getInt("Cod_pacote"));
                pacote.setDestino(destinoDAO.buscarDestino(resultado.getInt("Cod_destino")));
                pacote.setDescricao(resultado.getString("Descricao"));
                pacote.setQuantidade(resultado.getInt("Quantidade"));
                pacote.setPreco(resultado.getDouble("Preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacote;
    }

    public void criarPacotePromocional(PacotePromocional pacote) {
        String sql = "INSERT INTO pacotesViagens (Cod_destino, Descricao, Quantidade, Preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pacote.getDestino().getCod_destino());
            stmt.setString(2, pacote.getDescricao());
            stmt.setInt(3, pacote.getQuantidade());
            stmt.setDouble(4, pacote.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PacotePromocional> listarPacotesPromocionais() {
        List<PacotePromocional> pacotes = new ArrayList<>();
        String sql = "SELECT * FROM pacotesViagens";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                PacotePromocional pacote = new PacotePromocional();
                pacote.setCod_pacote(resultado.getInt("Cod_pacote"));
                pacote.setDestino(destinoDAO.buscarDestino(resultado.getInt("Cod_destino")));
                pacote.setDescricao(resultado.getString("Descricao"));
                pacote.setQuantidade(resultado.getInt("Quantidade"));
                pacote.setPreco(resultado.getDouble("Preco"));
                pacotes.add(pacote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacotes;
    }

    public void excluirPacotePromocional(int id) {
        String sql = "DELETE FROM pacotesViagens WHERE Cod_pacote = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPacotePromocional(PacotePromocional pacote) {
        String sql = "UPDATE pacotesViagens SET Cod_destino = ?, Descricao = ?, Quantidade = ?, Preco = ? WHERE Cod_pacote = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pacote.getDestino().getCod_destino());
            stmt.setString(2, pacote.getDescricao());
            stmt.setInt(3, pacote.getQuantidade());
            stmt.setDouble(4, pacote.getPreco());
            stmt.setInt(5, pacote.getCod_pacote());
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
