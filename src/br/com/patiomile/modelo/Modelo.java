package br.com.patiomile.modelo;

public class Modelo {

	private int modeloID;
	private String nomeModelo;
	private int marcaID;

	private Marca marca;

	public int getModeloID() {
		return modeloID;
	}

	public void setModeloID(int modeloID) {
		this.modeloID = modeloID;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public int getMarcaID() {
		return marcaID;
	}

	public void setMarcaID(int marcaID) {
		this.marcaID = marcaID;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
