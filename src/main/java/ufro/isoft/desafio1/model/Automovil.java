package ufro.isoft.desafio1.model;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Automovil {
    @Column(name = "marca", length = 20, nullable = false)
    private String marca;
    @Column(name = "anio", length = 4, nullable = false)
    private int anio;
    @Column(name = "color", length = 15, nullable = false)
    private String color;
    @Column(name = "precio", length = 10, nullable = false)
    private String precio;
    @Column(name = "turbo", nullable = false)
    private boolean turbo;
    @Column(name = "motor", length = 5, nullable = false)
    private String motor;

}
