package com.giantdwarf.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(method = RequestMethod.GET) //이 컨트롤러는 get요청만 받을 수 있음
public class SampleController {

    //@PostMapping @PutMapping @PatchMapping //하나만 쓸때
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT}) //배열로도 가능
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
