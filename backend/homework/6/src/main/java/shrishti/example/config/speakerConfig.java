package shrishti.example.config;
import shrishti.example.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class speakerConfig {

    @Bean(name = "Sony")
    speakerService speaker1() {
        speakerService speaker = new speakerService();
        speaker.setSpeakerName("Sony");
        speaker.setSpeakerCost(100);
        return speaker;
    }

    @Bean(name = "Bose")
    speakerService speaker2() {
        speakerService speaker = new speakerService();
        speaker.setSpeakerName("Bose");
        speaker.setSpeakerCost(200);
        return speaker;
    }
}

