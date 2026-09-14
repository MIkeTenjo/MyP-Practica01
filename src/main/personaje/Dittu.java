package personaje;

import franquicia.Franquicia;
import habilidad.Habilidad;

/**
 * Representa a la criatura Dittu de la franquicia CHINPOKOMON
 * Posee estadísticas orientadas a ataques variables y absorción de criaturas de su propio catálogo
 * 
 * @author Equipo Los Troyanos
 * @version 1.0
 */
public class Dittu extends Personaje {

    /**
     * Construye a Dittu con estadísticas estándar y asignación fija
     * a la franquicia CHINPOKOMON.
     * 
     * @param id               Identificador numérico único del combatiente.
     * @param habilidadInicial Estrategia inicial de combate
     */
    public Dittu(int id, Habilidad habilidadInicial) {
        // Parametros: Nombre, id, franquicia, vida, defensa, ataque, habilidadInicial
        super("Dittu", id, Franquicia.CHINPOKOMON, 100, 12, 20, habilidadInicial);
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
    public Dittu(int id, int vida, int defensa, int ataque, Habilidad habilidadInicial) {
        super("Dittu", id, Franquicia.CHINPOKOMON, vida, defensa, ataque, habilidadInicial);
    }
}