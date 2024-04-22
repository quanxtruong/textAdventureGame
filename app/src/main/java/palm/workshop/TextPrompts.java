package palm.workshop;

import java.util.Scanner;
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
        
        String context = "You find yourself in the middle of a mystical forest, with a sword, a bow, " +
        "and a magical staff in front of you\nWhat do you do?";
        System.out.println("\nWelcome to this Text Adventure Game!");
        System.out.println(context);

        boolean AOK = true;
        Scanner scan = new Scanner(System.in);
        while (AOK) {
            System.out.print("\nAction: ");
            String userInput = scan.nextLine();
            if (userInput.toString().equals("quit")) {
                AOK = false;
                System.out.println("See you next time adventurer!");
            } else {
                Response<String> response = model.generate("Based on this context: " + context + 
                            ", continue the story with an only one sentence scenario and then ask only one question in a dungeons and dragons style" 
                            + userInput.toString());
                context = "\n" + response.content();
                System.out.println(context); 
            }
        }
        
        scan.close();
        
        

        
    }
}