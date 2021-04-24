package coursescheduler.security;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.mongodb.ConnectionString;

/** {@inheritDoc} */
public class BaseCredentialsRetriever implements CredentialsRetriever {
  @Override
  public ConnectionString getMongoDbClientConnectionString() {
    SecretClient secretClient =
        new SecretClientBuilder()
            .vaultUrl("https://courseschedulerkeyvault.vault.azure.net/")
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

    return new ConnectionString(secretClient.getSecret("MongoDbProdConnectionString").getValue());
  }
}
