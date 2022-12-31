package sofka.estacionespacial.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)// Se usa cuando hay herencia entre entidades
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Nave implements Serializable {
    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private UUID idNave;
    @Column(nullable = false,length =50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String tipoNave;
    @Column(nullable = false,length = 50)
    private String tipoCombustible;
    @Column(nullable = false)
    private double peso;
    @Column(nullable = false)
    private double capacidadEmpuje;
    @Column(nullable = false)
    private double orbitacion;
    @Column(nullable = false)
    private double altura;
    @Column(nullable = false)
    private int numeroMotores;

    public Nave(){ super();
        idNave = UUID.randomUUID();
    }


}
