package sofka.estacionespacial.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lanzadera extends Nave implements Serializable{
    @Column(nullable = false)
   private double capacidadTransporte;
    @Column(nullable = false)
    private String tipoTransporte;

    @Builder
    public Lanzadera(UUID idNave, String nombre, String tipoNave, String tipoCombustible, double peso, double capacidadEmpuje, double orbitacion, double altura, int numeroMotores, double capacidadTransporte, String tipoTransporte) {
        super(idNave, nombre, tipoNave, tipoCombustible, peso, capacidadEmpuje, orbitacion, altura, numeroMotores);
        this.capacidadTransporte = capacidadTransporte;
        this.tipoTransporte = tipoTransporte;
    }

}
