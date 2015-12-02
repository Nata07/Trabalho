package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import conexao.conexao;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.Pessoa;


public class ClienteDAOJDBC implements ClienteDAO{
	
	private TextField jtfNome;
	private Connection con;
	
	/**
	 * Metodo usado para conexao com o banco de dados
	 * @param ClienteDAOJDBC
	 * @author Natanael
	 */
	
	public ClienteDAOJDBC(){
		con = conexao.getCon();
	}

	/**
	 * Metodo usado para cadastrar um cliente no banco de dados 
	 * @param cliente
	 * @author Natanael
	 */
	@Override
	public void inserir(Pessoa cliente) {
		String sql = "insert into cliente (nome, cpf, rg, endereco, telefone)"
				+ "values (?,?,?,?,?)";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cliente.getNome());;
			pstmt.setString(2, cliente.getCpf());
			pstmt.setString(3, cliente.getRg());
			pstmt.setString(4, cliente.getEndereco());
			pstmt.setString(5, cliente.getTelefone());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para alterar dados do cliente
	 * @param alterar
	 * @author Natanael
	 */

	@Override
	public void alterar(Pessoa cliente) {
		String sql = "update cliente set nome = ?, cpf = ?, rg = ?, endereco = ?"
				+ "telefone = ?, veiculo = ? where codigo = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getCpf());
			pstmt.setString(3, cliente.getRg());
			pstmt.setString(4, cliente.getEndereco());
			pstmt.setString(5, cliente.getTelefone());
			
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo para exlcuir um cliente do banco de dados
	 * @param excluir
	 * @author Natanael
	 */
	@Override
	public void excluir(Pessoa cliente) {
		String sql = "delete from cliente where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cliente.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para fazer pesquisa no banco de dados localizar um cliente especifico
	 * @param buscar
	 * @author Natanael
	 */

	@Override
	public Pessoa buscar(Integer id) {
		Pessoa cliente = null;
		String sql = "select * from cliente where codigo = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
				cliente = new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), 
						rs.getString("endereco"), rs.getString("telefone"));
				cliente.setIdCliente(rs.getInt("idCliente"));
				
			}
			}catch(Exception e){
				e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * @param todos
	 * Metodo para fazer uma pesquisa de todos os clientes cadastrados no banco de dados
	 * @author Natanael
	 */

	@Override
	public List<Pessoa> todos() {
		List<Pessoa> clientes = new ArrayList<>();
		String sql = "select * from cliente";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
				Pessoa cliente = new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), 
						rs.getString("endereco"), rs.getString("telefone"));
				cliente.setIdCliente(rs.getInt("idCliente"));
				
				clientes.add(cliente);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return clientes;
	}
	
	@Override
	public void listarCliente(Connection con, ObservableList<Pessoa> nome) {
		String sql ="select nome, cpf, rg, endereco, telefone from cliente";
		ResultSet rs;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nome.add(new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), 
						rs.getString("endereco"), rs.getString("telefone")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void buscaPorNome(Connection con, ObservableList<Pessoa> nome){
		String sql = "select * from cliente where nome like ?";
		ResultSet rs = null;
		try{
			//Cliente cliente = new Cliente();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				nome.add(new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), 
						rs.getString("endereco"), rs.getString("telefone")));

			}
	}catch(SQLException e){
		e.printStackTrace();
	}
	

}

	}
