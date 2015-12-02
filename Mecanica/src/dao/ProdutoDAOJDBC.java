package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.conexao;
import daoFactory.DAOFactory;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import model.Produto;

public class ProdutoDAOJDBC implements ProdutoDAO {

	private Connection con;
	
	public ProdutoDAOJDBC(){
		con = conexao.getCon();
	}
	
	@Override
	public void inserir(Produto produto) {
		
		String sql = "insert into produto (item, dadosProduto, valorUnd, quantidade, total) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, produto.getItem());
			pstmt.setString(2, produto.getDadosProduto());
			pstmt.setDouble(3, produto.getValorUnd());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.setDouble(5, produto.getTotal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir produto no banco");
			e.printStackTrace();
		}
	}
	
	@Override
	public void alterar(Produto produto){
		String sql = "update produto set nome = ?, valor = ? where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, produto.getDadosProduto());
			pstmt.setDouble(2, produto.getValorUnd());
			pstmt.setInt(3, produto.getItem());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Produto produto) {
		String sql = "delete from produto where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, produto.getItem());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(Integer id) {
		Produto produtos = null;
		String sql = "select * from produto where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Produto produto = new Produto();
				produto.setItem(new SimpleIntegerProperty(rs.getInt("item")));
				produto.setDadosProduto(new SimpleStringProperty(rs.getString("nome")));
				produto.setValorUnd(new SimpleDoubleProperty(rs.getDouble("valor")));
				produto.setQuantidade(new SimpleIntegerProperty(rs.getInt("quantidade")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public List<Produto> todos() {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Produto produto = new Produto();
				produto.setItem(new SimpleIntegerProperty(rs.getInt("item")));
				produto.setDadosProduto(new SimpleStringProperty(rs.getString("dadosProduto")));
				produto.setValorUnd(new SimpleDoubleProperty(rs.getDouble("valorUnd")));
				produto.setQuantidade(new SimpleIntegerProperty(rs.getInt("quantidade")));
				produto.setTotal(new SimpleDoubleProperty(rs.getDouble("total")));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public void listarProduto(Connection con, ObservableList<Produto> produto) {
		String sql = "select dadosProduto, valorUnd, quantidade, total from produto";
		ResultSet rs;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				produto.add(new Produto(rs.getString("dadosProduto"), rs.getDouble("valorUnd"), rs.getInt("quantidade"), rs.getDouble("total")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
