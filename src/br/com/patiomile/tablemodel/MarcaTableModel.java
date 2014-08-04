/**
 * 
 */
package br.com.patiomile.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.patiomile.modelo.Marca;

/**
 * @author Paulo Silva - Local
 * 
 */
public class MarcaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Marca> dados;
	private String[] colunas = { "ID", "Nome da Marca" };

	public MarcaTableModel() {
		dados = new ArrayList<Marca>();
	}

	public Marca get(int linha) {
		return this.dados.get(linha);
	}

	public void addRow(Marca m) {
		this.dados.add(m);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.dados.size();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return this.dados.get(linha).getMarcaID();
		case 1:
			return this.dados.get(linha).getNomeMarca();

		}
		return null;
	}

	public void setValuObject(Object valor, int linha, int coluna) {
		if (valor == null)
			return;

		switch (coluna) {
		case 0:
			dados.get(linha).setMarcaID((int) valor);
			break;
		case 1:
			dados.get(linha).setNomeMarca((String) valor);
			break;
		}

		// avisa que os dados mudaram
		fireTableRowsUpdated(linha, linha);
	}

	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}

}
