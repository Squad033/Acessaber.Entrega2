package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Alunos;

public class AlunoDAO {

	//create
	public void create(Alunos aluno) {
		
		String sql = "insert into Alunos (CPF_aluno, nome_aluno, email_aluno, telefone_aluno) values (?,?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aluno.getCPF());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getEmail());
			pstm.setString(4, aluno.getTelefone());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace ();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	
	//read
	public List<Alunos> read() {
		List<Alunos> Alunos = new ArrayList<Alunos>();
		String sql = "select * from Alunos;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Alunos aluno = new 	Alunos();
				
				aluno.setId(rset.getInt("id_aluno"));
				aluno.setCPF(rset.getString("CPF_aluno"));
				aluno.setNome(rset.getString("nome_aluno"));
				aluno.setEmail(rset.getString("email_aluno"));
				aluno.setTelefone(rset.getString("telefone_aluno"));
				
				Alunos.add(aluno);
				
			}
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		return Alunos;
	}
	
	//update
	public void update(Alunos aluno) {
		
String sql = "UPDATE Alunos SET CPF-aluno = ?, nome_aluno = ?, email_aluno = ?, senha_aluno = ? WHERE id_aluno = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
					
			pstm.setString(1, aluno.getCPF());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getEmail());
			pstm.setString(4, aluno.getTelefone());
			pstm.setInt(5,  aluno.getId());
			
			pstm.execute();
		
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	}
	
	//delete
	public void delete(int id) {
		String sql = "DELETE FROM Alunos WHERE id_aluno = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		
	}
	
	//readById
	public Alunos readById(int id) {
		
		Alunos aluno = new Alunos();
		
	String sql = "SELECT * FROM Alunos WHERE id_aluno = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();		
			
			aluno.setId(rset.getInt("id_aluno"));
			aluno.setCPF(rset.getString("CPF_aluno"));
			aluno.setNome(rset.getString("nome_aluno"));
			aluno.setEmail(rset.getString("email_aluno"));
			aluno.setTelefone(rset.getString("telefone_aluno"));
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		
		return aluno;
	}
}
