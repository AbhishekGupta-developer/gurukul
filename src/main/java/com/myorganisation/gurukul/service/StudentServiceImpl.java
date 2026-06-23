package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.dto.request.StudentRequestDto;
import com.myorganisation.gurukul.dto.response.GenericResponseDto;
import com.myorganisation.gurukul.dto.response.StudentResponseDto;
import com.myorganisation.gurukul.entity.Student;
import com.myorganisation.gurukul.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponseDto registerStudent(StudentRequestDto studentRequestDto) {
        Student student = mapStudentRequestDtoToStudent(new Student(), studentRequestDto);
        studentRepository.save(student);
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
       List<StudentResponseDto> studentResponseDtoList = new LinkedList<>();

       for(Student student : studentList) {
           StudentResponseDto studentResponseDto = mapStudentToStudentResponseDto(student);
           studentResponseDtoList.add(studentResponseDto);
       }

       return studentResponseDtoList;
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

    // helper methods

    // Map StudentRequestDto to Student
    private Student mapStudentRequestDtoToStudent(Student student, StudentRequestDto studentRequestDto) {
        student.setName(studentRequestDto.getName());
        student.setCourse(studentRequestDto.getCourse());
        student.setPhone(studentRequestDto.getPhone());
        student.setMail(studentRequestDto.getMail());
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
        studentResponseDto.setMail(student.getMail());
        studentResponseDto.setGender(student.getGender());

        return studentResponseDto;
    }
}
