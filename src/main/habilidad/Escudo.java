package habilidad;

import personaje.Personaje;

/**
 * Clase que representa la habilidad de usar un escudo.
 */
public class Escudo extends Habilidad {

    public Escudo(){
        super("Escudo", "El personaje utiliza un escudo que reduce el daño recibido.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        usuario.setDefensa(usuario.getDefensa() + 2);
    }

}