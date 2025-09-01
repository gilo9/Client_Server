
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author grape
 */
@Path("api")
public class Orchestrator {

    @Context
    private UriInfo context;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String path = "C://users/grape/onedrive/documents/work/sccc/coursework/rooms.json";
    //  private static final Map<Integer, Application> AppStore = new ConcurrentHashMap<>();
    // private static final Map<Long, Room> RoomStore = new ConcurrentHashMap<>();
    private static final MongoClient mongo = QuickStart.start();
    private static MongoDatabase md;
    private final Logger logger = LoggerFactory.getLogger(Orchestrator.class);

    /**
     * Creates a new instance of Orchestrator
     */
    public Orchestrator() {
        loadDataBase();
    }

    public static final void loadDataBase() {

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry CodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        md = mongo.getDatabase("apiDB").withCodecRegistry(CodecRegistry);
    }

    /**
     * Retrieves representation of an instance of api.Orchestrator
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response viewRooms(@PathParam("id") int id) {

        MongoCollection<Document> roomsCol= md.getCollection("rooms");
        List<Document> rooms = roomsCol.find().into(new ArrayList<>());
        
        if (roomsCol == null) {
            logger.warn("No rooms found in the database.");
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No rooms found")
                    .build();
        }
        Rooms rms = gson.fromJson(rooms.get(0).toJson(),Rooms.class );
        String jsonString = "";
        if (id == 0) {

            for (Room r : rms.getRooms()) {
                jsonString += gson.toJson(r, Room.class);
            }

        } else {
            Room r= rms.getRooms()[id];
            jsonString += gson.toJson(r);

            Coordinates coords = new Coordinates(r.getLocation());
            Weather weather = new Weather(coords.getCoordinates());

            jsonString += weather.getWeather();

        }
        //TODO return proper representation object

        return Response.ok()
                .entity(jsonString)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of Orchestrator
     *
     * @param id representation for the resource
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getRoom(@PathParam("id") int id) {
        
        MongoCollection<Document> roomsCol= md.getCollection("rooms");
        Document rooms = roomsCol.find().first();
        Rooms r = gson.fromJson(rooms.toJson(),Rooms.class);
        Room[] rms = r.getRooms();
        Room room = rms[id-1];
        
        
        String jsonString = "";
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
            //  return Response
            //        .status(Response.Status.NOT_FOUND)
            //      .entity("No such room with id: " + id).build();

        }
        jsonString += gson.toJson(room);

        Coordinates coords = new Coordinates(room.getLocation());
        Weather weather = new Weather(coords.getCoordinates());

        jsonString += Weather.getWeather();
        return Response.ok()
                .entity(jsonString)
                .build();
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response apply(String content) {
        MongoCollection<Document> apps = md.getCollection("applications");
        Application a = new Application();
        try {
            a = gson.fromJson(content, Application.class);
            a.setAppId((int) (apps.countDocuments() + 1));
            apps.insertOne(new Document(String.valueOf(a.getAppId()),gson.toJson(a)));

        } catch (JsonSyntaxException e) {
            System.err.println("Json Structure is incorrect");
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
        String js = gson.toJson(a, Application.class);
        //URI applicationId = UriBuilder.fromResource(Application.class).build();
        return Response.status(201)
                .entity(js)
                .build();
    }

    @GET
    @Path("/applications")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)

    public Response viewApplications() {
        MongoCollection<Document> apps = md.getCollection("applications");
        List<Document> aps = apps.find().into(new ArrayList<>());
        if (!aps.isEmpty()) {

           List<Application> aplist = new ArrayList<>();
           for (Document d: aps){
   
                Application a = gson.fromJson(d.toJson(),Application.class);
                aplist.add(a);
 
               
            }
           String jsonString = gson.toJson(aplist);
            return Response
                    .ok()
                    .entity(jsonString)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("There are no applications")
                    .build();
        }

    }

    @DELETE
    @Path("/Del/{id}")
    public Response DeleteApplication(@PathParam("id") int id) {
        MongoCollection<Document> apps = md.getCollection("applications");
        List<Document> aps = apps.find().into(new ArrayList<>()); 
 
        if (aps != null) {
            
            apps.deleteOne(aps.get(id-1));
            
            return Response.status(200)
                    .entity("Application: " + id + " has been Deleted")
                    .build();
        } else {
            return Response.
                    status(Response.Status.NOT_FOUND)
                    .entity("No such Application with id:" + id).build();

        }

    }
}
