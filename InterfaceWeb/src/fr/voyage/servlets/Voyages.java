package fr.voyage.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import fr.voyage.flickr.ApiFlickr;
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
		String toDisplay = "<div>";
		for(soapservice.Pair pair: responseVoyage){
			String ville = (String)pair.getFirst();
			String pays = (String)pair.getSecond();
			ApiFlickr flickr = new ApiFlickr();
			TreeSet<String> photos = flickr.getPhotosWithTag(ville);
			toDisplay += "\t<div>\n"
					+ "\t\t<p>Photos de la ville : "+ville+"</p>\n";
			for(String photo : photos)
					toDisplay += "\t\t<img class=\"imageVille\" src=\""+photo+"\" alt=\"photo_"+ville+"\" />\n";
					
			toDisplay += "\t</div>";
		}
		toDisplay += "</div>";
		request.setAttribute("toDisplay", toDisplay);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/voyages.jsp" ).forward( request, response );
	}

}
