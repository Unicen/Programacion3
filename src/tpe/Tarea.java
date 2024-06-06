package ProgramacionIII.tpe;

public class Tarea {

    private String  id;
    private String nombre;
    private Integer tiempoEjecucion;
    private Boolean esCritica;
    private Integer nivelPrioridad;

    public Tarea(String id, String nombre, Integer tiempoEjecucion, Boolean esCritica, Integer nivelPrioridad) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.esCritica = esCritica;
        this.nivelPrioridad = nivelPrioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", tiempoEjecucion=" + tiempoEjecucion +
                ", esCritica=" + esCritica +
                ", nivelPrioridad=" + nivelPrioridad +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id.equals(tarea.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Integer tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Boolean getEsCritica() {
        return esCritica;
    }

    public void setEsCritica(Boolean esCritica) {
        this.esCritica = esCritica;
    }

    public Integer getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(Integer nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

}
