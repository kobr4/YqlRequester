package com.nicolasmy.yql;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;

public class YqlRequester {
	private static String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
	private static String sanFransicoRequest = "select * from geo.places where text=\"san francisco, ca\"";
	private static String weatherRequestStart =  "select * from weather.forecast where woeid IN (select woeid from geo.places where ";
	private static String weatherRequestEnd = " )";
	private static String buildRequest(String request) {
		
		try {
			return baseUrl + URLEncoder.encode(request, "UTF-8")+"&format=json";
		} catch (UnsupportedEncodingException e) {
			return baseUrl + URLEncoder.encode(request) +"&format=json";
		}
	}
	
	public static void addPlaceRequest(StringBuffer reqBuffer, String place) {
		reqBuffer.append(" OR ");
		reqBuffer.append("text=\"");
		reqBuffer.append(place);
		reqBuffer.append("\"");
	}
	
	private static InputStreamReader fetchRessource(String request) throws IOException {
		URL url = new URL(request);
		URLConnection  urlc = url.openConnection();
		return new InputStreamReader(urlc.getInputStream());
	}
	
	public static StringBuffer createRequestBuffer(String elementRequest) {
		StringBuffer bufferRequest = new StringBuffer(weatherRequestStart);
		bufferRequest.append("text=\""+elementRequest+"\"");
		return bufferRequest;
	}
	
	public static Request fetchRequest(StringBuffer requestBuffer) throws IOException {
		ObjectMapper sMapper = new ObjectMapper();
		sMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);  		
		
		InputStreamReader is = null;
		Request yqlrequest = null;
		String request = buildRequest(requestBuffer.toString()+")");
		
		try {
			is = fetchRessource(request);
			yqlrequest = sMapper.readValue(is, Request.class);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return yqlrequest;
	}
	
	
	public static void main(String[] argv) {		
		ObjectMapper sMapper = new ObjectMapper();
		sMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
		
		StringBuffer bufferRequest = new StringBuffer(weatherRequestStart);
		bufferRequest.append("text=\"Aruba Oranjestad\"");
		addPlaceRequest(bufferRequest,"Australia Canberra");
		addPlaceRequest(bufferRequest,"Cote d'Ivoire Yamoussoukro");
		bufferRequest.append(weatherRequestEnd);
		
		String request = buildRequest(sanFransicoRequest);
		request = buildRequest(bufferRequest.toString());
		InputStreamReader is = null;
		Request yqlrequest = null;
		try {
			is = fetchRessource(request);
			yqlrequest = sMapper.readValue(is, Request.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		if ((yqlrequest != null)&&(yqlrequest.query != null)) {
			System.out.println("Channel :"+yqlrequest.query.result.channel.size());
		} else {
			System.out.println("Objet null !");
		}
	}
	
}
