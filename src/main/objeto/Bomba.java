package objeto;

import franquicia.Franquicia;
import habilidad.Explosion;
import personaje.Personaje;

/**
 * Clase que representa un objeto Bomba.
 */
public class Bomba extends Objeto {
    
    public Bomba(){
        super(Franquicia.NIENTIENDO, "Bomba", 8, new Explosion());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(8);
        personaje.setVida(personaje.getVida() - 1);
    }
}
