package habilidad;

import personaje.Personaje;

public class RayoDeNeutrones extends Habilidad{

    public RayoDeNeutrones(){
        super("Rayo de Neutrones", "Un rayo iluminiscente que daña al enemigo y le quita su defensa.");
    }

    @Override public void ejecutar(Personaje usuario, Personaje objetivo){
        objetivo.setVida(objetivo.getVida() - 2);
        objetivo.setDefensa(objetivo.getDefensa() - 1);
    }

}
