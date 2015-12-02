package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Funcionario {
	
	private IntegerProperty idFuncionario;
	private StringProperty nome;
	private StringProperty usuario;
	private StringProperty senha;
	
	public Funcionario() {
	
	}
	
	public Funcionario(Integer idFuncionario, String nome,
					String usuario, String senha){
		this.idFuncionario= new SimpleIntegerProperty(idFuncionario);
		this.nome= new SimpleStringProperty(nome);
		this.usuario= new SimpleStringProperty(usuario);
		this.senha= new SimpleStringProperty(senha);
		
	}
	
	

	public IntegerProperty idFuncionario(){
		return idFuncionario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario.get();
	}

	public void setIdFuncionario(IntegerProperty idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public StringProperty nome(){
		return nome;
	}
	
	public String getNome() {
		return nome.get();
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}
	
	public StringProperty usuario(){
		return usuario;
	}
	
	public String getUsuario() {
		return usuario.get();
	}

	public void setUsuario(StringProperty usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha.get();
	}

	public void setSenha(StringProperty senha) {
		this.senha = senha;
	}
	
	public StringProperty senha(){
		return senha;
	}
	

}
