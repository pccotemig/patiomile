package br.com.patiomile.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.dao.MarcaDAO;
import br.com.patiomile.modelo.Marca;
import br.com.patiomile.utilitario.MensagensType;

public class MarcaControle {

	public boolean gravarRegistro(Marca marca) {
		boolean inserido = false;
		MarcaDAO marcaDAO = new MarcaDAO();

		if (validarObjeto(marca)) {
			inserido = marcaDAO.inserirMarca(marca);
		}

		return inserido;
	}

	public boolean atualizarRegistro(Marca marca) {
		boolean autalizado = false;
		MarcaDAO marcaDAO = new MarcaDAO();

		if (validarObjeto(marca)) {
			autalizado = marcaDAO.atualizarMarca(marca);
		}

		return autalizado;
	}

	public boolean excluirRegistro(int marcaID) {
		boolean excluido = false;
		MarcaDAO marcaDAO = new MarcaDAO();

		if (marcaID != 0) {
			excluido = marcaDAO.excluirMarca(marcaID);
		}
		return excluido;
	}

	public List<Marca> listarTodasMarcas() {
		MarcaDAO marcaDAO = new MarcaDAO();

		List<Marca> listaMarca = new ArrayList<Marca>();
		listaMarca = marcaDAO.listarTodasMarcas();

		if (!listaMarca.isEmpty()) {
			return listaMarca;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public List<Marca> listarMarcasPorNome(String nomeMarca) {
		MarcaDAO marcaDAO = new MarcaDAO();

		List<Marca> listaMarca = new ArrayList<Marca>();
		listaMarca = marcaDAO.listarMarcasPorNome(nomeMarca);

		if (!listaMarca.isEmpty()) {
			return listaMarca;
		} else {
			JOptionPane.showMessageDialog(null,
					MensagensType.ERROAOPREENCHERLISTA);
			return null;
		}
	}

	public boolean validarObjeto(Marca marca) {
		boolean valido = false;
		if (!marca.equals(null) || !marca.equals("")) {
			valido = true;
		}
		return valido;
	}
}
