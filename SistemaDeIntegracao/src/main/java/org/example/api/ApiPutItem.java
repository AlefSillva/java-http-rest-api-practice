package org.example.api;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiPutItem {
    public void updateItem(String isbn) {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/simpleapi/items");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInput = "{ \"type\": \"book\", \"isbn13\": \"" + isbn + "\", \"price\": 9.99, \"numberinstock\": 10 }";

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInput.getBytes());
            }

            int status = connection.getResponseCode();
            System.out.println("PUT Update Item - Status Code: " + status);

            connection.disconnect();
        } catch(Exception e) {
            System.out.println("Erro ao atualizar item: " + e.getMessage());
        }
    }
}