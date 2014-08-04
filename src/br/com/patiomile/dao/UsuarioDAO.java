package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.GrupoUsuario;
import br.com.patiomile.modelo.Usuario;
import br.com.patiomile.utilitario.Conexao;
import br.com.patiomile.utilitario.MensagensType;

public class UsuarioDAO {

	public boolean autenticarUsuario(String login, String senha) {
		boolean autenticado = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "SELECT * FROM usuario WHERE loginusuario = ? AND senhausuario = ? AND usuarioativo = ?";

		try {

			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login);
			pstmt.setString(2, senha);
			pstmt.setBoolean(3, true);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				autenticado = true;
			} else {
				autenticado = false;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário!\n"
					+ e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return autenticado;
	}

	public boolean inserirUsuario(Usuario usuario) {
		boolean inserido = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO usuario (nomeusuario, emailusuario, loginusuario, senhausuario, usuarioAtivo, grupoUsuarioID) VALUES ( ?, ?, ?, ?, ?, ?);";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getLogin());
			pstmt.setString(4, usuario.getSenha());
			pstmt.setBoolean(5, usuario.isUsuarioAtivo());
			pstmt.setInt(6, usuario.getGrupoUsuarioID());

			pstmt.execute();

			inserido = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao cadastrar o usuário! \n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return inserido;
	}

	public boolean atualizarUsuario(Usuario usuario) {
		boolean atualizado = false;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE usuario SET nome = ?, email = ?, login = ?, senha = ?, usuarioAtivo = ?, grupoUsuarioID = ? WHERE usuarioID = ?;";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usuario.getUsuarioID());

			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getLogin());
			pstmt.setString(4, usuario.getSenha());
			pstmt.setBoolean(5, usuario.isUsuarioAtivo());
			pstmt.setInt(6, usuario.getGrupoUsuarioID());

			pstmt.execute();

			atualizado = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao atualizar o usuário! \n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return atualizado;
	}

	public boolean excluirUsuario(int usuarioID) {
		boolean excluido = false;
		String sql = "";
		int excluir;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM usuario WHERE usuarioID = ?";

		try {

			excluir = JOptionPane.showConfirmDialog(null,
					"Tem certeza que deseja excluir o usuario?",
					"Confirma Excluir", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, usuarioID);

				pstmt.execute();

				excluido = true;
			} else if (excluir == JOptionPane.NO_OPTION) {

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario. \n"
					+ e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt);
		}

		return excluido;
	}

	public List<Usuario> listarTodosUsuario() {
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

		sql = "SELECT * FROM usuario INNER JOIN grupousuario ON usuario.grupousuarioID = grupousuario.grupousuarioID;";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				Usuario listaUsuario = new Usuario();

				grupoUsuario.setNomeGrupoUsuario(rs.getString("nomegrupousuario"));
				
				listaUsuario.setUsuarioID(rs.getInt("usuarioID"));
				listaUsuario.setNome(rs.getString("nomeusuario"));
				listaUsuario.setEmail(rs.getString("emailusuario"));
				listaUsuario.setLogin(rs.getString("loginusuario"));
				listaUsuario.setSenha(rs.getString("senhausuario"));
				listaUsuario.setUsuarioAtivo(rs.getBoolean("usuarioativo"));
				listaUsuario.setGrupoUsuarioID(rs.getInt("grupousuarioID"));
				listaUsuario.setGrupoUsuario(grupoUsuario);

				listaTodosUsuarios.add(listaUsuario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA + "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaTodosUsuarios;
	}

	public List<Usuario> listarTodosUsuariosAtivos() {
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Usuario> listaTodosUsuariosAtivos = new ArrayList<Usuario>();

		sql = "SELECT * FROM usuario INNER JOIN grupousuario ON usuario.grupousuarioID = grupousuario.grupousuarioID WHERE usuarioativo = ?;";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				Usuario listaUsuario = new Usuario();
				
				grupoUsuario.setNomeGrupoUsuario(rs.getString("nomegrupousuario"));

				listaUsuario.setUsuarioID(rs.getInt("usuarioID"));
				listaUsuario.setNome(rs.getString("nomeusuario"));
				listaUsuario.setEmail(rs.getString("emailusuario"));
				listaUsuario.setLogin(rs.getString("loginusuario"));
				listaUsuario.setSenha(rs.getString("senhausuario"));
				listaUsuario.setUsuarioAtivo(rs.getBoolean("usuarioativo"));
				listaUsuario.setGrupoUsuarioID(rs.getInt("grupousuarioID"));
				listaUsuario.setGrupoUsuario(grupoUsuario);

				listaTodosUsuariosAtivos.add(listaUsuario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA + "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaTodosUsuariosAtivos;
	}

	public List<Usuario> listarUsuarioPorNome(String nomeUsuario) {
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Usuario> listaUsuariosPorNome = new ArrayList<Usuario>();

		sql = "SELECT * FROM usuario INNER JOIN grupousuario ON usuario.grupousuarioID = grupousuario.grupousuarioID WHERE nomeusuario LIKE ? ";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeUsuario + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				Usuario listaUsuario = new Usuario();

				grupoUsuario.setNomeGrupoUsuario(rs.getString("nomegrupousuario"));
				
				listaUsuario.setUsuarioID(rs.getInt("usuarioID"));
				listaUsuario.setNome(rs.getString("nomeusuario"));
				listaUsuario.setEmail(rs.getString("emailusuario"));
				listaUsuario.setLogin(rs.getString("loginusuario"));
				listaUsuario.setSenha(rs.getString("senhausuario"));
				listaUsuario.setUsuarioAtivo(rs.getBoolean("usuarioativo"));
				listaUsuario.setGrupoUsuarioID(rs.getInt("grupousuarioID"));
				listaUsuario.setGrupoUsuario(grupoUsuario);

				listaUsuariosPorNome.add(listaUsuario);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA + "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaUsuariosPorNome;
	}

	public List<GrupoUsuario> listarTodosGruposUsuarios() {
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<GrupoUsuario> listaTodosGruposUsuarios = new ArrayList<GrupoUsuario>();

		sql = "SELECT * FROM grupousuario;";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GrupoUsuario listaItem = new GrupoUsuario();

				listaItem.setGrupoUsuarioID(rs.getInt("grupousuarioID"));
				listaItem.setNomeGrupoUsuario(rs.getString("nomegrupousuario"));

				listaTodosGruposUsuarios.add(listaItem);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA + "\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return listaTodosGruposUsuarios;
	}

	public int buscarCodigo(String nome) {

		String sql = "";
		int grupoUsuarioID = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "SELECT grupousuarioID FROM grupousuario WHERE nomegrupousuario = ?";

		try {
			conn = Conexao.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nome);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				grupoUsuarioID = rs.getInt("grupousuarioID");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Nome não encontrado!\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return grupoUsuarioID;
	}

	public String buscarNome(int grupoUsuarioID) {
		String sql = "", nomeGrupoUsuario = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "SELECT nomegrupousuario FROM grupousuario WHERE grupousuarioID = ?";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grupoUsuarioID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				nomeGrupoUsuario = rs.getString("nomegrupousuario");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Código não encontrado!\n" + e.getMessage());
		} finally {
			Conexao.closeConnection(conn, pstmt, rs);
		}

		return nomeGrupoUsuario;
	}
}
