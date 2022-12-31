package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofka.estacionEspacial.entidades.Nave;

import java.util.List;
import java.util.Optional;
/**
 * Esta clase nos permite manejar los datos de la tabla nave en la base de datos
* */
@Repository
public interface NaveRepo <T extends Nave> extends JpaRepository<T,String> {

    // Usamos Jpql para realizar las consultas  basicas a  nuestra bases de datos
    //listar las naves
    @Query("select n from Nave n")
    List<Nave> listarNaves();
    // buscar una nave dada su id
    @Query("select n from Nave  n where n.idNave= :idnNave")
    Nave buscarPorId(String idNave);
    // buscar una nave dado su nombre
    @Query("select n from Nave  n where n.nombre= :nombre")
    Nave buscarPorNombre(String nombre);
    @Query("select n from Nave n where n.tipoCombustible= :combustible")
    Nave buscarCombustible(String combustible);

}
