package br.com.patiomile.modelo;

public class Usuario {

	private int usuarioID;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private boolean usuarioAtivo;
	private int grupoUsuarioID;

	private GrupoUsuario grupoUsuario;

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}

	public void setUsuarioAtivo(boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}

	public int getGrupoUsuarioID() {
		return grupoUsuarioID;
	}

	public void setGrupoUsuarioID(int grupoUsuarioID) {
		this.grupoUsuarioID = grupoUsuarioID;
	}

	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}

	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioID=" + usuarioID + ", nome=" + nome
				+ ", email=" + email + ", login=" + login + ", senha=" + senha
				+ ", usuarioAtivo=" + usuarioAtivo + ", grupoUsuarioID="
				+ grupoUsuarioID + ", grupoUsuario=" + grupoUsuario + "]";
	}

	public boolean validarObjeto(Usuario u) {
		boolean resp = false;

		if (u.getNome().isEmpty()) {
			resp = false;
		} else if (u.getEmail().isEmpty()) {
			resp = false;
		} else if (u.getLogin().isEmpty()) {
			resp = false;
		} else if (u.getSenha().isEmpty()) {
			resp = false;
		} else if (u.getGrupoUsuarioID() == 0) {
			resp = false;
		} else {
			resp = true;
		}

		return resp;
	}

}
