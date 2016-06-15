package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	static DBConnection INSTANCE = null;
	
	private Connection connection;
	private Statement statement;
	
	public DBConnection(){
		System.out.println("Nouvelle Connexion !");
		this.open();
	}
	
	public static DBConnection getInstance(){
		if(INSTANCE == null){
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	protected void close(){
		if(getStatement() != null)
			try {
				getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(getConnection() != null)
			try {
				getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public boolean open(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				setConnection(DriverManager.getConnection(DBProperties.URL, DBProperties.LOGIN, DBProperties.PASSWORD));
				System.out.println("Connexion Ouverte !");
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	/* GETTERS AND SETTERS FOR DATABASE CONNECTION ACCESS */
	
	public Statement getStatement() {
		return this.statement;
	}
	
	public void setStatement(Statement statement){
		this.statement = statement;
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	
}
