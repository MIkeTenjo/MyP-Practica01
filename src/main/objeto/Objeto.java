package objeto;

import franquicia.Franquicia;
import habilidad.Habilidad;
import personaje.Personaje;

/**
 * Clase que representa los objetos que pueden ser consumidos por los personajes.
 * Cada objeto solo puede ser consumido por un personaje de la misma franquicia, además
 * por el uso del objeto se va consumiendo dentro del personaje hasta que ya no tenga ningún efecto.
 */
public abstract class Objeto{
    private Franquicia franquicia;
    private String nombre;
    private float tiempoDeUso;
    private Habilidad habilidad;

    public Objeto(Franquicia franquicia, String nombre,
                  float tiempoDeUso, Habilidad habilidad){
        this.franquicia = franquicia;
        this.nombre = nombre;
        this.tiempoDeUso = tiempoDeUso;
        this.habilidad = habilidad;
    }

    /**
     * Obtiene la franquicia a la que pertenece el objeto.
     * @return La franquicia del objeto.
     */
    public Franquicia getFranquicia() {
        return franquicia;
    }

    /**
     * Obtiene el nombre del objeto.
     * @return El nombre del objeto.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el tiempo de uso del objeto.
     * @return El tiempo de uso del objeto.
     */
    public float getTiempoDeUso(){
        return tiempoDeUso;
    }

    /**
     * Establece el tiempo de uso del objeto.
     * @param tiempoDeUso El tiempo de uso del objeto.
     */
    public void setTiempoDeUso(float tiempoDeUso){
        this.tiempoDeUso = tiempoDeUso;
    }

    /**
     * Regresa la habilidad que posee el objeto.
     * @return La habilidad del objeto.
     */
    public Habilidad getHabilidad() {
        return habilidad;
    }

    /**
     * Consume el objeto y aplica un efecto a un personaje si lo tiene.
     * @param tiempo El tiempo que ha pasado desde que se utilizó el objeto.
     * @param personaje El personaje que será afectado al consumirse
     * el  objeto.
     */
    public void consumir(int tiempo, Personaje personaje){
        if(!estaConsumido()){
            tiempoDeUso -= tiempo;
            if(tiempoDeUso < 0){
                tiempoDeUso = 0;
            }
        }else{
            habilidad = null;
            efectoConsumir(personaje);
        }
    }

    /**
     * Método abstracto que define el efecto que tendrá el objeto al ser consumido por un personaje.
     * Puede no tener efecto alguno.
     * @param personaje El personaje que será afectado al consumirse el objeto.
     */
    protected abstract void efectoConsumir(Personaje personaje);

    /**
     * Método que nos dice si un objeto todavía puede usarse 
     * al ser consumido o se consumió por completo
     * @return true si el objeto ya no puede usarse, false en caso contrario.
     */
    public boolean estaConsumido(){
        return tiempoDeUso <= 0;
    }

    /**
     * Método que compará si dos objetos consumibles son iguales.
     * @param obj El objeto a comparar con el objeto actual.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Objeto objeto = (Objeto) obj;
        return Float.compare(objeto.tiempoDeUso, tiempoDeUso) == 0 &&
                franquicia == objeto.franquicia &&
                nombre.equals(objeto.nombre) &&
                habilidad.equals(objeto.habilidad);
    }
    
}