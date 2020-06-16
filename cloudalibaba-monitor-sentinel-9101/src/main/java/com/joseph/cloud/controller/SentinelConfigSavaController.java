package com.joseph.cloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [
 *     {
 *         "resource":"/monitor/config/save",
 *         "limitApp":"default",
 *         "grade":1,
 *         "count":1,
 *         "strategy":0,
 *         "controlBehavior":0,
 *         "clusterMode":false
 *     }
 * ]
 */


@RestController
@RequestMapping("/monitor")
public class SentinelConfigSavaController {

    @GetMapping("/config/save")
    public String save() {
        return "*******************save...save...save";
    }


}
