package com.myorganisation.gurukul.exception;

import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<GenericResponseDto> handleStudentNotFoundException(StudentNotFoundException ex) {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(genericResponseDto, HttpStatus.valueOf(404));
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<GenericResponseDto> handleCourseNotFoundException(CourseNotFoundException ex) {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(genericResponseDto, HttpStatus.valueOf(404));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDto> handleException(Exception ex) {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage(ex.getMessage());
//        genericResponseDto.setDetails(ex);

        return new ResponseEntity<>(genericResponseDto, HttpStatus.valueOf(400));
    }
}
