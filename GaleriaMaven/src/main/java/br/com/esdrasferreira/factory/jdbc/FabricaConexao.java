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
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() throws Exception {
		
		return conn;
		
		
	
//		String url = "jdbc:mysql://192.175.108.234/servlet?useTimezone=true&serverTimezone=UTC";	 //porta tcp 3306	
//		try {
//			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//			return DriverManager.getConnection( url , "esdras01", "j4cA0~uh!x-f");
//		} catch (SQLException e) {
//			
//			throw new Exception("Erro na conexão");
//		}
	}
	
	public static void fecharConexao(Connection conexao) throws Exception{
		fecharTudo(conexao, null, null, null);
		
		
	}
	
	public static void fecharStatement(Statement stmt) throws Exception{
		fecharTudo(null, stmt, null, null);
		
	}
	
	public static void fecharResultSet(ResultSet rs) throws Exception{
		fecharTudo(null, null, rs, null);
		
	}
	
	public static void fecharPreparedStatement(PreparedStatement ps) throws Exception{
		fecharTudo(null, null, null, ps);
		
	}
	
	public static void fecharStmtRs(Statement stmt, ResultSet rs) throws Exception{
		fecharTudo(null, stmt, rs, null);
		
	}
	
	public static void fecharStmtRs2(Statement stmt, ResultSet rs) throws Exception{
		fecharTudo(null, stmt, rs, null);
		
	}
	
	
	private static void fecharTudo(Connection conn, Statement stmt, ResultSet rs, PreparedStatement ps) throws Exception {
		
		try {
			
			if( rs != null ) rs.close();
			if( ps != null ) ps.close();
			if( stmt != null ) stmt.close();
	
			
		}catch (Exception e){
			throw new Exception(e.getMessage()) ;
		}
		
	}
	
	
	

}
