package objeto;

import franquicia.Franquicia;
import habilidad.Indestructible;
import personaje.Personaje;

/**
 * Clase que representa un objeto Estrella que hace inmune a un personaje.
 */
public class Estrella extends Objeto{

    public Estrella(){
        super(Franquicia.NIENTIENDO, "Estrella", 5, new Indestructible());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(5);
        personaje.setDefensa(personaje.getDefensa() - 2);
    }

}
