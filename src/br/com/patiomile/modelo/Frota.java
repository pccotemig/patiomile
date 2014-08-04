package br.com.patiomile.modelo;


public class Frota {

	private int frotaID;
	private int marcaID;
	private int modeloID;
	private String placa;
	private String ano;

	private Marca marca;
	private Modelo modelo;

	public int getFrotaID() {
		return frotaID;
	}

	public void setFrotaID(int frotaID) {
		this.frotaID = frotaID;
	}

	public int getMarcaID() {
		return marcaID;
	}

	public void setMarcaID(int marcaID) {
		this.marcaID = marcaID;
	}

	public int getModeloID() {
		return modeloID;
	}

	public void setModeloID(int modeloID) {
		this.modeloID = modeloID;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Frota [frotaID=" + frotaID + ", marcaID=" + marcaID
				+ ", modeloID=" + modeloID + ", placa=" + placa + ", ano="
				+ ano + "]";
	}

}
