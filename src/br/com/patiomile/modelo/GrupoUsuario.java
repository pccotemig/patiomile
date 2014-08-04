package br.com.patiomile.modelo;

public class GrupoUsuario {

	private int grupoUsuarioID;
	private String nomeGrupoUsuario;

	public int getGrupoUsuarioID() {
		return grupoUsuarioID;
	}

	public void setGrupoUsuarioID(int grupoUsuarioID) {
		this.grupoUsuarioID = grupoUsuarioID;
	}

	public String getNomeGrupoUsuario() {
		return nomeGrupoUsuario;
	}

	public void setNomeGrupoUsuario(String nomeGrupoUsuario) {
		this.nomeGrupoUsuario = nomeGrupoUsuario;
	}

	@Override
	public String toString() {
		return "GrupoUsuario [grupoUsuarioID=" + grupoUsuarioID
				+ ", nomeGrupoUsuario=" + nomeGrupoUsuario + "]";
	}

	public boolean validarObjeto(GrupoUsuario gp) {

		boolean resp = false;

		if (gp.getNomeGrupoUsuario().isEmpty()) {
			resp = false;
		} else {
			resp = true;
		}

		return resp;
	}

}
