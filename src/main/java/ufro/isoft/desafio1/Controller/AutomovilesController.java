package ufro.isoft.desafio1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/automoviles")
public class AutomovilesController {
    @GetMapping("automoviles")
    public String vistaAutomoviles() {
        return "vistaAutom  oviles";
    }
}
