package observer;

/**
 * -----------------------------------------------------------------------------
 * SISTEMA DE TRANSMISIÓN DE PELEAS - PATRÓN OBSERVER
 * -----------------------------------------------------------------------------
 * Interfaz que define el contrato oficial para el Sujeto Observable.
 * 
 * Establece los métodos indispensables para que el motor de combate pueda
 * suscribir espectadores, removerlos de la lista de transmisión y notificarles 
 * en tiempo real cualquier acontecimiento que ocurra en la plataforma.
 * -----------------------------------------------------------------------------
 */
public interface SujetoObservable {

    /**
     * Registra un nuevo espectador en la lista de transmisión de la arena.
     * 
     * @param espectador Instancia que implementa la interfaz EspectadorObserver.
     */
    void registrarEspectador(EspectadorObserver espectador);

    /**
     * Remueve a un espectador existente de la lista de transmisión.
     * 
     * @param espectador Instancia que implementa la interfaz EspectadorObserver.
     */
    void removerEspectador(EspectadorObserver espectador);

    /**
     * Notifica el evento actual a cada uno de los espectadores registrados 
     * recorriendo la lista de observadores.
     */
    void notificarEspectadores();
}