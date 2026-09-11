package habilidad;

import personaje.Personaje;

public class BolaDeFuego extends Habilidad{

    public BolaDeFuego(){
        super("Bola de Fuego", "Lanza una bola de fuego que inflige daño al enemigo.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(( objetivo.getVida() - 4));
    }

}
