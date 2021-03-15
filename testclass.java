package testexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import com.google.gson.Gson;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class testclass {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		testclass testclass = new testclass();
		String jsonString = testclass.MyGETRequest();
		
		Gson g = new Gson();  
		Response response = g.fromJson(jsonString, Response.class);
		testclass.POSTRequest(response);

	}
	
	
	public  String MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL("https://evening-brook-34199.herokuapp.com/application");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	   // conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
	    int responseCode = conection.getResponseCode();


	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        System.out.println("JSON String Result " + response.toString());
	        return response.toString();
	        //GetAndPost.POSTRequest(response.toString());
	    } else {
	        System.out.println("GET NOT WORKED");
	        return null;
	    }

	}
	
	public  void POSTRequest(Response response ) throws IOException, ParseException {

		 System.out.println(response.toString());

	    final String POST_PARAMS = "{\n" + "\"role\": java\r\n" +
	        "    \"referrer\": \"pure software\",\r\n" +
	        "    \"answer\": \"answer\"" + "\n}";
	    
	    final String POST_PARAMS1 = "{\n" + "\"applicant\": {\r\n" +
		        "    \"id\": 7276f591-d71a-48c4-ab72-a32dadca5f53,\r\n" +
		        "    \"firstName\": \"pinakee\",\r\n" +
		        "    \"lastName\": \"saha\",\r\n" +
		        "    \"lastName\": \"saha\",\r\n" +


		        "    \"lastName\": \"Saha\"" + "\n}";
		    
	    System.out.println(POST_PARAMS1);
	    System.out.println(POST_PARAMS);
	    
	    URL obj = new URL("https://evening-brook-34199.herokuapp.com/application");
	   // URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	 //   postConnection.setRequestProperty("userId", "a1bcdefgh");
	    postConnection.setRequestProperty("Content-Type", "application/json");


	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();


	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());

	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer respons = new StringBuffer();

	        while ((inputLine = in .readLine()) != null) {
	            respons.append(inputLine);
	        } in .close();

	        // print result
	        System.out.println(respons.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	}
	


}
