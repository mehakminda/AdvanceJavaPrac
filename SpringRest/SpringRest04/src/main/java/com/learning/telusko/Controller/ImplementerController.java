package com.learning.telusko.Controller;

import com.learning.telusko.pojo.Implementers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/implementers")
public class ImplementerController {

    static List<Implementers> implementersList = new ArrayList<>();


    @GetMapping("/getDetails")
    public ResponseEntity<Implementers> showImplementors(){
        Implementers impl = new Implementers();
        impl.setId(1);
        impl.setName("Mehak");
        impl.setCity("USA EU");
        impl.setHobbies(List.of("Painting","Dancing","Learning"));
        impl.setTeamName(new String[] {"achievers","dreamers","leaders"});
        ResponseEntity<Implementers> response = new ResponseEntity<Implementers>(impl, HttpStatus.OK);
        return response;
        // return new ResponseEntity<Implementers>(impl, HttpStatus.OK);
    }

   @GetMapping("/getDetails/{id}")
    public ResponseEntity<Implementers> getImplementorByID(@PathVariable String id){
        return implementersList.stream().filter(impl -> impl.getId() == Integer.parseInt(id)).findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/getAllDetails")
    public ResponseEntity<List<Implementers>> getAllImplementers(){
        return new ResponseEntity<List<Implementers>>(implementersList,HttpStatus.OK);
    }

    //take data from user: header/body
    @PostMapping("/addImplementor")
    public  ResponseEntity<String> saveImplementorsInfo(@RequestBody Implementers implementers){
        System.out.println("Added obj: "+implementers.toString());
        boolean isDataAdded = implementersList.add(implementers);
        String body = "Updating ..";
        if(isDataAdded) body = "Updated successfully";
        else body = "Update Failed";
        return new ResponseEntity<String>(body,HttpStatus.OK);

    }

    @DeleteMapping("/deleteImplementor/{id}")
    public  ResponseEntity<String> deleteImplementorById(@PathVariable String id){
        boolean isDeleted =  implementersList.removeIf(implementers -> implementers.getId()== Integer.parseInt(id));
       String body;
       if(isDeleted) body = "Delete Successfull";
       else body = "Specified Id doesnt exist";
       return new ResponseEntity<String>(body,HttpStatus.OK);

    }
}



/**
 *Everything is taken care by jackson
 * all types of json property: string, array, list, string ,boolean
 *
 * GET: localhost:8080/mehak/api/implementers/getDetails
 *
 * {
 *     "city": "USA EU",
 *     "hobbies": [
 *         "Painting",
 *         "Dancing",
 *         "Learning"
 *     ],
 *     "id": 1,
 *     "name": "Mehak",
 *     "teamName": [
 *         "achievers",
 *         "dreamers",
 *         "leaders"
 *     ]
 * }
 *
 *
 */
