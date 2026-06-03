package com.myorganisation.gurukul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @GetMapping
    public ResponseEntity<String> getStudentData(@RequestParam String name, @RequestParam String course, @RequestParam Long phone) {
        System.out.println("Name: " + name + ", Course: " + course + ", Phone: " + phone);
        return new ResponseEntity<>("Get student details!", HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Student> getStudentDetailsInJson(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<String> getProfile(@PathVariable String username) {
        return new ResponseEntity<>("Profile of " + username, HttpStatus.OK);
    }
}
