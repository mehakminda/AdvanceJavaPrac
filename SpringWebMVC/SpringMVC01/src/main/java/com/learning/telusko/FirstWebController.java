package com.learning.telusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstWebController {

    @RequestMapping("/welcome")
    public ModelAndView displayMessage(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Welcome to telusko learning"); //data in key-value form
        mav.setViewName("index"); //logical view name
        return mav;
    }
    @RequestMapping("/home")
    public ModelAndView displayMessage2(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Spring MVC application"); //data in key-value form
        mav.setViewName("index"); //logical view name
        return mav;
    }
}
/*
this application will be exporting as war, hence by default we had servlet initializer and webcontent folder.
 when running on embedded tomcat, we only need main class and not servlet initializer
  when running on other server, we need servlet initializer.
 */



/**
 * Client -> Request Dispatcher servlet
 * Request Dispatcher  -> Handler mapper (return which controller to go to)
 * Request Dispatcher  -> Controller (return data and logical view name ie just file name not extension)
 * Request Dispatcher  ->  View Resolver (view resolver will decide the file type and file location)
 * Request Dispatcher  -> View (data is rendered in view component)
 *
 */

/**
 * @Controller and @frontController
 *
 * controller gives back 2 thing model data nd logical view name
 *
 *
 * @RequestMapping -> for all http request method until spring 4
 * >spring 4 we have individual annotation for each http method.
 */

//tomcat jasper is required to compile jsp file, hence add dependency, added only when we have jsp as the view part.

//in application, we mention prefix and suffix that is the arrangement done for view resolver to know where to find the view part.
