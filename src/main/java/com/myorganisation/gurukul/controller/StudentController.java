package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.request.StudentRequestDto;
import com.myorganisation.gurukul.dto.response.StudentResponseDto;
import com.myorganisation.gurukul.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> registerStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(studentService.registerStudent(studentRequestDto), HttpStatusCode.valueOf(201));
    }
}
