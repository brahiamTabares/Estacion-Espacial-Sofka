package sofka.estacionEspacial.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import sofka.estacionEspacial.entidades.Nave;
import sofka.estacionEspacial.repositorios.NaveRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NaveTest {

    @Autowired
    private NaveRepo<Nave> naveRepo;


    @Test // prueba para registrar una nave
    @Sql("classpath:nave.sql")
    public void  registrarNaveTest(){
        Nave nave= new Nave("1959","apolo","Tripulada","petroleo",240.0,100.0,43.5,100,2);
         Nave naveRegistrada=naveRepo.save(nave);
        Assertions.assertNotNull(naveRegistrada);

    }
    @Test // prueba para registrar una nave
    @Sql("classpath:nave.sql")
    public void  eliminarNaveTest(){
      naveRepo.deleteById("1717");
      Nave naveRegistrada=naveRepo.findById("1717").orElse(null);
      Assertions.assertNull(naveRegistrada);

    }







    @Test //prueba para actualizar informacion de una nave
    @Sql("classpath:nave.sql")
    public  void actualizarNaveTest(){
        Nave naveRegistrada=naveRepo.findById("1717").orElse(null);
        naveRegistrada.setNombre("prometeo");
        naveRepo.save(naveRegistrada);
        Nave naveBuscada=naveRepo.findById("1779").orElse(null);
        Assertions.assertEquals("prometeo",naveBuscada.getNombre());

    }

}
