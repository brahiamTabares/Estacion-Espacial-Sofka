package sofka.estacionespacial.servicios;


import sofka.estacionespacial.entidades.Nave;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface NaveServicio {

    //listar Naves Espaciales

    Collection<Nave> listarNaves() ;

    //Gestion de Naves tipó lanzadera
    Nave registrar(Nave nave) throws Exception;

    Nave actualizar(Nave lanzadera) throws Exception;

    Optional<Nave> buscarNave(UUID id) throws Exception;

    void eliminar(UUID idNave) throws Exception;

    Collection<Nave> listar(Predicate<? super Nave> predicate);
}
