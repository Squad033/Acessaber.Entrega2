package modelos;

public class Equipamentos {
	
	// atributos
	private int id;
	private String disponibilidade;
	
	
	// construtor
	public Equipamentos() {
	}


	public Equipamentos(int id, String disponibilidade) {
		this.id = id;
		this.disponibilidade = disponibilidade;
		
	}


	public Equipamentos(String disponibilidade) {
		this.disponibilidade = disponibilidade;
		
	}

	//getters e setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getdisponibilidade() {
		return disponibilidade;
	}


	public void setdisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	//tostring
	@Override
	public String toString() {
		return "Equipamentos [id=" + id + ", disponibilidade=" + disponibilidade + "]";
	}
	

	

}
