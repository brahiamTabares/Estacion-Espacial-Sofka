package sofka.estacionespacial.repositorios;

import sofka.estacionespacial.entidades.Nave;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Esta clase nos permite manejar los datos de la tabla nave en la base de datos
* */
public interface NaveRepo   {

    /**
     * Permite obtener todas las naves registradas
     */
    Collection<Nave> getAll();

    /**
     * Permite guardar una nave
     */
    Nave save(Nave nave);

    /**
     * Permite obtener una nave a partir de su id
     */
    Optional<Nave> findById(UUID id);

    /**
     * Permite remover una nave
     */
    void deleteById(UUID id);

    /**
     * Permite obtener el número de naves almacenadas
     */
    long count();

    // Usamos Jpql para realizar las consultas  basicas a  nuestra bases de datos
    //listar las naves
//    @Query("select n from Nave n")
    Collection<Nave> listarNaves();
    // buscar una nave dada su id
//    @Query("select n from Nave  n where n.idNave= :idnNave")
    Optional<Nave> buscarPorId(UUID idNave);
    // buscar una nave dado su nombre
//    @Query("select n from Nave  n where n.nombre= :nombre")
    Optional<Nave> buscarPorNombre(String nombre);
//    @Query("select n from Nave n where n.tipoCombustible= :combustible")
    Collection<Nave> buscarCombustible(String combustible);

    Collection<Nave> listar(Predicate<? super Nave> predicate);
}
