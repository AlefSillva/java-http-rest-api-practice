package org.example.exercises.post;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostEditEntity {
    public void updateEntity10() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities/10");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInput = "{\"name\": \"atualizado\"}";

            try (DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {
                output.writeBytes(jsonInput);
                output.flush();
            }

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code (POST): " + statusCode);

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

            System.out.println("Response (POST):");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Erro na atualização da entidade 10: " + e.getMessage());
        }
    }
}
