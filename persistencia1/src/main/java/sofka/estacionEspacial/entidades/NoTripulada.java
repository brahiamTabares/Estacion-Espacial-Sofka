package sofka.estacionEspacial.entidades;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)// Se usa cuando hay herencia entre entidades
@Getter
@Setter
public class NoTripulada extends Nave{
    @Column(nullable = false,length = 50)
    public String tipoNaveNoTripulada;
public  NoTripulada(){
    super();
}
}
