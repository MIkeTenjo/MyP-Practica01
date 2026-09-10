import aplicacion.franquicia.Franquicia;
import aṕlicacion.habilidad.Habilidad;

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

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public String getNombre(){
        return nombre;
    }

    public float getTiempoDeUso(){
        return tiempoDeUso;
    }

    public void setTiempoDeUso(float tiempoDeUso){
        this.tiempoDeUso = tiempoDeUso;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void consumir(float tiempo){
        if(tiempoDeUso > 0){
            this.tiempoDeUso -= tiempo;
        }
        efectoAlConsumir();
    }

    public abstract void efectoAlConsumir();

    public boolean estaConsumido(){
        return tiempoDeUso <= 0;
    }

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