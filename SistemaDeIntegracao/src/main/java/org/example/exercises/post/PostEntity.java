package org.example.exercises.post;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostEntity {
    public void createEntity() {
        String urlString = "https://apichallenges.eviltester.com/sim/entities";
        String jsonInput = "{\"name\": \"aluno\"}";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviando o corpo da requisição
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonInput);
            outputStream.flush();
            outputStream.close();

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
            connection.disconnect();

            System.out.println("Response Body:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Erro ao enviar POST: " + e.getMessage());
        }
    }
}
