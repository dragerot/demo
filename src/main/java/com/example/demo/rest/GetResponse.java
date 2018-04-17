package com.example.demo.rest;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetResponse {
    String key;
    String data;
}
