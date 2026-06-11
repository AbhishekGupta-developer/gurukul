package com.myorganisation.gurukul.dto.request;

import com.myorganisation.gurukul.enums.Gender;
import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private String course;
    private String phone;
    private String mail;
    private Gender gender;
}
