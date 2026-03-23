package com.learning.telusko.controller;

import com.learning.telusko.model.Implementors;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ImplementorsController {

    @GetMapping("/register")
    public String responseHome(){
        return "register";
    }

    //method1 - the traditional way
 /*   @PostMapping("/register")
    public String registerData(Map<String, Object> map, HttpServletRequest request){

        Integer id= Integer.valueOf(request.getParameter("uid")); //we always receive String, but we want to map to other datatype , hence we parse it
        String name= request.getParameter("uname");
        String city= request.getParameter("ucity");
        Long number= Long.valueOf(request.getParameter("unumber"));

        Implementors implementors=new Implementors();
        implementors.setUid(id);
        implementors.setUname(name);
        implementors.setUcity(city);
        implementors.setUnumber(number);

        map.put("regUser", implementors);

        return "results";
    }*/

    //method2
    @PostMapping("/register")
    public String registerData1(Map<String, Object> map, @ModelAttribute("impl") Implementors impl){
        //@ModelAttribute("impl") Implementors impl - hey look spring there is a form, map the field of that form with Implementor class object
        //Implementors class is a model class which has to be binded within our application
        System.out.println(impl.toString());
        map.put("regUser", impl);

        return "results";
    }
}

//Are we able to get the form data as a java object into our application
//Data binding : sending data from view to controller
//data rendering: sending data from controller to view

//Access: http://localhost:8080/implementors/register

/**
 * Flow:
 * We have a form register.jsp with form tag and inputs tag each having unique name
 * Based on this we have to create a model class in app, field types could be anything, but field names must be same as the name attribute of input tag
 * spring does the parsing and mapping using @ModelAttribute - using properties editor internally
 * spring takes string type from form and converts to corresponding field type of the model class
 * Dispatcher servlet will create an object (implementors obj), using setter , the data is injected to that object by spring
 * this object can be given to view component/sent to db/sent to service layer
 *
 */

//spring takes care of - object creation, data injection to object, required datatype conversion , now after this object is ready

//THIS IS UNI-DIRECTIONAL MAPPING (data travels from form to POJO)

//html tags make it unidirectional, to achieve bidirectional biding we need to use Spring Tag library
//bidirectional -> form to pojo, pojo to form



