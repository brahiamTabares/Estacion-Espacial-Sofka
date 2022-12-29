package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.estacionEspacial.entidades.Lanzadera;

public interface LanzaderaRepo <T extends Lanzadera> extends JpaRepository<T,String> {
}
