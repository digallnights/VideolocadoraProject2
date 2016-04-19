package persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class PersistenciaFactory {

	private static String url;
	private static String usuario;
	private static String senha;
	private static String driver;
	private static Boolean inicializado = false;
	
	public static Persistencia criarPersistencia() throws PersistenciaException{
		
		InputStream arquivo = null;
		Properties propriedade = null;
		Persistencia persistencia = null;
		
		try {
			
			if (!inicializado) {
				propriedade = new Properties();
				arquivo = PersistenciaFactory.class.getResourceAsStream("jdbc.properties");
				propriedade.load(arquivo);
				
				driver = propriedade.get("DRIVER").toString();
				usuario = propriedade.get("USUARIO").toString();
				senha = propriedade.get("SENHA").toString();
				url = propriedade.get("URL").toString();
				
				Class.forName(driver);
				inicializado = true;
			}
			
			Connection con = DriverManager.getConnection(url,usuario,senha);
			
			persistencia = new Persistencia(con);
			
		} catch (IOException e) {
			throw new PersistenciaException("Não foi possivel achar o arquvo de propriedade");
		} catch (ClassNotFoundException e) {
			throw new PersistenciaException("O driver de banco de dados nao foi encontrado");
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao tentar abrir uma conexao");
		} catch (Exception e) {
			throw new PersistenciaException("Erro geral no sistema.");
		}
		return persistencia;
	}
}