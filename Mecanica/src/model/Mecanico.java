package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Mecanico {
	
	private Integer idMecanico;
	private StringProperty nome;
	//private List<OrdemServico> ordemServi�o;
	
	public Mecanico(String nome){
		this.nome = new SimpleStringProperty(nome);
	}

	public Mecanico() {
		// TODO Auto-generated constructor stub
	}
	
	public Mecanico(Integer idMecanico) {
		this.getIdMecanico();
	}
	
	public Integer getIdMecanico() {
		return idMecanico;
	}
	public void setIdMecanico(Integer idMecanico) {
		this.idMecanico = idMecanico;
	}
	@Override
	public String toString() {
		return nome.get();
	}
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}
/*	public List<OrdemServico> getOrdemServi�o() {
		return ordemServi�o;
	}
	public void setOrdemServi�o(List<OrdemServico> ordemServi�o) {
		this.ordemServi�o = ordemServi�o;
	}*/
	
	

}
