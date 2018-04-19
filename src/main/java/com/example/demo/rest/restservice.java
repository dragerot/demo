package com.example.demo.rest;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmlpull.v1.XmlPullParserException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/restservice")
public class restservice {

    @Inject
    MinioClient minioClient;

    @RequestMapping(
            value = "/create",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.POST
    )
    ResponseEntity<CreateResponse> create(HttpServletRequest request, @RequestBody CreateRequest createRequest ) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException, InvalidArgumentException {
        String contentType = request.getHeader("Content-Type");
        // Check if the bucket already exists.
        CreateResponse createResponse = CreateResponse
                .builder()
                .key(createRequest
                        .getKey())
                .build();

        boolean isExist = minioClient.bucketExists(createRequest.getDomain());
        if(isExist) {
            System.out.println("domain already exists.");
            createResponse.setMessage("domain already exists.");
           // return ResponseEntity.badRequest().body(createResponse);
        } else {
            // Make a new bucket called domain to hold a zip file of photos.
            minioClient.makeBucket(createRequest.getDomain());
        }

        // Upload the zip file to the bucket with putObject
        minioClient.putObject(createRequest.getDomain(),
                createRequest.getKey(), "c:/temp/s3/Anti.pdf");
        System.out.println("c:/temp/s3/Anti.pdf is successfully uploaded asgetKey to `domain` bucket.");
        return ResponseEntity.ok().body(createResponse);
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
