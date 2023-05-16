package ufro.isoft.desafio1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufro.isoft.desafio1.service.TipoAutomovil;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "camionetas")
public class Camioneta extends Automovil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo")
    private TipoAutomovil tipo;
    @Column(name = "cabinas", nullable = false)
    private boolean cabinas;

    public Camioneta(String marca, int anio, String color, String precio, boolean turbo, String motor, TipoAutomovil tipo, boolean cabinas){
        super(marca, anio, color, precio, turbo, motor);
        this.tipo = tipo;
        this.cabinas = cabinas;
    }
}
