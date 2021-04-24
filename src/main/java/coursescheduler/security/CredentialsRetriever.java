package coursescheduler.security;

import com.mongodb.ConnectionString;

/** Retrieves credentials for the Course Scheduler application. */
public interface CredentialsRetriever {
  ConnectionString getMongoDbClientConnectionString();
}
