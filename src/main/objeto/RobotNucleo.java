package objeto;

import franquicia.Franquicia;
import habilidad.RayoDePlasma;
import personaje.Personaje;

/**
 * Clase que representa un objeto Robot Nucleo, que es un objeto consumible por personajes
 * de la franquicia COPCAM.
 */
public class RobotNucleo extends Objeto{

    public RobotNucleo(){
        super(Franquicia.COPCAM, "Robot Nucleo", 10, new RayoDePlasma());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(15);
        personaje.setDefensa(personaje.getDefensa() - 2);
        personaje.setAtaque(personaje.getAtaque() - 2);
    }

}
