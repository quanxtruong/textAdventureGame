package palm.workshop;

import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.vertexai.VertexAiLanguageModel;

public class TextPrompts {
    public static void main(String[] args) {
        VertexAiLanguageModel model = VertexAiLanguageModel.builder()
            .endpoint("us-central1-aiplatform.googleapis.com:443")
            .project("bionic-baton-421000")
            .location("us-central1")
            .publisher("google")
            .modelName("text-bison@001")
            .maxOutputTokens(500)
            .build();

        Response<String> response = model.generate("What do you do if you fight this big dragon?");

        System.out.println(response.content());
    }
}