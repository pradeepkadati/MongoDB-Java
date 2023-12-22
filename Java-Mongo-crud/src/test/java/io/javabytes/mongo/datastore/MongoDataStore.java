package io.javabytes.mongo.datastore;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoDataStore {
    MongoClient client;
    private static final MongoDataStore INSTANCE = new MongoDataStore();
    private MongoDataStore(){

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        ConnectionString connectionString = new ConnectionString("mongodb://kadpra:admin123@localhost:27017");
        client= MongoClients.create(MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(pojoCodecRegistry).build());
    }

    public static MongoDataStore getInstance(){
        return INSTANCE;
    }

    public MongoClient getClient(){
      return client;
    }

}
