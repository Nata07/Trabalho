package daoFactory;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.MecanicoDAO;
import dao.ProdutoDAO;
import dao.VeiculoDAO;

public interface GenericDAOFactory {
	
	ClienteDAO clienteDAO();
	FuncionarioDAO funcionarioDAO();
	MecanicoDAO mecanicoDAO();
	VeiculoDAO veiculoDAO();
	ProdutoDAO produtoDAO();
}
