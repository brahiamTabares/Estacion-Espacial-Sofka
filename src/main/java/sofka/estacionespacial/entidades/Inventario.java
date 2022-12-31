package sofka.estacionespacial.entidades;

import one.microstream.integrations.cdi.types.Storage;
import one.microstream.persistence.types.Persister;

import javax.inject.Inject;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Clase que representa de la base de datos. Permite acceder a la información registrada en el sistema,
 */
@Storage
public class Inventario {

    @Inject
    private transient Persister persister;

    private final Map<UUID,Nave> naves;
    /**
     * Contructor de la clase. Encargado de inicializar los elementos de la clase.
     */
    public Inventario() {
        naves = new HashMap<>();
    }

    public void add(Nave nave) {
        Objects.requireNonNull(nave, "nave is required");
        naves.put(nave.getIdNave(),nave);
        persister.store(naves);
    }

    public Collection<Nave> getNaves() {
        return Collections.unmodifiableCollection(naves.values());
    }

    public Optional<Nave> findById(UUID id) {
        return naves.values().stream().filter(nave -> nave.getIdNave() == id).findAny();
    }

    public void deleteById(final UUID id) {
        naves.remove(id);
        persister.store(naves);
    }

    public int size(){
        return naves.size();
    }

    public Optional<Nave> findOne(Predicate< ? super Nave> predicate){
        return naves.values().stream().filter(predicate).findFirst();
    }

    public Collection<Nave> findMany(Predicate< ? super Nave> predicate){
        return naves.values().stream().filter(predicate).collect(Collectors.toList());
    }
}
