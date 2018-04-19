package com.example.demo;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${S3.accessKey}")
    String accessKey;

    @Value("${S3.secretKey}")
    String secretkey;

    @Value("${S3.endpoint}")
    String endpoint;

    @Bean
    MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(endpoint,accessKey,secretkey);
    }
}
