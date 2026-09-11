package objeto;

import franquicia.Franquicia;
import habilidad.BolaDeFuego;
import personaje.Personaje;

public class RobotDeFuego extends Objeto{

    public RobotDeFuego(){
        super(Franquicia.COPCAM, "Robot De Fuego", 8, new BolaDeFuego());
    }

    @Override protected void efectoConsumir(Personaje personaje){
        setTiempoDeUso(8);
        personaje.setVida(personaje.getVida() - 2);
    }

}
