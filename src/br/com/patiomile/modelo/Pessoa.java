package br.com.patiomile.modelo;

import java.util.List;

public abstract class Pessoa {

	private int pessoaID;
	private String nome;
	private int tipoPessoaID;

	private String email;
	private String telefone;
	private String celular;

	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private int estadoID;
	private String cep;

	private String logradourocobranca;
	private String complementocobranca;
	private String bairrocobranca;
	private String cidadecobranca;
	private int estadoIDcobranca;
	private String cepcobranca;

	private String logradourocomercial;
	private String complementocomercial;
	private String bairrocomercial;
	private String cidadecomercial;
	private int estadoIDcomercial;
	private String cepcomercial;

	private int limiteCredito;
	private String nomeContato;
	private String emailContato;
	private String telefoneContato;
	private String celularContato;
	private String observacao;

	List<TipoPessoa> listaTipoPessoa;
	List<Estado> listaEstados;

	public int getPessoaID() {
		return pessoaID;
	}

	public void setPessoaID(int pessoaID) {
		this.pessoaID = pessoaID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoPessoaID() {
		return tipoPessoaID;
	}

	public void setTipoPessoaID(int tipoPessoaID) {
		this.tipoPessoaID = tipoPessoaID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradourocobranca() {
		return logradourocobranca;
	}

	public void setLogradourocobranca(String logradourocobranca) {
		this.logradourocobranca = logradourocobranca;
	}

	public String getComplementocobranca() {
		return complementocobranca;
	}

	public void setComplementocobranca(String complementocobranca) {
		this.complementocobranca = complementocobranca;
	}

	public String getBairrocobranca() {
		return bairrocobranca;
	}

	public void setBairrocobranca(String bairrocobranca) {
		this.bairrocobranca = bairrocobranca;
	}

	public String getCidadecobranca() {
		return cidadecobranca;
	}

	public void setCidadecobranca(String cidadecobranca) {
		this.cidadecobranca = cidadecobranca;
	}

	public int getEstadoIDcobranca() {
		return estadoIDcobranca;
	}

	public void setEstadoIDcobranca(int estadoIDcobranca) {
		this.estadoIDcobranca = estadoIDcobranca;
	}

	public String getCepcobranca() {
		return cepcobranca;
	}

	public void setCepcobranca(String cepcobranca) {
		this.cepcobranca = cepcobranca;
	}

	public String getLogradourocomercial() {
		return logradourocomercial;
	}

	public void setLogradourocomercial(String logradourocomercial) {
		this.logradourocomercial = logradourocomercial;
	}

	public String getComplementocomercial() {
		return complementocomercial;
	}

	public void setComplementocomercial(String complementocomercial) {
		this.complementocomercial = complementocomercial;
	}

	public String getBairrocomercial() {
		return bairrocomercial;
	}

	public void setBairrocomercial(String bairrocomercial) {
		this.bairrocomercial = bairrocomercial;
	}

	public String getCidadecomercial() {
		return cidadecomercial;
	}

	public void setCidadecomercial(String cidadecomercial) {
		this.cidadecomercial = cidadecomercial;
	}

	public int getEstadoIDcomercial() {
		return estadoIDcomercial;
	}

	public void setEstadoIDcomercial(int estadoIDcomercial) {
		this.estadoIDcomercial = estadoIDcomercial;
	}

	public String getCepcomercial() {
		return cepcomercial;
	}

	public void setCepcomercial(String cepcomercial) {
		this.cepcomercial = cepcomercial;
	}

	public int getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(int limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getCelularContato() {
		return celularContato;
	}

	public void setCelularContato(String celularContato) {
		this.celularContato = celularContato;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<TipoPessoa> getListaTipoPessoa() {
		return listaTipoPessoa;
	}

	public void setListaTipoPessoa(List<TipoPessoa> listaTipoPessoa) {
		this.listaTipoPessoa = listaTipoPessoa;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

}
