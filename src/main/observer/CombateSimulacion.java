package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * -----------------------------------------------------------------------------
 * SISTEMA DE TRANSMISIÓN DE PELEAS - PATRÓN OBSERVER
 * -----------------------------------------------------------------------------
 * Clase que representa el motor de simulación del combate y actúa como el
 * Sujeto Observable dentro del patrón Observer.
 * 
 * Se encarga de administrar la lista de espectadores suscritos, registrar los
 * acontecimientos detallados de las peleas y notificar en tiempo real a cada
 * observador para que actualicen sus respectivas bitácoras.
 * -----------------------------------------------------------------------------
 */
public class CombateSimulacion implements SujetoObservable {

    // Lista de observadores registrados (Paso 1 del diagrama)
    private List<EspectadorObserver> espectadores;
    
    // Atributos de estado del combate
    private String eventoActual;
    private String ganadorFinal;

    /**
     * Constructor de CombateSimulacion.
     * Inicializa la estructura de datos que albergará a la audiencia.
     */
    public CombateSimulacion() {
        this.espectadores = new ArrayList<>();
    }

    /**
     * Registra a un nuevo espectador en la lista de transmisión.
     * 
     * @param espectador Instancia que recibirá los eventos del combate.
     */
    @Override
    public void registrarEspectador(EspectadorObserver espectador) {
        this.espectadores.add(espectador);
    }

    /**
     * Elimina a un espectador de la lista de transmisión.
     * 
     * @param espectador Instancia a remover.
     */
    @Override
    public void removerEspectador(EspectadorObserver espectador) {
        this.espectadores.remove(espectador);
    }

    /**
     * Recorre a todos los espectadores suscritos y ejecuta su método 
     * recibirEvento() enviando la descripción de la acción actual.
     */
    @Override
    public void notificarEspectadores() {
        for (EspectadorObserver espectador : this.espectadores) {
            espectador.recibirEvento(this.eventoActual);
        }
    }

    /**
     * Registra un suceso acontecido en la plataforma, actualiza el estado 
     * del evento y notifica inmediatamente a todos los espectadores.
     * 
     * @param detalle Descripción completa y detallada del suceso narrativo.
     */
    public void registrarEventoPelea(String detalle) {
        this.eventoActual = detalle;
        
        // Muestra el evento en la consola general de la simulación
        System.out.println("[TRANSMISIÓN EN VIVO]: " + detalle);
        
        // Dispara la notificación a todos los observadores registrados
        notificarEspectadores();
    }

    /**
     * Declara la conclusión oficial de la pelea, guarda el ganador final y 
     * notifica a todos los espectadores para que cierren sus bitácoras.
     * 
     * @param ganador Nombre del luchador victorioso ("Korby", "MeganMan" o "Dittuu").
     */
    public void finalizarCombate(String ganador) {
        this.ganadorFinal = ganador;
        
        System.out.println("\n=======================================================");
        System.out.println("  ¡FIN DEL COMBATE! GANADOR OFICIAL: " + ganador);
        System.out.println("=======================================================\n");
        
        // Solicita a cada espectador que finalice su transmisión y evalúe su resultado
        for (EspectadorObserver espectador : this.espectadores) {
            espectador.finalizarTransmision(this.ganadorFinal);
        }
    }

    /**
     * Permite consultar el evento actual que se está transmitiendo.
     * @return Cadena de texto con el detalle del evento.
     */
    public String getEventoActual() {
        return this.eventoActual;
    }

    /**
     * Permite consultar el ganador final decretado en la arena.
     * @return Nombre del peleador victorioso.
     */
    public String getGanadorFinal() {
        return this.ganadorFinal;
    }
}
