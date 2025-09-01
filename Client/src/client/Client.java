/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.http.*;
import java.net.*;
import java.util.HashSet;
import java.util.Scanner;
import javax.ws.rs.core.Response;

/**
 *
 * @author grape
 */
public class Client {
    private static final URI uri = URI.create("http://localhost:8080/OrchApi/webresources/api/");
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Scanner sc = new Scanner(System.in);
    
    
    
    
    public static HttpRequest postRequest(Application a){
        
    
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        String JsonRequest = gson.toJson(a,Application.class); 
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(JsonRequest))
                .setHeader("content-type","application/json")
                .build();
        
        return request;
    }
    
     public static HttpRequest getRequest(){
         
         HttpRequest r = HttpRequest.newBuilder()
                 .uri(URI.create("http://localhost:8080/OrchApi/webresources/api/applications"))
                 .setHeader("content-type", "application/json")
                 .build();
       return  r;
     }
     public static HttpRequest getRequest(int id){
         
         URI u; 
         
             if (id == 0){ u = uri;}
             
            else{u = URI.create(uri.toString() + id);
                    }
          HttpRequest r = HttpRequest.newBuilder()
                  .uri(u)
                 .setHeader("content-type", "application/json")
                 .build();
         
        return r;
     }
     
     
     
     
    
    public static String sendRequest(HttpRequest request){
                
        try{
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        
        if (statusCode == 200 || statusCode == 201 || statusCode == 204 || statusCode == 303 ){
           return ("Response: " + response.statusCode() + "\nBody: " + response.body()); 
            }
        else{
            return ("Error , Status Code: " + statusCode);
        }}catch(Exception e){ 
            return "";
        }
       
    }
    
   public static HttpRequest deleteRequest(int id){
        HttpRequest r = HttpRequest.newBuilder()
                 .uri(URI.create("http://localhost:8080/OrchApi/webresources/api/Del/" + id))
                 .DELETE()
                 .setHeader("content-type", "application/json")
                 .build();
       
   return r;
   } 

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
       
                

        //GET Room by ID works
       // System.out.println(sendRequest(getRequest(1)));
        //GET all rooms works
       // System.out.println(sendRequest(getRequest(0)));
        
        Application a = new Application();
      
        a.setRoomId(1);
        a.setUserId("Gilo");
        
        Application b = new Application();
        
        b.setRoomId(2);
        b.setUserId("Pheobs");
        
        //Make Application works
        System.out.println(sendRequest(postRequest(a)));
        
        // 
        System.out.println(sendRequest(postRequest(b)));
        
        //GET ALL APPLICATIONS
        System.out.println(sendRequest(getRequest()));
        //
        System.out.println(sendRequest(getRequest(4)));
        //DELETE APPLICATION
        System.out.println(sendRequest(deleteRequest(1)));   
        
        //GET APPLICATION BY ID
       
    } 
}
