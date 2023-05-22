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
   

    @GetMapping("/listar")
    public List<Automovil> listar(){
       return generatorService.mostrarAutomoviles();
    }

    @RequestMapping("/generar")
    @ResponseBody
    public List<Automovil> generar(@RequestParam("cantidad") int cantidad){
       generatorService.generarAutomoviles(cantidad);
       return generatorService.mostrarAutomoviles();
    }

    @RequestMapping("/filtrar/menores")
    @ResponseBody
    public List<Automovil> filtrarMenores(@RequestParam("precio") int precio) {
        return generatorService.filtrarPrecioMenor(precio);
    }
    @RequestMapping("/filtrar/mayores")
    @ResponseBody
    public List<Automovil> filtrarMayores(@RequestParam("precio") int precio) {
        return generatorService.filtrarPrecioMayor(precio);
    }
  

}
