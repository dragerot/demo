package com.example.demo.rest;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateRequest {
    private String key;
    private String data;
}
