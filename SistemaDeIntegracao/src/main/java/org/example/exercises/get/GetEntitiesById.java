package org.example.exercises.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GetEntitiesById {
    public void getEntitiy(int id){
        try {
            URI uri = URI.create("https://apichallenges.eviltester.com/sim/entities/" + id);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("ID: " + id);
            System.out.println("Status Code: " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            reader.close();

            System.out.println("Response:");
            System.out.println(response.toString());
            System.out.println("-----------------------------------");

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro ao buscar entidade: " + id + ": " +  e.getMessage());
        }
    }
}
