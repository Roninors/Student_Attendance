package fetchData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) throws Exception{
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://serval-select-totally.ngrok-free.app/api/student/search?search=ronin"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int responseCode = response.statusCode();
            if(responseCode == 200){
                ObjectMapper objectMapper = new ObjectMapper();
                Course[] course  = objectMapper.readValue(String.valueOf(response.body()), new TypeReference<Course[]>() {});
                System.out.println(course[0].toString());
            }else{
                System.out.println("Cannot access api");
            }

        }
    }

    }