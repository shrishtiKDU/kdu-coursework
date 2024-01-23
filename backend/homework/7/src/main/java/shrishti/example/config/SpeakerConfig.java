package shrishti.example.config;
import org.springframework.context.annotation.Primary;
import shrishti.example.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerConfig {
    @Bean(name = "Sony")
    Speaker speaker1() {
        Speaker speaker = new Speaker();
        speaker.setSpeakerName("Sony");
        speaker.setSpeakerCost(100);
        return speaker;
    }
    @Bean(name = "Bose")
    @Primary
    Speaker speaker2() {
        Speaker speaker = new Speaker();
        speaker.setSpeakerName("Bose");
        speaker.setSpeakerCost(200);
        return speaker;
    }
}

