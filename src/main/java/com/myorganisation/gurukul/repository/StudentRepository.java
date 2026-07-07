package com.myorganisation.gurukul.repository;

import com.myorganisation.gurukul.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPA custom finder method
    List<Student> findByCourse(String course);
    List<Student> findByCourseContaining(String course);
    List<Student> findByNameContainingAndCourseContaining(String name, String course);

    // JPQL -> Java Persistence Query Language
    @Query("SELECT s FROM Student s WHERE s.course = :c")
    List<Student> searchStudentsByCourse(@Param("c") String course);

    @Query("SELECT s FROM Student s WHERE s.course LIKE %:c%")
    List<Student> searchStudentsByCourseLike(@Param("c") String course);

    // Native SQL
    @Query(value = "SELECT s.* FROM students s WHERE s.mail LIKE %:email%", nativeQuery = true)
    List<Student> searchStudentsByEmailContaining(@Param("email") String email);

    @Query(value =
            """
            SELECT s.* 
            FROM students s 
            WHERE CAST(s.id AS CHAR) LIKE %:q% 
                OR s.course LIKE %:q% 
                OR s.mail LIKE %:q% 
                OR s.name LIKE %:q% 
                OR s.phone LIKE %:q% 
            """, nativeQuery = true)
    List<Student> searchStudentsGlobally(@Param("q") String q);

}
