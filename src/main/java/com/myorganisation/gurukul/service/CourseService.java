package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAllCourseList();
}
