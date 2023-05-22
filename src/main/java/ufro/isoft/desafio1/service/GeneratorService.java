package ufro.isoft.desafio1.service;

import org.springframework.stereotype.Service;
import ufro.isoft.desafio1.model.Automovil;
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
        return new Camioneta(String.valueOf(marca), generarAnio(), generarColor(),
                String.valueOf(marca.getPrecio()), generarBoolean(), generarMotorCamioneta(),generarPopularidad(),"CAMIONETA", generarBoolean());
    }
    /*------------------|GENERAR SEDAN|--------------------*/
    private Sedan generarSedan(){
        Marca marca = generarMarca(0);
        return new Sedan(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()), generarBoolean(),
                generarMotorSedan(),generarPopularidad(), "SEDAN");
    }
    /*--------------------|GENERAR SUV|-----------------------*/
    private Suv generarSuv(){
        Marca marca = generarMarca(10);
        return new Suv(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()),generarBoolean(),
                generarMotorSuv(),generarPopularidad(), "SUV", generarBoolean());
    }
    /*--------------|GENERAR UN COLOR AL AZAR|---------------*/
    private String generarColor() {
        Random rnd = new Random();
        Color[] colores = Color.values();
        return String.valueOf(colores[rnd.nextInt(5)]);
    }
    /*----------------|CAMIONETA: GENERAR BOOLEAN QUE DEVUELVA TRUE SI CAMIONETA TIENE DOBLE CABINA Y FALSE SI TIENE SOLO UNA|-----------------*/
    /*----------------|SUV: GENERAR BOOLEAN QUE DEVUELVA TRUE SI SUV TIENE SUNROOF Y FALSE SI NO|-----------------*/
    /*----------------|GENERAR UN BOOLEAN QUE DEVUELVA TRUE SI TIENE TURBO Y FALSE SI NO|-----------------*/
    private boolean generarBoolean(){
        Random rnd = new Random();
        return rnd.nextBoolean();
    }

    /*----------------------|GENERAR MOTOR SEGUN TIPO DE AUTOMOVIL|-------------------*/
    private String generarMotorSedan(){
        Random rnd = new Random();
        return crearMotoresSedan().get(rnd.nextInt(crearMotoresSedan().size()));
    }
    private String generarMotorCamioneta(){
        Random rnd = new Random();
        return crearMotoresCamioneta().get(rnd.nextInt(crearMotoresCamioneta().size()));
    }
    private String generarMotorSuv(){
        Random rnd = new Random();
        return crearMotoresSuv().get(rnd.nextInt(crearMotoresSuv().size()));
    }
    private ArrayList<String> crearMotoresSedan(){
        ArrayList<String> motoresSedan = new ArrayList<>();
        guardarMotor(motoresSedan, "1.4cc");
        guardarMotor(motoresSedan, "1.6cc");
        guardarMotor(motoresSedan, "2.0cc");
        return motoresSedan;
    }
    private ArrayList<String> crearMotoresCamioneta(){
        ArrayList<String> motoresCamioneta = new ArrayList<>();
        guardarMotor(motoresCamioneta, "2.4cc");
        guardarMotor(motoresCamioneta, "3.0cc");
        guardarMotor(motoresCamioneta, "4.0cc");
        return motoresCamioneta;
    }
    private ArrayList<String> crearMotoresSuv(){
        ArrayList<String> motoresSuv = new ArrayList<>();
        guardarMotor(motoresSuv, "1.8cc");
        guardarMotor(motoresSuv, "2.2cc");
        guardarMotor(motoresSuv, "2.8cc");
        return motoresSuv;
    }
    private void guardarMotor(ArrayList<String> motores, String motor){
        motores.add(motor);
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
        camionetaRepository.save(generarCamioneta());
    }
    private void guardarSedan(){
        sedanRepository.save(generarSedan());
    }
    private void guardarSuv(){
        suvRepository.save(generarSuv());
    }
    /*-------------------------|MOSTRAR LISTA DE AUTOMOVILES CREADOS|------------------------*/
    public List<Automovil> mostrarAutomoviles(){
        List<Automovil> automoviles = new ArrayList<>();
        automoviles.addAll(camionetaRepository.findAll());
        automoviles.addAll(sedanRepository.findAll());
        automoviles.addAll(suvRepository.findAll());
        return automoviles;
    }
    /*-----------------------|filtrar precio < numero ingresado|-----------------------*/
    public List<Automovil> filtrarPrecioMenor(int numero){
        List<Automovil> automoviles = agregarAutomoviles();
        List<Automovil> automovilesFiltrados = new ArrayList<>();
        for (Automovil automovil : automoviles){
            if (Integer.parseInt(automovil.getPrecio()) < numero){
                automovilesFiltrados.add(automovil);
            }
        }
        return automovilesFiltrados;
    }
    /*-----------------------|filtrar precio > numero ingresado|-----------------------*/
    public List<Automovil> filtrarPrecioMayor(int numero){
        List<Automovil> automoviles = agregarAutomoviles();
        List<Automovil> automovilesFiltrados = new ArrayList<>();
        for (Automovil automovil : automoviles){
            if (Integer.parseInt(automovil.getPrecio()) > numero){
                automovilesFiltrados.add(automovil);
            }
        }
        return automovilesFiltrados;
    }

    /*-------------------------|agregar automoviles a lista|-----------------------*/
    private List<Automovil> agregarAutomoviles(){
        List<Automovil> automoviles = new ArrayList<>();
        automoviles.addAll(camionetaRepository.findAll());
        automoviles.addAll(sedanRepository.findAll());
        automoviles.addAll(suvRepository.findAll());
        return automoviles;
    }


    private String generarPopularidad(){
        Random rnd=new Random();
       
        return  String.valueOf(rnd.nextInt(20000)); 
    }



}
