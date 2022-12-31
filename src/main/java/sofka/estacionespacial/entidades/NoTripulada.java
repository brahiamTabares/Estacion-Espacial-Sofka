package sofka.estacionespacial.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)// Se usa cuando hay herencia entre entidades
@Getter
@Setter
public class NoTripulada extends Nave{
    @Column(nullable = false,length = 50)
    public String tipoNaveNoTripulada;

    public NoTripulada(UUID idNave, String nombre, String tipoNave, String tipoCombustible, double peso, double capacidadEmpuje, double orbitacion, double altura, int numeroMotores, String tipoNaveNoTripulada) {
        super(idNave, nombre, tipoNave, tipoCombustible, peso, capacidadEmpuje, orbitacion, altura, numeroMotores);
        this.tipoNaveNoTripulada = tipoNaveNoTripulada;
    }

    public  NoTripulada(){
    super();
}
}
