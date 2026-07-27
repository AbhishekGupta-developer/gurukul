package com.myorganisation.gurukul.dto.response;

import lombok.Data;

@Data
public class CourseResponseDto {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double duration;
    private Double fee;
}
