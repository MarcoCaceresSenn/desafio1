package ufro.isoft.desafio1.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sedan")
public class Sedan extends Automovil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;

    public Sedan(String marca, int anio, String color, String precio, boolean turbo, String motor, String tipo){
        super(marca, anio, color, precio, turbo, motor);
        this.tipo = tipo;
    }
}
