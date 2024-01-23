package shrishti.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "shrishti.example.config")
@ComponentScan(basePackages = "shrishti.example.Data")
public class MainConfig {
}
