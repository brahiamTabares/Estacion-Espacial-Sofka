package sofka.estacionEspacial.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import sofka.estacionEspacial.entidades.Tripulada;
import sofka.estacionEspacial.repositorios.TripuladaRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TripuladaTest {
    @Autowired
    private TripuladaRepo<Tripulada> tripuladaRepo;

    @Test // prueba para registrar una nave tripulada
    @Sql("classpath:tripulada.sql")
    public void  registrarTripuladaTest(){
        Tripulada tripulada= new Tripulada("2020","Vostok","Tripulada","petroleo",90.5,128.00,40.8,100,2,7);
        Tripulada tripuladaRegistrada=tripuladaRepo.save(tripulada);
        Assertions.assertNotNull(tripuladaRegistrada);

    }
    @Test // prueba para registrar una nave tripulada
    @Sql("classpath:tripulada.sql")
    public void  eliminarTripuladaTest(){
        tripuladaRepo.deleteById("1515");
        Tripulada tripuladaRegistrada=tripuladaRepo.findById("1515").orElse(null);
        Assertions.assertNull(tripuladaRegistrada);
    }

    @Test //prueba para actualizar informacion de una nave tripulada
    @Sql("classpath:tripulada.sql")
    public  void actualizarTripuladaTest(){
        Tripulada tripuladaRegistrada=tripuladaRepo.findById("1515").orElse(null);
        tripuladaRegistrada.setNombre("Afrodita");
        tripuladaRepo.save(tripuladaRegistrada);
        Tripulada tripuladaBuscada=tripuladaRepo.findById("1515").orElse(null);
        Assertions.assertEquals("Afrodita",tripuladaBuscada.getNombre());
    }
    @Test // prueba para listar las naves tripuladas
    @Sql("classpath:tripulada.sql")
    public void listarTest(){
        List<Tripulada> tripuladas=tripuladaRepo.findAll();
        tripuladas.forEach(Tripulada-> System.out.println(Tripulada));
    }
}
