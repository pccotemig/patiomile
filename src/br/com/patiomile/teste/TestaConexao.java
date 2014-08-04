package br.com.patiomile.teste;

import java.sql.Connection;

import br.com.patiomile.utilitario.Conexao;

public class TestaConexao {

	public static void main(String[] args) {

		Connection conn = Conexao.getConnection();

		if (conn != null) {
			System.out.println("Conexao efetuada com sucesso!");
		} else {
			System.out.println("Houve um erro na conexão!");
		}

	}

}
