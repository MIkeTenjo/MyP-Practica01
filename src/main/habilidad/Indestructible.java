package habilidad;

import personaje.Personaje;

/**
 * Clase que representa la habilidad de ser indestrutible momentaneamente.
 */
public class Indestructible extends Habilidad{

    public Indestructible(){
        super("Indestructible", "Habilidad que le otorga al personaje inmunidad por unos instantes");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        usuario.setDefensa(999);
    }

}
