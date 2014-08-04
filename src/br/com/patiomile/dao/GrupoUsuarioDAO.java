package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.GrupoUsuario;
import br.com.patiomile.utilitario.Conexao;

public class GrupoUsuarioDAO {

	public boolean inserirGrupoUsuario(GrupoUsuario grupoUsuario) {
		boolean inserido = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO grupoUsuario (nome) VALUES (?);";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, grupoUsuario.getNomeGrupoUsuario());

			inserido = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir o grupo de usuário!\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return inserido;
	}

	public boolean atualizarGrupoUsuario(GrupoUsuario grupousuario) {
		boolean atualizado = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE grupousuario SET nome = ? WHERE grupousuarioID = ?;";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, grupousuario.getNomeGrupoUsuario());
			pstmt.setInt(2, grupousuario.getGrupoUsuarioID());

			pstmt.execute();

			atualizado = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao atualizar grupo de usuário!\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return atualizado;
	}

	public boolean excluirGrupoUsuario(int grupoUsuarioID) {
		boolean excluido = false;
		String sql = "";
		int excluir = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM grupousuario WHERE grupousuarioID = ? ";

		try {

			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o usuario?",
					"Confirma Excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, grupoUsuarioID);

				pstmt.execute();

				excluido = true;
			} else if (excluir == JOptionPane.NO_OPTION) {

			}

			excluido = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao excluir grupo de usuário!\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return excluido;
	}

	public List<GrupoUsuario> listarTodosGruposUsuarios() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GrupoUsuario> listaTodosGruposUsuarios = new ArrayList<GrupoUsuario>();

		sql = "SELECT * FROM grupousuario";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				GrupoUsuario listaGrupoUsuario = new GrupoUsuario();

				listaGrupoUsuario
						.setGrupoUsuarioID(rs.getInt("grupousuarioID"));
				listaGrupoUsuario.setNomeGrupoUsuario(rs.getString("nome"));

				listaTodosGruposUsuarios.add(listaGrupoUsuario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Erro ao preencher a lista dos grupos de usuários!\n"
							+ e.getMessage());
		}

		return listaTodosGruposUsuarios;
	}

	public List<GrupoUsuario> listarGrupoUsuarioPorNome(String nomeGrupoUsuario) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GrupoUsuario> listaGruposUsuarios = new ArrayList<GrupoUsuario>();

		sql = "SELECT * FROM grupousuario WHERE nome LIKE ? ";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeGrupoUsuario + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				GrupoUsuario listaGrupoUsuario = new GrupoUsuario();

				listaGrupoUsuario
						.setGrupoUsuarioID(rs.getInt("grupoUsuarioID"));
				listaGrupoUsuario.setNomeGrupoUsuario(rs.getString("nome"));

				listaGruposUsuarios.add(listaGrupoUsuario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Erro ao preencher a lista dos grupos de usuários!\n"
							+ e.getMessage());
		}

		return listaGruposUsuarios;
	}

}
