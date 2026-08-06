package com.learning.telusko.springai_demo2;


import com.openai.models.realtime.AudioTranscription;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.tts.TextToSpeechPrompt;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/audio")
public class AudioController {

    private final ChatClient chatClient ;
    private OpenAiAudioTranscriptionModel audioModel;
    private OpenAiAudioSpeechModel speechModel;

    public AudioController(OpenAiAudioSpeechModel speechModel, OpenAiAudioTranscriptionModel audioModel,
            ChatClient.Builder builder){
        this.audioModel = audioModel;
        this.speechModel = speechModel;
        this.chatClient = builder.build();
    }

    @PostMapping("/speech-to-text")
    public String speechToText(@RequestParam MultipartFile file){ // this is called controller method
        AudioTranscriptionPrompt audioTranscriptionPrompt = new AudioTranscriptionPrompt(file.getResource());
        return audioModel.call(audioTranscriptionPrompt)
                .getResult()
                .getOutput();
    }

    @PostMapping("/speech-to-text2")
    public String speechToText2(@RequestParam MultipartFile file , @RequestParam String lang){
        AudioTranscriptionPrompt audioTranscriptionPrompt = new AudioTranscriptionPrompt(file.getResource());
        String response= audioModel.call(audioTranscriptionPrompt)
                .getResult()
                .getOutput();

        //pass this response to ai model and covert it into your preferred language.
        return chatClient.prompt()
                .user("Translate the following  to %s" +lang+ response)
                .call().content();
    }

    @PostMapping("/text-to-speech")
    public byte[] textToSpeech(@RequestParam String prompt){

        OpenAiAudioSpeechOptions options = OpenAiAudioSpeechOptions
                .builder()
                .speed(1.5)
                .voice(OpenAiAudioSpeechOptions.Voice.NOVA)
                .build();



        TextToSpeechPrompt finalPrompt = new TextToSpeechPrompt(prompt, options);

        return speechModel.call(finalPrompt).getResult().getOutput();

    }


}
/***
 *
 * https://www.perplexity.ai/search/b3fe394b-e497-4ca4-ae36-a1a4467d6c59
 *
 * Handler method and controller method
 *
 * A controller is the Spring class that groups request-handling logic, while a handler method is one specific method inside that controller that actually processes a request.
 *  1. Controller = the class, like your AudioController.
 *  2. Handler method = one mapped method inside it, like speechToText() or speechToText2().
 *
 *
 *
 */
