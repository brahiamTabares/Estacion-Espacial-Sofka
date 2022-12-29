package sofka.estacionEspacial.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Lanzadera extends Nave{
    @Column(nullable = false)
   private double capacidadTransporte;
    @Column(nullable = false)
    private String tipoTransporte;

}
