package com.joseph.cloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @GetMapping("/testA")
    public String testA() {
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }


}
