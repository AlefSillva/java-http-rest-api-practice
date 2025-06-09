package org.example.exercises.options;

import java.net.HttpURLConnection;
import java.net.URL;

public class OptionsEntities {
    public void checkOptions() {
        try {
            URL url = new URL("https://apichallenges.eviltester.com/sim/entities");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("OPTIONS");
            //------------------------------------------------------

            int statusCode = connection.getResponseCode();
            System.out.println("Status Code: " + statusCode);
            //-------------------------------------------------------

            String allowedMethods = connection.getHeaderField("Allow");
            System.out.println("Métodos permitidos (Allow): " + allowedMethods);

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro na requisição OPTIONS: " + e.getMessage());
        }
    }
}
