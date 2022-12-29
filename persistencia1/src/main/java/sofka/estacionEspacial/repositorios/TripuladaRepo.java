package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.estacionEspacial.entidades.Tripulada;

public interface TripuladaRepo<T extends Tripulada> extends JpaRepository<T,String>{
}
