package habilidad;
import personaje.Personaje;

/**
 * Clase que representa la habilidad de golpe de mazo.
 */
public class BrazoMazo extends Habilidad {

    public BrazoMazo(){
        super("BrazoMazo", "Transforma el brazo del personaje en un mazo gigante que aumenta su ataque en 4 puntos y su defensa en 3 puntos.");
    }
    
    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(( objetivo.getVida() - 2));
        usuario.setAtaque(usuario.getAtaque() + 2);
        usuario.setDefensa(usuario.getDefensa() + 1);
    }
    
}