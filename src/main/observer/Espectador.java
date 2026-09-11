import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

/**
 * -----------------------------------------------------------------------------
 * SISTEMA DE TRANSMISIÓN DE PELEAS - PATRÓN OBSERVER
 * -----------------------------------------------------------------------------
 * Clase que representa a un espectador individual dentro de la transmisión.
 * 
 * Cada espectador cuenta con una identidad única (ID) y un personaje preferido 
 * al que apoya durante la contienda. Esta clase se encarga de recibir cada suceso 
 * narrativo del combate en tiempo real, estampar la marca de tiempo (timestamp) 
 * correspondiente, evaluar si su favorito resultó victorioso o derrotado al final 
 * del enfrentamiento, y generar de forma automatizada un archivo de bitácora (.txt).
 * -----------------------------------------------------------------------------
 */
public class Espectador implements EspectadorObserver {

    private String idEspectador;
    private String personajeFavorito;
    private String bitacoraLog;

    /**
     * Constructor de la clase Espectador.
     * Inicializa los datos del espectador y crea el encabezado de su bitácora.
     * 
     * @param idEspectador Identificador único de la audiencia (ej. "espectador101").
     * @param personajeFavorito Nombre del peleador al que apoya ("Korby", "MeganMan" o "Dittuu").
     */
    public Espectador(String idEspectador, String personajeFavorito) {
        this.idEspectador = idEspectador;
        this.personajeFavorito = personajeFavorito;
        
        // Encabezado visual y descriptivo personalizado
        this.bitacoraLog = "=======================================================\n";
        this.bitacoraLog += "  BITÁCORA OFICIAL DE TRANSMISIÓN DE PELEAS - DE LA ROSA  \n";
        this.bitacoraLog += "  ID de Audiencia: " + this.idEspectador + "\n";
        this.bitacoraLog += "  Personaje Apoyado en esta Sesión: " + this.personajeFavorito + "\n";
        this.bitacoraLog += "=======================================================\n\n";
        this.bitacoraLog += "--- INICIO DE LA TRANSMISIÓN EN VIVO ---\n\n";
    }

    /**
     * Recibe la descripción textual de un acontecimiento en la plataforma, 
     * le adjunta la fecha y hora exacta del sistema y lo registra en la bitácora.
     * 
     * @param evento Detalle narrativo del golpe, transformación o suceso en la arena.
     */
    @Override
    public void recibirEvento(String evento) {
        // Marca de tiempo tradicional
        String horaActual = new Date().toString();
        this.bitacoraLog += "[" + horaActual + "] " + evento + "\n";
    }

    /**
     * Procesa la conclusión del combate. Compara el ganador final contra el 
     * personaje favorito del espectador para emitir la reacción personalizada 
     * de victoria o derrota, y procede a guardar la bitácora física.
     * 
     * @param ganador Nombre del luchador que quedó en pie al final de la simulación.
     */
    @Override
    public void finalizarTransmision(String ganador) {
        this.bitacoraLog += "\n-------------------------------------------------------\n";
        this.bitacoraLog += "REACCIÓN Y BALANCE FINAL DEL ESPECTADOR (" + this.idEspectador + "):\n";
        
        // EVALUACIÓN DE VICTORIA O DERROTA INDIVIDUAL
        if (ganador.equalsIgnoreCase(this.personajeFavorito)) {
            // Mensaje si el favorito ganó
            this.bitacoraLog += "¡VICTORIA ABSOLUTA! Tu peleador favorito, " 
                                + this.personajeFavorito 
                                + ", ha demostrado su superioridad, eliminó a sus rivales y se corona CAMPEÓN de la plataforma.\n";
        } else {
            // Mensaje si el favorito perdió
            this.bitacoraLog += "TRISTE DERROTA... Lamentablemente tu personaje favorito, " 
                                + this.personajeFavorito 
                                + ", cayó eliminado durante el combate. El ganador de esta edición fue " 
                                + ganador + ". ¡Más suerte en la próxima simulación!\n";
        }
        
        this.bitacoraLog += "-------------------------------------------------------\n";
        this.bitacoraLog += "--- FIN DE LA TRANSMISIÓN ---\n";

        // Genera el archivo físico .txt
        guardarEnArchivo();
    }

    /**
     * Método privado que escribe el contenido acumulado en la memoria 
     * dentro de un archivo de texto con el formato bitacora_[idEspectador].txt.
     */
    private void guardarEnArchivo() {
        try {
            String nombreArchivo = "bitacora_" + this.idEspectador + ".txt";
            File archivo = new File(nombreArchivo);
            PrintWriter escritor = new PrintWriter(archivo);
            
            escritor.print(this.bitacoraLog);
            escritor.close();
            
            System.out.println("-> Bitácora individual generada con éxito: " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al escribir la bitácora de " + this.idEspectador + ": " + e.getMessage());
        }
    }

    /**
     * Permite consultar el ID del espectador.
     * @return Identificador textual del espectador.
     */
    public String getIdEspectador() {
        return this.idEspectador;
    }

    /**
     * Permite consultar el personaje apoyado por este espectador.
     * @return Nombre del personaje favorito.
     */
    public String getPersonajeFavorito() {
        return this.personajeFavorito;
    }
}