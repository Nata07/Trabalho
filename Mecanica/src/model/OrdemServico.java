package model;

public class OrdemServico {
	
	private Integer idOrdem;
	private Pessoa cliente;
	private Veiculo veiculo;
	private Mecanico mecanico;
	
	public Integer getIdOrdem() {
		return idOrdem;
	}
	public void setIdOrdem(Integer idOrdem) {
		this.idOrdem = idOrdem;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	
	
}
