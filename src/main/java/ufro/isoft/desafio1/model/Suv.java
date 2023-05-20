package ufro.isoft.desafio1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "suv")
public class Suv extends Automovil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;
    @Column(name = "sunroof", nullable = false)
    private String sunroof;

    public Suv(String marca, int anio, String color, String precio, String turbo, String motor, String tipo, String sunroof){
        super(marca, anio, color, precio, turbo, motor);
        this.tipo = tipo;
        this.sunroof = sunroof;
    }
}
