package ufro.isoft.desafio1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufro.isoft.desafio1.model.Automovil;
import ufro.isoft.desafio1.model.Camioneta;
import ufro.isoft.desafio1.model.Sedan;
import ufro.isoft.desafio1.model.Suv;
import ufro.isoft.desafio1.service.GeneratorService;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class InitController {
    GeneratorService generatorService;
    @GetMapping("/listar")
    public List<Automovil> index() {
        return generatorService.mostrarAutomoviles();
    }
    @GetMapping("/showSedan")
    public List<Sedan> showSedan() {
        return generatorService.mostrarSedan();
    }
    @GetMapping("/showCamioneta")
    public List<Camioneta> showCamioneta() {
        return generatorService.mostrarCamionetas();
    }
    @GetMapping("/showSuv")
    public List<Suv> showSuv() {
        return generatorService.mostrarSuv();
    }

}
