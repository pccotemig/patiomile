package br.com.patiomile.teste;

import javax.swing.JOptionPane;

import br.com.patiomile.controle.CargoControle;
import br.com.patiomile.modelo.Cargo;

public class TestaCargo {

	public static void main(String[] args) {

		boolean r1 = false;
		boolean r2 = false;

		Cargo c1 = new Cargo();
		Cargo c2 = new Cargo();

		CargoControle cc = new CargoControle();

		c1.setNomeCargo("Teste1");
		r1 = cc.gravarRegistro(c1);

		if (r1) {
			JOptionPane
					.showMessageDialog(null, "Registro gravado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao gravar registro!");
		}

		c2.setCargoID(1);
		c2.setNomeCargo("Almoxarife Atualizado");
		r2 = cc.atualizarRegistro(c2);

		if (r2) {
			JOptionPane.showMessageDialog(null,
					"Registro atualizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
		}

	}

}
