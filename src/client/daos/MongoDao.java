package mongodb.client.daos;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


/**
 *
 * Setup fields a Dao of the client will need.
 */
public abstract class MongoDao {
  private static String connectionStr = ""; // removing as left off on blocker trying different framework.
  private static final ConnectionString connectionString = new ConnectionString(connectionStr);
  private static final CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
  private static final CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
  private static final MongoClientSettings clientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .codecRegistry(codecRegistry)
          .build();
  protected static final MongoClient mongoClient = MongoClients.create(clientSettings);
  // public static final MongoClient mongoClient = MongoClients.create(connectionStr);
}
