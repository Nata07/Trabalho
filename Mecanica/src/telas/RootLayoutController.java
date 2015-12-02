package telas;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;

import conexao.conexao;
import daoFactory.DAOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Pessoa;
import model.Produto;
import relatorio.RelatorioUtil;
import model.MainApp;

public class RootLayoutController {
	
	private TelaInicialController tela;
	
	private MainApp mainApp;
	
	 public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
	    }
	 /**
	  * Metodo para cadastrar cliente.
	  * É criado um .FXML onde carrega a tela de cadasro de clientes, assim com o Parent, Scene e Stage onde é adicionado essa nova tela, assim podendo cadastra novo cliente.
	  * @author Natanael
	  */
	 
	 @FXML
	 public void handleNovoCliente() {
		 try{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("../telas/CadastroCliente.fxml"));
				loader.load();
				Parent parent = loader.getRoot();
				Stage stage = new Stage();
				Scene cena = new Scene(parent);
				stage.setScene(cena);
				stage.getIcons().add(new Image("file:img/icone_usuario.jpg"));
				stage.setTitle("Cadastro de Clientes");
				
				stage.show();
			}catch (IOException e){
				e.printStackTrace();
			}
	 }
	 
	 @FXML
	 public void handleRelatorios(){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idcliente", 1);
		 new RelatorioUtil().viewReport("src/relatorio/Clientes.jasper", 
						conexao.getCon(), parametros); // vizualiza o relatorio
		
		
		
	 }
	 public void handleClose(){
		 System.exit(0);
	 }
	
}
