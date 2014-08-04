package br.com.patiomile.modelo;

import java.util.Date;

public class Reboquista extends PessoaFisica {

	private String cnh;
	private int categoriCnh;
	private Date dataVencimentoCnh;

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public int getCategoriCnh() {
		return categoriCnh;
	}

	public void setCategoriCnh(int categoriCnh) {
		this.categoriCnh = categoriCnh;
	}

	public Date getDataVencimentoCnh() {
		return dataVencimentoCnh;
	}

	public void setDataVencimentoCnh(Date dataVencimentoCnh) {
		this.dataVencimentoCnh = dataVencimentoCnh;
	}

}
