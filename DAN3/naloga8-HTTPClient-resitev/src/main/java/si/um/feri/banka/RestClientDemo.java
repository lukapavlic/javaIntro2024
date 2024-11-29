package si.um.feri.banka;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClientDemo {
	                                         
    static final URI OSEBE_URI = URI.create("http://127.0.0.1:8888/api/v1/osebe");

    HttpClient client = HttpClient.newBuilder().build();
    Jsonb jsonb= JsonbBuilder.create();

    void vseOsebe() throws Exception {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(OSEBE_URI).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    void dodaj(Oseba o) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonb.toJson(o)))
                .header("Content-Type","\tapplication/json")
                .uri(OSEBE_URI)
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.body());
    }

    public static void main(String[] args) throws Exception {
        RestClientDemo client=new RestClientDemo();
        client.vseOsebe();

        //TODO dodajanje bančnega računa na daljavo

        //TODO pregled bančnih računov na daljavo

    }

}
