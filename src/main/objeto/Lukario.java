package objeto;

import franquicia.Franquicia;
import habilidad.RayoDePlasma;
import personaje.Personaje;

/**
 * Clase que representa el objeto Lukario (un CHINPOKOMON), que es un 
 * objeto consumible por personajes que pertenecen a la franquicia CHINPOKOMON.
 */
public class Lukario extends Objeto{

    public Lukario(){
        super(Franquicia.CHINPOKOMON, "Lukario", 8, new RayoDePlasma());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(8);
        personaje.setDefensa(personaje.getDefensa() + 1);
        personaje.setAtaque(personaje.getAtaque() + 1);
    }
}
