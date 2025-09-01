/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;


/**
 *
 * @author grape
 */
public class Coordinates {
    
    private static final String key = "e2ed192c925f4d1c8138faefe6050e94";
    private static final String base = "https://api.opencagedata.com/geocode/v1/json?q=";
    private Location loc;
    private BufferedReader bf;
    private String postCode; 
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String params = "";
    
    public Coordinates(Location l){
        this.loc = l;
        this.postCode = l.getPostcode();
    }
    public Geometry getCoordinates(){
        //build params
        Geometry h = null;
        
        params+= (postCode.replace(" ","+"));
        params+= ("&key="+key+"&no_annotations=1");
       String responseString = "";
       //build connection
       try{
         URL url = new URL(base + params);
       
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        
        int responseCode = con.getResponseCode();
        
        if (responseCode == 200){
            Reader reader = new InputStreamReader(con.getInputStream());
            bf = new BufferedReader(reader);
            String r;
            while ((r = bf.readLine()) != null){
                
                responseString += r;
                
                    }
            
        }else{
            System.err.print("Status Code: " + responseCode);
        }
        
        GeoCode g = gson.fromJson(responseString,api.GeoCode.class);
        
        Results r = g.getResults()[0];
        h = r.getGeometry();
        
       } catch(JsonSyntaxException e){
           System.err.print("Error in Json Deserialization");
       } catch(MalformedURLException e){
           System.err.print("URL not generated correctly");         
       }catch (IOException e){
           System.err.print("Unable to get Stream from Buffered Reader");
       }
       return h;
   }   
        
}