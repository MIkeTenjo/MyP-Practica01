import java.util.ArrayList;
import java.util.Random;
import objeto.*;
import personaje.*;
import observer.*;
/**
 * Clase que simula un combate entre personajes de la clase {@link Personaje}.
 * 
 * Combate es una clase que simula una pelea entre personajes, con objetos de la clase
 * {@link Objeto}. Es una simulación "semi-automatica". La clase además generá varios
 * archivos de {@link Espectador} que tienen el registro completo del combate desde que se 
 * unieron, el único Espectador que está desde el principio del combate es el Anfitrion.
 */
public class Combate {

    /* Nuestro objeto Aleatorio. */
    private static final Random random = new Random();

    /*El anfitrio que ve todo el combate desde el principio. */
    private static Espectador anfitrion;

    /*Nombre de los personajes existentes en el sistema. */
    private static final String[] nombres = {"Korby", "MeganMan", "Dittu"};

    /*Nuestro combate observable que avisa a los Espectadores lo que esta pasando. */
    private static final CombateSimulacion combateSimulacion = new CombateSimulacion();

    /*El identificador del Espectador que quiere ver el combate. */ 
    private static int idContadorEspectadores = 1;

    /*El contador de los personajes. */
    private static int idContador = 0;

    /*Los personajes seleccionados. */
    private static final ArrayList<Personaje> personajesSeleccionados = new ArrayList<>();

    /*Una copia de los personajes cuando se requiere actualizar a un personaje. */
    private static final Personaje[] copiaEstaticaPersonajes = {new Korby(1, null), new MeganMan(2, null), new Dittu(3, null)};

    /*Objetos que apareceran en el combate. */
    private static final Objeto[] objetos = {new Aguilejo(), new Bomba(), new Estrella(), new Lukario(), new Mazo(), new OsoDormilon(), new RobotDeFuego(), new RobotMetalicoNegro(), new RobotNucleo()};

    /**
     * Método que intenta unir a un {@link Espectador} de acuerdo a una probabilidad.
     * @param idEspectador El identificador del Espectador que quiere unirse a ver el combate.
     * @param probabilidad La probabilidad que tiene el Espectador de unirse.
     * @return Un Espectador nuevo si es que se pudo unir. Null en otro caso.
     */
    public static Espectador intentarUnirEspectador(int idEspectador, double probabilidad){
        if (random.nextDouble() < probabilidad) {
            String personajeFavorito = nombres[random.nextInt(nombres.length)];
            Espectador espectador = new Espectador("Espectador " + idEspectador, personajeFavorito);
            return espectador;
        }
        return null;
    }

    /**
     * Método que une un {@link Espectador} para ver el combate.
     * @param e El espectador nuevo que quiere ver el combate.
     */
    public static void unirseEspectador(Espectador e) {
        if (e != null) {
            String msg =  e.getIdEspectador() + " se ha unido como espectador.";
            combateSimulacion.registrarEventoPelea(msg);
            combateSimulacion.registrarEspectador(e);
        }
    }

    /**
     * Método que solo da aviso que iniciará el combate.
     * @return El mensaje que dice que iniciará el combate.
     */
    public static String iniciarCombate() {
        String msg = " ¡Comienza el combate! Los participantes se preparan...";
        System.out.println(msg);
        return msg;
    }

    /**
     * Método que avisa que ya inicio la pelea. Además se tratará de unir
     * un {@link Espectador}.
     * @return El mensaje con la información de que ya inicio la pelea.
     */
    public static String iniciarPelea() {
        String msg = "¡La pelea ha comenzado!";
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.05));
        return msg;
    }

    /**
     * Método que simula el ataque de un {@link Personaje} a otro. Claramente 
     * el método tiene que entregar el mensaje del ataque hacia todos los 
     * Espectadores. Además, se intentarán unir nuevos Espectadores.
     * @param atacante El Personaje que ataca al defensor.
     * @param defensor El Personaje que se defiende del Personaje que lo ataco.
     * @return El mensaje de lo que paso en el ataque para todos los Espectadores.
     */
    public static String atacar(Personaje atacante, Personaje defensor){
        String msg = atacante.Nombre + " ataca a " + defensor.Nombre + ". ";
        if(atacante.getHabilidad() != null && !(atacante.getObjeto().estaConsumido())){
            msg = msg + atacante.Nombre + " esta usando su habilidad " + atacante.getHabilidad().getNombre() + ". ";
        }else if (atacante.getHabilidad() != null && atacante.getObjeto().estaConsumido()){
            msg = msg + atacante.Nombre + " ha consumido el objeto " + atacante.getObjeto().getNombre() + ". ";
            for(Personaje pa : copiaEstaticaPersonajes){
                if(atacante.Nombre.equals(pa.Nombre)){
                    Personaje personajeActualizar = pa;
                    atacante.Actualizar(null, personajeActualizar.getVida(), personajeActualizar.getDefensa(), personajeActualizar.getAtaque(), null);
                }
            }
        }
        int vidaDefensor = defensor.getVida();

        atacante.Atacar(defensor);
        int vidaRestante = vidaDefensor - defensor.getVida();
        msg = msg + atacante.Nombre + " hizo " + vidaRestante + " de danio a " + defensor.Nombre + ". ";
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.05));
        return msg;
    }

    /**
     * Método que avisa que acaba de aparecer un nuevo {@link Objeto} en el
     * campo de combate. Además, se interá unir un nuevo {@link Espectador}.
     * @param o El nuevo Objeto que acaba de aparecer en el combate.
     * @return El mensaje de que acaba de aparecer un nuevo Objeto para los
     * Espectadores.
     */
    public static String aparecerObjeto(Objeto o){
        String msg =  o.getNombre() + " ha aparecido en el campo de batalla.";
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.05));
        return msg;
    }

    /**
     * Método que simula la absorción de un {@link Objeto} por un
     * {@link Personaje}. El método debe de entregar un mensaje a los
     * Espectadores acerca de lo que paso al momento de simular la 
     * absorción del Objeto. Puede que el personaje {@code p} no pueda
     * absorber el Objeto y también lo deben saber los Espectadores. Por último
     * un nuevo {@link Espectador} puede intentar unirse.
     * @param p El Personaje que simulará la absorción del Objeto si es que puede hacerlo.
     * @param o El Objeto a ser absorbido.
     * @return El mensaje acerca de lo que paso al intentar absorber el Objeto.
     */
    public static String absorber(Personaje p, Objeto o){
        String msg = "";
        if(!p.puedeAbsorber(o)){
            msg = p.Nombre + " no puede absorber a " + o.getNombre() + " porque ";
            if(!p.franquicia.equals(o.getFranquicia())){
                msg = msg + o.getNombre() + " no es compatible. \n";
            }else{
                msg = msg + p.Nombre + " ya tiene un objeto consumiendose. \n";
            }
        }else{
            p.absorberObjeto(o);
            msg = msg + p.Nombre + " absorbe " + o.getNombre() + " y gana la habilidad de " + o.getHabilidad().getNombre() + ".";
            unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.05));
        }
        return msg;
    }

    /**
     * Método que simula cuando un {@link Personaje} se defiende de otro.
     * El método debe de avisar por un mensaje acerca de lo que paso cuando
     * el Personaje simulo defender. Además, un nuevo {@link Espectador} puede
     * intentar unirse.
     * @param p El personaje que esta simulando defender.
     * @return El mensaje acerca de lo que paso cuando el Personaje defiende.
     */
    public static String defender(Personaje p){
        String msg = p.Nombre + " se esta defendiendo";
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.05));
        return msg;
    }

    /**
     * Método que avisa cuando un {@link Personaje} acaba de perder la batalla.
     * Todos los Espectadores deben de enterarse a tráves de un mensaje. Además,
     * un nuevo {@link Espectador} puede intentar unirse.
     * @param p El personaje que perdió todos sus puntos de vida.
     * @return El mensaje que avisá a todos los Espectadores quien acaba de perder.
     */
    public static String perdio(Personaje p){
        String msg = p.Nombre + " ha perdido todos sus puntos de vida y es eliminado.";
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores, 0.05));
        return msg;
    }

    /**
     * Método que generá diferentes eventos aleatorios acerca de lo que puede
     * pasar en el combate.
     * 1-Puede pasar que un {@link Personaje} ataque a otro.
     * 2-Puede pasar que un {@link Objeto} caiga en la arena de combate.
     * 3-Puede pasar que un {@link Personaje} defienda.
     * Lo que pase, debe de ser notificado a los Espectadores del combate
     * por un mensaje. Además, un nuevo {@link Espectador} puede intentar unirse.
     * @param personaje1 El Personaje que será el que haga la acción.
     * @param personaje2 El Personaje que reciba la acción del primer Personaje.
     * @return El mensaje del evento que ocurrió.
     */
    private static String generarEventoAleatorio(Personaje personaje1, Personaje personaje2) {
        int probabilidad = random.nextInt(100);
        //Usamos una probabilidad que nos dirá que evento se hará.
        String resultadoEvento = "";

        if (probabilidad < 50) {
            resultadoEvento = resultadoEvento + atacar(personaje1, personaje2);
            
        } else if (probabilidad < 69) {

            Objeto objAleatorio = objetos[random.nextInt(objetos.length)];
            resultadoEvento = resultadoEvento + aparecerObjeto(objAleatorio) + ". \n"; 
            for (Personaje p : personajesSeleccionados) {

                boolean loLogroAbsorber = p.puedeAbsorber(objAleatorio);
                resultadoEvento = resultadoEvento + absorber(p, objAleatorio);

                if(loLogroAbsorber){
                    break;
                }
            }
            
        } else {
            resultadoEvento = resultadoEvento + defender(personaje2);
        }

        return resultadoEvento;
    }




    public static void main(String[] args) {
        // Inicializando el anfitrión de la transmisión
        anfitrion = new Espectador("Anfitrión", "Nadie");
        anfitrion.recibirEvento(iniciarCombate());
        //Se registra el nuevo Anfitrión que nos dará todo el combate en escrito.
        combateSimulacion.registrarEspectador(anfitrion);

        //Intento unir un nuevo espectador :)
        unirseEspectador(intentarUnirEspectador(idContadorEspectadores++, 0.7));

        //Inicialización de Korby
        Korby korby = new Korby(idContador++, null);
        String msg = "Se ha unido al combate " + korby.Nombre + " con ID: " + korby.getIdentificacion();
        combateSimulacion.registrarEventoPelea(msg);
        personajesSeleccionados.add(korby);

        //Inicialización de MeganMan
        MeganMan meganMan = new MeganMan(idContador++, null);
        String msg2 = "Se ha unido al combate " + meganMan.Nombre + " con ID: " + meganMan.getIdentificacion();
        combateSimulacion.registrarEventoPelea(msg2);
        personajesSeleccionados.add(meganMan);

        //Inicialización de Dittu.
        Dittu dittu = new Dittu(idContador++, null);
        String msg3 = "Se ha unido al combate " + dittu.Nombre + " con ID: " + dittu.getIdentificacion();
        combateSimulacion.registrarEventoPelea(msg3);
        personajesSeleccionados.add(dittu);

        //Iniciar la pelea
        combateSimulacion.registrarEventoPelea(iniciarPelea());

        // Bucle dinámico de combate: continúa hasta que quede 1 solo luchador
        while (personajesSeleccionados.size() > 1) {
            
            // Seleccionar dos participantes vivos al azar
            int indiceAtacante = random.nextInt(personajesSeleccionados.size());
            int indiceDefensor = random.nextInt(personajesSeleccionados.size());
            
            // Garantizar que no se ataquen a sí mismos
            while (indiceAtacante == indiceDefensor) {
                indiceDefensor = random.nextInt(personajesSeleccionados.size());
            }

            Personaje pAtacante = personajesSeleccionados.get(indiceAtacante);
            Personaje pDefensor = personajesSeleccionados.get(indiceDefensor);

            //  Genera el evento de esta ronda y lo registra.
            String eventoActual = generarEventoAleatorio(pAtacante, pDefensor);
            combateSimulacion.registrarEventoPelea(eventoActual);
            
            //Si un personaje perdió entonces se elimina del combate.
            if (!pDefensor.estaVivo()) {
                combateSimulacion.registrarEventoPelea(perdio(pDefensor));
                personajesSeleccionados.remove(pDefensor);
            }

        }

        // Declarar al ganador
        if (personajesSeleccionados.size() == 1) {
            Personaje campeon = personajesSeleccionados.get(0);
            combateSimulacion.finalizarCombate(campeon.Nombre);
        }

    }

}