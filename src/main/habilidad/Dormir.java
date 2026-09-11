package habilidad;

import personaje.Personaje;

/**
 * Clase que representa la habilidad de dormir.
 */
public class Dormir extends Habilidad {

    public Dormir(){
        super("Dormir", "El personaje se duerme y recupera puntos de vida.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        usuario.setVida(usuario.getVida() + 2);
    }
    
}