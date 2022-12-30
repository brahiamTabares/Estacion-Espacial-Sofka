package sofka.estacionEspacial.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import sofka.estacionEspacial.entidades.Lanzadera;
import sofka.estacionEspacial.repositorios.LanzaderaRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LanzaderaTest {

    @Autowired
    private LanzaderaRepo<Lanzadera> lanzaderaRepo;

    @Test // prueba para registrar una nave tipo lanzadera
    @Sql("classpath:lanzadera.sql")
    public void  registrarlanzaderaTest(){
        Lanzadera lanzadera= new Lanzadera("1866","Saturno","Lanzadera","oxido de nitrogeno",150.00,125.00,26.8,250,3,80.5,"Tripulada");
        Lanzadera lanzaderaRegistrada=lanzaderaRepo.save(lanzadera);
        Assertions.assertNotNull(lanzaderaRegistrada);

    }
    @Test // prueba para registrar una nave tipo lanzadera
    @Sql("classpath:lanzadera.sql")
    public void  eliminarlanzaderaTest(){
        lanzaderaRepo.deleteById("1010");
        Lanzadera lanzaderaRegistrada=lanzaderaRepo.findById("1010").orElse(null);
        Assertions.assertNull(lanzaderaRegistrada);

    }

    @Test //prueba para actualizar informacion de una lanzadera
    @Sql("classpath:lanzadera.sql")
    public  void actualizarNaveTest(){
        Lanzadera lanzaderaRegistrada=lanzaderaRepo.findById("1010").orElse(null);
        lanzaderaRegistrada.setNombre("prometeo");
        lanzaderaRepo.save(lanzaderaRegistrada);
        Lanzadera lanzaderaBuscada=lanzaderaRepo.findById("1010").orElse(null);
        Assertions.assertEquals("prometeo",lanzaderaBuscada.getNombre());
    }
    @Test // prueba para listar las naves tipo lanzadera
    @Sql("classpath:lanzadera.sql")
    public void listarTest(){
        List<Lanzadera> lanzaderas=lanzaderaRepo.findAll();
        lanzaderas.forEach(Lanzadera-> System.out.println(Lanzadera));
    }
}
