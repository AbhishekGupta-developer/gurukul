package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.request.StudentRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto registerStudent(StudentRequestDto studentRequestDto);
    StudentResponseDto getStudent(Long id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto);
    GenericResponseDto removeStudent(Long id);

    GenericResponseDto  removeAllStudents();
}
