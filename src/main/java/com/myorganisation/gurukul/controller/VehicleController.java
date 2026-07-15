package com.myorganisation.gurukul.controller;

import com.myorganisation.gurukul.dto.request.VehicleRequestDto;
import com.myorganisation.gurukul.dto.response.VehicleResponseDto;
import com.myorganisation.gurukul.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDto> registerVehicle(@RequestBody VehicleRequestDto vehicleRequestDto) {
        return new ResponseEntity<>(vehicleService.registerVehicle(vehicleRequestDto), HttpStatusCode.valueOf(201));
    }
}
