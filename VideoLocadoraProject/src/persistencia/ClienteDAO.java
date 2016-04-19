package persistencia;

import java.sql.SQLException;
import com.sun.rowset.CachedRowSetImpl;
import entidades.Cliente;
import exceptions.ClienteException;


public class ClienteDAO {

	public Cliente pesquisarCliente(String nome, Integer id) throws ClienteException{
		
		Cliente c = null;
		try {
			String sql = "select * from cliente where id = " + id + " or nome = '" + nome+ "'";
			
			Persistencia persistencia = PersistenciaFactory.criarPersistencia();
			
			CachedRowSetImpl result = persistencia.executeQuery(sql);
			
			if (result.next()){
				c = new Cliente();
				c.setNome(result.getString("nome"));
				c.setId(result.getInt("id"));
			}else{
				throw new ClienteException("O cliente pesquisado não existe");
			}
		} catch (PersistenciaException e) {
			throw new ClienteException(e.getMessage());
		} catch (SQLException e) {
			throw new ClienteException("Erro ao executar o sql de pesquisa de cliente.");
		}
		return c;
	}
	
	public void imprimirClientes() throws ClienteException{
		try {
			Persistencia persistencia = PersistenciaFactory.criarPersistencia();
			
			 CachedRowSetImpl resultado = persistencia.executeQuery("select * from cliente order by nome");
			
			 while(resultado.next()) {
				 System.out.println("Dados do cliente.:");
				 System.out.println("ID.:" + resultado.getInt("id"));
				 System.out.println("Nome.:" + resultado.getInt("nome"));
				
			 }
			 
		} catch (PersistenciaException e) {
			throw new ClienteException("Nao foi possivel listar os clientes.");
		} catch (SQLException e) {
			throw new ClienteException("Nao foi possivel listar os clientes.");
		}
	}
	
	public void salvar(String nome, Integer idade) throws ClienteException{
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setIdade(idade);
		this.salvar(cliente);
	}
	
	public void salvar(String sql) throws ClienteException{
		
		try {
			Persistencia persistencia = PersistenciaFactory.criarPersistencia();
			
			persistencia.execute(sql);
			
		} catch (PersistenciaException e) {
			throw new ClienteException("Nao foi possivel salvar o cliente.");
		}
	}

	public void salvar(Cliente cliente) throws ClienteException{
		
		try {
			Persistencia persistencia = PersistenciaFactory.criarPersistencia();
			String idade = String.valueOf(cliente.getIdade());
			StringBuffer buffer = new StringBuffer("insert into cliente (nome, idade) values ( ");
			buffer.append("'").append(cliente.getNome()).append("', ")
			      .append("'").append(idade).append("' )");
		
			persistencia.execute(buffer.toString());
			
		} catch (PersistenciaException e) {
			throw new ClienteException("Nao foi possivel salvar o cliente222.");
		}
	}
	}