package functionalities;

import models.Address;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class AddressQuery {

    public Address CepQuery(String cep) {
        URI address = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(address)
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Address.class);
        } catch (Exception e) {
            throw new RuntimeException("Argumento inválido, por favor, verifique o CEP inserido");
        }
    }
}
