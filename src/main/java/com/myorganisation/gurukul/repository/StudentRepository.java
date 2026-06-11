package com.myorganisation.gurukul.repository;

import com.myorganisation.gurukul.entity.Student;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class StudentRepository {
    private static Long id = 0L;

    private Map<Long, Student> studentMap = new HashMap<>();

    public Long generateId() {
        return ++id;
    }
}
