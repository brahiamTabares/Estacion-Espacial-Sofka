package sofka.estacionEspacial.servicios;

import sofka.estacionEspacial.entidades.Lanzadera;
import sofka.estacionEspacial.entidades.Nave;
import sofka.estacionEspacial.entidades.NoTripulada;

import java.util.List;

public interface NaveServicio {

    //listar Naves Espaciales

    List<Nave> listarNaves() throws Exception;

    //Gestion de Naves tipó lanzadera
    Lanzadera registrarLanzadera(Lanzadera lanzadera)throws Exception;
    Lanzadera actualizarLanzadera(Lanzadera lanzadera) throws Exception;
     Lanzadera buscarLanzadera(Lanzadera lanzadera) throws Exception;

    //Gestion de naves no tripuladas

    NoTripulada registrarNoTripulada(NoTripulada noTripulada) throws Exception;
    NoTripulada actualizarNoTripulada(NoTripulada noTripulada) throws Exception;
    NoTripulada buscarNoTripulada(NoTripulada  noTripulada) throws Exception ;

    //Metodo para eliminar Naves
     void eliminarNave(String idNave) throws Exception;


}
