package com.example.demo.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateResponse {
    String key;
    String message;
}
