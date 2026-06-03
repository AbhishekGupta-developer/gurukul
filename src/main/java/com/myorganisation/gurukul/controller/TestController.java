package com.myorganisation.gurukul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> testGetApi() {
        return new ResponseEntity<>("GET API", HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<String> testPostApi() {
        return new ResponseEntity<>("POST API", HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<String> testPutApi() {
        return new ResponseEntity<>("PUT API", HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<String> testPatchApi() {
        return new ResponseEntity<>("PATCH API", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> testDeleteApi() {
        return new ResponseEntity<>("DELETE API", HttpStatus.NO_CONTENT);
    }
}
