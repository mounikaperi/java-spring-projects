package com.springpractice.springcore.games;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public String name() {
        return "sampleName";
    }
}
