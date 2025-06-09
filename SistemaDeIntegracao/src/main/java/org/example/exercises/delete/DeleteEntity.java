package org.example.exercises.delete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteEntity {
    public void deleteAndConfirmNotFound() {
        try {
            // DELETE da entidade 9
            URL deleteUrl = new URL("https://apichallenges.eviltester.com/sim/entities/9");
            HttpURLConnection deleteConnection = (HttpURLConnection) deleteUrl.openConnection();
            deleteConnection.setRequestMethod("DELETE");
            //-------------------------------------------------

            int deleteStatus = deleteConnection.getResponseCode();
            System.out.println("DELETE Status Code: " + deleteStatus);

            deleteConnection.disconnect();
            //-------------------------------------------------

            // Verificar se a foi entidade deletada
            URL getUrl = new URL("https://apichallenges.eviltester.com/sim/entities/9");
            HttpURLConnection getConnection = (HttpURLConnection) getUrl.openConnection();
            getConnection.setRequestMethod("GET");

            int getStatus = getConnection.getResponseCode();
            System.out.println("GET após DELETE - Status Code: " + getStatus);
            //-------------------------------------------------

            if (getStatus == 404) {
                System.out.println("Entidade 9 não encontrada (foi deletada com sucesso).");
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(getConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();
                System.out.println("Resposta: " + response);
            }

            getConnection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro durante o DELETE ou GET: " + e.getMessage());
        }
    }
}

