package br.com.patiomile.modelo;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class ApreensaoVeiculo {

	private int apreensaoVeiculoID;
	private String placa;
	private int estadoID;
	private int marcaID;
	private int modeloID;
	private String anoFabricacao;
	private String anoModelo;
	private String cor;
	private String renavam;
	private int especieVeiculoID;
	private String chassi;
	private int tipoVeiculoID;
	private Date dataRecepcao;
	private Time horaRecepcao;
	private String rva;
	private Date dataBoletimOcorrencia;
	private Time horaBoletimOcorrencia;
	private String numeroBoletimOcorrencia;
	private String objetosPessoais;
	private String avarias;
	private int formaremocaoID;
	private String motivo;
	private String kmReboque;
	private String municipio;
	private int reboquistaID;
	private int frotaID;
	private String policialResp;
	private String cargoPolicial;
	private String matriculaPolicial;

	List<Estado> listaEstados;
	List<Marca> listaMarcas;
	List<Modelo> listaModelos;
	List<EspecieVeiculo> listaEspecieVeiculos;
	List<TipoVeiculo> listaTiposVeiculos;
	List<FormaRemocao> listaFormasRemocao;
	List<Reboquista> listaReboquistas;
	List<Frota> listaFrota;

	public int getApreensaoVeiculoID() {
		return apreensaoVeiculoID;
	}

	public void setApreensaoVeiculoID(int apreensaoVeiculoID) {
		this.apreensaoVeiculoID = apreensaoVeiculoID;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
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

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public int getEspecieVeiculoID() {
		return especieVeiculoID;
	}

	public void setEspecieVeiculoID(int especieVeiculoID) {
		this.especieVeiculoID = especieVeiculoID;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public int getTipoVeiculoID() {
		return tipoVeiculoID;
	}

	public void setTipoVeiculoID(int tipoVeiculoID) {
		this.tipoVeiculoID = tipoVeiculoID;
	}

	public Date getDataRecepcao() {
		return dataRecepcao;
	}

	public void setDataRecepcao(Date dataRecepcao) {
		this.dataRecepcao = dataRecepcao;
	}

	public Time getHoraRecepcao() {
		return horaRecepcao;
	}

	public void setHoraRecepcao(Time horaRecepcao) {
		this.horaRecepcao = horaRecepcao;
	}

	public String getRva() {
		return rva;
	}

	public void setRva(String rva) {
		this.rva = rva;
	}

	public Date getDataBoletimOcorrencia() {
		return dataBoletimOcorrencia;
	}

	public void setDataBoletimOcorrencia(Date dataBoletimOcorrencia) {
		this.dataBoletimOcorrencia = dataBoletimOcorrencia;
	}

	public Time getHoraBoletimOcorrencia() {
		return horaBoletimOcorrencia;
	}

	public void setHoraBoletimOcorrencia(Time horaBoletimOcorrencia) {
		this.horaBoletimOcorrencia = horaBoletimOcorrencia;
	}

	public String getNumeroBoletimOcorrencia() {
		return numeroBoletimOcorrencia;
	}

	public void setNumeroBoletimOcorrencia(String numeroBoletimOcorrencia) {
		this.numeroBoletimOcorrencia = numeroBoletimOcorrencia;
	}

	public String getObjetosPessoais() {
		return objetosPessoais;
	}

	public void setObjetosPessoais(String objetosPessoais) {
		this.objetosPessoais = objetosPessoais;
	}

	public String getAvarias() {
		return avarias;
	}

	public void setAvarias(String avarias) {
		this.avarias = avarias;
	}

	public int getFormaremocaoID() {
		return formaremocaoID;
	}

	public void setFormaremocaoID(int formaremocaoID) {
		this.formaremocaoID = formaremocaoID;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getKmReboque() {
		return kmReboque;
	}

	public void setKmReboque(String kmReboque) {
		this.kmReboque = kmReboque;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getReboquistaID() {
		return reboquistaID;
	}

	public void setReboquistaID(int reboquistaID) {
		this.reboquistaID = reboquistaID;
	}

	public int getFrotaID() {
		return frotaID;
	}

	public void setFrotaID(int frotaID) {
		this.frotaID = frotaID;
	}

	public String getPolicialResp() {
		return policialResp;
	}

	public void setPolicialResp(String policialResp) {
		this.policialResp = policialResp;
	}

	public String getCargoPolicial() {
		return cargoPolicial;
	}

	public void setCargoPolicial(String cargoPolicial) {
		this.cargoPolicial = cargoPolicial;
	}

	public String getMatriculaPolicial() {
		return matriculaPolicial;
	}

	public void setMatriculaPolicial(String matriculaPolicial) {
		this.matriculaPolicial = matriculaPolicial;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public List<EspecieVeiculo> getListaEspecieVeiculos() {
		return listaEspecieVeiculos;
	}

	public void setListaEspecieVeiculos(
			List<EspecieVeiculo> listaEspecieVeiculos) {
		this.listaEspecieVeiculos = listaEspecieVeiculos;
	}

	public List<TipoVeiculo> getListaTiposVeiculos() {
		return listaTiposVeiculos;
	}

	public void setListaTiposVeiculos(List<TipoVeiculo> listaTiposVeiculos) {
		this.listaTiposVeiculos = listaTiposVeiculos;
	}

	public List<FormaRemocao> getListaFormasRemocao() {
		return listaFormasRemocao;
	}

	public void setListaFormasRemocao(List<FormaRemocao> listaFormasRemocao) {
		this.listaFormasRemocao = listaFormasRemocao;
	}

	public List<Reboquista> getListaReboquistas() {
		return listaReboquistas;
	}

	public void setListaReboquistas(List<Reboquista> listaReboquistas) {
		this.listaReboquistas = listaReboquistas;
	}

	public List<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(List<Frota> listaFrota) {
		this.listaFrota = listaFrota;
	}

}
