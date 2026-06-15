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
        Student student = new Student();
        Long id = studentRepository.generateId();
        student.setId(id);
        student.setName(studentRequestDto.getName());
        student.setCourse(studentRequestDto.getCourse());
        student.setPhone(studentRequestDto.getPhone());
        student.setMail(studentRequestDto.getMail());
        student.setGender(studentRequestDto.getGender());

        studentRepository.getStudentMap().put(id, student);

        Student registeredStudent = studentRepository.getStudentMap().get(id);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(registeredStudent.getId());
        studentResponseDto.setName(registeredStudent.getName());
        studentResponseDto.setCourse(registeredStudent.getCourse());
        studentResponseDto.setPhone(registeredStudent.getPhone());
        studentResponseDto.setMail(registeredStudent.getMail());
        studentResponseDto.setGender(registeredStudent.getGender());

        return studentResponseDto;
    }

    @Override
    public StudentResponseDto getStudent(Long id) {
        Student student = studentRepository.getStudentMap().get(id);
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        if(student != null) {
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setCourse(student.getCourse());
            studentResponseDto.setPhone(student.getPhone());
            studentResponseDto.setMail(student.getMail());
            studentResponseDto.setGender(student.getGender());
        }

        return studentResponseDto;
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
       List<Student> studentList = new LinkedList<>(studentRepository.getStudentMap().values());
       List<StudentResponseDto> studentResponseDtoList = new LinkedList<>();

       for(Student student : studentList) {
           StudentResponseDto studentResponseDto = new StudentResponseDto();
           studentResponseDto.setId(student.getId());
           studentResponseDto.setName(student.getName());
           studentResponseDto.setCourse(student.getCourse());
           studentResponseDto.setPhone(student.getPhone());
           studentResponseDto.setMail(student.getMail());
           studentResponseDto.setGender(student.getGender());

           studentResponseDtoList.add(studentResponseDto);
       }

       return studentResponseDtoList;
    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
        return null;
    }

    @Override
    public GenericResponseDto removeStudent(Long id) {
        return null;
    }
}
