package sofka.estacionEspacial.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tripulada extends Nave{
    @Column(nullable = false)
    public int cantidadTripulacion;
    @Builder
    public Tripulada(String idNave, String nombre, String tipoNave, String tipoCombustible, double peso, double capacidadEmpuje, double orbitacion, double altura, int numeroMotores, int cantidadTripulacion) {
        super(idNave, nombre, tipoNave, tipoCombustible, peso, capacidadEmpuje, orbitacion, altura, numeroMotores);
        this.cantidadTripulacion = cantidadTripulacion;
    }
}
