package com.example.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restservice")
public class restservice {

    @RequestMapping(
            value = "/create",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.POST
    )
    ResponseEntity<CreateResponse> create(@RequestBody CreateRequest createRequest ){
                return ResponseEntity.ok(CreateResponse
                        .builder()
                        .key(createRequest
                                .getKey())
                        .build());
    }

    @RequestMapping(
            value = "/get/{key}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    ResponseEntity<GetResponse> get(@PathVariable String key){
        return ResponseEntity.ok(GetResponse
                .builder()
                .key(key).data("noedata").build());
    }
}
