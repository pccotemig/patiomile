package br.com.patiomile.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.dao.CargoDAO;
import br.com.patiomile.modelo.Cargo;
import br.com.patiomile.utilitario.MensagensType;

public class CargoControle {

	public boolean gravarRegistro(Cargo cargo) {
		boolean retorno = false;

		if (validarObjeto(cargo)) {
			CargoDAO cargoDAO = new CargoDAO();
			retorno = cargoDAO.inserirRegistro(cargo);
		}
		return retorno;
	}

	public boolean atualizarRegistro(Cargo cargo) {
		boolean retorno = false;

		if (validarObjeto(cargo)) {
			CargoDAO cargoDAO = new CargoDAO();
			retorno = cargoDAO.atualizarRegistro(cargo);
		}
		return retorno;
	}

	public boolean excluirRegistro(int cargoID) {
		boolean retorno = false;

		if (cargoID != 0) {
			CargoDAO cargoDAO = new CargoDAO();
			retorno = cargoDAO.excluirRegistro(cargoID);
		}
		return retorno;
	}

	public List<Cargo> listarTodosCargos(Cargo cargo) {
		CargoDAO cargoDAO = new CargoDAO();

		List<Cargo> listaTodosCargos = new ArrayList<Cargo>();
		listaTodosCargos = cargoDAO.listarTodosCargos(cargo);

		if (!listaTodosCargos.isEmpty()) {
			return listaTodosCargos;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public List<Cargo> listarCargoPorNome(String nomeCargo) {
		CargoDAO cargoDAO = new CargoDAO();

		List<Cargo> listaCargo = new ArrayList<Cargo>();
		listaCargo = cargoDAO.listarCargoPorNome(nomeCargo);

		if (!listaCargo.isEmpty()) {
			return listaCargo;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public boolean validarObjeto(Cargo cargo) {
		boolean objetoValdo = false;

		if (!cargo.getNomeCargo().equals(null)) {
			objetoValdo = true;
		}

		return objetoValdo;
	}

}
