package istio.demo.preference.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class RecommendationServiceImpl implements RecommendationService {
    @Value("${RECOMMENDATION_URL}")
    private String RECOMMENDATION_URL;

    public java.lang.String getRecommendation() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create("http://" + RECOMMENDATION_URL + "/recommendation")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (InterruptedException| IOException ex) {
            return "Unable to get recommendation";
        }
    }
}
