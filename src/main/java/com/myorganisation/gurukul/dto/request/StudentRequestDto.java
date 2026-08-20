package com.myorganisation.gurukul.dto.request;

import com.myorganisation.gurukul.enums.Gender;
import com.myorganisation.gurukul.enums.StudentRole;
import lombok.Data;

import java.util.Set;

@Data
public class StudentRequestDto {
    private String name;
    private String phone;
    private String email;
    private Gender gender;
    private StudentRole role;
    private String password;
    private Set<Long> courseIds;
}
