package com.giantdwarf.demospringmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Controller
public class SampleController {

    //@PostMapping @PutMapping @PatchMapping //하나만 쓸때
    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/hello")
    @ResponseBody
    public String helloPost() {
        return "hello";
    }

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getEvents(@PathVariable int id) {
        return "events";
    }
    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String deleteEvents(@PathVariable int id) {
        return "events";
    }

//    @RequestMapping("/**") //배열로도 가능
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
}
