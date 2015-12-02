package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import conexao.conexao;
import model.Veiculo;

public class VeiculoDAOJDBC implements VeiculoDAO {
	
	private Connection con;
	
	public VeiculoDAOJDBC() {
		con = conexao.getCon();
	}

	@Override
	public void inserir(Veiculo veiculo) {
		String sql = "insert into veiculo (nome, placa, ano) values (?,?,?)";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getNome());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setString(3, veiculo.getAno());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Veiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}
