package telas;

import java.io.IOException;
import java.sql.Connection;

import conexao.conexao;
import daoFactory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pessoa;
import model.MainApp;

public class TelaInicialController {
	
	@FXML
	private TextField jtfNome;
	@FXML
	private TextField jtfCpf;
	@FXML
	private TextField jtfRg;
	@FXML
	private TextField jtfEndereco;
	@FXML
	private TextField jtfTelefone;
	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnOrdem;
	@FXML
	private TextField jtfano;
	@FXML
	private TextField jtfplaca;
	@FXML
	private TableView<Pessoa> tabelaCliente = new TableView<Pessoa>();
	@FXML
	private TableColumn<Pessoa, String> colunaNome;
	@FXML
	private TableColumn<Pessoa, String> colunaCPF;
	@FXML
	private TableColumn<Pessoa, String> colunaRG;
	@FXML
	private TableColumn<Pessoa, String> colunaEndereco;
	@FXML
	private TableColumn<Pessoa, String> colunaTelefone;

	private ObservableList<Pessoa> cliente = FXCollections.observableArrayList();
	
	private Connection con;
	
	private MainApp mainApp;
	
	@FXML 
	private void initialize(){		
	
		colunaNome.setCellValueFactory(cellData -> cellData.getValue().nome());
		colunaCPF.setCellValueFactory(cellData -> cellData.getValue().cpf());
		colunaRG.setCellValueFactory(cellData -> cellData.getValue().rg());
		colunaEndereco.setCellValueFactory(cellData -> cellData.getValue().endereco());
		colunaTelefone.setCellValueFactory(cellData -> cellData.getValue().telefone());
		
		
	}
	
	/**
	 * Metodo que abre a tela da ordem de serviço
	 * @author Natanael
	 */
	
	@FXML
	 public void handleOrdemServico() {
		 try{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("../telas/Servico.fxml"));
				loader.load();
				Parent parent = loader.getRoot();
				Stage stage = new Stage();
				Scene cena = new Scene(parent);
				stage.setScene(cena);
				//stage.getIcons().add(new Image("file:img/icone_usuario.jpg"));
				
				stage.setTitle("Ordem de Serviço");
				OrdemServicoController ordem = loader.<OrdemServicoController>getController();
				Pessoa clienteDados = tabelaCliente.getSelectionModel().getSelectedItem();
				ordem.populaLabel(clienteDados);
				
				
				stage.show();
			}catch (IOException e){
				e.printStackTrace();
				
			}
	 }
	
	
	/**
	 * Metodo para pesquisar clientes cadastrados e jogar na tabela
	 * @author Natanael
	 */
	@FXML
	public void handlePesquisa(){
		
		DAOFactory.get().clienteDAO().listarCliente(conexao.getCon(), cliente);
		tabelaCliente.setItems(cliente);
	
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp=mainApp;

    }
	
	/**
	 * Metodo para fechar o sistema.
	 * @author Natanael
	 */
	
	public void handleCancelar(){
		 System.exit(0);
	}
}
