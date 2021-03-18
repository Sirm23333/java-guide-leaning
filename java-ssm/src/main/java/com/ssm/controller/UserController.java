package com.ssm.controller;

import com.ssm.pojo.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/")
@RestController
public class UserController {


    @GetMapping("test")
    public Resp test(){
        return Resp.suc();
    }

}
