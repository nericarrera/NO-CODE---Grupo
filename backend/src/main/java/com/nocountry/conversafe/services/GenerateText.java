package com.nocountry.conversafe.services;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GenerateText {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    Client client = Client.builder().apiKey("AIzaSyCy1C-5r5v1S7264FqTFQB6PEIpK_7zbiw").build();

    public void pregunta(String texto){
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash",
                "Analiza el tipo de mensaje siguiente, si es una pregunta, si es una afirmacion y tambien, si notas que esta en un tono negativo dimelo y responde en un formato de este estilo: pregunta= (afirmativo/negativo), afirmacion= si/no, tono= negativo/positivo  " + texto,
                null
        );

        System.out.println(response.text());
    }
}
