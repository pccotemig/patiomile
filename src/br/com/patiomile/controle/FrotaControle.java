package br.com.patiomile.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.patiomile.dao.FrotaDAO;
import br.com.patiomile.modelo.Frota;

public class FrotaControle {

	public void gravarRegistro(Frota frota) {
		
		FrotaDAO frotaDAO = new FrotaDAO();
		frotaDAO.inserirFrota(frota);
		
	}

	public void atualizarRegistro(Frota frota) {
		
		FrotaDAO frotaDAO = new FrotaDAO();
		frotaDAO.atualizarFrota(frota);
		
	}

	public void excluirRegistro(int frotaID) {
		
		FrotaDAO frotaDAO = new FrotaDAO();
		frotaDAO.excluirFrota(frotaID);
		
	}
	
	public List<Frota> listarTodaFrota(){
		
		FrotaDAO frotaDAO = new FrotaDAO();
		List<Frota> listaFrota = new ArrayList<Frota>();
		
		listaFrota = frotaDAO.listarTodosVeiculosFrota();
		
		return listaFrota;
		
	}
	
	public List<Frota> listarFrotaPorNome(String nomeMarca){
		
		FrotaDAO frotaDAO = new FrotaDAO();
		List<Frota> listaFrota = new ArrayList<Frota>();
		
		listaFrota = frotaDAO.listarVeiculosPorNomeMarca(nomeMarca);
		
		return listaFrota;
		
	}
	
	public List<Frota> listarFrotaPorNomeModelo(String nomeModelo){
		
		FrotaDAO frotaDAO = new FrotaDAO();
		List<Frota> listaFrotaPorModelo = new ArrayList<Frota>();
		
		listaFrotaPorModelo = frotaDAO.listarVeiculosPorNomeModelo(nomeModelo);
		
		return listaFrotaPorModelo;
	}

}
