package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.Marca;
import br.com.patiomile.modelo.Modelo;
import br.com.patiomile.utilitario.Conexao;

public class ModeloDAO {

	public void inserirModelo(Modelo modelo) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO modelo (nomeModelo, marcaID) VALUES ( ?, ? )";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, modelo.getNomeModelo());
			pstmt.setInt(2, modelo.getMarcaID());

			pstmt.execute();

			conn.close();
			pstmt.close();

			JOptionPane.showMessageDialog(null, "Modelo inserido com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao inserir o Modelo!\n"
					+ e.getMessage());

		}

	}

	public void atualizarModelo(Modelo modelo) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE modelo SET nomeModelo = ?, marcaID = ? WHERE modeloID = ? ";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, modelo.getNomeModelo());
			pstmt.setInt(2, modelo.getMarcaID());
			pstmt.setInt(3, modelo.getModeloID());

			pstmt.executeQuery();

			conn.close();
			pstmt.close();

			JOptionPane.showMessageDialog(null,
					"Modelo atualizado com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar o Modelo!\n"
					+ e.getMessage());

		}

	}

	public void excluirModelo(int modeloID) {

		String sql = "";
		int excluir = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM modelo WHERE modeloID = ? ";

		try {

			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o modelo?",
					"Confirma Excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, modeloID);

				pstmt.executeQuery();

				conn.close();
				pstmt.close();

				JOptionPane.showMessageDialog(null,
						"O modelo foi excluido com sucesso!");

			} else if (excluir == JOptionPane.NO_OPTION) {

			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao excluir grupo de usuário!\n" + e.getMessage());

		}

	}

	public List<Modelo> listarTodosModelos() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Modelo> listaModelos = new ArrayList<Modelo>();

		sql = "SELECT * FROM modelo INNER JOIN marca ON modelo.marcaID = modelo.marcaID;";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo listaModelo = new Modelo();

				listaModelo.setModeloID(rs.getInt("modeloID"));
				listaModelo.setNomeModelo(rs.getString("nomeModelo"));
				listaModelo.setMarcaID(rs.getInt("marcaID"));

				listaModelo.setMarca(marca);

				listaModelos.add(listaModelo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaModelos;

	}

	public List<Modelo> listarModelosPorNome(String nomeModelo) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Modelo> listaModelos = new ArrayList<Modelo>();

		sql = "SELECT * FROM modelo INNER JOIN marca ON modelo.marcaID = modelo.marcaID WHERE nomeModelo LIKE ?";

		try {

			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeModelo + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo listaModelo = new Modelo();

				listaModelo.setModeloID(rs.getInt("modeloID"));
				listaModelo.setNomeModelo(rs.getString("nomeModelo"));
				listaModelo.setMarcaID(rs.getInt("marcaID"));

				listaModelo.setMarca(marca);

				listaModelos.add(listaModelo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaModelos;

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

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher lista das Marcas!" + e.getMessage());

		}

		return listaTodasMarcas;

	}

	public List<Modelo> listarModelosPelaMarca(int marcaID) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Modelo> listaModelos = new ArrayList<Modelo>();

		sql = "SELECT * FROM modelo WHERE marcaID = ?";

		try {

			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + marcaID + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo listaModelo = new Modelo();

				listaModelo.setModeloID(rs.getInt("modeloID"));
				listaModelo.setNomeModelo(rs.getString("nomeModelo"));
				listaModelo.setMarcaID(rs.getInt("marcaID"));

				listaModelo.setMarca(marca);

				listaModelos.add(listaModelo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaModelos;
	}

	public int ObterCodigoMarca(String nomeMarca) {

		String sql = "";
		int marcaID = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "SELECT * FROM marca WHERE nomeMarca = ?";

		try {

			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nomeMarca);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				marcaID = rs.getInt("marcaID");
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao encontrar codigo da marca.\n" + e.getMessage());

		}

		return marcaID;
	}

}
