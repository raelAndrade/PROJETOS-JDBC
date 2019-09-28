package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class ProgramMain {

	public static void main(String[] args) {
	
		Connection conn = null;
		
		PreparedStatement stm = null;
		
		try {
			conn = DB.getConnection();
			
			stm = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			stm.setDouble(1, 200.0);
			stm.setInt(2, 2);
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Concluído! Linhas afetadas: " + rowsAffected);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(stm);
			DB.closeConnection();
		}
	}
}
