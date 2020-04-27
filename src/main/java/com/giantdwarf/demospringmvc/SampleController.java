package com.giantdwarf.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id,@MatrixVariable String name){
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}")
    @ResponseBody
    public String findPet(
            @MatrixVariable MultiValueMap<String, String> matrixVars,
            @MatrixVariable(pathVar="petId") MultiValueMap<String, String> petMatrixVars) {

        System.out.println(matrixVars.get("q"));
        System.out.println(petMatrixVars.get("q"));

        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
        // petMatrixVars: ["q" : 22, "s" : 23]
        return "owners";
    }


}
