package telas;

import javafx.scene.Node;
import javafx.scene.control.Button;



import conexao.conexao;
import dao.ProdutoDAO;
import dao.ProdutoDAOJDBC;
import dao.VeiculoDAO;
import dao.VeiculoDAOJDBC;
import daoFactory.DAOFactory;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Pessoa;
import model.Mecanico;
import model.Produto;
import model.Veiculo;

public class OrdemServicoController {
	
	@FXML
	private Label Nome;
	@FXML
	private Label CPF;
	@FXML
	private Label RG;
	@FXML
	private Label Endereco;
	@FXML
	private Label Telefone;
	@FXML
	private Label jlbNome;
	@FXML
	private Label jlbCPF;
	@FXML
	private Label jlbRG;
	@FXML
	private Label jlbEndereco;
	@FXML
	private Label jlbTelefone;
	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnOrdem;
	@FXML
	private Button btnIncluir;
	@FXML
	private TextField jtfNomeCarro;
	@FXML
	private TextField jtfAno;
	@FXML
	private TextField jtfPlaca;
	@FXML
	private TextField jtfItem;
	@FXML
	private TextField jtfDados;
	@FXML
	private TextField jtfQuantidade;
	@FXML
	private TextField jtfPreco;
	@FXML
	private TextField jtfTotal;
	@FXML
	private TableView<Produto> tabelaOrdem = new TableView<Produto>();

	@FXML
	private TableColumn<Produto, String> colunaDados;
	@FXML
	private TableColumn<Produto, Integer> colunaQuantidade;
	@FXML
	private TableColumn<Produto, Double> colunaPreco;
	@FXML
	private TableColumn<Produto, Double> colunaTotal;
	private ObservableList<Produto> dados = FXCollections.observableArrayList();
	
	private ObservableList<Mecanico> mecanicos;
	@FXML
	private ComboBox<Mecanico> mecanico;
	
	@FXML
	public void initialize(){
		mecanicos = FXCollections.observableArrayList();
		DAOFactory.get().mecanicoDAO().buscarNomeMecanico(conexao.getCon(), mecanicos);
		mecanico.setItems(mecanicos);
		
	//	colunaItem.setCellValueFactory(cellData -> cellData.getValue().itemPropety().asObject());
		colunaDados.setCellValueFactory(cellData -> cellData.getValue().dadosProduto());
		colunaPreco.setCellValueFactory(cellData -> cellData.getValue().valorPropety().asObject());
		colunaQuantidade.setCellValueFactory(cellData -> cellData.getValue().quantidade().asObject());
		colunaTotal.setCellValueFactory(cellData -> cellData.getValue().total().asObject());
		
		
	}
	
	/**
	 * Metodo que adiciona os dados do cliente na ordem de serviço.
	 * @param cliente recebe os dados do cliente selecionado na tabela.
	 * @author Natanael
	 */
	
	public void populaLabel(Pessoa cliente){
		jlbNome.setText(cliente.getNome());
		jlbCPF.setText(cliente.getCpf());
		jlbRG.setText(cliente.getRg());
		jlbEndereco.setText(cliente.getEndereco());
		jlbTelefone.setText(cliente.getTelefone());
	}
	
	@FXML
	private void handleOrdemServico(){
		Veiculo veiculo = new Veiculo(jtfNomeCarro.getText(), jtfPlaca.getText(), jtfAno.getText());
		DAOFactory.get().veiculoDAO().inserir(veiculo);
	}
	
	@FXML
	private void handleCancelar(ActionEvent event){
		(((Node)(event.getSource())).getScene()).getWindow().hide();
	}
	
	/**
	 * Mostra dados dos produtos na tabela 
	 * @param tabelaOrdem recebe os valores do banco de dados 
	 * @author Natanael
	 */
	@FXML
	public void handleIncluir(){
		//inserirDados();
		DAOFactory.get().produtoDAO().listarProduto(conexao.getCon(), dados);
		tabelaOrdem.setItems(dados);
	}
	@FXML
	public void handleLancarOrdem(){
		
	}
	
	public void inserirDados(){

		/*Produto produtos = new Produto(jtfDados.getText(), Double.parseDouble(jtfPreco.getText()), Integer.parseInt(jtfQuantidade.getText()),
				Double.parseDouble(jtfTotal.getText()));

		DAOFactory.get().produtoDAO().inserir(produtos);*/
		
	}
}
