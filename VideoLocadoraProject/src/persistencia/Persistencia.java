package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;

public class Persistencia {

	private Connection con;
	
	public void fecharConexao() throws PersistenciaException{
		try {
			this.con.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Não foi possível fechar a conexao com o banco de dados.");
		}
	}
	
	public Persistencia(Connection con) {
		this.con = con;
	}
	
	public CachedRowSetImpl executeQuery(String sql) throws PersistenciaException{
		try {
			
			Statement st = this.con.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			CachedRowSetImpl resultado = new CachedRowSetImpl();
			resultado.populate(result);
			
			return resultado;
			
		} catch (SQLException e) {
			throw new PersistenciaException("Não foi possível executar o sql desejado.");
		}finally{
			this.fecharConexao();
		}
	}
	
	public Integer executeUpdate(String sql) throws PersistenciaException{
		
		try {
			
			Statement st = this.con.createStatement();
			return st.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw new PersistenciaException("Não foi possível executar o sql desejado.");
		}finally{
			this.fecharConexao();
		}
	}

	public void execute(String sql) throws PersistenciaException{
		
		try {
			
			Statement st = this.con.createStatement();
			st.execute(sql);
			
		} catch (SQLException e) {
			throw new PersistenciaException("Não foi possível executar o sql desejado.");
		}finally{
			this.fecharConexao();
		}
	}
	
	public Connection getConnection(){
		return this.con;
	}
}