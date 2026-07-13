package com.myorganisation.gurukul.dto.response;

import com.myorganisation.gurukul.entity.Vehicle;
import com.myorganisation.gurukul.enums.Gender;
import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private String course;
    private String phone;
    private String email;
    private Gender gender;
    private Vehicle vehicle;
}
