package com.circulosiete.workshop.devops.tests.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("*")
public class HomeController {

  @GetMapping
  public String index(HttpServletRequest request) {
    String uri = request.getRequestURI();
    System.out.println(uri);
    return uri;
  }
}
