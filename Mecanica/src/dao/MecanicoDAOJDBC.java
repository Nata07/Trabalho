package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javafx.collections.ObservableList;
import model.Pessoa;
import model.Mecanico;

public class MecanicoDAOJDBC implements MecanicoDAO{

	private Connection con;
	
	@Override
	public void inserir(Mecanico mecanico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Mecanico mecanico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Mecanico mecanico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarNomeMecanico(Connection con, ObservableList<Mecanico> nome) {
		String sql ="select nome from mecanico";
		ResultSet rs;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nome.add(new Mecanico(rs.getString("nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Mecanico> todos() {
		List<Mecanico> mecanicos = new ArrayList<>();
		String sql = "select * from mecanico";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Mecanico mecanico = new Mecanico(rs.getString("nome"));
				mecanico.setIdMecanico(rs.getInt("idMecanico"));
		
				//mecanico.setOrdemServiço(rs.getShort(""));
				//cliente.setVeiculo(rs.getInt("veiculo")); -- verificar erro
				mecanicos.add(mecanico);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		return mecanicos;
	}

	@Override
	public Mecanico buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public Mecanico mostrarNome(Mecanico mecanico){
	
	

}
