package crud;

import java.util.Scanner;

import dao.EquipamentoDAO;
import modelos.Equipamentos;

public class EquipamentoCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		
		int opcao = 0, id = 0;
		
		String  disponibilidade = "";
				
		do {
			
			System.out.println("\n========================= CLIENTES =============================\n");
			System.out.println("1-CRIAR 2-CONSULTAR 3- ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Digite o disponibilidade");
				disponibilidade = s.nextLine();
				
				
				Equipamentos equipamento1 = new Equipamentos(disponibilidade);
				
				equipamentoDAO.create(equipamento1); 
				break;
			case 2:
				
				for(Equipamentos e : equipamentoDAO.read()) {
					System.out.println(e.toString());
				}
				equipamentoDAO.read();
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				System.out.println("Digite a disponibilidade");
				disponibilidade = s.nextLine();
				
				
				Equipamentos equipamento2 = new Equipamentos(id,disponibilidade);
				
				equipamentoDAO.update(equipamento2); 
				break;
			case 4:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				equipamentoDAO.delete(id);
				break;
			case 5:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				Equipamentos equipamento3 = equipamentoDAO.readById(id);
				
				System.out.println(equipamento3.toString());
				
				equipamentoDAO.readById(id);
				break;
			default:
				
				break;
			}
			
		}while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}