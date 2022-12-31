package sofka.estacionespacial.bean;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import sofka.estacionespacial.entidades.Nave;
import sofka.estacionespacial.servicios.NaveServicio;
import sofka.estacionespacial.util.faces.FacesMessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

/**
 * Clase de negocio encargada la interacción del usuario con las funcionalidades
 * de gestión de naves
 *
 *
 */
@Named
@ViewScoped
public class NaveBean implements Serializable {
	/**
	 * Variable que representa la nave
	 */
	@Getter @Setter
	private Nave nave = new Nave();

	/**
	 * Variable que representa el listado de todas las naves
	 */
	@Getter @Setter
	private Collection<Nave> naves;

	/**
	 * Variable que representa el servicio de naves.
	 */
	@Inject
	private NaveServicio naveServicio;

	/**
	 * Método encargado de inicializar los datos de la clase
	 */
	@PostConstruct
	public void inicializar() {
		try {
			naves = naveServicio.listarNaves();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Método que permite registrar una nave en el sistema
	 */
	public void registrar() {
		FacesMessage mensaje;
		try {
			naveServicio.registrar(nave);
			nave = new Nave();
			naves = naveServicio.listarNaves();
			mensaje = FacesMessageUtil.createUserMessage("REGISTRO EXITOSO");
		} catch (Exception e) {
			mensaje = FacesMessageUtil.createFromException(e);
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Método que permite eliminar una nave del sistema
	 * 
	 * @param nave
	 *            Instancia de la nave a ser eliminada
	 */
	public void eliminar(Nave nave) {
		FacesMessage mensaje;
		try {
			naveServicio.eliminar(nave.getIdNave());
			naves = naveServicio.listarNaves();
			mensaje = FacesMessageUtil
					.createUserMessage("ELIMINACION_EXITOSO");
		} catch (Exception e) {
			mensaje = FacesMessageUtil.createFromException(e);
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Método encargado de responder al evento de edicion de la
	 * nave
	 * 
	 * @param event
	 *            Evento generado al editar una nave
	 */
	public void onRowEdit(RowEditEvent<Nave> event) {
		FacesMessage mensaje;
		Nave nave = event.getObject();
		try {
			naveServicio.actualizar(nave);
			mensaje = FacesMessageUtil
					.createUserMessage("ACTUALIZACION EXITOSA");
		} catch (Exception e) {
			mensaje = FacesMessageUtil.createFromException(e);
			naves = naveServicio.listarNaves();
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Método encargado de responder al evento de cancelación de la edicion de
	 * la nave
	 * 
	 * @param event
	 *            Evento generado al cancela la edición de una nave
	 */
	public void onRowCancel(RowEditEvent<Nave> event) {
		FacesMessage mensaje = FacesMessageUtil
				.createUserMessage("EDICION CANCELADA");
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
}
