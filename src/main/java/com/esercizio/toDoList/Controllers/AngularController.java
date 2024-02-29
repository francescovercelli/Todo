package com.esercizio.toDoList.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AngularController {
    
    
    @RequestMapping(value = {"/", "/{path:^(?!api$).*$}/**"})
    public String redirectToAngularApp() {
        return "forward:/index.html";
    }
}
