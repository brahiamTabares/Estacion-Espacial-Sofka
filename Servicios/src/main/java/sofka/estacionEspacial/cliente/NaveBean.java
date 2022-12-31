package sofka.estacionEspacial.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import sofka.estacionEspacial.entidades.Lanzadera;
import sofka.estacionEspacial.entidades.Nave;
import sofka.estacionEspacial.servicios.NaveServicio;

import java.io.Serializable;

public class NaveBean implements Serializable {

    private Nave nave;
    private Lanzadera lanzadera;
    @Autowired
    private NaveServicio naveServicio;

}
