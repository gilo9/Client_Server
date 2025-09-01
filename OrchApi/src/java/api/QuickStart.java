package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bson.Document;
import com.mongodb.client.*;
import com.mongodb.*;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import java.util.Collection;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickStart {

    private static final Logger logger = LoggerFactory.getLogger(QuickStart.class);

    private static final ConnectionString cs = new ConnectionString("mongodb://localhost:27017");
        
            //?directConnection=true&serverSelectionTimeoutMS=2000")
    public static MongoClient start(){
        

        MongoClient mongoClient = null;
        try{
            mongoClient = MongoClients.create(cs);
            return mongoClient;
           }
        catch(NullPointerException e){
            logger.error("Database is empty", e);
            
        }
        if (mongoClient == null){
        throw (new NullPointerException()); 
        }
        return mongoClient;
    } 
        
    }

       /* try (MongoClient mongoClient = MongoClients.create(cs)) {
            MongoDatabase database = mongoClient.getDatabase("apiDB");
            MongoCollection<Document> collection = database.getCollection("rooms");

            Document d = collection.find().first();
            if (d == null) {
                logger.error("Database is empty");
                
            } else {
               
                System.out.println(d.toJson());
                Gson g = new GsonBuilder().setPrettyPrinting().create();
                Rooms r = g.fromJson(d.toJson() ,Rooms.class);
                Room[] rooms = r.getRooms(); 
                for (int i=0;i<rooms.length;i++){
                    System.out.println(g.toJson(rooms[i]));
                }
                    
                System.out.println(r);
            }

        } catch (NullPointerException e) {
            logger.error("Database is empty", e);
        }
    }
}*/ 