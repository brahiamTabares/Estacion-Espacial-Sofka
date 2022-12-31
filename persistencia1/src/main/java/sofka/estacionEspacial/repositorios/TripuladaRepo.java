package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofka.estacionEspacial.entidades.Nave;
import sofka.estacionEspacial.entidades.Tripulada;
@Repository
public interface TripuladaRepo<T extends Tripulada> extends JpaRepository<T,String>{

    @Query("select t from Tripulada t where t.cantidadTripulacion= :cantidadT")
    Nave buscarcantidadT(String cantidadT);

}
