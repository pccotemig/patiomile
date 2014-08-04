package br.com.patiomile.teste;

import br.com.patiomile.controle.MarcaControle;
import br.com.patiomile.modelo.Marca;

public class TestaMarca {

	public static void main(String[] args) {
		
		Marca marca = new Marca();
		MarcaControle marcaControle = new MarcaControle();
		
		// Inserir
		marca.setNomeMarca("Teste Marca");
		marcaControle.gravarRegistro(marca);
		
		// Atualizar
		marca.setMarcaID(8);
		marca.setNomeMarca("Nome da Marca Alterado");
		marcaControle.atualizarRegistro(marca);
		
		// Excluir
		int marcaID = -1;
		marcaID = 8;		
		marcaControle.excluirRegistro(marcaID);

	}

}
