package br.com.esdrasferreira.factory.jdbc;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FabricaConexao {

	private Connection conn;

	public FabricaConexao() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sistema");

			conn = ds.getConnection();
			System.out.println("ds.getConnection executado.....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() throws Exception {

		return conn;

	}

	public static void fecharConexao(Connection conn) throws Exception {
		fecharTudo(conn, null, null, null);

	}

	public static void fecharStatement(Statement stmt) throws Exception {
		fecharTudo(null, stmt, null, null);

	}

	public static void fecharResultSet(ResultSet rs) throws Exception {
		fecharTudo(null, null, rs, null);

	}

	public static void fecharPreparedStatement(PreparedStatement ps) throws Exception {
		fecharTudo(null, null, null, ps);

	}

	public static void fecharStmtRs(Statement stmt, ResultSet rs) throws Exception {
		fecharTudo(null, stmt, rs, null);

	}

	public static void fecharStmtRs2(Statement stmt, ResultSet rs) throws Exception {
		fecharTudo(null, stmt, rs, null);

	}

	private static void fecharTudo(Connection conn, Statement stmt, ResultSet rs, PreparedStatement ps)
			throws Exception {

		try {

			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
