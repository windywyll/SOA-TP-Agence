package soapservice;
import java.sql.*;
import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.opensaml.xml.util.Pair;

@WebService(targetNamespace = "http://soapservice/", portName = "RequestServerPort", serviceName = "RequestServerService")
public class RequestServer {
	
	public ArrayList<Pair<String,String>> getChosenVoyage(@WebParam(name = "arg0") String voyage){
		Connection connect;
		Statement stat;
		ResultSet res = null;
		ArrayList<Pair<String,String>> resFormat = new ArrayList<Pair<String,String>>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/voyages","root","");
			stat = connect.createStatement();
			res = stat.executeQuery("select v.nom p.nom from pays p join ville v on p.id = v.pays where p.nom = "+voyage+" OR v.nom ="+voyage);
			while(res.next()){
				resFormat.add(new Pair<String,String>(res.getString("v.nom"), res.getString("p.nom")));
			}
		}catch(Exception e){
			System.out.println("Impossible de se connecter à la base de données");
		}
		
		return resFormat;
	}
}