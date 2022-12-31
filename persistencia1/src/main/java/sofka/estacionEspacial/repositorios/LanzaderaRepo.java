package sofka.estacionEspacial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofka.estacionEspacial.entidades.Lanzadera;
import sofka.estacionEspacial.entidades.Nave;

import java.util.List;

@Repository
public interface LanzaderaRepo <T extends Lanzadera> extends JpaRepository<T,String> {


    // Usamos Jpql para realizar las consultas  basicas a  nuestra bases de datos
    //listar las naves de tipo lanzadera
    @Query("select l from Lanzadera l")
    List<Lanzadera> listarLanzaderas();
    // buscar una nave dada su id
    @Query("select l from Lanzadera  l where l.idNave= :idnNave")
    Lanzadera buscarLanzaderaPorId(String idNave);
    // buscar una nave dado su nombre
    @Query("select l from Lanzadera  l where l.nombre= :nombre")
    Lanzadera buscarPorNombre(String nombre);
}


