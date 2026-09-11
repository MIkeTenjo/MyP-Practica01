package habilidad;

import personaje.Personaje;

/**
 * Clase que representa la habilidad de lanzar un rayo de plasma.
 */
public class RayoDePlasma extends Habilidad {

    public RayoDePlasma(){
        super("RayoDePlasma", "El personaje lanza un rayo de plasma que inflige daño al enemigo.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(objetivo.getVida() - 3);
    }

}