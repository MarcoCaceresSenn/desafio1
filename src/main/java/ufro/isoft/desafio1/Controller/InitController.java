package ufro.isoft.desafio1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
