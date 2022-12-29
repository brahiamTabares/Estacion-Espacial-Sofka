package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.estacionEspacial.entidades.NoTripulada;

public interface NoTripuladaRepo <T extends NoTripulada> extends JpaRepository<T,String> {
}
