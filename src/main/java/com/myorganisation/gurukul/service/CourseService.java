package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.response.CourseResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAllCourseList();

    Page<CourseResponseDto> getCoursePage(int pageIndex, int size, String sortBy, String sortOrder);
}
