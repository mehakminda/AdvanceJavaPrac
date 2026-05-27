package com.learning.telusko.springsecurity02;


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

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

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
 * for non-get request we are getting .. 401 .. even though we provided username and password
 * so wee need to pass csrf token
 * sessison id  -> can be used to other malicious app - so protect it we need csrf token
 *
 *third party will not have your csrf token
 *
 * same site strict : disable cross site.
 * server.servlet.session.cookie.site=strict
 *
 *
 * rest api: stateful and stateless
 *
 * all these request are statefull . they all have same session id
 * in stateless we need not even use a csrf token. coz every request is a new request
 */