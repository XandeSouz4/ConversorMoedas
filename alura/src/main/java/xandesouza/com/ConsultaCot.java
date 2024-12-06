package xandesouza.com;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;


public class ConsultaCot {
    public Cotacao buscaCot(String cotacao) {
        URI cotar = URI.create("https://v6.exchangerate-api.com/v6/9b850fe9c13f27c73761b46a/latest/" + cotacao);
        HttpRequest request = HttpRequest.newBuilder().uri(cotar).build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cotacao.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Algo saiu errado!");
    }
    
}}
