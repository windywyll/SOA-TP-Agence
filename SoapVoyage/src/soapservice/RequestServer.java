package soapservice;
import java.sql.*;
import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.opensaml.xml.util.Pair;

@WebService(targetNamespace = "http://soapservice/", portName = "RequestServerPort", serviceName = "RequestServerService")
public class RequestServer {
	
	public ArrayList<Pair<String,String>> getChosenVoyage(@WebParam(name = "arg0") String voyage){
		Statement stat;
		ResultSet res = null;
		ArrayList<Pair<String,String>> resFormat = new ArrayList<Pair<String,String>>();
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/voyages","root","");
				try {
					stat = connect.createStatement();
					res = stat.executeQuery("SELECT v.nom, p.nom FROM pays p JOIN ville v ON p.id = v.pays WHERE p.nom = \""+voyage+"\" OR v.nom =\""+voyage+"\"");
					while(res.next()){
						resFormat.add(new Pair<String,String>(res.getString("v.nom"), res.getString("p.nom")));
					}
				} catch (SQLException e) {
					System.out.println(e.getSQLState());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		return resFormat;
	}
}