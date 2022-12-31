package sofka.estacionEspacial.servicios;

import org.springframework.stereotype.Service;

import sofka.estacionEspacial.repositorios.*;
import sofka.estacionEspacial.entidades.*;

import java.util.List;

@Service
public class NaveServicioImp implements NaveServicio {

 private final NaveRepo naveRepo;
 private final LanzaderaRepo lanzaderaRepo;
 private final TripuladaRepo tripuladaRepo;
 private final NoTripuladaRepo noTripuladaRepo;

 public NaveServicioImp(NaveRepo naveRepo, LanzaderaRepo lanzaderaRepo, TripuladaRepo tripuladaRepo, NoTripuladaRepo noTripuladaRepo) {
  this.naveRepo = naveRepo;
  this.lanzaderaRepo = lanzaderaRepo;
  this.tripuladaRepo = tripuladaRepo;
  this.noTripuladaRepo = noTripuladaRepo;
 }

 // Metodos para naves tipo lanzadera
/**
*Permite regristar una nave tipo lanzadera
 */
 public Lanzadera registrarLanzadera(Lanzadera lanzadera) throws Exception {
      Lanzadera lanzaderaExistente= lanzaderaRepo.buscarLanzaderaPorId(lanzadera.getIdNave());

  if ( lanzaderaExistente!= null) {
   throw new Exception("Esta nave ya esta registrada " + lanzadera.getIdNave());
  }

  return (Lanzadera) lanzaderaRepo.save(lanzadera);
 }

 /**
  *Permite actualizar una nave tipo lanzadera
  */
 public Lanzadera actualizarLanzadera(Lanzadera lanzadera) throws Exception {
  Lanzadera lanzaderaExistente= lanzaderaRepo.buscarLanzaderaPorId(lanzadera.getIdNave());

  if ( lanzaderaExistente == null) {
   throw new Exception("no existe esta nave " + lanzadera.getIdNave());
  }

  return (Lanzadera) lanzaderaRepo.save(lanzadera);
 }
 /**
  *Permite buscar  una nave tipo lanzadera por su id
  */
 public Lanzadera buscarLanzadera(Lanzadera lanzadera) throws Exception {
  Lanzadera lanzaderaExistente= lanzaderaRepo.buscarLanzaderaPorId(lanzadera.getIdNave());

  if ( lanzaderaExistente == null) {
   throw new Exception("no existe esta nave con ese id  " + lanzadera.getIdNave());
  }
  return lanzadera;
 }
 // Metodos para naves tipo no tripuladas
 /**
  *Permite regristar una nave no tripulada
  */
 public NoTripulada registrarNoTripulada(NoTripulada noTripulada) throws Exception {
  NoTripulada noTripuladaExistente= noTripuladaRepo.buscarNoTripuladaPorId(noTripulada.getIdNave());

  if ( noTripuladaExistente!= null) {
   throw new Exception("Esta nave ya esta registrada " + noTripulada.getIdNave());
  }

  return (NoTripulada) lanzaderaRepo.save(noTripulada);
 }

 /**
  *Permite actualizar una nave tipo noTripulada
  */
 public NoTripulada actualizarNoTripulada(NoTripulada noTripulada) throws Exception {
  NoTripulada noTripuladaExistente= noTripuladaRepo.buscarNoTripuladaPorId(noTripulada.getIdNave());
  if ( noTripuladaExistente == null) {
   throw new Exception("no existe esta nave " + noTripulada.getIdNave());
  }

  return (NoTripulada) noTripuladaRepo.save(noTripulada);
 }
 /**
  *Permite buscar  una nave no tripulada por su id
  */
 public NoTripulada buscarNoTripulada(NoTripulada  noTripulada) throws Exception {
  NoTripulada noTripuladaExistente= noTripuladaRepo.buscarNoTripuladaPorId(noTripulada.getIdNave());

  if (noTripuladaExistente == null) {
   throw new Exception("no existe esta nave con ese id  " + noTripuladaExistente.getIdNave());
  }
  return noTripulada;
 }
 /*
  * Este metodo permite eliminar  una nave dado su id
  */
 public void eliminarNave(String idNave) throws Exception {

  Nave navebuscada = naveRepo.buscarPorId(idNave);

  if ( navebuscada == null) {
   throw new Exception("no existe esta nave con ese id  " + idNave);
  }
  naveRepo.delete(navebuscada);
  System.out.println("la nave fue eliminada ");

 }
  /**
   * Permite listar las naves registradas
   * */
  public List<Nave>listarNaves()throws Exception{
  List<Nave>listaNaves=naveRepo.findAll();
  if (listaNaves.isEmpty()){
   throw  new Exception("La lista de naves esta vacia");
  }
  return listaNaves;
 }

}
