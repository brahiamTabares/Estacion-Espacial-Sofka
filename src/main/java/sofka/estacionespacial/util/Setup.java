package sofka.estacionespacial.util;

import sofka.estacionespacial.servicios.NaveServicioImp;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Locale;

/**
 * Clase que permite inicializar los datos de la app
 *
 */
@Startup
@Singleton
public class Setup {

	/**
	 * Instancia del servicio
	 */
	@Inject
	private NaveServicioImp naveService;

	/**
	 * Método encargado de crear el usuario cuando la aplicación es iniciada por
	 * primera vez
	 */
	@PostConstruct
	public void setup() {
		try {
			setupNaves();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Método encargado de registrar las categorias por defecto usados en la
	 * aplicación
	 */
	private void setupNaves() throws Exception {
		if (naveService.listarNaves().size() == 0) {
			//TODO CREAR NAVES
		}
	}

}
