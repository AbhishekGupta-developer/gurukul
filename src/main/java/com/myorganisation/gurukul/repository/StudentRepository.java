package com.myorganisation.gurukul.repository;

import com.myorganisation.gurukul.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPA custom finder method
    List<Student> findByCourse(String course);
    List<Student> findByCourseContaining(String course);
    List<Student> findByNameContainingAndCourseContaining(String name, String course);

}
