package soapservice;
import java.sql.*;

public class RequestServer {
	
	public ResultSet getAllVoyage(){
		Connection connect;
		Statement stat;
		ResultSet res = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/voyages","root","");
			stat = connect.createStatement();
			res = stat.executeQuery("select nom from ville");
		}catch(Exception e){
			System.out.println("Impossible de se connecter à la base de données");
		}
		
		return res;
	}
	
	public ResultSet getChosenVoyage(String voyage){
		Connection connect;
		Statement stat;
		ResultSet res = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/voyages","root","");
			stat = connect.createStatement();
			res = stat.executeQuery("select v.nom p.nom from pays p join ville v on p.id = v.pays where p.nom = "+voyage+" OR v.nom ="+voyage);
		}catch(Exception e){
			System.out.println("Impossible de se connecter à la base de données");
		}
		
		return res;
	}
}