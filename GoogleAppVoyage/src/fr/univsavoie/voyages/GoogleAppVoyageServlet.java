package fr.univsavoie.voyages;

import java.io.IOException;

import javax.servlet.http.*;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@SuppressWarnings("serial")
public class GoogleAppVoyageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException {
		resp.setContentType("text/plain");
		String name = req.getParameter("name");
		resp.getWriter().println("Hello, world");
		
		ObjectifyService.register(VoyageList.class);
		Objectify ofy = ObjectifyService.begin();
		
		Query<VoyageList> q = ofy.query(VoyageList.class).filter("name =", name);
		VoyageList vl = q.get();
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n"
				+ "<ids>\n";
		
		
		for (int i = 0; i < vl.getIdVoyages().length; i++)
		{
			xml += "\n<id>"+vl.getIdVoyages()[i]+"</id>\n";
		}
		
		xml += "</ids>\n";
		resp.getOutputStream().print(xml);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String idVoyages = req.getParameter("ids");
		
		String []stringIds = idVoyages.split(",");
		
		int ids [] = new int[stringIds.length];
		
		for (int i = 0; i < stringIds.length; i++)
		{
			ids[i] = Integer.parseInt(stringIds[i]);
		}
		
		ObjectifyService.register(VoyageList.class);
		Objectify ofy = ObjectifyService.begin();
		
		VoyageList vl = new VoyageList(name, ids);
		
		ofy.put(vl);
		
		resp.getWriter().print("Voyages enregistrés avec succès !");
	}
}
