package org.example.exercises.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCreatedEntity {
    public void getEntityId11() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities/11");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code: " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();

            System.out.println("Response:");
            System.out.println(response.toString());

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro ao buscar entidade ID 11: " + e.getMessage());
        }
    }
}
