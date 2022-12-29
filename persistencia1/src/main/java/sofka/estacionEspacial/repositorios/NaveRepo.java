package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.estacionEspacial.entidades.Nave;

import java.util.List;
import java.util.Optional;
/**
 * Esta clase nos permite manejar los datos de la tabla nave en la base de datos
* */
public interface NaveRepo <T extends Nave> extends JpaRepository<T,String> {

}
