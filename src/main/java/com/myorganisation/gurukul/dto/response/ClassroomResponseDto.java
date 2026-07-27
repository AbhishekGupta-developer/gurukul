package com.myorganisation.gurukul.dto.response;

import lombok.Data;

@Data
public class ClassroomResponseDto {
    private Long id;
    private Long roomNumber;
    private Long floorNumber;
    private Long capacity;
}
