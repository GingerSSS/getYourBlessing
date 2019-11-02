package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/*
* @Controller
* @ResponseBody
*
* =
*
* @RestController
* */

@RestController
//@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

//    @GetMapping({"/hello", "/hi"})
    @GetMapping("/say/{id}")
//    @ResponseBody
    public String say(@PathVariable("id") Integer id) {
//        return "This is Ginger's new adventure!";
//        return "description: " + limitConfig.getDescription();
//        return "index";
        return "id:" + id;
    }
}
