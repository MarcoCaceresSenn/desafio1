package ufro.isoft.desafio1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "camionetas")
public class Camioneta extends Automovil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;
    @Column(name = "cabinas", length = 5, nullable = false)
    private boolean cabinas;

    public Camioneta(String marca, int anio, String color, String precio, boolean turbo, String motor, String tipo, boolean cabinas){
        super(marca, anio, color, precio, turbo, motor);
        this.tipo = tipo;
        this.cabinas = cabinas;
    }
}
