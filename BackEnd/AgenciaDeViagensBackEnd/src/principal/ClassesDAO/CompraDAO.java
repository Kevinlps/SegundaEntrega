package principal.ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Classes.Compra;
import principal.Classes.Conexao;

public class CompraDAO {
    private Connection conexao;

    ClienteDAO2 clienteDAO = new ClienteDAO2();
    PacotePromocionalDAO pacotePromocionalDAO = new PacotePromocionalDAO();
    
    public CompraDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Compra buscarCompra(int compraId) {
        Compra compra = null;

        String sql = "SELECT * FROM compra WHERE Cod_compra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, compraId);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                compra = new Compra();

                compra.setCod_compra(resultado.getInt("Cod_compra"));
                compra.setPacote(pacotePromocionalDAO.buscarPacotePromocional(resultado.getInt("Cod_pacote")));
                compra.setCliente(clienteDAO.buscarCliente(resultado.getInt("id_clientes")));
                compra.setDataCompra(resultado.getDate("dataCompra"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compra;
    }

    public void criarCompra(Compra compra) {
        String sql = "INSERT INTO compra (Cod_pacote, id_clientes, dataCompra) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, compra.getPacote().getCod_pacote());
            stmt.setInt(2, compra.getCliente().getId_clientes());
            stmt.setDate(3, new java.sql.Date(compra.getDataCompra().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Compra> listarCompras() {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Compra compra = new Compra();

                compra.setCod_compra(resultado.getInt("Cod_compra"));
                compra.setPacote(pacotePromocionalDAO.buscarPacotePromocional(resultado.getInt("Cod_pacote")));
                compra.setCliente(clienteDAO.buscarCliente(resultado.getInt("id_clientes")));
                compra.setDataCompra(resultado.getDate("dataCompra"));

                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compras;
    }

    public void excluirCompra(int id) {
        String sql = "DELETE FROM compra WHERE Cod_compra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCompra(Compra compra) {
        String sql = "UPDATE compra SET Cod_pacote = ?, id_clientes = ?, dataCompra = ? WHERE Cod_compra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, compra.getPacote().getCod_pacote());
            stmt.setInt(2, compra.getCliente().getId_clientes());
            stmt.setDate(3, new java.sql.Date(compra.getDataCompra().getTime()));
            stmt.setInt(4, compra.getCod_compra());

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
