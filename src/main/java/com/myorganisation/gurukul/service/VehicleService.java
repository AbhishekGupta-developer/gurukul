package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.request.VehicleRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.VehicleResponseDto;

public interface VehicleService {
    VehicleResponseDto registerVehicle(VehicleRequestDto vehicleRequestDto);
    VehicleResponseDto getVehicleById(Long vehicleId);
    VehicleResponseDto getVehicleByRegistrationNumber(String registrationNumber);
    VehicleResponseDto getVehicleByStudentId(Long studentId);
    VehicleResponseDto updateVehicle(VehicleRequestDto vehicleRequestDto);
    GenericResponseDto removeVehicle(Long vehicleId);
}
