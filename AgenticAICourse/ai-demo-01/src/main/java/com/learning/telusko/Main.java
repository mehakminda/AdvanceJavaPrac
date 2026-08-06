package com.learning.telusko;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        String apiKey = System.getenv("");
        String uri = "";
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = """
                {
                "model" : "gpt--4o",
                "message" : [
                    {"role":"system", "content":"You are a helpful assistant."},
                    {"role": "user","content":"Hello! how are you?"}
                ]
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("authorization","Bearer" + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString())''
            System.out.println(response.body());
        }
        catch(Exception e){

        }
    }
}
