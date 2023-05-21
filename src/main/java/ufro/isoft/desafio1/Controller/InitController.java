package ufro.isoft.desafio1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufro.isoft.desafio1.model.Automovil;
import ufro.isoft.desafio1.model.Camioneta;
import ufro.isoft.desafio1.model.Sedan;
import ufro.isoft.desafio1.model.Suv;
import ufro.isoft.desafio1.service.FiltroServicio;
import ufro.isoft.desafio1.service.GeneratorService;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class InitController {
    
    @Autowired
    GeneratorService generatorService;

    @Autowired
    FiltroServicio filtro;


    @GetMapping("/crear")
    public void crearAutos() {
    generatorService.generarAutomoviles(5);
    }


    @GetMapping("/listar")
    public List<Automovil> index() {
        return generatorService.mostrarAutomoviles();
    }


    @GetMapping("/listar/camioneta/precio")
    public List<Camioneta> camionetaPrecio() {  
        return filtro.mostrarFiltradroPrecioCamioneta("22190000");
    }


    @GetMapping("/listar/camioneta/color")
    public List<Camioneta> camionetaColor() {  
        return filtro.mostrarFiltradroColorCamioneta("Negro");
    }

    @GetMapping("/listar/suv/precio")
    public List<Suv> suvPrecio() {  
        return filtro.mostrarFiltradroPrecioSuv("19290000");
    }


    @GetMapping("/listar/suv/color")
    public List<Suv> suvColor() {  
        return filtro.mostrarFiltradroColorSuv("Negro");
    }

    @GetMapping("/listar/sedan/precio")
    public List<Sedan> sedanPrecio() {  
        return filtro.mostrarFiltradroPrecioSedan("16990000");
    }


    @GetMapping("/listar/sedan/color")
    public List<Sedan> sedanColor() {  
        return filtro.mostrarFiltradroColorSedan("Negro");
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
