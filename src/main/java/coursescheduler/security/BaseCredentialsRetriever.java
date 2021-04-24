package coursescheduler.security;

import com.mongodb.ConnectionString;

/** {@inheritDoc} */
public class BaseCredentialsRetriever implements CredentialsRetriever {
  //  @Override
  //  public ConnectionString getMongoDbClientConnectionString() {
  //    SecretClient secretClient =
  //        new SecretClientBuilder()
  //            .vaultUrl("https://courseschedulerkeyvault.vault.azure.net/")
  //            .credential(new DefaultAzureCredentialBuilder().build())
  //            .buildClient();
  //
  //    return new
  // ConnectionString(secretClient.getSecret("MongoDbProdConnectionString").getValue());

  @Override
  public ConnectionString getMongoDbClientConnectionString() {
    return new ConnectionString(
        "mongodb+srv://thxorht:tpd6rC6zQqFBCH9@cluster0.ywekc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
  }
}
