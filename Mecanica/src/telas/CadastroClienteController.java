package telas;

import java.sql.Connection;

import javax.swing.JOptionPane;

import conexao.conexao;
import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import daoFactory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import model.Pessoa;

public class CadastroClienteController {
	
	@FXML
	private TextField jtfNome;
	@FXML
	private TextField jtfCPF;
	@FXML
	private TextField jtfRG; 
	@FXML
	private TextField jtfEndereco;
	@FXML
	private TextField jtfTelefone;	
	private Connection con;
	
	@FXML
	public void handleCadastrar(){
		testaCPF();
		inserirCliente();
	}
	
	@FXML
	public void handleCancelar(ActionEvent event){
		// Encerra somente a janela em que esta em primeiro plano.
		(((Node)(event.getSource())).getScene()).getWindow().hide();
	
	}
	
	public void inserirCliente(){
		//ClienteDAO cliente = new ClienteDAOJDBC();
		Pessoa dados = new Pessoa(jtfNome.getText(), jtfCPF.getText(), jtfRG.getText(), 
										jtfEndereco.getText(), jtfTelefone.getText());
		DAOFactory.get().clienteDAO().inserir(dados);
		JOptionPane.showMessageDialog(null, "Cliente cadastrado");
		
	}
	
	public void testaCPF(){
		String mensagem = "CPF invalido!";
		if(jtfCPF.getText().length() != 11 /*COMPARAR COM STRING*/){
			JOptionPane.showMessageDialog(null, mensagem);
		}
		/*if(jtfCpf.getText()){
			JOptionPane.showMessageDialog(null, "SOMENTE NUMEROS");
		}
		else{
			
		}*/
	}
	
	public CadastroClienteController() {
		con = conexao.getCon();
	}

}
