public abstract class Habilidad{
    private String nombre;
    private String descripcion;

    public Habilidad(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract void ejecutar(Personaje usuario, Personaje objetivo);

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Habilidad habilidad = (Habilidad) obj;
        return nombre.equals(habilidad.nombre) &&
                descripcion.equals(habilidad.descripcion);
    }
}