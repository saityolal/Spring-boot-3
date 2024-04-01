package com.springboot.webapplication.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sayhello {

    @RequestMapping("/sayhello")
    public String sayHello() {
        return "Hello MF " ;


    }  @RequestMapping("/sayhello-jsp")
    public String sayHelloJsp() {
        return "sayhello" ;
    }

    @RequestMapping("say-hello-html")
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
