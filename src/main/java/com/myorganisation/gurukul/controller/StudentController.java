package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.request.StudentRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.StudentResponseDto;
import com.myorganisation.gurukul.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> registerStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(studentService.registerStudent(studentRequestDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentRequestDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<GenericResponseDto> removeStudent(@RequestParam Long id) {
        return new ResponseEntity<>(studentService.removeStudent(id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/all")
    public ResponseEntity<GenericResponseDto> removeAllStudents() {
        return new ResponseEntity<>(studentService.removeAllStudents(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/course/{course}")
    public ResponseEntity<List<StudentResponseDto>> searchStudentsByCourse(@PathVariable String course) {
        return new ResponseEntity<>(studentService.searchStudentsByCourse(course), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/global/course/{course}")
    public ResponseEntity<List<StudentResponseDto>> searchStudentsByCourseContaining(@PathVariable String course) {
        return new ResponseEntity<>(studentService.searchStudentsByCourseContaining(course), HttpStatusCode.valueOf(200));
    }

    @GetMapping("search/global")
    public ResponseEntity<List<StudentResponseDto>> searchStudentsByNameContainingAndCourseContaining(@RequestParam String name,  @RequestParam String course) {
        return new ResponseEntity<>(studentService.searchStudentsByNameContainingAndCourseContaining(name, course), HttpStatusCode.valueOf(200));
    }

}
