package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.exceptions.DBIntegrityException;

public class ProgramMain {

	public static void main(String[] args) {
	
		Connection conn = null;
		
		PreparedStatement stm = null;
		
		try {
			conn = DB.getConnection();
			
			stm = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "(Id = ?)");
			stm.setInt(1, 5);
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Concluído! Linhas afetadas: " + rowsAffected);
		}catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(stm);
			DB.closeConnection();
		}
	}
}
