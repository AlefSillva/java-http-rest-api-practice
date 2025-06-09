package org.example.exercises.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GetEntities {
    public void getEntities() {
        try {
            // Criando a conexão HTTP
            URI uri = URI.create("https://apichallenges.eviltester.com/sim/entities");
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code: " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();
            System.out.println("Response:");
            System.out.println(response.toString().replace("},{", "},\n{"));


            connection.disconnect();

        } catch (IOException e) {
            System.out.println("Eror: " + e.getMessage());
        }
    }
}
