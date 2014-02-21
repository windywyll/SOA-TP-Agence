package fr.voyage.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import soapservice.RequestServer;
import soapservice.RequestServerService;

/**
 * Servlet implementation class Voyages
 */
public class Voyages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private URL searchVoyagesURL;
	private QName SERVICE_Voyage = new QName("http://soapservice/", "RequestServerService");
	private RequestServer portvoyage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voyages() {
        super();
        searchVoyagesURL = RequestServerService.WSDL_LOCATION;
        RequestServerService ss = new RequestServerService(searchVoyagesURL, SERVICE_Voyage);
        portvoyage = ss.getRequestServerPort();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toDisplay = "<p>Aucun Voyage recherché</p>";
		request.setAttribute("toDisplay", toDisplay);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/voyages.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<soapservice.Pair> responseVoyage = portvoyage.getChosenVoyage(request.getParameter("pays"));
		String toDisplay = "<table>";
		for(soapservice.Pair pair: responseVoyage){
			toDisplay += "<tr><td>"+pair.getFirst()+"</td><td>"+pair.getSecond()+"<td></tr>";
		}
		toDisplay += "</table>";
		request.setAttribute("toDisplay", toDisplay);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/voyages.jsp" ).forward( request, response );
	}

}
