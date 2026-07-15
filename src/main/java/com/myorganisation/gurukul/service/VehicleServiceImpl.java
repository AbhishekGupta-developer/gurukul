package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.request.VehicleRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.VehicleResponseDto;
import com.myorganisation.gurukul.entity.Student;
import com.myorganisation.gurukul.entity.Vehicle;
import com.myorganisation.gurukul.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private StudentService studentService;

    @Override
    public VehicleResponseDto registerVehicle(VehicleRequestDto vehicleRequestDto) {
        Long studentId = vehicleRequestDto.getStudentId();

        Student student = studentService.getStudentEntity(studentId);

        if(student == null) {
            throw new RuntimeException("Student doesn't exist");
        }

        if(student.getVehicle() != null) {
            throw new RuntimeException("Vehicle already exists");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleRequestDto.getType());
        vehicle.setRegistrationNumber(vehicleRequestDto.getRegistrationNumber());
        vehicle.setStudent(student);
        student.setVehicle(vehicle);

        vehicleRepository.save(vehicle);

        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
        vehicleResponseDto.setId(vehicle.getId());
        vehicleResponseDto.setType(vehicle.getType());
        vehicleResponseDto.setRegistrationNumber(vehicle.getRegistrationNumber());
        vehicleResponseDto.setStudentId(studentId);

        return vehicleResponseDto;
    }

    @Override
    public VehicleResponseDto getVehicleById(Long vehicleId) {
        return null;
    }

    @Override
    public VehicleResponseDto getVehicleByRegistrationNumber(String registrationNumber) {
        return null;
    }

    @Override
    public VehicleResponseDto getVehicleByStudentId(Long studentId) {
        return null;
    }

    @Override
    public VehicleResponseDto updateVehicle(VehicleRequestDto vehicleRequestDto) {
        return null;
    }

    @Override
    public GenericResponseDto removeVehicle(Long vehicleId) {
        return null;
    }
}
