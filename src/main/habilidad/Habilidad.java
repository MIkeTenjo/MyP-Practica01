package habilidad;

import personaje.Personaje;

/**
 * Clase abstracta que representa una habilidad utilizada por el personaje que 
 * fue otorgada por un objeto.
 * Es abstracta porque una habilidad tiene diferentes efectos a ejecutar en los
 * personajes.
 */
public abstract class Habilidad{
    private final String nombre;
    private final String descripcion;

    public Habilidad(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Ejecuta la habilidad sobre los personajes afectados.
     * @param usuario El personaje que utiliza la habilidad.
     * @param objetivo El personaje enemigo del usuario a afectar con la habilidad.
     */
    public abstract void ejecutar(Personaje usuario, Personaje objetivo);

    /**
     * Obtiene el nombre de la habilidad.
     * @return El nombre de la habilidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción de la habilidad.
     * @return La descripción de la habilidad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Compara esta habilidad con otro objeto.
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Habilidad habilidad = (Habilidad) obj;
        return nombre.equals(habilidad.nombre) &&
                descripcion.equals(habilidad.descripcion);
    }
}