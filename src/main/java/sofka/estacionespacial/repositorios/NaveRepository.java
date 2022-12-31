package sofka.estacionespacial.repositorios;

import sofka.estacionespacial.entidades.Inventario;
import sofka.estacionespacial.entidades.Nave;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@ApplicationScoped
public class NaveRepository implements NaveRepo{
    @Inject
    private Inventario inventario;

    @Override
    public Collection<Nave> getAll() {
        return inventario.getNaves();
    }

    @Override
    public Nave save(Nave nave) {
        inventario.add(nave);
        return nave;
    }

    @Override
    public Optional<Nave> findById(UUID id) {
        return inventario.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        inventario.deleteById(id);
    }

    @Override
    public long count() {
        return inventario.size();
    }

    @Override
    public Collection<Nave> listarNaves() {
        return getAll();
    }

    @Override
    public Optional<Nave> buscarPorId(UUID idNave) {
        return inventario.findById(idNave);
    }

    @Override
    public Optional<Nave> buscarPorNombre(String nombre) {
        return inventario.findOne( nave -> nave.getNombre().equals(nombre) );
    }

    @Override
    public Collection<Nave> buscarCombustible(String combustible) {
        return inventario.findMany(nave->nave.getTipoCombustible().equals(combustible));
    }

    @Override
    public Collection<Nave> listar(Predicate<? super Nave> predicate) {
        return inventario.findMany(predicate);
    }
}
