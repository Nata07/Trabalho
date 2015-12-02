package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.conexao;
import model.Funcionario;

public class FuncionarioDAOJDBC implements FuncionarioDAO {
	
	private Connection con;
	
	public FuncionarioDAOJDBC() {
		con = conexao.getCon();
	}
	
	@Override
	public void inserir(Funcionario funcionario) {
		String sql = "inset into funcionario (nome, usuario, senha) values (?,?,?)";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setString(2, funcionario.getSenha());
			pstmt.setString(3, funcionario.getUsuario());
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Funcionario funcionario) {
		String sql = "update funcionario set nome=?, usuario=?, senha=? where idFuncionario=?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setString(3, funcionario.getUsuario());
			pstmt.setString(2, funcionario.getSenha());
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Funcionario funcionario) {
		String sql = "delete from funcionario where idFuncionario=?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getIdFuncionario());
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Funcionario buscar(Integer id) {
		Funcionario funcionario = null;
		String sql = "select * from funcionario where idFuncionario=?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				funcionario = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), 
										rs.getString("usuario"), rs.getString("senha"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return funcionario;
	}

	@Override
	public List<Funcionario> todos() {
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "select * from funcionario";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Funcionario funcionario = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), 
								rs.getString("usuario"), rs.getString("senha"));
				funcionarios.add(funcionario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return funcionarios;
	}

}
