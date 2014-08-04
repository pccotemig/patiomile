package br.com.patiomile.modelo;

import java.util.List;

public class Funcionario {

	private int departamentoID;
	private int cargoID;
	private int grupoUsuarioID;

	List<Departamento> listaDepartamentos;
	List<Cargo> listaCargos;
	List<GrupoUsuario> listaGruposUsuarios;

	public int getDepartamentoID() {
		return departamentoID;
	}

	public void setDepartamentoID(int departamentoID) {
		this.departamentoID = departamentoID;
	}

	public int getCargoID() {
		return cargoID;
	}

	public void setCargoID(int cargoID) {
		this.cargoID = cargoID;
	}

	public int getGrupoUsuarioID() {
		return grupoUsuarioID;
	}

	public void setGrupoUsuarioID(int grupoUsuarioID) {
		this.grupoUsuarioID = grupoUsuarioID;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public List<GrupoUsuario> getListaGruposUsuarios() {
		return listaGruposUsuarios;
	}

	public void setListaGruposUsuarios(List<GrupoUsuario> listaGruposUsuarios) {
		this.listaGruposUsuarios = listaGruposUsuarios;
	}

}
