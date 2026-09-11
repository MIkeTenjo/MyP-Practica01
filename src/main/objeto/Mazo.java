package objeto;

import franquicia.Franquicia;
import habilidad.BrazoMazo;
import personaje.Personaje;

/**
 * Clase que representa el objeto Mazo, que es un objeto consumible por personajes
 * que pertenecen a la franquicia NIENTIENDO.
 */
public class Mazo extends Objeto{

    public Mazo(){
        super(Franquicia.NIENTIENDO, "Mazo", 12, new BrazoMazo());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(12);
        personaje.setAtaque(personaje.getAtaque() - 2);
    }


}
