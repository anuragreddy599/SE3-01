package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class LoadData {

	private static String JDBC_CONNECTION_URL = 
			"jdbc:mysql://localhost:3306/invoice";

	
	public static void main(String[] args) {
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
		      
		      EntityManager entitymanager = emfactory.createEntityManager( );
		      entitymanager.getTransaction( ).begin( );

			CSVLoader loader = new CSVLoader(getCon());
			
			loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//client_data.csv", "CLIENT", true);
			loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//company_data.csv", "COMPANY", true);
			loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//people_data.csv", "EMPLOYEE", true);
			loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//project_data.csv", "CLIENTPROJECT", true);
            //loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//project_person.csv", "PROJECTPERSON", true);
			//loader.loadCSV("C://Users//ravikanthreddy//Desktop//Sample Data.zip//project_person.csv", "CUSTOMER", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL,"root","Darling5");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
