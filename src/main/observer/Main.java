/**
 * -----------------------------------------------------------------------------
 * SISTEMA DE TRANSMISIÓN DE PELEAS - PATRÓN OBSERVER
 * -----------------------------------------------------------------------------
 * Clase principal ejecutable para validar el funcionamiento del patrón Observer.
 * 
 * Instancia el motor de combate (Sujeto Observable), genera las 4 entidades de
 * espectadores requeridas con sus IDs y personajes favoritos, simula una pelea
 * altamente detallada y descriptiva, y detona la creación automatizada de los
 * archivos de bitácora (.txt) en el disco duro.
 * -----------------------------------------------------------------------------
 */
public class Main {

    /**
     * Punto de entrada principal de la aplicación.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        
        System.out.println("=======================================================");
        System.out.println("   INICIANDO SIMULACIÓN DE COMBATE - DE LA ROSA GAMES  ");
        System.out.println("=======================================================\n");

        // 1. Instanciación del Sujeto Observable (Motor de la Arena)
        CombateSimulacion pelea = new CombateSimulacion();

        // 2. Creación de las 4 entidades de espectadores simulados exigidas por la práctica
        Espectador e1 = new Espectador("espectador101", "Korby");
        Espectador e2 = new Espectador("espectador102", "MeganMan");
        Espectador e3 = new Espectador("espectador103", "Dittuu");
        Espectador e4 = new Espectador("espectador104", "Korby");

        // 3. Registro de la audiencia en el sistema de transmisión
        pelea.registrarEspectador(e1);
        pelea.registrarEspectador(e2);
        pelea.registrarEspectador(e3);
        pelea.registrarEspectador(e4);

        System.out.println("-> AUDIENCIA CONECTADA: 4 espectadores listos para la transmisión.\n");

        // 4. SIMULACIÓN EXTENDIDA Y CREATIVA DE SUCESOS EN LA ARENA
        pelea.registrarEventoPelea("¡SUENA LA CAMPANA! Korby (HP: 100), MeganMan (HP: 100) y Dittuu (HP: 100) ingresan a la plataforma de combate.");
        pelea.registrarEventoPelea("Los tres peleadores analizan el terreno de juego manteniendo sus distancias iniciales.");
        pelea.registrarEventoPelea("Korby lanza un 'Golpe Básico' hacia Dittuu, pero Dittuu esquiva dando un salto hacia atrás.");
        pelea.registrarEventoPelea("MeganMan aprovecha la apertura y dispara 'Disparo Secuencial' afectando a Korby y Dittuu por 10 puntos de daño. (Korby HP: 90, Dittuu HP: 90).");
        
        pelea.registrarEventoPelea("¡EVENTO DE ESCENARIO! Cae del cielo un contenedor con el logo de Nientiendo.");
        pelea.registrarEventoPelea("Korby corre hacia el contenedor, lo engulle y asume la transformación 'Korby Piedra'. Su defensa aumenta drásticamente.");
        pelea.registrarEventoPelea("Dittuu intenta copiar la apariencia de Korby Piedra pero resbala en la plataforma y falla su transformación.");
        
        pelea.registrarEventoPelea("¡APARECE OTRO OBJETO! Cae un contenedor de la franquicia Copcam.");
        pelea.registrarEventoPelea("MeganMan recoge el objeto y se transforma en 'MeganMan Fuego' adquiriendo el ataque 'Llamarada Sol'.");
        pelea.registrarEventoPelea("MeganMan Fuego lanza una 'Llamarada Sol' masiva hacia Korby Piedra. Korby se defiende como piedra y amortigua el golpe. (Korby HP: 85).");
        
        pelea.registrarEventoPelea("¡EVENTO DE ESCENARIO! Aparece un contenedor de la franquicia Chinpokomon.");
        pelea.registrarEventoPelea("Dittuu consume el objeto Chinpokomon y se transforma exitosamente en 'Dittuu Llama'.");
        pelea.registrarEventoPelea("Dittuu Llama ataca con 'Lanzafuegos' a MeganMan Fuego causando 20 puntos de daño. (MeganMan HP: 80).");
        
        pelea.registrarEventoPelea("Korby Piedra salta y ejecuta el movimiento 'Golpe Aplastante' sobre Dittuu Llama provocando 70 puntos de daño masivo. (Dittuu HP: 20).");
        pelea.registrarEventoPelea("Dittuu Llama, al borde de la derrota, ejecuta un contraataque desesperado 'Chispa Rápida' sobre Korby Piedra infligiendo 5 de daño. (Korby HP: 80).");
        pelea.registrarEventoPelea("MeganMan Fuego remata a Dittuu Llama con un 'Disparo Térmico' infligiendo 20 de daño.");
        pelea.registrarEventoPelea("¡DITTUU HA SIDO ELIMINADO! Puntos de vida reducidos a cero (Dittuu HP: 0).");
        
        pelea.registrarEventoPelea("MeganMan Fuego y Korby Piedra se posicionan para el duelo final en el centro de la plataforma.");
        pelea.registrarEventoPelea("MeganMan Fuego descarga un 'Super Cañonazo', pero Korby Piedra rueda por el suelo y evade el impacto directo.");
        pelea.registrarEventoPelea("Korby Piedra aprovecha el desgaste de MeganMan y asesta su ataque 'Martillazo Estelar' causando 80 puntos de daño. (MeganMan HP: 0).");
        pelea.registrarEventoPelea("¡MEGANMAN HA SIDO NOQUEADO! Puntos de vida reducidos a cero.");

        // 5. Cierre de la transmisión y declaración del ganador oficial
        pelea.finalizarCombate("Korby");
    }
}