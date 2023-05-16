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
        Camioneta camioneta = new Camioneta(String.valueOf(marca), generarAnio(), generarColor(),
                String.valueOf(marca.getPrecio()), tieneTurbo(), generarMotor(automovil),TipoAutomovil.CAMIONETA, tieneModificacion());
        Map<String, Object> mapCamioneta = new HashMap<>();
        mapCamioneta.put("Tipo", camioneta.getTipo());
        mapCamioneta.put("Marca", camioneta.getMarca());
        mapCamioneta.put("Año", camioneta.getAnio());
        mapCamioneta.put("Color", camioneta.getColor());
        mapCamioneta.put("Turbo", camioneta.isTurbo());
        mapCamioneta.put("Motor", camioneta.getMotor());
        mapCamioneta.put("Doble cabina", camioneta.isCabinas());
        mapCamioneta.put("Precio", camioneta.getPrecio());
        return camioneta;
    }
    /*------------------|GENERAR SEDAN|--------------------*/
    private Map<String, Object> generarSedan(){
        Marca marca = generarMarca(0);
        String automovil = String.valueOf(marca).split("_")[0];
        Sedan sedan = new Sedan(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()), tieneTurbo(),
                generarMotor(automovil), TipoAutomovil.SEDAN);
        Map<String, Object> mapSedan = new HashMap<>();
        mapSedan.put("Tipo", sedan.getTipo());
        mapSedan.put("Marca", sedan.getMarca());
        mapSedan.put("Año", sedan.getAnio());
        mapSedan.put("Color", sedan.getColor());
        mapSedan.put("Turbo", sedan.isTurbo());
        mapSedan.put("Motor", sedan.getMotor());
        mapSedan.put("Precio", sedan.getPrecio());
        return mapSedan;
    }
    /*--------------------|GENERAR SUV|-----------------------*/
    private Map<String, Object> generarSuv(){
        Marca marca = generarMarca(10);
        String automovil = String.valueOf(marca).split("_")[0];
        Suv suv = new Suv(String.valueOf(marca), generarAnio(), generarColor(), String.valueOf(marca.getPrecio()), tieneTurbo(),
                generarMotor(automovil), TipoAutomovil.SUV, tieneModificacion());
        Map <String, Object> mapSuv = new HashMap<>();
        mapSuv.put("Tipo", suv.getTipo());
        mapSuv.put("Marca", suv.getMarca());
        mapSuv.put("Año", suv.getAnio());
        mapSuv.put("Color", suv.getColor());
        mapSuv.put("Turbo", suv.isTurbo());
        mapSuv.put("Motor", suv.getMotor());
        mapSuv.put("Sunroof", suv.isSunroof());
        mapSuv.put("Precio", suv.getPrecio());
        return mapSuv;
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
    private void generarAutomoviles(int numeroAutomovilesAGenerar){
        String outputPath = "C:/Users/lilsa/OneDrive/Escritorio";
        String fileName = "automoviles.csv";
        //falta agregar el metodo para convertir esto a csv con openCSV

        String filePath = outputPath + "/" + fileName;
        for (int indice = 0; indice <= numeroAutomovilesAGenerar; indice++){
            Random rnd = new Random();

        }
    }



}
