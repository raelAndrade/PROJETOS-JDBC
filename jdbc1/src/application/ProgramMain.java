package application;

import java.sql.Connection;

import db.DB;

public class ProgramMain {

	public static void main(String[] args) {
		
		Connection  conn = DB.getConnection();
			
		DB.closeConnection();

	}

}
