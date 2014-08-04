package br.com.patiomile.modelo;

public class PessoaJuridica extends Pessoa {

	private String razaoSocial;
	private String cnpj;
	private String ie;
	private boolean ieIsento;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public boolean isIeIsento() {
		return ieIsento;
	}

	public void setIeIsento(boolean ieIsento) {
		this.ieIsento = ieIsento;
	}

}
