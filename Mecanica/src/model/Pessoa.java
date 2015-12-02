package model;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	
	private Integer idCliente;
	private StringProperty nome;
	private List<Veiculo> veiculo;
	//private List<OrdemServico> ordemServico;
	private StringProperty cpf;
	private StringProperty rg;
	private StringProperty endereco;
	private StringProperty telefone;

	
	public Pessoa(String nome, String cpf, String rg, String endereco, String telefone){
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.rg = new SimpleStringProperty(rg);
		this.endereco= new SimpleStringProperty(endereco);
		this.telefone = new SimpleStringProperty(telefone);
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	// get settes nome
	public String getNome() {
		return nome.get();
	}
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}
	 public StringProperty nome() {
	        return nome;
	 }
	 // get setters cpf 
	 public String getCpf() {
			return cpf.get();
	}
	 public void setCpf(StringProperty cpf) {
		this.cpf = cpf;
	}
	 public StringProperty cpf() {
	       return cpf;
	 }
	 // get setters rg
	 public String getRg() {
		return rg.get();
	}
	public void setRg(StringProperty rg) {
		this.rg = rg;
	}
	public StringProperty rg() {
		 return rg;
	}
	//get setters endereco
	public String getEndereco() {
		return endereco.get();
	}
	public void setEndereco(StringProperty endereco) {
		this.endereco = endereco;
	}
	 public StringProperty endereco() {
	    return endereco;
	 }
	//get setters telefone
	 public String getTelefone() {
		return telefone.get();
	}
	public void setTelefone(StringProperty telefone) {
		this.telefone = telefone;
		}
	 public StringProperty telefone() {
		 return telefone;
	}
 
	
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	/*public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}
	*/
	
	
}
