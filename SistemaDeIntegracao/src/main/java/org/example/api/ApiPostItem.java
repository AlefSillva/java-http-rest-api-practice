package org.example.api;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiPostItem {
    public void createItem(String isbn) {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/simpleapi/items");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInput = "{ \"type\": \"book\", \"isbn13\": \"" + isbn + "\", \"price\": 5.99, \"numberinstock\": 5 }";

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInput.getBytes());
            }

            int status = connection.getResponseCode();
            System.out.println("POST Create Item - Status Code: " + status);

            connection.disconnect();
        } catch(Exception e) {
            System.out.println("Erro ao criar item: " + e.getMessage());
        }
    }
}
