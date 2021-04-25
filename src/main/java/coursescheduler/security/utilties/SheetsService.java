package coursescheduler.security.utilties;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class SheetsService {

    private static final String APPLICATION_NAME = "Course Scheduler";

    private static Sheets service = null;

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        if (service != null) {
            return service;
        }
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = GoogleAuthUtil.authorize(HTTP_TRANSPORT);
        return service = new Sheets.Builder(
                HTTP_TRANSPORT,
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
