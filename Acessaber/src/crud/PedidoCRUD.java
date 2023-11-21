package crud;

import java.util.Scanner;

import dao.AlunoDAO;
import dao.EquipamentoDAO;
import dao.PedidoDAO;
import dao.PassagemDAO;
import modelos.Alunos;
import modelos.Equipamentos;
import modelos.Pedidos;
import modelos.Passagem;

public class PedidoCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PedidoDAO pedidoDAO = new PedidDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		
		int opcao = 0, id = 0, id_cliente = 0; 
		
		
		do {
			
			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data do pedido:");
				String data_pedido = s.nextLine();
				System.out.println("Digite o total do pedido:");
				double total_pedido = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o id do aluno:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do Equipamento:");
				id_equipamento = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do Passagem:");
				int id_passagem = s.nextInt();
				s.nextLine();
				
				Alunos aluno1 = alunoDAO.readById(id_aluno);
				Equipamentos equipamento1 = equipamentoDAO.readById(id_equipamento);
				Passagem passagem1 = passagemDAO.readById(id_passagem);
				
				
				Compras pedido1 = new Pedidos(data_pedido, total_pedido, aluno1, equipamento1, passagem1);
				
				
				pedidoDAO.create(pedido1);
				break;
			case 2:
				
				for (Pedidos p : pedidoDAO.read()) {
					
					System.out.println(p.toString());
					
				}
				
				break;
			case 3:
				System.out.println("Digite o id do pedido:");
				id = s.nextInt();
				s.nextLine();				
				System.out.println("Digite a data do pedido:");
				data_pedido = s.nextLine();
				System.out.println("Digite o total do pedido:");
				total_pedido = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o id do aluno:");
				int id_aluno2 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do equipamento:");
				int id_equipamento2 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do Passagem:");
				int id_Passagem2 = s.nextInt();
				s.nextLine();
				
				Alunos aluno2 = alunoDAO.readById(id_aluno2);
				Equipamentos equipamento2 = equipamentoDAO.readById(id_equipamento2);
				Passagem passagem2 = passagemDAO.readById(id_Passagem2);
				
				
				Pedidos pedido2 = new Pedidos(id, data_pedido,total_pedido, pedido2, equipamento2, passagem2);
				
				pedidoDAO.update(pedido2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				pedidoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Pedidos pedido3 = pedidoDAO.readById(id);
				
				System.out.println(pedido3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();
	}

}
