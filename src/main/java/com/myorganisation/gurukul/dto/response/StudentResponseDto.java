package com.myorganisation.gurukul.dto.response;

import com.myorganisation.gurukul.entity.Vehicle;
import com.myorganisation.gurukul.enums.Gender;
import com.myorganisation.gurukul.enums.StudentRole;
import lombok.Data;

import java.util.Set;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Gender gender;
    private StudentRole role;
    private Set<Vehicle> vehicles;
    private Set<CourseResponseDto> courses;
}
