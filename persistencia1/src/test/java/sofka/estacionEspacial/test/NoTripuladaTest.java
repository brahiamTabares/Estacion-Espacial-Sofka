package sofka.estacionEspacial.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import sofka.estacionEspacial.entidades.NoTripulada;
import sofka.estacionEspacial.repositorios.NoTripuladaRepo;


import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NoTripuladaTest {


    @Autowired
    private NoTripuladaRepo<NoTripulada> noTripuladaRepo;

    @Test // prueba para registrar una nave no tripulada
    @Sql("classpath:noTripulada.sql")
    public void  registrarNoTripuladaTest(){
        NoTripulada noTripulada= new NoTripulada("3030","Explorer","noTripulada","celdas fotovoltaicas",100.5,200.00,25.6,150,4,"satelite");
        NoTripulada noTripuladaRegistrada=noTripuladaRepo.save(noTripulada);
        Assertions.assertNotNull(noTripuladaRegistrada);

    }
    @Test // prueba para registrar una nave no tripulada
    @Sql("classpath:noTripulada.sql")
    public void  eliminarNoTripuladaTest(){
        noTripuladaRepo.deleteById("3031");
        NoTripulada noTripuladaRegistrada=noTripuladaRepo.findById("3031").orElse(null);
        Assertions.assertNull(noTripuladaRegistrada);
    }

    @Test //prueba para actualizar informacion de una nave no tripulada
    @Sql("classpath:noTripulada.sql")
    public  void actualizarNaveTest(){
        NoTripulada noTripuladaRegistrada=noTripuladaRepo.findById("3031").orElse(null);
        noTripuladaRegistrada.setNombre("CEO");
        noTripuladaRepo.save(noTripuladaRegistrada);
        NoTripulada noTripuladaBuscada=noTripuladaRepo.findById("3031").orElse(null);
        Assertions.assertEquals("CEO",noTripuladaBuscada.getNombre());
    }
    @Test // prueba para listar las naves no tripuladas
    @Sql("classpath:noTripulada.sql")
    public void listarTest(){
        List<NoTripulada> noTripuladas=noTripuladaRepo.findAll();
        noTripuladas.forEach(NoTripulada-> System.out.println(NoTripulada));
    }

}


