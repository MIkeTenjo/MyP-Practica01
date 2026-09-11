package objeto;

import franquicia.Franquicia;
import habilidad.AtaqueAereo;
import personaje.Personaje;

/**
 * Clase que representa el objeto Aguilejo, que es un objeto consumible por personajes
 * que pertenecen a la franquicia NIENTIENDO.
 */
public class Aguilejo extends Objeto{
    
    public Aguilejo(){
        super(Franquicia.NIENTIENDO, "Aguilejo", 9, new AtaqueAereo());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(9);
    }

}
