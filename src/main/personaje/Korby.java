package personaje;

import franquicia.Franquicia;
import habilidad.Habilidad;

/**
 * Representa al personaje Korby de la franquicia NIENTIENDO.
 * Puede absorber objetos de su franquicia para mutar sus habilidades.
 * 
 * @author Equipo Los Troyanos
 * @version 1.0
 */
public class Korby extends Personaje {

    /**
     * Construye a Korby con valores base equilibrados y asignación fija
     * a la franquicia NIENTIENDO
     * 
     * @param id               Identificador numérico único del combatiente
     * @param habilidadInicial Estrategia inicial de combate
     */
    public Korby(int id, Habilidad habilidadInicial) {
        // Parametros: Nombre, id, franquicia, vida, defensa, ataque, habilidadInicial
        super("Korby", id, Franquicia.NIENTIENDO, 100, 6, 31, habilidadInicial);
    }

    /**
     * Constructor sobrecargado que permite personalizar atributos iniciales
     * 
     * @param id               Identificador numérico único
     * @param vida             Puntos de vida iniciales
     * @param defensa          Puntos de defensa iniciales
     * @param ataque           Puntos de ataque iniciales
     * @param habilidadInicial Estrategia inicial de combate
     */
    public Korby(int id, int vida, int defensa, int ataque, Habilidad habilidadInicial) {
        super("Korby", id, Franquicia.NIENTIENDO, vida, defensa, ataque, habilidadInicial);
    }
}