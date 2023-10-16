package principal.ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Classes.Cliente;
import principal.Classes.Conexao;

public class ClienteDAO2 {
    private Connection conexao;

    public ClienteDAO2() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarCliente(int clienteId) {
        Cliente cliente = null;

        String sql = "SELECT * FROM clientes WHERE id_clientes = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                cliente = new Cliente();

                cliente.setId_clientes(resultado.getInt("id_clientes"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setIdade(resultado.getInt("idade"));
                cliente.setEmail(resultado.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, endereco, cpf, idade, email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCpf());
            stmt.setInt(4, cliente.getIdade());
            stmt.setString(5, cliente.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();

                cliente.setId_clientes(resultado.getInt("id_clientes"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setIdade(resultado.getInt("idade"));
                cliente.setEmail(resultado.getString("email"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void excluirCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id_clientes = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, endereco = ?, cpf = ?, idade = ?, email = ? WHERE id_clientes = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCpf());
            stmt.setInt(4, cliente.getIdade());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getId_clientes());

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

