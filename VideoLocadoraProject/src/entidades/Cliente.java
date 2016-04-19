package entidades;

/**
 * @author Rodrigo
 *
 */
public class Cliente {
	
	Integer id;  
 	String nome;
	Integer idade;
	
	@Override
	public String toString() {
		return "\nID: " + this.id +
				"\nNOME: " + this.nome +
				"\nIDADE: " + this.idade;
	}
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
