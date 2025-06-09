package org.example.exercises.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GetEntitiesWithParams {
    public void getEntitiesWithParams() {
        try {
            // Parâmetros fictícios
            String categoria = "teste";
            int limite = 5;

            String urlComParametros = "https://apichallenges.eviltester.com/sim/entities" +
                    "?categoria=" + categoria + "&limite=" + limite;

            URI uri = URI.create(urlComParametros);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            System.out.println("URL Final: " + urlComParametros);
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
            System.out.println(response.toString());
            System.out.println("-----------------------------------");

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro na requisição com parâmetros: " + e.getMessage());
        }
    }
}
