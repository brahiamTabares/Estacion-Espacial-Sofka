package sofka.estacionespacial.servicios;


import sofka.estacionespacial.entidades.Nave;
import sofka.estacionespacial.repositorios.NaveRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@ApplicationScoped
public class NaveServicioImp implements NaveServicio {

    private NaveRepo naveRepo;

    public NaveServicioImp() {
    }

    @Inject
    public NaveServicioImp(NaveRepo naveRepo) {
        this.naveRepo = naveRepo;
    }

    /**
     * Permite regristar una nave
     */
    @Override
    public Nave registrar(Nave nave) throws Exception {
        Optional<Nave> naveOptional = naveRepo.buscarPorId(nave.getIdNave());
        if (naveOptional.isPresent()) {
            throw new Exception("Esta nave ya esta registrada " + nave.getIdNave());
        }
        return naveRepo.save(nave);
    }

    /**
     * Permite actualizar una nave
     */
    @Override
    public Nave actualizar(Nave nave) throws Exception {
        Optional<Nave> naveOptional = naveRepo.buscarPorId(nave.getIdNave());
        if (naveOptional.isEmpty()) {
            throw new Exception("Esta nave no esta registrada " + nave.getIdNave());
        }
        return naveRepo.save(nave);
    }

    /**
     * Permite buscar una nave por su nombre
     */
    @Override
    public Optional<Nave> buscarNave(UUID id) throws Exception {
        return naveRepo.buscarPorId(id);
    }

    /**
     * Permite eliminar una nave
     */
    @Override
    public void eliminar(UUID idNave) throws Exception {
        Optional<Nave> naveOptional = naveRepo.buscarPorId(idNave);
        if (naveOptional.isEmpty()) {
            throw new Exception("Esta nave no esta registrada " +idNave);
        }
        naveRepo.deleteById(idNave);
    }

    /**
     * Permite buscar un grupo de naves basado en una condicion (predicado)
     */
    @Override
    public Collection<Nave> listar(Predicate<? super Nave> predicate) {
        return naveRepo.listar(predicate);
    }



    /**
     * Permite listar las naves registradas
     */
    @Override
    public Collection<Nave> listarNaves() {
        return naveRepo.listarNaves();
    }

}
