package ufro.isoft.desafio1.service;

import org.springframework.stereotype.Service;
import ufro.isoft.desafio1.model.Camioneta;
import ufro.isoft.desafio1.model.Sedan;
import ufro.isoft.desafio1.model.Suv;
import ufro.isoft.desafio1.respository.CamionetaRepository;
import ufro.isoft.desafio1.respository.SedanRepository;
import ufro.isoft.desafio1.respository.SuvRepository;

import java.util.*;

@Service
public class GeneratorService {
    final private CamionetaRepository camionetaRepository;
    final private SedanRepository sedanRepository;
    final private SuvRepository suvRepository;

    public GeneratorService(CamionetaRepository camionetaRepository, SedanRepository sedanRepository, SuvRepository suvRepository) {
        this.camionetaRepository = camionetaRepository;
        this.sedanRepository = sedanRepository;
        this.suvRepository = suvRepository;
    }
    /*-----------------|GENERAR CAMIONETA|------------------*/
    private Camioneta generarCamioneta(){
        Marca marca = generarMarca(5);
        String automovil = String.valueOf(marca).split("_")[0];
        return new Camioneta(String.valueOf(marca), generarAnio(), generarColor(),
                String.valueOf(marca.getPrecio()), tieneTurbo(), generarMotor(automovil),TipoAutomovil.CAMIONETA, tieneModificacion());
    }
    /*------------------|GENERAR SEDAN|--------------------*/
    private Sedan generarSedan(){
        Marca marca = generarMarca(0);
        String automovil = String.valueOf(marca).split("_")[0];
        return new Sedan(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()), tieneTurbo(),
                generarMotor(automovil), TipoAutomovil.SEDAN);
    }
    /*--------------------|GENERAR SUV|-----------------------*/
    private Suv generarSuv(){
        Marca marca = generarMarca(10);
        String automovil = String.valueOf(marca).split("_")[0];
        return new Suv(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()), tieneTurbo(),
                generarMotor(automovil), TipoAutomovil.SUV, tieneModificacion());
    }
    /*--------------|GENERAR UN COLOR AL AZAR|---------------*/
    private String generarColor() {
        Random rnd = new Random();
        Color[] colores = Color.values();
        return String.valueOf(colores[rnd.nextInt(5 - 1) + 1]);
    }
    /*----------------|CAMIONETA: GENERAR BOOLEAN QUE DEVUELVA TRUE SI CAMIONETA TIENE DOBLE CABINA Y FALSE SI TIENE SOLO UNA|-----------------*/
    /*----------------|SUV: GENERAR BOOLEAN QUE DEVUELVA TRUE SI SUV TIENE SUNROOF Y FALSE SI NO|-----------------*/

    private boolean tieneModificacion(){
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
    /*----------------|GENERAR UN BOOLEAN QUE DEVUELVA TRUE SI TIENE TURBO Y FALSE SI NO|-----------------*/
    private boolean tieneTurbo(){
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
    /*----------------------|GENERAR MOTOR SEGUN TIPO DE AUTOMOVIL|-------------------*/
    private String generarMotor(String automovil){
        Random rnd = new Random();
        if (automovil.equals("CAMIONETA")){
            ArrayList<String> motorCamioneta = new ArrayList<>();
            motorCamioneta.add("2.4cc");
            motorCamioneta.add("3.0cc");
            motorCamioneta.add("4.0cc");
            return motorCamioneta.get(rnd.nextInt(motorCamioneta.size()));
        } else if (automovil.equals("SEDAN")) {
            ArrayList<String> motorSedan = new ArrayList<>();
            motorSedan.add("1.4cc");
            motorSedan.add("1.6cc");
            motorSedan.add("2.0cc");
            return motorSedan.get(rnd.nextInt(motorSedan.size()));
        }
        else {
            ArrayList<String> motorSUV = new ArrayList<>();
            motorSUV.add("1.8cc");
            motorSUV.add("2.2cc");
            motorSUV.add("2.8cc");
            return motorSUV.get(rnd.nextInt(motorSUV.size()));
        }
    }
    /*-----------------|GENERAR MARCA AL AZAR SEGUN POSICIÓN INICIAL EN ENUM DE 'MARCAS SEGUN TIPO'|----------------*/
    /*-------------------------|CADA MARCA TIENE ASOCIADO UN PRECIO EN PESOS CHILENOS|-----------------------*/
    private Marca generarMarca(int parametroInicialEnum){/*parametroInicialEnum recibe la posicion inicial dentro del enum de la marca corresponiente a su tipo de vehiculo*/
        Random rnd = new Random();
        Marca[] marcas = Marca.values();
        return marcas[rnd.nextInt((parametroInicialEnum+4) - (parametroInicialEnum) + 1) + (parametroInicialEnum)];
    }
    private int generarAnio(){
        Random rnd = new Random();
        return rnd.nextInt(139)+ 1880;
    }

    /*-----------------------|GENERAR N AUTOMOVILES AL AZAR Y ALMACENAR EN ARCHIVO JSON|----------------------*/
    public void generarAutomoviles(int numeroAutomovilesAGenerar){
        Random rnd = new Random();
        for (int indice = 0; indice <= numeroAutomovilesAGenerar; indice++){
            int indiceAuto = rnd.nextInt(3);
            guardarAutomovilSegunTipo(indiceAuto);
        }
    }
    /*----------------------|GENERAR AUTOMOVILES SEGUN TIPO Y GUARDAR|------------------------*/
    private void guardarAutomovilSegunTipo(int indiceAuto){
        if (indiceAuto == 0){
            guardarSedan();
        } else if (indiceAuto == 1) {
            guardarCamioneta();
        }
        else{
            guardarSuv();
        }
    }
    private void guardarCamioneta(){
        this.camionetaRepository.save(generarCamioneta());
    }
    private void guardarSedan(){
        this.sedanRepository.save(generarSedan());
    }
    private void guardarSuv(){
        this.suvRepository.save(generarSuv());
    }
    /*-------------------------|MOSTRAR LISTA DE AUTOMOVILES CREADOS|------------------------*/
    public void mostrarListaSedanes(){
        sedanRepository.findAll();
        /*mostrar por consola -------- provicional*/
        System.out.println("Lista de Sedanes: ");
        if (sedanRepository.findAll().isEmpty()){
            System.out.println("No hay sedanes");
        }
        else{
            for (Sedan sedan : sedanRepository.findAll()){
                System.out.println(sedan);
            }
        }
    }
    public void mostrarListaCamionetas(){
        camionetaRepository.findAll();
        /*mostrar por consola -------- provicional*/
        System.out.println("Lista de Camionetas: ");
        if (camionetaRepository.findAll().isEmpty()){
            System.out.println("No hay camionetas");
        }
        else{
            for (Camioneta camioneta : camionetaRepository.findAll()){
                System.out.println(camioneta);
            }
        }
    }
    public void mostrarListaSuv(){
        suvRepository.findAll();
        /*mostrar por consola -------- provicional*/
        System.out.println("Lista de SUV: ");
        if (suvRepository.findAll().isEmpty()){
            System.out.println("No hay SUV");
        }
        else{
            for (Suv suv : suvRepository.findAll()){
                System.out.println(suv);
            }
        }
    }


}
