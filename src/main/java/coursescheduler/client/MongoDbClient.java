package coursescheduler.client;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import coursescheduler.security.BaseCredentialsRetriever;
import coursescheduler.security.CredentialsRetriever;

/** Eager singleton for MongoDB client. */
public class MongoDbClient {

  private static final CredentialsRetriever credentialsRetriever = new BaseCredentialsRetriever();

  private static final ConnectionString connectionString =
      credentialsRetriever.getMongoDbClientConnectionString();

  /* As a note, "The Codec interface abstracts the processes of decoding a BSON value into a Java object using
  a BsonReader and encoding a Java object into a BSON value using a BsonWriter."*/

  // handles the translation to and from BSON for our POJOs
  private static final CodecRegistry pojoCodecRegistry =
      fromProviders(PojoCodecProvider.builder().automatic(true).build());

  // contains all the default codecs (e.g. Boolean, Double, String, BigDecimal, etc.).
  private static final CodecRegistry codecRegistry =
      fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

  // wrap settings together
  private static final MongoClientSettings clientSettings =
      MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .codecRegistry(codecRegistry)
          .build();

  private static final MongoClient instance = MongoClients.create(clientSettings);

  private MongoDbClient() {}

  public static MongoClient getInstance() {
    return instance;
  }
}
