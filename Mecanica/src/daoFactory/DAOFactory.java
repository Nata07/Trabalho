package daoFactory;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.MecanicoDAO;
import dao.ProdutoDAO;
import dao.VeiculoDAO;

public class DAOFactory {

		private static DAOFactory factory;
		
		private static final String tipoSistema = "BANCO";
		
		private static GenericDAOFactory daoFactory;
		
		public static DAOFactory get(){
			if(factory == null){
				factory = new DAOFactory();
			}
			if(tipoSistema.equals("BANCO")){
				daoFactory = new DAOFactoryJDBC();
			}
			return factory;
		}
		public ClienteDAO clienteDAO(){
			return daoFactory.clienteDAO();
		}
		public MecanicoDAO mecanicoDAO(){
			return daoFactory.mecanicoDAO();
		}
		public FuncionarioDAO funcionarioDAO(){
			return daoFactory.funcionarioDAO();
		}
		public VeiculoDAO veiculoDAO(){
			return daoFactory.veiculoDAO();
		}
		public ProdutoDAO produtoDAO(){
			return daoFactory.produtoDAO();
		}
}