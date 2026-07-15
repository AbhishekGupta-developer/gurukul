package com.myorganisation.gurukul.dto.response;

import com.myorganisation.gurukul.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleResponseDto {
    private Long id;
    private VehicleType type;
    private String registrationNumber;
    private Long studentId;
}
