package dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.Produto;

public interface ProdutoDAO extends Generic<Produto> {
	
	void listarProduto(Connection con, ObservableList<Produto> produto);
}
