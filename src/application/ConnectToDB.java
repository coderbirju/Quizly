package application;

import java.util.ArrayList;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectToDB {

    private static ConnectToDB instance;

    private static final String DATABASE_NAME = "Quizly";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private ConnectToDB() {
        // Create a new MongoDB client instance
        mongoClient = MongoClients.create("mongodb+srv://<add_your_srv_here>");

        // Get a reference to the database and collection
        database = mongoClient.getDatabase(DATABASE_NAME);
        System.out.println("Connected to database: " + database.getName());
        System.out.println("Collections: " + database.listCollectionNames().into(new ArrayList<>()));
    }

    public static ConnectToDB getInstance() {
        if (instance == null) {
            instance = new ConnectToDB();
        }
        return instance;
    }

    public MongoClient getClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection(String CollectionName) {
        collection = database.getCollection(CollectionName);
        return collection;
    }

    public void close() {
        mongoClient.close();
    }
}
