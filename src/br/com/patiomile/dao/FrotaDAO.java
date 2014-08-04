package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.Frota;
import br.com.patiomile.modelo.Marca;
import br.com.patiomile.modelo.Modelo;
import br.com.patiomile.utilitario.Conexao;

public class FrotaDAO {

	/**
	 * @wbp.parser.entryPoint
	 */
	public void inserirFrota(Frota frota) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO frota (marcaID, modeloID, placa, ano) VALUES ( ?, ?, ?, ? )";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, frota.getMarcaID());
			pstmt.setInt(2, frota.getModeloID());
			pstmt.setString(3, frota.getPlaca());
			pstmt.setString(4, frota.getAno());

			pstmt.execute();

			conn.close();
			pstmt.close();

			JOptionPane.showMessageDialog(null, "Frota inserida com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao inserir a Frota!\n"
					+ e.getMessage());

		}

	}

	public void atualizarFrota(Frota frota) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE frota SET marcaID = ?, modeloID = ?, placa = ?, ano = ? WHERE frotaID = ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, frota.getMarcaID());
			pstmt.setInt(2, frota.getModeloID());
			pstmt.setString(3, frota.getPlaca());
			pstmt.setString(4, frota.getAno());
			pstmt.setInt(5, frota.getFrotaID());

			pstmt.executeQuery();

			conn.close();
			pstmt.close();

			JOptionPane
					.showMessageDialog(null, "Frota atualizada com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar a Frota!\n"
					+ e.getMessage());

		}

	}

	public void excluirFrota(int frotaID) {

		String sql = "";
		int excluir = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM frota WHERE frotaID = ?";

		try {

			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o modelo?",
					"Confirma Excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, frotaID);

				pstmt.executeQuery();

				conn.close();
				pstmt.close();

				JOptionPane.showMessageDialog(null,
						"Frota excluído com sucesso!");

			} else if (excluir == JOptionPane.NO_OPTION) {

			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao excluir Frota!\n" + e.getMessage());

		}

	}

	public List<Frota> listarTodosVeiculosFrota() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Frota> listaVeiculos = new ArrayList<Frota>();

		sql = "SELECT * FROM frota INNER JOIN marca ON frota.marcaID = marca.marcaID INNER JOIN modelo ON frota.modeloID = modelo.modeloID;";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo modelo = new Modelo();
				Frota listaVeiculo = new Frota();

				listaVeiculo.setFrotaID(rs.getInt("frotaID"));
				listaVeiculo.setMarcaID(rs.getInt("marcaID"));
				listaVeiculo.setModeloID(rs.getInt("modeloID"));
				listaVeiculo.setPlaca(rs.getString("placa"));
				listaVeiculo.setAno(rs.getString("ano"));

				listaVeiculo.setMarca(marca);
				listaVeiculo.setModelo(modelo);

				listaVeiculos.add(listaVeiculo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaVeiculos;

	}

	public List<Frota> listarVeiculosPorNomeMarca(String nomeMarca) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Frota> listaVeiculos = new ArrayList<Frota>();

		sql = "SELECT * FROM frota INNER JOIN marca ON frota.marcaID = marca.marcaID INNER JOIN modelo ON frota.modeloID = modelo.modeloID WHERE marca.nomeMarca = ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeMarca + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo modelo = new Modelo();
				Frota listaVeiculo = new Frota();

				listaVeiculo.setFrotaID(rs.getInt("frotaID"));
				listaVeiculo.setMarcaID(rs.getInt("marcaID"));
				listaVeiculo.setModeloID(rs.getInt("modeloID"));
				listaVeiculo.setPlaca(rs.getString("placa"));
				listaVeiculo.setAno(rs.getString("ano"));

				listaVeiculo.setMarca(marca);
				listaVeiculo.setModelo(modelo);

				listaVeiculos.add(listaVeiculo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaVeiculos;

	}

	public List<Frota> listarVeiculosPorNomeModelo(String nomeModelo) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Frota> listaVeiculos = new ArrayList<Frota>();

		sql = "SELECT * FROM frota INNER JOIN marca ON frota.marcaID = marca.marcaID INNER JOIN modelo ON frota.modeloID = modelo.modeloID WHERE modelo.nomeModelo = ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeModelo + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Marca marca = new Marca();
				Modelo modelo = new Modelo();
				Frota listaVeiculo = new Frota();

				listaVeiculo.setFrotaID(rs.getInt("frotaID"));
				listaVeiculo.setMarcaID(rs.getInt("marcaID"));
				listaVeiculo.setModeloID(rs.getInt("modeloID"));
				listaVeiculo.setPlaca(rs.getString("placa"));
				listaVeiculo.setAno(rs.getString("ano"));

				listaVeiculo.setMarca(marca);
				listaVeiculo.setModelo(modelo);

				listaVeiculos.add(listaVeiculo);

			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de Frota!\n" + e.getMessage());

		}

		return listaVeiculos;

	}

	

}
