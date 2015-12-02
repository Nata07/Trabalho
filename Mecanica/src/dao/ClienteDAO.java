package dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.Pessoa;

public interface ClienteDAO extends Generic<Pessoa> {
	
	//public void buscarNomeMecanico(Connection con, ObservableList<Cliente> nome);

	void listarCliente(Connection con, ObservableList<Pessoa> nome);

	void buscaPorNome(Connection con, ObservableList<Pessoa> nome);
}
