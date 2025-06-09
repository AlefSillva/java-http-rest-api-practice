package org.example.api;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApiDeleteItem {
    public void deleteItem(String isbn) {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/simpleapi/items/" + isbn);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int status = connection.getResponseCode();
            System.out.println("DELETE Item - Status Code: " + status);

            connection.disconnect();
        } catch(Exception e) {
            System.out.println("Erro ao deletar item: " + e.getMessage());
        }
    }
}
