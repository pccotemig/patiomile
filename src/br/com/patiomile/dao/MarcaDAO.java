package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.Marca;
import br.com.patiomile.utilitario.Conexao;
import br.com.patiomile.utilitario.MensagensType;

public class MarcaDAO {

	public boolean inserirMarca(Marca marca) {
		boolean inserido = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO marca (nomemarca) VALUES (?);";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, marca.getNomeMarca());
			pstmt.execute();

			inserido = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir marca!" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return inserido;
	}

	public boolean atualizarMarca(Marca marca) {
		boolean atualizado = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE marca SET nomemarca = ? WHERE marcaID = ?";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, marca.getNomeMarca());
			pstmt.setInt(2, marca.getMarcaID());
			pstmt.execute();

			atualizado = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOATUALIZAR
					+ "\n" + e.getMessage());
		}

		return atualizado;
	}

	public boolean excluirMarca(int marcaID) {
		boolean excluido = false;
		String sql = "";
		int excluir = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM marca WHERE marcaID = ?";

		try {
			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir a marca?",
					"Confirma Excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, marcaID);
				pstmt.execute();

				excluido = true;
			} else if (excluir == JOptionPane.NO_OPTION) {

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOEXCLUIR
					+ "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return excluido;
	}

	public List<Marca> listarTodasMarcas() {
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Marca> listaTodasMarcas = new ArrayList<Marca>();

		sql = "SELECT * FROM marca";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Marca listaMarca = new Marca();

				listaMarca.setMarcaID(rs.getInt("marcaID"));
				listaMarca.setNomeMarca(rs.getString("nomeMarca"));
				listaTodasMarcas.add(listaMarca);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOINSERIR
					+ "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaTodasMarcas;
	}

	public List<Marca> listarMarcasPorNome(String nomeMarca) {
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Marca> listaMarcasPorNome = new ArrayList<Marca>();

		sql = "SELECT * FROM marca WHERE nomeMarca LIKE ?";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeMarca + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Marca listaMarca = new Marca();

				listaMarca.setMarcaID(rs.getInt("marcaID"));
				listaMarca.setNomeMarca(rs.getString("nomeMarca"));
				listaMarcasPorNome.add(listaMarca);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA + "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaMarcasPorNome;
	}

}
