package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class ProgramMain {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			/*ps = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			ps.setString(1, "Israel Andrade");
			ps.setString(2, "israel@gmail.com");
			ps.setDate(3, new Date(sdf.parse("23/02/1985").getTime()));
			ps.setDouble(4, 4000.0);
			ps.setInt(5, 4);*/
			
			// Ou inserir dois ao mesmo tempo no banco
			ps = conn.prepareStatement("INSERT INTO department (Name) VALUES ('Human Resource'), ('Administration')");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		/*} catch (ParseException e) {
			e.printStackTrace();*/
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
	}

}
