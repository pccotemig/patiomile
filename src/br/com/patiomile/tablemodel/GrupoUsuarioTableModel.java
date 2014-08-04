package br.com.patiomile.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.patiomile.modelo.GrupoUsuario;

public class GrupoUsuarioTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constantes representando o índice das colunas
	private static final int Codigo = 0;
	private static final int Nome = 1;

	// Lista de Sócios a serem exibidos na tabela
	private List<GrupoUsuario> linhas;

	// Cria um GrupoUsuarioTableModel sem nenhuma linha
	public GrupoUsuarioTableModel() {
		linhas = new ArrayList<GrupoUsuario>();
	}

	// Cria um GrupoUsuarioTabelModel contendo a lista recebida por parâmetro
	public GrupoUsuarioTableModel(List<GrupoUsuario> listaGrupoDeUsuario) {
		linhas = new ArrayList<GrupoUsuario>(listaGrupoDeUsuario);
	}

	// Array com os nomes das colunas.
	private String[] colunas = new String[] { "ID", "Grupo de Usuário" };

	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case Codigo:
			return String.class;
		case Nome:
			return String.class;
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o sócio referente a linha especificada.
		GrupoUsuario grupousuario = linhas.get(rowIndex);

		switch (columnIndex) {
		case Codigo:
			return grupousuario.getGrupoUsuarioID();
		case Nome:
			return grupousuario.getNomeGrupoUsuario();
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o sócio referente a linha especificada.
		GrupoUsuario grupousuario = linhas.get(rowIndex);

		switch (columnIndex) {
		case Codigo:
			grupousuario.setGrupoUsuarioID((int) aValue);
			break;
		case Nome:
			grupousuario.setNomeGrupoUsuario((String) aValue);
			break;
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização
														// da célula
	}

}
