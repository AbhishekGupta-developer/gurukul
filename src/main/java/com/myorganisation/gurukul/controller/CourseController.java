package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.response.CourseResponseDto;
import com.myorganisation.gurukul.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/page")
    public ResponseEntity<Page<CourseResponseDto>> getCoursePage(
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return new ResponseEntity<>(courseService.getCoursePage(pageIndex, size, sortBy, sortOrder), HttpStatus.OK);
    }

}
