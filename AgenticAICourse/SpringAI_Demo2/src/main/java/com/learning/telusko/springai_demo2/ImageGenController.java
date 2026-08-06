package com.learning.telusko.springai_demo2;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/image")
public class ImageGenController {
    private final ChatClient chatClient;
    private final OpenAiImageModel imageModel;


    public ImageGenController(OpenAiImageModel imageModel, ChatClient.Builder builder){
        this.imageModel = imageModel;
        chatClient = builder.build();
    }

    @GetMapping("/image-generator/{prompt}")
    public String generateImage(@PathVariable String prompt) throws IOException {
        ImagePrompt imagePrompt = new ImagePrompt(prompt,
                OpenAiImageOptions.builder().quality("high").height(1024).width(1024).build());
        // we can add model here in OpenAIImageOptions or in application properties:
        // spring.ai.openai.image.options.model=gpt-image-1


        ImageResponse imageResponse = imageModel.call(imagePrompt);

        /*String url = imageResponse.getResult().getOutput().getUrl();
        System.out.println(url); //giving null
        return url;*/

        String base64Json = imageResponse.getResult().getOutput().getB64Json();
        System.out.println(">>> \n base64Json : "+base64Json);

        byte[] byteImage = Base64.getDecoder().decode(base64Json);
        System.out.println(">>> \n byteImage: "+byteImage.toString());

        Files.write(Paths.get("ai-generated-image.jpg"),byteImage);

        return "Image generated";
    }

    @GetMapping("/image-generator2/{prompt}")
    public String generateImage2(@PathVariable String prompt) throws IOException {
        ImagePrompt imagePrompt = new ImagePrompt(prompt,
                OpenAiImageOptions.builder().quality("high").height(1024).width(1024).build());


        ImageResponse imageResponse = imageModel.call(imagePrompt);

        String base64Json = imageResponse.getResult().getOutput().getB64Json();


        return "Image generated";
    }

    @PostMapping("/describe-image")
    public String describeImage(@RequestParam String prompt, @RequestParam MultipartFile file){
        return chatClient.prompt()
                .user(us -> us.text(prompt)
                        .media(MimeTypeUtils.IMAGE_JPEG,file.getResource()))
                .call()
                .content();

    }
}

/**
 * User prompt -> image prompt --> OpenAiImageModel -> Base64 -> Decode Base64 -> Save Image
 */