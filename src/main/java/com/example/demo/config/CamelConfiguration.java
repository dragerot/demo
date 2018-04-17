package com.example.demo.config;

import com.example.demo.camel.MainRoute;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

    @Bean
    RouteBuilder mainRoute(){
        return new MainRoute();
    }
}
