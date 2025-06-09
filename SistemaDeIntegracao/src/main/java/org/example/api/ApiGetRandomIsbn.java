package org.example.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiGetRandomIsbn {
    public String getRandomIsbn() {
        String isbn = "";
        try {
            URL url = new URL("https://apichallenges.eviltester.com/simpleapi/randomisbn");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            System.out.println("GET Random ISBN - Status Code: " + status);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            String responseStr = response.toString();
            isbn = responseStr.split(":")[1].replaceAll("[\"}]", "").trim();

            System.out.println("ISBN gerado: " + isbn);

        } catch(Exception e) {
            System.out.println("Erro ao gerar ISBN: " + e.getMessage());
        }
        return isbn;
    }
}
