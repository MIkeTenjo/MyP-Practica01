package personaje;

import franquicia.Franquicia;
import habilidad.Habilidad;
import java.util.Objects;
import objeto.Objeto;

/**
 * Clase abstracta que representa a un personaje en la arena.
 * Gestiona sus estadísticas del personaje, su pertenencia a una franquicia y la
 * gestion de habilidades mediante el uso del patrón Strategy.
 * 
 * @author Equipo Los Troyanos
 * @version 1.0 
 */
public abstract class Personaje {

    /** Nombre del personaje. */
    public String Nombre;

    /** Identificador único del personaje. */
    private int id;

    /** Franquicia de origen del personaje. */
    public Franquicia franquicia;

    /** Objeto consumible actualmente equipado o absorbido. */
    private Objeto objeto; //Duda pendiente con el nombre de tipo de dato

    /** Puntos de vida (HP) restantes del personaje. */
    private int vida;

    /** Valor base de defensa del personaje. */
    private int defensa;

    /** Valor base de daño de los ataques. */
    private int ataque;

    /** Estrategia de combate o habilidad activa en tiempo de ejecución. */
    private Habilidad habilidadActual; //Falta implementar

    /**
     * Constructor para inicializar los atributos de un personaje
     * 
     * @param nombre           Nombre visible del personaje.
     * @param id               Identificador numérico único.
     * @param franquicia       Franquicia a la que pertenece el personaje.
     * @param vida             Puntos de vida iniciales.
     * @param defensa          Puntos de defensa iniciales.
     * @param ataque           Puntos de ataque iniciales.
     * @param habilidadInicial Habilidad base inicial (Strategy estándar).
     */
    public Personaje(String nombre, int id, Franquicia franquicia, int vida, int defensa, int ataque, Habilidad habilidadInicial) {
        this.Nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.id = id;
        this.id = id;
        this.franquicia = Objects.requireNonNull(franquicia, "La franquicia no puede ser nula");
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidadActual = habilidadInicial;
    }//MIsmo falta Franquincia

    /**
     * Obtiene la franquicia de origen del personaje.
     * 
     * @return Franquicia del personaje
     */
    public Franquicia getFranquicia() {
        return this.franquicia;
    }

    /**
     * Obtiene el identificador único del personaje.
     * 
     * @return ID del personaje
     */
    public int getIdentificacion() {
        return this.id;
    }

    /**
     * Obtiene el objeto consumible actualmente asignado.
     * 
     * @return El Objeto actual
     */
    public Objeto getObjeto() {
        return this.objeto;
    }

    /**
     * Asigna un objeto al personaje.
     * 
     * @param o Objeto a asignar
     */
    public void setObjeto(Objeto o) {
        this.objeto = o;
    }

    /**
     * Modifica la habilidad activa del personaje (cambio de estrategia).
     * 
     * @param h Nueva habilidad a asignar
     */
    public void setHabilidad(Habilidad h) {
        this.habilidadActual = h;
    }

    /**
     * Obtiene la habilidad actual que el personaje está ejecutando.
     * 
     * @return Habilidad activa 
     */
    public Habilidad getHabilidad() {
        return this.habilidadActual;
    }

    /**
     * Obtiene la vida actual del personaje.
     * 
     * @return Cantidad de vida restantes
     */
    public int getVida() {
        return this.vida;
    }

    /**
     * Actualiza la vida del personaje
     * 
     * @param vida Nueva cantidad de vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene los puntos de defensa actuales
     * 
     * @return Valor numérico de defensa
     */
    public int getDefensa() {
        return this.defensa;
    }

    /**
     * Actualiza los puntos de defensa del personaje
     * 
     * @param defensa Nuevo valor de defensa
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Obtiene los puntos de ataque actuales
     * 
     * @return Valor numérico de ataque
     */
    public int getAtaque() {
        return this.ataque;
    }

    /**
     * Actualiza los puntos de ataque del personaje
     * 
     * @param ataque Nuevo valor de ataque
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * Valida si el personaje tiene permitido consumir un objeto específico
     * verificando que pertenezca a su misma franquicia
     * 
     * @param o Objeto que aparece en la arena.
     * @return true si las franquicias coinciden, false si el objeto
     *         es nulo o de otra franquicia.
     */
    public Boolean puedeAbsorber(Objeto o) {
        if (o == null || o.getFranquicia() == null || this.franquicia == null) {
            return false;
        }
        return this.franquicia == o.getFranquicia();
    }

    /**
     * Consume un objeto y equipa la habilidad que contiene si es compatible con la franquicia
     * 
     * @param o Objeto que se desea absorber
     */
    public void absorberObjeto(Objeto o) {
        if (puedeAbsorber(o)) {
            setObjeto(o);
            if (o.getHabilidad() != null) {
                setHabilidad(o.getHabilidad());
            }
        }
    }

    /**
     * Ejecuta una acción de ataque contra un rival
     * 
     * @param p Personaje rival que recibirá el impacto
     */
    public void Atacar(Personaje p) {
        // Validaciones: que el objetivo exista, no sea él mismo y ambos sigan en pie
        if (p == null || p == this || !this.estaVivo() || !p.estaVivo()) {
            return;
        }

        // Delegación de comportamiento según el patrón Strategy
        if (this.habilidadActual != null) {
            this.habilidadActual.ejecutar(this, p);
        } else {
            // Comportamiento de ataque básico por defecto
            p.recibirDano(this.ataque);
        }
    }


   
    /**
     * Ejecuta defensa básica contra futuros ataques.
     */
    public void Defender() {
        // Incremento temporal o ajuste de mitigación según la regla de juego
        this.defensa = 1; //Valor Temploar
    }

    /**
     * Aplica daño al personaje reduciendo su vida en función de su defensa
     * 
     * @param dano Cantidad de daño entrante.
     */
    public void recibirDano(int dano) {
        int danoEfectivo = Math.max(1, dano - this.defensa);
        setVida(this.vida - danoEfectivo);
    }

    /**
     * Indica si el personaje aún cuenta con puntos de vida para seguir combatiendo
     * 
     * @return true si vida > 0}, false si fue noqueado
     */
    public Boolean estaVivo() {
        return this.vida > 0;
    }

    /**
     * Actualiza el estado completo del personaje en un solo paso
     * 
     * @param o         Nuevo objeto asignado
     * @param vida      Puntos de vida actualizados
     * @param defensa   Puntos de defensa actualizados
     * @param ataque    Puntos de ataque actualizados
     * @param habilidad Nueva habilidad activa
     */
    public void Actualizar(Objeto o, int vida, int defensa, int ataque, Habilidad habilidad) {
        setObjeto(o);
        setVida(vida);
        setDefensa(defensa);
        setAtaque(ataque);
        setHabilidad(habilidad);
    }

    

    /**
     * Compara la igualdad de dos personajes con base en su identificador único
     * 
     * @param obj Objeto con el cual comparar
     * @return true si ambos personajes tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Personaje other)) return false;
        return this.id == other.id;
    }

    /**
     * Genera el código hash del personaje con base en su identificador único
     * 
     * @return Código hash entero.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }

   
}