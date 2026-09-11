/**
 * -----------------------------------------------------------------------------
 * SISTEMA DE TRANSMISIÓN DE PELEAS - PATRÓN OBSERVER
 * -----------------------------------------------------------------------------
 * Interfaz que actua como el contrato oficial para todos los observadores
 * (espectadores) del combate. 
 * 
 * Esta interfaz garantiza que cualquier entidad que desee escuchar la pelea 
 * implemente obligatoriamente los métodos para recibir eventos en tiempo real 
 * y enterarse del resultado final del combate.
 * -----------------------------------------------------------------------------
 */
public interface EspectadorObserver {

    /**
     * Recibe y procesa un evento o suceso narrativo transmitido desde la arena de pelea.
     * 
     * @param evento Texto descriptivo con el detalle de la accion (golpes, uso de 
     *               poderes, transformaciones o eliminaciones).
     */
    void recibirEvento(String evento);

    /**
     * Recibe la notificacion formal del cierre del combate e informa quién es 
     * el peleador victorioso.
     * 
     * @param ganador Nombre oficial del personaje que gano la pelea (Korby, MeganMan o Dittuu).
     */
    void finalizarTransmision(String ganador);
}

