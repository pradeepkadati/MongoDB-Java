package io.javabytes.mongo.db.connection;

import com.mongodb.client.MongoClient;
import io.javabytes.mongo.datastore.MongoDataStore;
import org.bson.Document;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Given A MongoDB Client")
public class TestConnection {

    private static MongoClient client;

    @BeforeEach
    public void setUp() {


    }

    @BeforeAll
    public static void init() {
        client = MongoDataStore.getInstance().getClient();
    }

    @AfterEach
    public void cleanUp() {

    }

    @AfterAll
    public static void destroy() {
        client.close();
        client = null;
    }


    @Nested
    @DisplayName("When Connection is established")
    class Connection {

        @Test
        @DisplayName("Then get all Databases")
        public void testConnection() {

            List<Document> databases = client.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
            Assertions.assertTrue(databases.size()>=3);
        }

        @Test
        @DisplayName("Then has all Default Databases")
        public void hasAllDefaultDBs() {

            List<Document> databases = client.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
            Assertions.assertFalse(databases.size()<3);
        }
    }
}
