package modelos;

public class Pedidos {

	private int id;
	private String data_pedido;
	private String data_equipamento;
	private Double total_pedido;
	
	private Alunos aluno;
	private Equipamento equipamento;
	private Passagem passagem;
	
	public pedidos() {
	}
	public pedidos(int id, String data_pedido, Double total_pedido, Alunos aluno, Equipamento equipamento, Passagem passagem) {
		this.id = id;
		this.data_pedido = data_pedido;
		this.total_pedido = total_pedido;
		this.aluno = aluno;
		this.equipamento = equipamento;
		this.passagem = passagem;
	}
	public pedidos(String data_pedido, Double total_pedido, Alunos aluno,Equipamento equipamento, Passagem passagem) {
		this.data_pedido = data_pedido;
		this.total_pedido = total_pedido;
		this.aluno = aluno;
		this.equipamento = equipamento;
		this.passagem = passagem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}
	public Double getTotal_pedido() {
		return total_pedido;
	}
	public void setTotal_pedido(Double total_pedido) {
		this.total_pedido = total_pedido;
	}
	public alunos getaluno() {
		return aluno;
	}
	public void setaluno(alunos aluno) {
		this.aluno = aluno;
	}
	public equipamentos getequipamento() {
		return equipamento;
	}
	public void setequipamento(equipamentos equipamento) {
		this.equipamento = equipamento;
	}
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	
	@Override
	public String toString() {
		return "pedidos [id=" + id + ", data_pedido=" + data_pedido + ", total_pedido=" + total_pedido + ", aluno="
				+ aluno + ",equipamento=" + equipamento + ", passagem=" + passagem + "]";
	}
	
	
}
