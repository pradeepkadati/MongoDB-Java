package io.javabytes.mongo.db.insert;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import io.javabytes.mongo.cricinfo.models.Availability;
import io.javabytes.mongo.cricinfo.models.Match;
import io.javabytes.mongo.cricinfo.models.Player;
import io.javabytes.mongo.cricinfo.models.Role;
import io.javabytes.mongo.datastore.MongoDataStore;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Given A MongoDB Client")
public class TestInserts {

    private static MongoClient mongoClient;
    @BeforeAll
    public static void beforeClass(){
        mongoClient=MongoDataStore.getInstance().getClient();
    }

    @AfterAll
    public static void afterClass(){
        mongoClient.close();
    }

    @Nested
    @DisplayName("When Player(s) needs to be inserted")
    class InsertPlayers{

        @Test
        @DisplayName("Then insert one Player")
        public void insertOnePlayer(){

            List<Match> matches= new ArrayList<>();
            matches.add(new Match("test",200,190));
            matches.add(new Match("odis",250,230));
            matches.add(new Match("T20",100,90));

            Player player = new Player("kamble",48, Role.BOWLER, Availability.RETIRED,5000,1000,400,matches);

           InsertOneResult result =  mongoClient.getDatabase("cric_info")
                   .getCollection("players",Player.class).insertOne(player);

            Bson filter = Filters.eq("_id",result.getInsertedId().asObjectId());
            FindIterable<Player> playerResult = mongoClient.getDatabase("cric_info")
                    .getCollection("players",Player.class).find(filter);



            Assertions.assertNotNull(playerResult);
            for (Player player1 : playerResult) {
                Assertions.assertEquals("kamble",player1.getName());
            }

        }

        @Test
        @DisplayName("Then insert many players")
        public void insertManyPlayers(){

            List<Match> matches1= new ArrayList<>();
            matches1.add(new Match("test",100,160));
            matches1.add(new Match("odis",150,230));
            matches1.add(new Match("T20",50,70));

            Player player1 = new Player("Kohli",44, Role.BATSMAN, Availability.PLAYING,4000,1300,420,matches1);

            List<Match> matches2= new ArrayList<>();
            matches2.add(new Match("test",230,170));
            matches2.add(new Match("odis",112,210));
            matches2.add(new Match("T20",120,60));

            Player player2 = new Player("Ganguly",35, Role.ALL_ROUNDER, Availability.INJURED,3000,1500,478,matches2);

            List<Player> playersList = List.of(player1,player2);

            InsertManyResult result = mongoClient.getDatabase("cric_info").getCollection("players",Player.class).insertMany(playersList);
            Assertions.assertEquals(2, result.getInsertedIds().size());
        }
    }

}
