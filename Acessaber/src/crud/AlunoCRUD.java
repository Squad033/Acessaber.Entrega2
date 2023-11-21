package crud;

import java.util.Scanner;

import dao.AlunoDAO;
import modelos.Alunos;

public class AlunoCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AlunoDAO clienteDAO = new AlunoDAO();
		
		int opcao = 0, id = 0;
		
		String  CPF = "", nome = "", email = "", telefone = "";
				
		do {
			
			System.out.println("\n========================= CLIENTES =============================\n");
			System.out.println("1-CRIAR 2-CONSULTAR 3- ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Digite o CPF");
				CPF = s.nextLine();
				System.out.println("Digite o nome");
				nome = s.nextLine();
				System.out.println("Digite o email");
				email = s.nextLine();
				System.out.println("Digite o telefone");
				telefone = s.nextLine();
				
				Alunos cliente1 = new Alunos(CPF, nome, email, telefone);
				
				alunoDAO.create(aluno1); 
				break;
			case 2:
				
				for(Alunos a : alunoDAO.read()) {
					System.out.println(c.toString());
				}
				alunoDAO.read();
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o CPF");
				CPF = s.nextLine();
				System.out.println("Digite o nome");
				nome = s.nextLine();
				System.out.println("Digite o email");
				email = s.nextLine();
				System.out.println("Digite o telefone");
				telefone = s.nextLine();
				
				Alunos aluno2 = new Alunos(id, CPF, nome, email, telefone);
				
				alunoDAO.update(aluno2); 
				break;
			case 4:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				alunoDAO.delete(id);
				break;
			case 5:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				Alunos aluno3 = alunoDAO.readById(id);
				
				System.out.println(aluno3.toString());
				
				alunoDAO.readById(id);
				break;
			default:
				
				break;
			}
			
		}while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}