/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;




/**
 *
 * @author grape
 */
public  class Weather {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<String, String> parameters = new HashMap<>();
    private static BufferedReader bf;
    
    
    private static final URI weather = URI.create("https://www.7timer.info/bin/civillight.php?");
        
    
  
    
    
    public  Weather(Geometry g){
        parameters.put("lon",g.getLng() );
        parameters.put("lat" , g.getLat() );
        parameters.put("lang","en");
        parameters.put("unit" ,"metric");
        parameters.put("output","json");
        
        
    }
    public static String generateParameters(){
        List<String> params = parameters.entrySet().stream().map(entry -> entry.getKey()+ "=" + entry.getValue()).collect(Collectors.toList()); 
        String convertedParamsToString = "";
        convertedParamsToString = String.join("&",params);
        
        return convertedParamsToString;
    }
    
   public static String getWeather(){
       String responseString = "";
       try{
        URL url = new URL(weather.toString() + Weather.generateParameters());
       
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
            System.err.print("Not Found");
        }
        
        
       } catch(Exception e){
           e.printStackTrace();
       } 
       WeatherData w = gson.fromJson(responseString,WeatherData.class);
       
       return gson.toJson(w);
   }   
}
