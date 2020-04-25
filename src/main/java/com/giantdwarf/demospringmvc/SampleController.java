package com.giantdwarf.demospringmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    //@PostMapping @PutMapping @PatchMapping //하나만 쓸때
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/hello")
    @ResponseBody
    public String helloPost() {
        return "hello";
    }

//    @RequestMapping("/**") //배열로도 가능
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
}
