package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.response.CourseResponseDto;
import com.myorganisation.gurukul.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCoursesList() {
        return new ResponseEntity<>(courseService.getAllCourseList(), HttpStatus.OK);
    }

}
