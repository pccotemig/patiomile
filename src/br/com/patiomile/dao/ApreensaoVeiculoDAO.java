package br.com.patiomile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.patiomile.modelo.ApreensaoVeiculo;
import br.com.patiomile.modelo.EspecieVeiculo;
import br.com.patiomile.modelo.Estado;
import br.com.patiomile.modelo.FormaRemocao;
import br.com.patiomile.modelo.Frota;
import br.com.patiomile.modelo.Marca;
import br.com.patiomile.modelo.Modelo;
import br.com.patiomile.modelo.Reboquista;
import br.com.patiomile.modelo.TipoVeiculo;
import br.com.patiomile.utilitario.Conexao;

public class ApreensaoVeiculoDAO {

	public boolean gravarRegistro(ApreensaoVeiculo apreensaoVeiculo) {

		boolean retorno = false;
		String sql = "";
		int cont = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "INSERT INTO apreensaoveiculo ( placa, estadoID, marcaID, modeloID, anoFabricacao, anoModelo, cor, renavam, especieVeiculoID, chassi, tipoVeiculoID, dataRecepcao, horaRecepcao, rva, dataBoletimOcorrencia, horaBoletimOcorrencia, numeroBoletimOcorrencia, objetosPessoais, avarias, formaremocaoID, motivo, kmReboque, municipio, reboquistaID, frotaID, policialResp, cargoPolicial, matriculaPolicial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(cont++, apreensaoVeiculo.getPlaca());
			pstmt.setInt(cont++, apreensaoVeiculo.getEstadoID());
			pstmt.setInt(cont++, apreensaoVeiculo.getMarcaID());
			pstmt.setInt(cont++, apreensaoVeiculo.getModeloID());
			pstmt.setString(cont++, apreensaoVeiculo.getAnoFabricacao());
			pstmt.setString(cont++, apreensaoVeiculo.getAnoModelo());
			pstmt.setString(cont++, apreensaoVeiculo.getCor());
			pstmt.setString(cont++, apreensaoVeiculo.getRenavam());
			pstmt.setInt(cont++, apreensaoVeiculo.getEspecieVeiculoID());
			pstmt.setString(cont++, apreensaoVeiculo.getChassi());
			pstmt.setInt(cont++, apreensaoVeiculo.getTipoVeiculoID());
			pstmt.setDate(cont++, (Date) apreensaoVeiculo.getDataRecepcao());
			pstmt.setTime(cont++, apreensaoVeiculo.getHoraRecepcao());
			pstmt.setString(cont++, apreensaoVeiculo.getRva());
			pstmt.setDate(cont++,
					(Date) apreensaoVeiculo.getDataBoletimOcorrencia());
			pstmt.setTime(cont++, apreensaoVeiculo.getHoraBoletimOcorrencia());
			pstmt.setString(cont++,
					apreensaoVeiculo.getNumeroBoletimOcorrencia());
			pstmt.setString(cont++, apreensaoVeiculo.getObjetosPessoais());
			pstmt.setString(cont++, apreensaoVeiculo.getAvarias());
			pstmt.setInt(cont++, apreensaoVeiculo.getFormaremocaoID());
			pstmt.setString(cont++, apreensaoVeiculo.getMotivo());
			pstmt.setString(cont++, apreensaoVeiculo.getKmReboque());
			pstmt.setString(cont++, apreensaoVeiculo.getMunicipio());
			pstmt.setInt(cont++, apreensaoVeiculo.getReboquistaID());
			pstmt.setInt(cont++, apreensaoVeiculo.getFrotaID());
			pstmt.setString(cont++, apreensaoVeiculo.getPolicialResp());
			pstmt.setString(cont++, apreensaoVeiculo.getCargoPolicial());
			pstmt.setString(cont++, apreensaoVeiculo.getMatriculaPolicial());

			pstmt.execute();

			pstmt.close();
			conn.close();

			retorno = true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir apreensao de veiculo!\n" + e.getMessage());
		}

		return retorno;
	}

	public boolean atualizarRegistro(ApreensaoVeiculo apreensaoVeiculo) {

		boolean retorno = false;
		String sql = "";
		int cont = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "UPDATE apreensaoveiculo SET placa = ?, estadoID = ?, marcaID = ?, modeloID = ?, anoFabricacao = ?, anoModelo = ?, cor = ?, renavam = ?, especieVeiculoID = ?, chassi = ?, tipoVeiculoID = ?, dataRecepcao = ?, horaRecepcao = ?, rva = ?, dataBoletimOcorrencia = ?, horaBoletimOcorrencia = ?, numeroBoletimOcorrencia = ?, objetosPessoais = ?, avarias = ?, formaremocaoID = ?, motivo = ?, kmReboque = ?, municipio = ?, reboquistaID = ?, frotaID = ?, policialResp = ?, cargoPolicial = ?, matriculaPolicial = ? WHERE apreensaoveiculoID = ?";

		try {

			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, apreensaoVeiculo.getApreensaoVeiculoID());

			pstmt.setString(cont++, apreensaoVeiculo.getPlaca());
			pstmt.setInt(cont++, apreensaoVeiculo.getEstadoID());
			pstmt.setInt(cont++, apreensaoVeiculo.getMarcaID());
			pstmt.setInt(cont++, apreensaoVeiculo.getModeloID());
			pstmt.setString(cont++, apreensaoVeiculo.getAnoFabricacao());
			pstmt.setString(cont++, apreensaoVeiculo.getAnoModelo());
			pstmt.setString(cont++, apreensaoVeiculo.getCor());
			pstmt.setString(cont++, apreensaoVeiculo.getRenavam());
			pstmt.setInt(cont++, apreensaoVeiculo.getEspecieVeiculoID());
			pstmt.setString(cont++, apreensaoVeiculo.getChassi());
			pstmt.setInt(cont++, apreensaoVeiculo.getTipoVeiculoID());
			pstmt.setDate(cont++, (Date) apreensaoVeiculo.getDataRecepcao());
			pstmt.setTime(cont++, apreensaoVeiculo.getHoraRecepcao());
			pstmt.setString(cont++, apreensaoVeiculo.getRva());
			pstmt.setDate(cont++,
					(Date) apreensaoVeiculo.getDataBoletimOcorrencia());
			pstmt.setTime(cont++, apreensaoVeiculo.getHoraBoletimOcorrencia());
			pstmt.setString(cont++,
					apreensaoVeiculo.getNumeroBoletimOcorrencia());
			pstmt.setString(cont++, apreensaoVeiculo.getObjetosPessoais());
			pstmt.setString(cont++, apreensaoVeiculo.getAvarias());
			pstmt.setInt(cont++, apreensaoVeiculo.getFormaremocaoID());
			pstmt.setString(cont++, apreensaoVeiculo.getMotivo());
			pstmt.setString(cont++, apreensaoVeiculo.getKmReboque());
			pstmt.setString(cont++, apreensaoVeiculo.getMunicipio());
			pstmt.setInt(cont++, apreensaoVeiculo.getReboquistaID());
			pstmt.setInt(cont++, apreensaoVeiculo.getFrotaID());
			pstmt.setString(cont++, apreensaoVeiculo.getPolicialResp());
			pstmt.setString(cont++, apreensaoVeiculo.getCargoPolicial());
			pstmt.setString(cont++, apreensaoVeiculo.getMatriculaPolicial());

			pstmt.execute();

			pstmt.close();
			conn.close();

			retorno = true;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Erro ao atualizar apreensao de veiculo!\n"
							+ e.getMessage());
		}

		return retorno;
	}

	public boolean excluirRegistro(int apreensaoVeiculoID) {

		boolean retorno = false;
		String sql = "";
		int excluir;
		Connection conn = null;
		PreparedStatement pstmt = null;

		sql = "DELETE FROM apreensaoveiculo WHERE apreensaoveiculoID = ?";

		try {

			excluir = JOptionPane
					.showConfirmDialog(
							null,
							"Tem certeza que deseja excluir o registro de Apreensao de Veiculos?",
							"Confirma Excluir", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

			if (excluir == JOptionPane.YES_OPTION) {

				conn = Conexao.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, apreensaoVeiculoID);

				pstmt.executeQuery();

				conn.close();
				pstmt.close();
				conn.close();

				retorno = true;

			} else if (excluir == JOptionPane.NO_OPTION) {
				retorno = false;
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario. \n"
					+ e.getMessage());

		}

		return retorno;

	}

	public List<ApreensaoVeiculo> listarTodasApreensoesVeiculos() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ApreensaoVeiculo> listaCompleta = new ArrayList<ApreensaoVeiculo>();

		sql = "SELECT * FROM apreensaoveiculo";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ApreensaoVeiculo listaItem = new ApreensaoVeiculo();

				listaItem
						.setApreensaoVeiculoID(rs.getInt("apreensaoveiculoID"));
				listaItem.setPlaca(rs.getString("placa"));
				listaItem.setEstadoID(rs.getInt("estadoID"));
				listaItem.setMarcaID(rs.getInt("marcaID"));
				listaItem.setModeloID(rs.getInt("modeloID"));
				listaItem.setAnoFabricacao(rs.getString("anofabricacao"));
				listaItem.setAnoModelo(rs.getString("anomodelo"));
				listaItem.setCor(rs.getString("cor"));
				listaItem.setRenavam(rs.getString("renavam"));
				listaItem.setEspecieVeiculoID(rs.getInt("especieveiculoID"));
				listaItem.setChassi(rs.getString("chassi"));
				listaItem.setTipoVeiculoID(rs.getInt("tipoveiculoID"));
				listaItem.setDataRecepcao(rs.getDate("datarecepcao"));
				listaItem.setHoraRecepcao(rs.getTime("horarecepcao"));
				listaItem.setNumeroBoletimOcorrencia(rs.getString("numerobo"));
				listaItem.setObjetosPessoais(rs.getString("objetospessoais"));
				listaItem.setAvarias(rs.getString("avarias"));
				listaItem.setFormaremocaoID(rs.getInt("formaremocaoID"));
				listaItem.setMotivo(rs.getString("motivo"));
				listaItem.setKmReboque(rs.getString("kmreboque"));
				listaItem.setMunicipio(rs.getString("municipio"));
				listaItem.setReboquistaID(rs.getInt("pessoaID"));
				listaItem.setFrotaID(rs.getInt("frotaID"));
				listaItem.setPolicialResp(rs.getString("policialresp"));
				listaItem.setCargoPolicial(rs.getString("cargopolicial"));
				listaItem.setMatriculaPolicial(rs
						.getString("matriculapolicial"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de apreensoes de veiculos!\n"
							+ e.getMessage());
		}

		return listaCompleta;

	}

	public List<ApreensaoVeiculo> listarApreensaoVeiculoPorCodigo(
			int apreensaoVeiculoID) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ApreensaoVeiculo> listaCompleta = new ArrayList<ApreensaoVeiculo>();

		sql = "SELECT * FROM apreensaoveiculo WHERE apreensaoveiculo LIKE ?";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, apreensaoVeiculoID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ApreensaoVeiculo listaItem = new ApreensaoVeiculo();

				listaItem
						.setApreensaoVeiculoID(rs.getInt("apreensaoveiculoID"));
				listaItem.setPlaca(rs.getString("placa"));
				listaItem.setEstadoID(rs.getInt("estadoID"));
				listaItem.setMarcaID(rs.getInt("marcaID"));
				listaItem.setModeloID(rs.getInt("modeloID"));
				listaItem.setAnoFabricacao(rs.getString("anofabricacao"));
				listaItem.setAnoModelo(rs.getString("anomodelo"));
				listaItem.setCor(rs.getString("cor"));
				listaItem.setRenavam(rs.getString("renavam"));
				listaItem.setEspecieVeiculoID(rs.getInt("especieveiculoID"));
				listaItem.setChassi(rs.getString("chassi"));
				listaItem.setTipoVeiculoID(rs.getInt("tipoveiculoID"));
				listaItem.setDataRecepcao(rs.getDate("datarecepcao"));
				listaItem.setHoraRecepcao(rs.getTime("horarecepcao"));
				listaItem.setNumeroBoletimOcorrencia(rs.getString("numerobo"));
				listaItem.setObjetosPessoais(rs.getString("objetospessoais"));
				listaItem.setAvarias(rs.getString("avarias"));
				listaItem.setFormaremocaoID(rs.getInt("formaremocaoID"));
				listaItem.setMotivo(rs.getString("motivo"));
				listaItem.setKmReboque(rs.getString("kmreboque"));
				listaItem.setMunicipio(rs.getString("municipio"));
				listaItem.setReboquistaID(rs.getInt("pessoaID"));
				listaItem.setFrotaID(rs.getInt("frotaID"));
				listaItem.setPolicialResp(rs.getString("policialresp"));
				listaItem.setCargoPolicial(rs.getString("cargopolicial"));
				listaItem.setMatriculaPolicial(rs
						.getString("matriculapolicial"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de marcas!\n" + e.getMessage());
		}

		return listaCompleta;

	}

	public List<Estado> listarTodosEstados() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Estado> listaCompleta = new ArrayList<Estado>();

		sql = "SELECT * FROM estado";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Estado listaItem = new Estado();

				listaItem.setEstadoID(rs.getInt("estadoID"));
				listaItem.setNomeEstado(rs.getString("nomeestado"));
				listaItem.setSiglaEstado(rs.getString("siglaestado"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de estados!\n" + e.getMessage());
		}

		return listaCompleta;

	}

	public List<Marca> listarTodasMarcas() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Marca> listaCompleta = new ArrayList<Marca>();

		sql = "SELECT * FROM marca";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Marca listaItem = new Marca();

				listaItem.setMarcaID(rs.getInt("marcaID"));
				listaItem.setNomeMarca(rs.getString("nomemarca"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de marcas!\n" + e.getMessage());
		}

		return listaCompleta;

	}

	public List<Modelo> listarTodosModelosPorMarca(int marcaID) {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Modelo> listaCompleta = new ArrayList<Modelo>();

		sql = "SELECT * FROM modelo WHERE marcaID = ?";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, marcaID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Modelo listaItem = new Modelo();

				listaItem.setModeloID(rs.getInt("modeloID"));
				listaItem.setNomeModelo(rs.getString("nomemodelo"));
				listaItem.setMarcaID(rs.getInt("marcaID"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Erro ao preencher a lista dos modelos!\n"
									+ e.getMessage());
		}

		return listaCompleta;

	}

	public List<EspecieVeiculo> listarTodasEspecieVeiculo() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<EspecieVeiculo> listaCompleta = new ArrayList<EspecieVeiculo>();

		sql = "SELECT * FROM especieveiculo";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EspecieVeiculo listaItem = new EspecieVeiculo();

				listaItem.setEspecieVeiculoID(rs.getInt("especieveiculoID"));
				listaItem.setNomeEspecieVeiculo(rs
						.getString("nomeespecieveiculo"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Erro ao preencher a lista de especie veiculo!\n"
							+ e.getMessage());
		}

		return listaCompleta;

	}

	public List<FormaRemocao> listarTodasFormasRemocao() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<FormaRemocao> listaCompleta = new ArrayList<FormaRemocao>();

		sql = "SELECT * FROM formaremocao";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FormaRemocao listaItem = new FormaRemocao();

				listaItem.setFormaRemocaoID(rs.getInt("estadoID"));
				listaItem.setNomeFormaRemocao(rs.getString("nomeestado"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de estados!\n" + e.getMessage());
		}

		return listaCompleta;

	}

	public List<TipoVeiculo> listarTodosTiposVeiculos() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<TipoVeiculo> listaCompleta = new ArrayList<TipoVeiculo>();

		sql = "SELECT * FROM tipoveiculo";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TipoVeiculo listaItem = new TipoVeiculo();

				listaItem.setTipoVeiculoID(rs.getInt("tipoveiculoID"));
				listaItem.setNomeTipoVeiculo(rs.getString("nometipoveiculo"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Erro ao preencher a lista de tipo veiculo!\n"
							+ e.getMessage());
		}

		return listaCompleta;

	}

	public List<Reboquista> listarTodosReboquista() {
		return null;
	}

	public List<Frota> listarTodaFrota() {

		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Frota> listaCompleta = new ArrayList<Frota>();

		sql = "SELECT * FROM frota";

		try {
			conn = Conexao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Frota listaItem = new Frota();

				listaItem.setFrotaID(rs.getInt("frotaID"));
				listaItem.setMarcaID(rs.getInt("marcaID"));
				listaItem.setMarcaID(rs.getInt("modeloID"));
				listaItem.setPlaca(rs.getString("placa"));
				listaItem.setAno(rs.getString("ano"));

				listaCompleta.add(listaItem);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao preencher a lista de frota!\n" + e.getMessage());
		}

		return listaCompleta;

	}

}
