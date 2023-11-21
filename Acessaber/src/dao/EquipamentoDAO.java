package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Equipamentos;

public class equipamentoDAO {

	//create
	public void create(Equipamentos equipamento) {
		
		String sql = "insert into Equipamentos (disponibilidade_equipamento) values (?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, equipamento.getDisponibilidade());
			
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
	public List<Equipamentos> read() {
		List<Equipamentos> Equipamentos = new ArrayList<Equipamentos>();
		String sql = "select * from Equipamentos;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Equipamentos equipamento = new 	Equipamentos();
				
				equipamento.setId(rset.getInt("id_equipamento"));
				equipamento.setDisponibilidade(rset.getString("disponibilidade_equipamento"));
				
				Equipamentos.add(equipamento);
				
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
		
		return Equipamentos;
	}
	
	//update
	public void update(Equipamentos equipamento) {
		
String sql = "UPDATE Equipamentos SET disponibilidade_equipamento = ? WHERE id_equipamento = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, equipamento.getDisponibilidade());
			pstm.setInt(2,  equipamento.getId());
			
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
		String sql = "DELETE FROM Equipamentos WHERE id_equipamento = ?";
		
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
	public Equipamentos readById(int id) {
		
		Equipamentos equipamento = new Equipamentos();
		
	String sql = "SELECT * FROM Equipamentos WHERE id_Equipamento = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			equipamento.setId(rset.getInt("id_equipamento"));
			equipamento.setNome(rset.getString("disponibilidade_equipamento"));
			
					
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
		
		
		return equipamento;
	}
}
