package com.giantdwarf.demospringmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @ExceptionHandler
    public ResponseEntity errorHandler(){
        return ResponseEntity.badRequest().body("can't create event");
    }

    @PostMapping
//    @ResponseBody @RestController가 붙은경우 생략 가
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }
}
