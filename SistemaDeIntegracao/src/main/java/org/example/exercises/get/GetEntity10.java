package org.example.exercises.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetEntity10 {
    public void getEntity10() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities/10");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code (GET): " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();
            connection.disconnect();

            System.out.println("Response (GET):");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Erro ao recuperar entidade 10: " + e.getMessage());
        }
    }
}
