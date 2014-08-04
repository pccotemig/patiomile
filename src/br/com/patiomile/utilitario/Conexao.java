package br.com.patiomile.utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	public static Connection getConnection() {

		Connection conn = null;
		String serverName, userName, pwdUser, url, databaseName;

		serverName = "localhost";
		userName = "root";
		pwdUser = "lab123";
		databaseName = "patiomile";
		url = "jdbc:mysql://" + serverName + ":3306/" + databaseName;

		try {
			conn = DriverManager.getConnection(url, userName, pwdUser);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao conectar ao BD. " + e.getMessage());
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao fechar conexão. " + e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement pstmt) {
		try {
			if ((!conn.isClosed() && (!pstmt.isClosed()))) {
				conn.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao fechar conexão. " + e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		try {
			if ((!conn.isClosed()) && (!pstmt.isClosed()) && (!rs.isClosed())) {
				conn.close();
				pstmt.close();
				rs.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao fechar conexão. " + e.getMessage());
		}
	}

}
