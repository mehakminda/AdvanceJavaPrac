package com.learning.telusko;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.telusko.pojo.Implementer;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws JsonProcessingException {

        //Java object to json
        Implementer impl= new Implementer();
        impl.setId(1);
        impl.setName("Mehak");
        impl.setCity("USA");

        //print the same in json by using jackson
        ObjectMapper objectMapper= new ObjectMapper();
        String json = objectMapper.writeValueAsString(impl);
        System.out.println(json);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(impl));
        System.out.println("----------------------------------");

        //multiple implementers object
        Implementer impl2= new Implementer();
        impl2.setId(1);
        impl2.setName("Mehak");
        impl2.setCity("Europe");

        List<Implementer> implementerList = List.of(impl,impl2);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(implementerList));

    }
}
