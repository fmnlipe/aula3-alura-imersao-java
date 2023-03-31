import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

// conexão HTTP (protocolo web) com a Api
public class ClienteHttp {
    

    public String buscaDados(String url) {
        
        try {
            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build(); //pegando os dados da API
            HttpResponse<String> response= client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        
        } catch(IOException | InterruptedException exception){
            throw new ClienteHttpException("Deu ruim ao consultar a URL");
        }

      
    }
}
