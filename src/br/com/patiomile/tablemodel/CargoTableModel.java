package br.com.patiomile.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.patiomile.modelo.Cargo;

public class CargoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Cargo> dados;
	private String[] colunas = { "ID", "Nome do Cargo" };

	public CargoTableModel() {
		dados = new ArrayList<Cargo>();
	}

	public void addRow(Cargo c) {
		this.dados.add(c);
		this.fireTableDataChanged();
	}

	/* Retorna o nome da coluna no índice especificado. 
     * Este método é usado pela JTable para saber o texto do cabeçalho. */  
    @Override  
	public String getColumnName(int num) {
    	// Retorna o conteúdo do Array que possui o nome das colunas  
        // no índice especificado.
		return this.colunas[num];
	}

	public int getRowCount() {
		return dados.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Cargo get(int linha) {
		return this.dados.get(linha);
	}

	// As células não vai ser editáveis 
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}

	public void setValueAt(Object valor, int linha, int coluna) {
		if (valor == null)
			return;

		//verifica qual valor vai ser alterado 
		switch (coluna) {
		case 0:
			dados.get(linha).setCargoID((int) valor);
			break;
		case 1:
			dados.get(linha).setNomeCargo((String) valor);
			break;
		}
		//avisa que os dados mudaram
		this.fireTableRowsUpdated(linha, linha);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getCargoID();
		case 1:
			return dados.get(linha).getNomeCargo();
		}
		return null;
	}
	
	
}
