package org.example.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiGetAll {
    public void getAllItems() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/simpleapi/items");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            System.out.println("GET All Items - Status Code: " + status);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();
            System.out.println("Response:\n" + response.toString());
            connection.disconnect();
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
