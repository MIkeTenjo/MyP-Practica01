package habilidad;

import personaje.Personaje;

/**
 * Clase que representa una habilidad de explosión.
 */
public class Explosion extends Habilidad {

    public Explosion(){
        super("Explosión", "Causa una explosión fuerte al enemigo y debil al propietario.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(objetivo.getVida() - 3);
        usuario.setVida(usuario.getVida() - 1);
    }
}
