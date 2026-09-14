package personaje;

import franquicia.Franquicia;
import habilidad.Habilidad;

/**
 * Representa al robot MeganMan de la franquicia Copcam
 * Adopta habilidades basadas en robots y tecnología derrotada de su universo
 * 
 * @author Equipo Los Troyanos
 * @version 1.0 
 */
public class MeganMan extends Personaje {
    /**
     * Construye a MeganMan con estadísticas estándar y asignación fija
     * a la franquicia COPCAM.
     * 
     * @param id               Identificador numérico único del combatiente.
     * @param habilidadInicial Estrategia inicial de combate 
     */
    public MeganMan(int id, Habilidad habilidadInicial) {
        // Parametros: Nombre, id, franquicia, vida, defensa, ataque, habilidadInicial
        super("MeganMan", id, Franquicia.COPCAM, 100, 8, 27, habilidadInicial);
    }

    /**
     * Constructor sobrecargado con estadísticas personalizables
     * 
     * @param id               Identificador numérico único
     * @param vida             Puntos de vida iniciales
     * @param defensa          Puntos de defensa iniciales
     * @param ataque           Puntos de ataque iniciales
     * @param habilidadInicial Estrategia inicial de combate
     */
    public MeganMan(int id, int vida, int defensa, int ataque, Habilidad habilidadInicial) {
        super("MeganMan", id, Franquicia.COPCAM, vida, defensa, ataque, habilidadInicial);
    }
}