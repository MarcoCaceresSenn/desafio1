package ufro.isoft.desafio1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufro.isoft.desafio1.model.Camioneta;
import ufro.isoft.desafio1.model.Sedan;
import ufro.isoft.desafio1.model.Suv;
import ufro.isoft.desafio1.respository.CamionetaRepository;
import ufro.isoft.desafio1.respository.SedanRepository;
import ufro.isoft.desafio1.respository.SuvRepository;

import java.util.*;


@Service
public class FiltroServicio {

@Autowired
CamionetaRepository camionetaRepository;

@Autowired
SedanRepository sedanRepository;

@Autowired
SuvRepository suvRepository;


/*---------------------|Filtro a la Camioneta|-----------------------*/
public List<Camioneta> mostrarFiltradroPrecioCamioneta(String precio){
    if(camionetaRepository.findAllByPrecio(precio).isEmpty()){
        return null;
    }
    return camionetaRepository.findAllByPrecio(precio);
}

public List<Camioneta> mostrarFiltradroColorCamioneta(String color){
    if(camionetaRepository.findAllByColor(color).isEmpty()){
        return null;
    }
    return camionetaRepository.findAllByColor(color);
}



/*-------------------------|Filtro Suv|---------------------------------- */

public List<Suv> mostrarFiltradroPrecioSuv(String precio){
    if(suvRepository.findAllByPrecio(precio).isEmpty()){
        return null;
    }
    return suvRepository.findAllByPrecio(precio);
}

public List<Suv> mostrarFiltradroColorSuv(String color){
    if(suvRepository.findAllByColor(color).isEmpty()){
        return null;
    }
    return suvRepository.findAllByColor(color);
}

/*--------------------------|Filtro Sedan|------------------------------ */

public List<Sedan> mostrarFiltradroPrecioSedan(String precio){
    if(sedanRepository.findAllByPrecio(precio).isEmpty()){
        return null;
    }
    return sedanRepository.findAllByPrecio(precio);
}

public List<Sedan> mostrarFiltradroColorSedan(String color){
    if(sedanRepository.findAllByColor(color).isEmpty()){
        return null;
    }
    return sedanRepository.findAllByColor(color);
}




}
