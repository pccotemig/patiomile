package br.com.patiomile.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.dao.ModeloDAO;
import br.com.patiomile.modelo.Modelo;

public class ModeloControle {

	public void inserirModelo(Modelo modelo) {
	}

	public void atualizarModelo(Modelo modelo) {
	}

	public void excluirModelo(int modeloID) {
	}

	public List<Modelo> listarTodosModelos() {

		ModeloDAO modeloDAO = new ModeloDAO();
		List<Modelo> listaModelo = new ArrayList<Modelo>();

		listaModelo = modeloDAO.listarTodosModelos();

		return listaModelo;

	}

	public List<Modelo> listarModeloPorNome(String nomeModelo) {

		ModeloDAO modeloDAO = new ModeloDAO();
		List<Modelo> listaModelo = new ArrayList<Modelo>();

		listaModelo = modeloDAO.listarModelosPorNome(nomeModelo);

		return listaModelo;

	}

	public int ObterCodigoMarca(String nomeMarca) {

		int marcaID = -1;
		ModeloDAO modeloDAO = new ModeloDAO();

		if (!nomeMarca.equals(null)) {
			marcaID = modeloDAO.ObterCodigoMarca(nomeMarca);
		} else {
			JOptionPane.showMessageDialog(null, "Selecione o combo Marca!");
		}
		
		return marcaID;

	}

}
