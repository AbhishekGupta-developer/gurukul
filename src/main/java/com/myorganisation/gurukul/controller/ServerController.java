package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.response.ServerStatusResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {
    @GetMapping
    public ResponseEntity<ServerStatusResponseDto> serverStatus() {
        return new ResponseEntity<>(new ServerStatusResponseDto(), HttpStatusCode.valueOf(200));
    }
}






















