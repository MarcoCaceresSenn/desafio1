package ufro.isoft.desafio1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufro.isoft.desafio1.model.Automovil;
import ufro.isoft.desafio1.service.GeneratorService;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
@CrossOrigin("http://localhost:8081/")
public class InitController {
    @Autowired
    GeneratorService generatorService;
   
    @RequestMapping("/generar")
    @ResponseBody
    public List<Automovil> generar(@RequestParam("cantidad") int cantidad){
       generatorService.generarAutomoviles(cantidad);
       return generatorService.mostrarAutomoviles();
    }

    @GetMapping("/filtrar/menores/{precio}")
    public List<Automovil> filtrarMenores(@PathVariable int precio) {
        return generatorService.filtrarPrecioMenor(precio);
    }
    @GetMapping("/filtrar/mayores/{precio}")
    public List<Automovil> filtrarMayores(@PathVariable int precio) {
        return generatorService.filtrarPrecioMayor(precio);
    }
    /**/

}
