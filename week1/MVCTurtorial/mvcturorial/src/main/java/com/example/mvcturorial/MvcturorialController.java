package com.example.mvcturorial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcturorialController {
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World!";
  }
}
