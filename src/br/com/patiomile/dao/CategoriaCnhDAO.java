package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.Cargo;
import br.com.patiomile.utilitario.Conexao;

public class CategoriaCnhDAO {


	public boolean inserirRegistro(Cargo cargo) {

		String sql = "";
		boolean retorno = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO cargo (nomeCargo) VALUES (?)";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cargo.getNomeCargo());

			pstmt.execute();

			conn.close();
			pstmt.close();

			retorno = true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir o registro!"
					+ e.getMessage());
		}

		return retorno;

	}

	public boolean atualizarRegistro(Cargo cargo) {

		String sql = "";
		boolean retorno = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE cargo SET nomeCargo = ? WHERE cargoID = ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cargo.getNomeCargo());
			pstmt.setInt(2, cargo.getCargoID());

			pstmt.executeQuery();

			conn.close();
			pstmt.close();

			retorno = true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"
					+ e.getMessage());
		}

		return retorno;

	}

	public boolean excluirRegistro(int cargoID) {

		String sql = "";
		boolean retorno = false;
		int excluir = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM cargo WHERE cargoID = ?";

		try {

			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o Cargo?",
					"Confirma excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cargoID);

				pstmt.executeQuery();

				conn.close();
				pstmt.close();

				retorno = true;

			} else if (excluir == JOptionPane.NO_OPTION) {
				retorno = false;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir o cargo!\n"
					+ e.getMessage());
		}

		return retorno;

	}

	public List<Cargo> listarTodosCargos() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Cargo> listaTodosCargos = new ArrayList<Cargo>();

		sql = "SELECT * FROM cargo";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Cargo listaCargo = new Cargo();

				listaCargo.setCargoID(rs.getInt("cargoID"));
				listaCargo.setNomeCargo(rs.getString("nomeCargo"));

				listaTodosCargos.add(listaCargo);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de cargos." + e.getMessage());
		}

		return listaTodosCargos;
	}

	public List<Cargo> listarCargoPorNome(String nomeCargo) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Cargo> listaCargoPorNome = new ArrayList<Cargo>();

		sql = "SELECT * FROM cargo WHERE nomeCargo LIKE ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Cargo listaCargo = new Cargo();

				listaCargo.setCargoID(rs.getInt("cargoID"));
				listaCargo.setNomeCargo(rs.getString("nomeCargo"));

				listaCargoPorNome.add(listaCargo);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a lista!"
					+ e.getMessage());
		}

		return listaCargoPorNome;
	}


	
}
