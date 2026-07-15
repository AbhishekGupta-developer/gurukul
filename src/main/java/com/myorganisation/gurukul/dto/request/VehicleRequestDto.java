package com.myorganisation.gurukul.dto.request;

import com.myorganisation.gurukul.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestDto {
    private VehicleType type;
    private String registrationNumber;
    private Long studentId;
}
