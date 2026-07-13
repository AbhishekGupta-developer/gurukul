package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.request.StudentRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.StudentResponseDto;
import com.myorganisation.gurukul.entity.Student;
import com.myorganisation.gurukul.entity.Vehicle;
import com.myorganisation.gurukul.repository.StudentRepository;
import com.myorganisation.gurukul.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private VehicleRepository vehicleRepository;

    @Override
    public StudentResponseDto registerStudent(StudentRequestDto studentRequestDto) {
        Student student = mapStudentRequestDtoToStudent(new Student(), studentRequestDto);

        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber("NOT REGISTERED YET");

//        vehicleRepository.save(vehicle);

        student.setVehicle(vehicle);
        vehicle.setStudent(student);

        studentRepository.save(student);

//        vehicle.setStudent(student);
//        vehicleRepository.save(vehicle);


        return mapStudentToStudentResponseDto(student);
    }

    @Override
    public StudentResponseDto getStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null) {
            return mapStudentToStudentResponseDto(student);
        }
        return null;
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
       List<Student> studentList = studentRepository.findAll();
       return mapStudentListToStudentResponseDtoList(studentList);
    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null) {
            mapStudentRequestDtoToStudent(student, studentRequestDto);
            studentRepository.save(student);
            return mapStudentToStudentResponseDto(student);
        }
        return null;
    }

    @Override
    public GenericResponseDto removeStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();

        if(student != null) {
            String name = student.getName();
            studentRepository.deleteById(id);
            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("Student name: " + name + " (" + id + ") has been removed!");
        } else {
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("Student ID: " + id + " doesn't exist");
        }

        return genericResponseDto;
    }

    @Override
    public GenericResponseDto removeAllStudents() {
        studentRepository.deleteAll();

        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(true);
        genericResponseDto.setMessage("All students have been removed!");

        return genericResponseDto;
    }

    @Override
    public List<StudentResponseDto> searchStudentsByCourse(String course) {
//        List<Student> studentList = studentRepository.findByCourse(course);
        List<Student> studentList = studentRepository.searchStudentsByCourse(course);

        return mapStudentListToStudentResponseDtoList(studentList);
    }

    @Override
    public List<StudentResponseDto> searchStudentsByCourseContaining(String course) {
//        List<Student> studentList = studentRepository.findByCourseContaining(course);
        List<Student> studentList = studentRepository.searchStudentsByCourseLike(course);
        return mapStudentListToStudentResponseDtoList(studentList);
    }

    @Override
    public List<StudentResponseDto> searchStudentsByNameContainingAndCourseContaining(String name, String course) {
        List<Student>  studentList = studentRepository.findByNameContainingAndCourseContaining(name, course);
        return mapStudentListToStudentResponseDtoList(studentList);
    }

    @Override
    public List<StudentResponseDto> searchStudentsByEmail(String email) {
        List<Student> studentList = studentRepository.searchStudentsByEmailContaining(email);
        return mapStudentListToStudentResponseDtoList(studentList);
    }

    @Override
    public List<StudentResponseDto> searchStudentsGlobally(String q) {
        List<Student> studentList = studentRepository.searchStudentsGlobally(q);

        return mapStudentListToStudentResponseDtoList(studentList);
    }


    // helper methods

    // Map StudentRequestDto to Student
    private Student mapStudentRequestDtoToStudent(Student student, StudentRequestDto studentRequestDto) {
        student.setName(studentRequestDto.getName());
        student.setCourse(studentRequestDto.getCourse());
        student.setPhone(studentRequestDto.getPhone());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());

        return student;
    }

    // Map Student to StudentResponseDto
    private StudentResponseDto mapStudentToStudentResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setCourse(student.getCourse());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setGender(student.getGender());
        studentResponseDto.setVehicle(student.getVehicle());

        return studentResponseDto;
    }

    // Map Student List to StudentResponseDto List
    private List<StudentResponseDto> mapStudentListToStudentResponseDtoList(List<Student> studentList) {
        List<StudentResponseDto> studentResponseDtoList = new LinkedList<>();

        for(Student student : studentList) {
            StudentResponseDto studentResponseDto = mapStudentToStudentResponseDto(student);
            studentResponseDtoList.add(studentResponseDto);
        }

        return studentResponseDtoList;
    }
}
