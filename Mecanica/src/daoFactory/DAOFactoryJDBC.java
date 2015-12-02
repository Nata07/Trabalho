package daoFactory;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOJDBC;
import dao.MecanicoDAO;
import dao.MecanicoDAOJDBC;
import dao.ProdutoDAO;
import dao.ProdutoDAOJDBC;
import dao.VeiculoDAO;
import dao.VeiculoDAOJDBC;

public class DAOFactoryJDBC implements GenericDAOFactory{

	@Override
	public ClienteDAO clienteDAO() {
		// TODO Auto-generated method stub
		return new ClienteDAOJDBC();
	}

	@Override
	public FuncionarioDAO funcionarioDAO() {
		// TODO Auto-generated method stub
		return new FuncionarioDAOJDBC();
	}

	@Override
	public MecanicoDAO mecanicoDAO() {
		// TODO Auto-generated method stub
		return new MecanicoDAOJDBC();
	}
	public VeiculoDAO veiculoDAO(){
		return new VeiculoDAOJDBC();
	}
	public ProdutoDAO produtoDAO(){
		return new ProdutoDAOJDBC();
	}


}
