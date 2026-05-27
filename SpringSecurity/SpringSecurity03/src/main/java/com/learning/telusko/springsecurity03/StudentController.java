package com.learning.telusko.springsecurity03;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,"Mehak","AI"),
            new Student(2, "Ellina", "Java")
    ));


    @GetMapping("students")
    public List<Student> getStudentList(){
        return studentList;
    }
    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        studentList.add(student);
    }
}
/**
 *
 *  rest api: stateful and stateless
 *
 *  make these request stateless.
 *   in stateless we need not even use a csrf token. coz every request is a new request
 */