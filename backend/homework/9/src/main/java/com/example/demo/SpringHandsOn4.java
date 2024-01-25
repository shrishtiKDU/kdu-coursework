package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication
public class SpringHandsOn4 {
	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringHandsOn4.class).profiles("dev").run(args);
	}

}
