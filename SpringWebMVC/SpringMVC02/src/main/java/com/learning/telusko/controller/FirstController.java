package com.learning.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @RequestMapping("/welcome") // till spring 4 same annotation for all http method
    //@RequestMapping(value="/home")
    //@RequestMapping(value="/home", method=RequestMethod.GET)
    public String somMessage(Model model){ //Model make this class/project invasive

        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak");
        return "home";  //logicalviewname , there shouls be a jsp file with this name
        //we do no return model and view object but only string, someone is implementing the model and doing all that for us

    }

    @GetMapping("/welcome2") //from spring 4 we have @GetMapping, @PostMapping, @PutMapping and @DeleteMapping along with @RequestMapping("/","Requestmethod.GET) POST,PUT,DELETE
    //If nothing specified by default method is binding to get request
    public String somMessage2(Model model){

        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak2");
        return "home";  //logicalviewname

    }
/*    @GetMapping("/skill")
    public String somImportantMsg(Model model){

        System.out.println("Model class is implemented by : "+model.getClass().getName());
        model.addAttribute("name","Mehak2");
        return "skill";  //logicalviewname

    }*/
@PostMapping("/skill")
public String somImportantMsg(Model model){

    System.out.println("Model class is implemented by : "+model.getClass().getName());
    model.addAttribute("name","Mehak2");
    return "skill";  //logicalviewname

}

}
//This is packaged as jar file, we got only main method no servlet intializer.
//We had to explicitly create webapp folder


//within 1  control class can we have multiple method binded to a http request? yes

//Modelandview class vs model class(no need to set model and view objects , and not need to return model and view object), the BindingAwareModelMap class takes care of it.