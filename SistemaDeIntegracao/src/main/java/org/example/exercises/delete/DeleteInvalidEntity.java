package org.example.exercises.delete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteInvalidEntity {
    public void DeleteEntity2() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities/2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int statusCode = connection.getResponseCode();
            System.out.println("DELETE Status Code: " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream() != null
                            ? connection.getErrorStream()
                            : connection.getInputStream())
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
            System.out.println("Erro ao tentar deletar a entidade 2: " + e.getMessage());
        }
    }
}

