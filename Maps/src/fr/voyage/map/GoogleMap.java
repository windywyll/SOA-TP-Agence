package fr.voyage.map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/GMaps")
public class GoogleMap {
	
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String instanciateGM(){
		return "<script src=\"https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false\"></script>";
	}
	
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String centeredMap(String address){
		return"<script>"
					+ "\tvar map;\n"
					+ "\tfunction initialize(){\n"
						+ "\t\tvar geocoder = new google.maps.Geocoder();\n"
						+ "\t\tvar mapOptions;\n"
						+ "\t\tgoecoder.geocode({'address':"+address+"}, function(results, status){\n"
							+ "\t\t\tif(status == google.maps.GeocoderStatus.OK){\n"
								+ "\t\t\t\tmapOptions = {\n"
									+ "\t\t\t\t\tzoom: 8,\n"
									+ "\t\t\t\t\tcenter: results[0].geometry.location};\n"
								+ "\t\t\t\tmap = new google.maps.Map(document.getElementByd('map-canvas'),mapOptions);\n"
								+ "\t\t\t\tvar marker = new google.maps.Marker({\n"
									+ "\t\t\t\t\tmap: map,\n"
									+ "\t\t\t\t\tposition: results[0].geometry.location\n"
								+ "\t\t\t\t});\n"
							+ "\t\t\t}\n"
							+ "\t\t\telse{\n"
								+ "\t\t\t\tconsole.log('Geocode problem: '+status);\n"
							+ "\t\t\t}\n"
						+ "\t\t};\n"
					+ "\t}\n"
					+ "\tgoogle.maps.event.addDomListener(window, 'load', initialize);\n"
				+ "</script>";
	}
	
}
