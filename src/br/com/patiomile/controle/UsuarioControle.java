package br.com.patiomile.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.dao.UsuarioDAO;
import br.com.patiomile.modelo.GrupoUsuario;
import br.com.patiomile.modelo.Usuario;
import br.com.patiomile.utilitario.MensagensType;

public class UsuarioControle {

	public boolean autenticarUsuario(String strLogin, String strSenha) {
		boolean autenticado = false;

		if (strLogin.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					MensagensType.CAMPONOMEUSUARIOVAZIO);
		} else if (strSenha.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					MensagensType.CAMPOSENHAUSUARIOVAZIO);
		} else {
			UsuarioDAO usuario = new UsuarioDAO();
			autenticado = usuario.autenticarUsuario(strLogin, strSenha);
		}

		return autenticado;
	}

	public boolean inserirUsuario(Usuario usuario) {
		boolean inserido = false;

		if (validarCampos(usuario)) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			inserido = usuarioDAO.inserirUsuario(usuario);
		}

		return inserido;
	}

	public boolean atualizarUsuario(Usuario usuario) {
		boolean atualizado = false;

		if (validarCampos(usuario)) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			atualizado = usuarioDAO.atualizarUsuario(usuario);
		}

		return atualizado;
	}

	public boolean excluirUsuario(int usuarioID) {
		boolean excluido = false;

		if (usuarioID != 0) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			excluido = usuarioDAO.excluirUsuario(usuarioID);
		}

		return excluido;
	}

	public List<Usuario> listarTodosUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();
		listaTodosUsuarios = usuarioDAO.listarTodosUsuario();

		if (!listaTodosUsuarios.isEmpty()) {
			return listaTodosUsuarios;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public List<Usuario> listarTodosUsuariosAtivos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> listaTodosUsuariosAtivos = new ArrayList<Usuario>();
		listaTodosUsuariosAtivos = usuarioDAO.listarTodosUsuariosAtivos();

		if (!listaTodosUsuariosAtivos.isEmpty()) {
			return listaTodosUsuariosAtivos;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public List<Usuario> listarUsuarioPorNome(String nomeUsuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = usuarioDAO.listarUsuarioPorNome(nomeUsuario);

		if (!listaUsuarios.isEmpty()) {
			return listaUsuarios;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public List<GrupoUsuario> listarTodosGruposUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<GrupoUsuario> listaGruposUsuarios = new ArrayList<GrupoUsuario>();
		listaGruposUsuarios = usuarioDAO.listarTodosGruposUsuarios();

		if (!listaGruposUsuarios.isEmpty()) {
			return listaGruposUsuarios;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public int buscarCodigo(String nome) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarCodigo(nome);
	}

	public String buscarNome(int cursoID) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarNome(cursoID);
	}

	public boolean validarCampos(Usuario usuario) {
		boolean retorno = false;

		if (usuario.getNome().isEmpty()) {
			retorno = false;
		} else if (usuario.getLogin().isEmpty()) {
			retorno = false;
		} else if (usuario.getSenha().isEmpty()) {
			retorno = false;
		} else {
			retorno = true;
		}

		return retorno;
	}

}
