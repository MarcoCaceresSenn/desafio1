package ufro.isoft.desafio1.service;

public enum Marca {
    /*-------------|SEDAN [0-4]|------------------*/
    SEDAN_CHEVROLET(15990000),
    SEDAN_MAZDA(16990000),
    SEDAN_VOLKSWAGEN(16990000),
    SEDAN_TOYOTA(17490000),
    SEDAN_HYUNDAI(18490000),
    /*--------------|CAMIONETAS [5-9]|-----------*/
    CAMIONETA_NISSAN(20990000),
    CAMIONETA_FORD(21390000),
    CAMIONETA_TOYOTA(21590000),
    CAMIONETA_MITSUBISHI(22190000),
    CAMIONETA_VOLKSWAGEN(22290000),
    /*----------------|SUV [10-14]|------------------*/
    SUV_SUSUKI(14790000),
    SUV_KIA(17990000),
    SUV_NISSAN(18990000),
    SUV_HYUNDAI(19290000),
    SUV_MAZDA(19590000);

    private final int precio;

    Marca(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }

}
