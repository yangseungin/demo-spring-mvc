package com.giantdwarf.demospringmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    //@PostMapping @PutMapping @PatchMapping //하나만 쓸때
    @RequestMapping(
            value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public String hello() {
        return "hello";
    }

//    @RequestMapping("/**") //배열로도 가능
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
}
