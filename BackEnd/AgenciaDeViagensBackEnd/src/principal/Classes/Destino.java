package principal.Classes;


public class Destino {

	private int Cod_destino; 
	private String nome;
	private String Endereco; 
	private String Telefone ;	
	private int Quantidade;
	
	
	public int getCod_destino() {
		return Cod_destino;
	}
	public void setCod_destino(int cod_destino) {
		Cod_destino = cod_destino;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	
}
