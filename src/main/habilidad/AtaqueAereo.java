package habilidad;

import personaje.Personaje;

/**
 * Clase que representa la habilidad de un ataque aéreo.
 */
public class AtaqueAereo extends Habilidad{

    public AtaqueAereo(){
        super("AtaqueAereo", "El personaje realiza un ataque aéreo que inflige daño al enemigo y reduce su defensa.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(( objetivo.getVida() -3));
        objetivo.setDefensa(objetivo.getDefensa() - 2);
    }
}