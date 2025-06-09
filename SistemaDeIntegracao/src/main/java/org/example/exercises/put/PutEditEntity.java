package org.example.exercises.put;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PutEditEntity {
    public void updateEntity10Put() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities/10");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInput = "{\"name\": \"atualizado\"}";
            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInput.getBytes());
            }

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code (PUT): " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();

            System.out.println("Response (PUT):");
            System.out.println(response.toString());
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro ao fazer PUT: " + e.getMessage());
        }
    }
}
