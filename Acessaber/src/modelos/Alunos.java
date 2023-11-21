package modelos;

public class Alunos {
	
	// atributos
	private int id;
	private String CPF;
	private String nome;
	private String email;
	private String telefone;
	
	
	// construtor
	public Alunos() {
	}


	public Alunos(int id, String CPF,String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
		this.telefone = telefone;
	}


	public Alunos(String CPF,String nome, String email, String telefone) {
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
		this.telefone = telefone;
	}

	//getters e setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEquipamento() {
		return equipamentos;
	}


	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//tostring
	@Override
	public String toString() {
		return "Alunos [id=" + id + ", nome=" + nome + ", CPF=" + CPF + ", email=" + email + ", telefone=" + telefone + "]";
	}
	

	

}

