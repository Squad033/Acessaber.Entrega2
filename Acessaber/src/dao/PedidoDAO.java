package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Alunos;
import modelos.Equipamentos;
import modelos.Pedidos;
import modelos.Passagem;

public class PedidoDAO {

	// create
	public void create(Pedidos pedido) {

		String sql = "insert into Pedidos (data_pedidos, id_alunos,id-equipamentos, id_passagem, total_pedido) values (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pedido.getData_pedido());
			pstm.setInt(2, pedido.getAluno().getId());
			pstm.setInt(3, pedido.getEquipamento().getId());
			pstm.setInt(4, pedido.getPassagem().getId());
			pstm.setDouble(5, pedido.getTotal_pedido());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// read
	public List<Pedidos> read() {
		List<Pedidos> Pedidos = new ArrayList<Pedidos>();
		String sql = "select * from aluno_passagem order by id_pedido;"; //talvez de erro

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Pedidos pedido = new Pedidos();
				Passagem passagem = new Passagem();
				Alunos aluno = new Alunos();
				Equipamentos equipamento = new Equipamentos();

				pedido.setId(rset.getInt("id_pedido"));
				pedido.setData_pedido(rset.getString("data_pedidos"));
				pedido.setTotal_pedido(rset.getDouble("total_pedido"));

				passagem.setDestino(rset.getString("destino_passagem"));
				passagem.setId(rset.getInt("id_passagem"));
				passagem.setPreco(rset.getFloat("preco_passagem"));
				
				
				aluno.setEmail(rset.getString("email_aluno"));
				aluno.setId(rset.getInt("id_aluno"));
				aluno.setNome(rset.getString("nome_aluno"));
				aluno.setCPF(rset.getString("CPF_aluno"));
				aluno.setSenha(rset.getString("telefone_aluno"));
				
				equipamento.setDisponibilidade(rset.getString("disponibilidade_equipamento"));

				pedido.setPassagem(passagem);
				pedido.setAluno(aluno);

				Pedidos.add(pedido);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Pedidos;
	}

	// update
	public void update(Pedidos pedido) {

		String sql = "UPDATE Pedidos SET data_Pedidos = ?, id_Alunos = ?, id_passagem = ?,  total_pedido = ? WHERE id_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pedido.getData_pedido());
			pstm.setInt(2, pedido.getAluno().getId());
			pstm.setInt(3, pedido.getEquipamento().getId());
			pstm.setInt(4, pedido.getPassagem().getId());
			pstm.setDouble(5, pedido.getTotal_pedido());
			pstm.setInt(6, pedido.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Pedidos WHERE id_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Pedidos readById(int id) {

		Pedidos pedido = new Pedidos();

		String sql = "SELECT * FROM aluno_passagem WHERE id_pedido = ?"; // verificar

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			Passagem passagem = new Passagem();
			Alunos aluno = new Alunos();
			Equipamentos equipamento = new Equipamentos();

			pedido.setId(rset.getInt("id_pedido"));
			pedido.setData_pedido(rset.getString("data_Pedidos"));
			pedido.setTotal_pedido(rset.getDouble("total_pedido"));

			passagem.setDestino(rset.getString("destino_passagem"));
			passagem.setId(rset.getInt("id_passagem"));
			passagem.setPreco(rset.getFloat("preco_passagem"));
			
			aluno.setEmail(rset.getString("email_aluno"));
			aluno.setId(rset.getInt("id_aluno"));
			aluno.setNome(rset.getString("nome_aluno"));
			aluno.setCPF(rset.getString("CPF_aluno"));
			aluno.setSenha(rset.getString("telefone_aluno"));
			
			equipamento.setDisponibilidade(rset.getString("disponibilidade_equipamento"));
			pedido.setPassagem(passagem);
			pedido.setAluno(aluno);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pedido;
	}

}
