package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.response.CourseResponseDto;
import com.myorganisation.gurukul.entity.Course;
import com.myorganisation.gurukul.exception.CourseNotFoundException;
import com.myorganisation.gurukul.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResponseDto> getAllCourseList() {
        List<Course> courseList = courseRepository.findAll();

        if(courseList.isEmpty()){
            throw new CourseNotFoundException("We haven't added any course yet! (कार्य प्रगति पर है)");
        }

        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();

        for(Course c : courseList) {
            courseResponseDtoList.add(mapCourseToCourseResponseDto(c));
        }

        return courseResponseDtoList;
    }

    @Override
    public Page<CourseResponseDto> getCoursePage(int pageIndex, int size, String sortBy, String sortOrder) {

        Sort sort = sortOrder.equalsIgnoreCase("DESC") ?
                Sort.by(Sort.Direction.DESC, sortBy) :
                Sort.by(Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(pageIndex, size, sort);

        Page<Course> coursePage = courseRepository.findAll(pageable);

        Page<CourseResponseDto> courseResponseDtoPage = coursePage.map(
                course -> mapCourseToCourseResponseDto(course)
        );

        return courseResponseDtoPage;
    }


    // helper methods
    // map Course entity to CourseResponse DTO

    private CourseResponseDto mapCourseToCourseResponseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();

        courseResponseDto.setId(course.getId());
        courseResponseDto.setCode(course.getCode());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setDescription(course.getDescription());
        courseResponseDto.setDuration(course.getDuration());
        courseResponseDto.setFee(course.getFee());

        return courseResponseDto;
    }

}
