package ufro.isoft.desafio1.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/automoviles")
//@CrossOrigin("localhost:8080")
 public class AutomovilesController {
    @GetMapping("automoviles")
    public String vistaAutomoviles() {
        return "/vistaAutomoviles";
    }
}
