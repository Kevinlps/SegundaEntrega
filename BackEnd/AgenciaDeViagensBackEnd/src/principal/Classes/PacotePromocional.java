package principal.Classes;

public class PacotePromocional {

	private int Cod_pacote;
	private Destino destino;
	private String Descricao;
	private int Quantidade;
	private Double Preco;
	
	

	public PacotePromocional(Destino destino, String Descricao ,int Quantidade, Double Preco) {
		super();
		this.Descricao =Descricao;
		this.destino = destino;
	
		this.Quantidade= Quantidade;
		this.Preco = Preco;
	}

	public PacotePromocional() {
		// TODO Auto-generated constructor stub
	}

	public int getCod_pacote() {
		return Cod_pacote;
	}

	public void setCod_pacote(int cod_pacote) {
		Cod_pacote = cod_pacote;
	}



	public Destino getCod_destino() {
		return destino;
	}

	public void setCod_destino(Destino cod_destino) {
		destino = cod_destino;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public Double getPreco() {
		return Preco;
	}

	public void setPreco(Double preco) {
		Preco = preco;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	

}
