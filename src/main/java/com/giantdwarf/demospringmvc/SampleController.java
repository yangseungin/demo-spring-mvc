package com.giantdwarf.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    //@PostMapping @PutMapping @PatchMapping //하나만 쓸때
    @RequestMapping("/yang")
    @ResponseBody
    public String helloYang() {
        return "hello yang";
    }

//    @RequestMapping("/**") //배열로도 가능
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
}
