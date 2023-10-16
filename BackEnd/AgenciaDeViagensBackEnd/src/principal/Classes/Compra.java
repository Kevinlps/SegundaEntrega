package principal.Classes;

import java.util.Date;

public class Compra {
	private int Cod_compra; 
	private PacotePromocional pacotePromocional; 	
	private Cliente cliente ;	
	private Date dataCompra;
	
	public int getCod_compra() {
		return Cod_compra;
	}
	public void setCod_compra(int cod_compra) {
		Cod_compra = cod_compra;
	}
	public PacotePromocional getPacote() {
		return pacotePromocional;
	}
	public void setPacote(PacotePromocional cod_pacote) {
		pacotePromocional = cod_pacote;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente idCliente) {
		this.cliente = idCliente;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	

}
