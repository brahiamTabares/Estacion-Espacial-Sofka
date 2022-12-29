package sofka.estacionEspacial.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Tripulada extends Nave{
    @Column(nullable = false)
    public int cantidadTripulacion;
}
