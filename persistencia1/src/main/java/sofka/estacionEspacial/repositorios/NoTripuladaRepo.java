package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofka.estacionEspacial.entidades.Nave;
import sofka.estacionEspacial.entidades.NoTripulada;

import java.util.List;

@Repository
public interface NoTripuladaRepo <T extends NoTripulada> extends JpaRepository<T,String> {


    // Usamos Jpql para realizar las consultas  basicas a  nuestra bases de datos
    //listar las naves
    @Query("select n from NoTripulada n")
    List<NoTripulada> listarNavesNoTripuladas();

    // buscar una nave dada su id
    @Query("select n from NoTripulada  n where n.idNave= :idnNave")
    NoTripulada buscarNoTripuladaPorId(String idNave);


    // buscar una nave dado su nombre
    @Query("select n from NoTripulada  n where n.nombre= :nombre")
    NoTripulada buscarPorNombre(String nombre);
}
