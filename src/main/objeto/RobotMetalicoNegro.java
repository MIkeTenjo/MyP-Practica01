package objeto;

import franquicia.Franquicia;
import habilidad.RayoDeNeutrones;   
import personaje.Personaje;

/**
 * Clase que representa un objeto Robot Metalico Negro, que es un objeto consumible por personajes
 * de la franquicia COPCAM.
 */
public class RobotMetalicoNegro extends Objeto{

    public RobotMetalicoNegro(){
        super(Franquicia.COPCAM, "Robot Metalico Negro", 12, new RayoDeNeutrones());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(12);
        personaje.setAtaque(personaje.getAtaque() - 3);
    }

}
