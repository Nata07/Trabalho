package dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.Mecanico;

public interface MecanicoDAO extends Generic<Mecanico> {
	
	public void buscarNomeMecanico(Connection con, ObservableList<Mecanico> nome);
}
