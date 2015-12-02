package model;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veiculo {
	
	private Integer idVeiculo;
	private StringProperty placa, ano, nome;
	//private List<OrdemServico> ordemServico;
	
	public Veiculo() {
		
	}
	public Veiculo(String nome, String placa, String ano) {
		this.nome = new SimpleStringProperty(nome);
		this.placa = new SimpleStringProperty(placa);
		this.ano = new SimpleStringProperty(ano);
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getNome(){
		return nome.get();
	}
	public void setNome(StringProperty nome){
		this.nome=nome;
	}
	
	public String getPlaca() {
		return placa.get();
	}
	public void setPlaca(StringProperty placa) {
		this.placa = placa;
	}
	public String getAno() {
		return ano.get();
	}
	public void setAno(StringProperty ano) {
		this.ano = ano;
	}
	/*public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}
	
	*/
	

}
