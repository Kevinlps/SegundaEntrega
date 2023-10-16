package principal;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.Classes.Cliente;
import principal.Classes.Compra;
import principal.Classes.Destino;
import principal.Classes.PacotePromocional;
import principal.ClassesDAO.ClienteDAO2;
import principal.ClassesDAO.CompraDAO;
import principal.ClassesDAO.DestinoDAO;
import principal.ClassesDAO.PacotePromocionalDAO;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO2 clienteDAO = new ClienteDAO2();
        CompraDAO compraDAO = new CompraDAO();
        DestinoDAO destinoDAO = new DestinoDAO();
        PacotePromocionalDAO pacotePromocionalDAO = new PacotePromocionalDAO();

        while (true) {
            System.out.println("\nAgencia de Viagens");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Cadastrar Compra");
            System.out.println("6. Listar Compras");
            System.out.println("7. Atualizar Compra");
            System.out.println("8. Excluir Compra");
            System.out.println("9. Cadastrar Destino");
            System.out.println("10. Listar Destinos");
            System.out.println("11. Atualizar Destino");
            System.out.println("12. Excluir Destino");
            System.out.println("13. Cadastrar Pacote Promocional");
            System.out.println("14. Listar Pacotes Promocionais");
            System.out.println("15. Atualizar Pacote Promocional");
            System.out.println("16. Excluir Pacote Promocional");
            System.out.println("17. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar Cliente
                    Cliente cliente = new Cliente();
                    System.out.print("Nome do Cliente: ");
                    scanner.nextLine();
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF do Cliente: ");
                    cliente.setCpf(scanner.next());
                    System.out.print("Idade do Cliente: ");
                    cliente.setIdade(scanner.nextInt());
                    System.out.print("Email: ");
                    cliente.setEmail(scanner.nextLine());
                    clienteDAO.criarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                 
                    break;
                case 2:
                    // Listar Clientes
                    List<Cliente> clientes = clienteDAO.listarClientes();
                    System.out.println("Lista de Clientes:");
                    for (Cliente c : clientes) {
                        System.out.println("ID: " + c.getId_clientes() +
                                ", Nome: " + c.getNome() +
                                ", CPF: " + c.getCpf() +
                                ", Idade: " + c.getIdade());
                    }
                    break;
                case 3:
                    // Atualizar Cliente
                    System.out.print("ID do Cliente para atualização: ");
                    int clienteIdAtualizar = scanner.nextInt();
                    Cliente clienteAtualizar = clienteDAO.buscarCliente(clienteIdAtualizar);
                    if (clienteAtualizar != null) {
                        System.out.print("Novo Nome do Cliente: ");
                        scanner.nextLine();
                        clienteAtualizar.setNome(scanner.nextLine());
                        System.out.print("Novo CPF do Cliente: ");
                        clienteAtualizar.setCpf(scanner.next());
                        System.out.print("Nova idade: ");
                        clienteAtualizar.setIdade(scanner.nextInt());
                        
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    // Excluir Cliente
                    System.out.print("ID do Cliente para exclusão: ");
                    int clienteIdExcluir = scanner.nextInt();
                    Cliente clienteExcluir = clienteDAO.buscarCliente(clienteIdExcluir);
                    if (clienteExcluir != null) {
                        clienteDAO.excluirCliente(clienteIdExcluir);
                        System.out.println("Cliente excluído com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    // Cadastrar Compra
                    Compra compra = new Compra();
                    System.out.print("ID do Cliente: ");
                    int clienteId = scanner.nextInt();
                    Cliente clienteCompra = clienteDAO.buscarCliente(clienteId);
                    if (clienteCompra != null) {
                        compra.setCliente(clienteCompra);
                        System.out.print("ID do Pacote Promocional: ");
                        int pacoteId = scanner.nextInt();
                        PacotePromocional pacote = pacotePromocionalDAO.buscarPacotePromocional(pacoteId);
                        if (pacote != null) {
                            compra.setPacote(pacote);
                            compra.setDataCompra(new Date());
                            compraDAO.criarCompra(compra);
                            System.out.println("Compra cadastrada com sucesso!");
                        } else {
                            System.out.println("Pacote Promocional não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 6:
                    // Listar Compras
                    List<Compra> compras = compraDAO.listarCompras();
                    System.out.println("Lista de Compras:");
                    for (Compra c : compras) {
                        System.out.println("ID: " + c.getCod_compra() +
                                ", Cliente: " + c.getCliente().getNome() +
                                ", Pacote Promocional: " + c.getPacote().getDescricao() +
                                ", Data de Compra: " + c.getDataCompra());
                    }
                    break;
                case 7:
                    // Atualizar Compra
                    System.out.print("ID da Compra para atualização: ");
                    int compraIdAtualizar = scanner.nextInt();
                    Compra compraAtualizar = compraDAO.buscarCompra(compraIdAtualizar);
                    if (compraAtualizar != null) {
                        compraAtualizar.setDataCompra(new Date());
                        compraDAO.atualizarCompra(compraAtualizar);
                        System.out.println("Compra atualizada com sucesso!");
                    } else {
                        System.out.println("Compra não encontrada.");
                    }
                    break;
                case 8:
                    // Excluir Compra
                    System.out.print("ID da Compra para exclusão: ");
                    int compraIdExcluir = scanner.nextInt();
                    Compra compraExcluir = compraDAO.buscarCompra(compraIdExcluir);
                    if (compraExcluir != null) {
                        compraDAO.excluirCompra(compraIdExcluir);
                        System.out.println("Compra excluída com sucesso!");
                    } else {
                        System.out.println("Compra não encontrada.");
                    }
                    break;
                case 9:
                    // Cadastrar Destino
                    Destino destino = new Destino();
                    System.out.print("Nome do Destino: ");
                    scanner.nextLine();
                    destino.setNome(scanner.nextLine());
                    System.out.print("Endereço do Destino: ");
                    destino.setEndereco(scanner.nextLine());
                    System.out.print("Telefone do Destino: ");
                    destino.setTelefone(scanner.nextLine());
                    System.out.print("Quantidade do Destino: ");
                    destino.setQuantidade(scanner.nextInt());
                    destinoDAO.criarDestino(destino);
                    System.out.println("Destino cadastrado com sucesso!");
                    break;
                case 10:
                    // Listar Destinos
                    List<Destino> destinos = destinoDAO.listarDestinos();
                    System.out.println("Lista de Destinos:");
                    for (Destino d : destinos) {
                        System.out.println("ID: " + d.getCod_destino() +
                                ", Nome: " + d.getNome() +
                                ", Endereço: " + d.getEndereco() +
                                ", Telefone: " + d.getTelefone() +
                                ", Quantidade: " + d.getQuantidade());
                    }
                    break;
                case 11:
                    // Atualizar Destino
                    System.out.print("ID do Destino para atualização: ");
                    int destinoIdAtualizar = scanner.nextInt();
                    Destino destinoAtualizar = destinoDAO.buscarDestino(destinoIdAtualizar);
                    if (destinoAtualizar != null) {
                        System.out.print("Novo Nome do Destino: ");
                        scanner.nextLine();
                        destinoAtualizar.setNome(scanner.nextLine());
                        System.out.print("Novo Endereço do Destino: ");
                        destinoAtualizar.setEndereco(scanner.nextLine());
                        System.out.print("Novo Telefone do Destino: ");
                        destinoAtualizar.setTelefone(scanner.nextLine());
                        System.out.print("Nova Quantidade do Destino: ");
                        destinoAtualizar.setQuantidade(scanner.nextInt());
                        destinoDAO.atualizarDestino(destinoAtualizar);
                        System.out.println("Destino atualizado com sucesso!");
                    } else {
                        System.out.println("Destino não encontrado.");
                    }
                    break;
                case 12:
                    // Excluir Destino
                    System.out.print("ID do Destino para exclusão: ");
                    int destinoIdExcluir = scanner.nextInt();
                    Destino destinoExcluir = destinoDAO.buscarDestino(destinoIdExcluir);
                    if (destinoExcluir != null) {
                        destinoDAO.excluirDestino(destinoIdExcluir);
                        System.out.println("Destino excluído com sucesso!");
                    } else {
                        System.out.println("Destino não encontrado.");
                    }
                    break;
                case 13:
                    // Cadastrar Pacote Promocional
                    PacotePromocional pacotePromocional = new PacotePromocional();
                    System.out.print("ID do Destino: ");
                    int destinoId = scanner.nextInt();
                    Destino destinoPacote = destinoDAO.buscarDestino(destinoId);
                    if (destinoPacote != null) {
                        pacotePromocional.setCod_destino(destinoPacote);
                        System.out.print("Descrição do Pacote Promocional: ");
                        scanner.nextLine();
                        pacotePromocional.setDescricao(scanner.nextLine());
                        System.out.print("Quantidade do Pacote Promocional: ");
                        pacotePromocional.setQuantidade(scanner.nextInt());
                        System.out.print("Preço do Pacote Promocional: ");
                        pacotePromocional.setPreco(scanner.nextDouble());
                        pacotePromocionalDAO.criarPacotePromocional(pacotePromocional);
                        System.out.println("Pacote Promocional cadastrado com sucesso!");
                    } else {
                        System.out.println("Destino não encontrado.");
                    }
                    break;
                case 14:
                    // Listar Pacotes Promocionais
                    List<PacotePromocional> pacotesPromocionais = pacotePromocionalDAO.listarPacotesPromocionais();
                    System.out.println("Lista de Pacotes Promocionais:");
                    for (PacotePromocional p : pacotesPromocionais) {
                        System.out.println("ID: " + p.getCod_pacote() +
                                ", Destino: " + p.getCod_destino().getNome() +
                                ", Descrição: " + p.getDescricao() +
                                ", Quantidade: " + p.getQuantidade() +
                                ", Preço: " + p.getPreco());
                    }
                    break;
                case 15:
                    // Atualizar Pacote Promocional
                    System.out.print("ID do Pacote Promocional para atualização: ");
                    int pacoteIdAtualizar = scanner.nextInt();
                    PacotePromocional pacotePromocionalAtualizar = pacotePromocionalDAO.buscarPacotePromocional(pacoteIdAtualizar);
                    if (pacotePromocionalAtualizar != null) {
                        System.out.print("Nova Descrição do Pacote Promocional: ");
                        scanner.nextLine();
                        pacotePromocionalAtualizar.setDescricao(scanner.nextLine());
                        System.out.print("Nova Quantidade do Pacote Promocional: ");
                        pacotePromocionalAtualizar.setQuantidade(scanner.nextInt());
                        System.out.print("Novo Preço do Pacote Promocional: ");
                        pacotePromocionalAtualizar.setPreco(scanner.nextDouble());
                        pacotePromocionalDAO.atualizarPacotePromocional(pacotePromocionalAtualizar);
                        System.out.println("Pacote Promocional atualizado com sucesso!");
                    } else {
                        System.out.println("Pacote Promocional não encontrado.");
                    }
                    break;
                case 16:
                    // Excluir Pacote Promocional
                    System.out.print("ID do Pacote Promocional para exclusão: ");
                    int pacoteIdExcluir = scanner.nextInt();
                    PacotePromocional pacotePromocionalExcluir = pacotePromocionalDAO.buscarPacotePromocional(pacoteIdExcluir);
                    if (pacotePromocionalExcluir != null) {
                        pacotePromocionalDAO.excluirPacotePromocional(pacoteIdExcluir);
                        System.out.println("Pacote Promocional excluído com sucesso!");
                    } else {
                        System.out.println("Pacote Promocional não encontrado.");
                    }
                    break;
                case 17:
                    // Sair
                    System.out.println("Saindo do sistema...");
                    pacotePromocionalDAO.fecharConexao();
                    destinoDAO.fecharConexao();
                    compraDAO.fecharConexao();
                    clienteDAO.fecharConexao();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}