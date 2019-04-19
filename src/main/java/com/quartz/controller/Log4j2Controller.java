package com.quartz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yubin
 * @date 2019/4/19
 */
@RestController
@RequestMapping("log4j2")
public class Log4j2Controller {

    private static final Logger logger = LoggerFactory.getLogger(Log4j2Controller.class);

    @GetMapping("/test")
    public boolean log4j2(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        return true;
    }
}
