package fr.voyage.flickr;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.TreeSet;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.jdom2.Document;
import org.jdom2.Element;  
import org.jdom2.JDOMException;  
import org.jdom2.input.SAXBuilder; 

public class ApiFlickr
{
	public static final String API_KEY = "758a4e03400b4dea3f19cab2a9ba4c5a";
	public static final String API_SECRET = "f7a102d625174159";
	public static final String URL_API = "http://api.flickr.com/services/soap/";
	private static SOAPConnection soapConnexion = null;
	
	public ApiFlickr()
	{
		try {
			soapConnexion = SOAPConnectionFactory.newInstance().createConnection();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}
	
	public TreeSet<String> getPhotosPays(String pays)
	{
		TreeSet<String> setPhotos = new TreeSet<String>();
		SOAPMessage message = null;
		try {
			message = soapConnexion.call(buildXMLRequest(pays), URL_API);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		if(message != null)
		{
			setPhotos = getPhotosFromReponse(message);
		}
		return setPhotos;
	}
	
	public TreeSet<String> getPhotosFromReponse(SOAPMessage message)
	{
		TreeSet<String> photoSet = new TreeSet<String>();
		try {
			ByteArrayOutputStream outSStream = new ByteArrayOutputStream();
			message.writeTo(System.out);
			message.writeTo(outSStream);
			
			SAXBuilder builder = new SAXBuilder();
			Document docXML = builder.build(new ByteArrayInputStream(outSStream.toByteArray()));
			
			List<Element> nodePhotos = docXML.getRootElement().getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren();
			for(Element e : nodePhotos)
			{
				System.out.println("http://farm"+e.getAttributeValue("farm")+".staticflickr.com/"+e.getAttributeValue("server")+"/"+e.getAttributeValue("id")+"_"+e.getAttributeValue("secret")+".jpg");
				photoSet.add("http://farm"+e.getAttributeValue("farm")+".staticflickr.com/"+e.getAttributeValue("server")+"/"+e.getAttributeValue("id")+"_"+e.getAttributeValue("secret")+".jpg");
			}
			
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e1) {
			e1.printStackTrace();
		}
		return photoSet;
	}
	
	public SOAPMessage buildXMLRequest(String pays)
	{
		String xml = "<s:Envelope" +
				"	xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\""+
				"	xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\""+
				"	xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">"+
				"	<s:Body>"+
				"		<x:FlickrRequest xmlns:x=\"urn:flickr\">"+
				"			<method>flickr.photos.search</method>"+
				"			<api_key>"+API_KEY+"</api_key>"+
				"			<secret>"+API_SECRET+"</secret>"+
				"			<tag>"+pays+"</tag>"+
				"			<privacy_filter>1</privacy_filter>"+
				"			<geo_context>2</geo_context>"+
				"			<content_type>6</content_type>"+
				"			<per_page>10</per_page>"+
				"			<format>soap2</format>"+
				"		</x:FlickrRequest>"+
				"	</s:Body>"+
				"</s:Envelope>";
		
		MessageFactory factory;
		SOAPMessage message = null;
		try {
			factory = MessageFactory.newInstance();
			message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public static void main (String args[])
	{
		ApiFlickr test = new ApiFlickr();
		System.out.println(test.getPhotosPays("Paris"));
	}
}