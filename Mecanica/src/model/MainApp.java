package model;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane root;
	private ObservableList<Pessoa> cliente = FXCollections.observableArrayList();
	
	public MainApp() {
		
	}
	/**
	 * Metodo que carrega o arquivo fxml principal e mostra na tela (PALCO)
	 * @author Natanael
	 */
	public void initRootLayout(){
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("../telas/RootLayout.fxml"));
		root = (BorderPane) loader.load();
		
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}catch (IOException e){
		e.printStackTrace();
	}
	}
	/**
	 * Segundo metodo que carrega as cenas dentro do palco, aqui sao carregadas 
	 * as informações para dentro do arquivo fxml principal.
	 * @author Natanael
	 */
	public void showTelaInicial(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../telas/TelaInicial.fxml"));
			AnchorPane telaInicial = (AnchorPane) loader.load();
		
			root.setCenter(telaInicial);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void showCadastroCliente(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../telas/CadastroCliente.fxml"));
			AnchorPane telaInicial = (AnchorPane) loader.load();
		
			root.setCenter(telaInicial);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		
	/**
	 * Esse metodo é reponsavel por startar todos os outros conforme programados
	 * @author Natanael
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		primaryStage.setTitle("Mecanica");
		initRootLayout();
		showTelaInicial();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public ObservableList<Pessoa> getCliente() {
        return cliente;
    }

}
