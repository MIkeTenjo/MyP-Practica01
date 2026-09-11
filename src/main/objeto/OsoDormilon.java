package objeto;

import franquicia.Franquicia;
import habilidad.Dormir;
import personaje.Personaje;

/**
 * Clase que representa un objeto OsoDormilon(CHINPOKOMON), que es un objeto consumible por personajes
 * que pertenecen a la franquicia CHINPOKOMON.
 */
public class OsoDormilon extends Objeto{

    public OsoDormilon(){
        super(Franquicia.CHINPOKOMON, "OsoDormilon", 10, new Dormir());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(10);
        personaje.setVida(personaje.getVida() - 1);
    }

}
