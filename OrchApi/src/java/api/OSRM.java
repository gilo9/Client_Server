/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import api.DistanceData;

/**
 *
 * @author grape
 */
public class OSRM {
    
    private static final String base = "http://router.project-osrm.org/route/v1/car/";
    private static BufferedReader bf;
    private static String start;
    private static String end;
    private static final Map<String, String> parameters = new HashMap<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public OSRM(Geometry start,Geometry coords ){
        
       
        OSRM.start = start.getLng()+","+start.getLat();
        OSRM.end = coords.getLng()+","+coords.getLat();
    }
    private static String generateParameters(){
        String paramsToString = "";
        
        paramsToString +=  start + ";";
        paramsToString +=  end + ".json?";
        paramsToString += "overview=false";
       
       return paramsToString;
    }        
    
    public String getDistance(){
        String responseString = "";
        
        System.out.println(base + OSRM.generateParameters());
        String urll = base + OSRM.generateParameters();
        try{
         URL url = new URL(urll);
         
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("GET");
         
        con.connect();
        
        bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String r;
        while((r = bf.readLine()) != null){
            responseString += r;
        }
        }catch(MalformedURLException e){
            System.err.println("Wrong URL");
        }catch(IOException a){
            System.err.println("Error reading API DATA");
            
    }
     return responseString;   
    }
    
    public static void main(String[] args){
        
    Location l = new Location();
    l.setPostcode("n18 2tx");
    
    Location p = new Location();
    p.setPostcode("n9 9rs");

    Coordinates a = new Coordinates(l);
    
    Coordinates b = new Coordinates(p);
    
    Geometry c = a.getCoordinates();
    Geometry d = b.getCoordinates();
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    OSRM o = new OSRM(c,d);
    String rawJson = o.getDistance();
    
    
    Route r = gson.fromJson(rawJson, DistanceData.class).getRoutes()[0];
    System.out.println("Distance:"+r.getDistance()  + "m Duration: " + r.getDistance()  + "minutes");
    
    }
   
}