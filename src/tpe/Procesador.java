package tpe;

import java.util.List;

public class Procesador {

    private String  id;
    private String codigoProcesador;
    private Integer anioFuncionamiento;
    private Boolean refrigerado;
    private Integer tiempoEjecucion;
    private Integer tiempoMaximo;
    private List<Tarea> tareasAsignadas;


    public Procesador(String id, String codigoProcesador, Integer anioFuncionamiento, Boolean refrigerado) {
        this.id = id;
        this.codigoProcesador = codigoProcesador;
        this.anioFuncionamiento = anioFuncionamiento;
        this.refrigerado = refrigerado;
        this.tiempoEjecucion = 0;
        this.tiempoMaximo = -1;
    }

    public boolean addTarea(Tarea t) {
        var ultimo = this.tareasAsignadas.size() -1;
        if((!this.tareasAsignadas.get(ultimo).getEsCritica()) && this.tieneTiempo(t.getTiempoEjecucion())){
          this.tareasAsignadas.add(t);
          this.tiempoEjecucion += t.getTiempoEjecucion();
          return true;
        }
        return false;
    }

    public boolean tieneTiempo(Integer tiempoTarea){
        if(!this.refrigerado){
            return  (this.tiempoEjecucion+tiempoTarea < this.getTiempoMaximo());
        }else{
            return true;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procesador that = (Procesador) o;
        return id.equals(that.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoProcesador() {
        return codigoProcesador;
    }

    public void setCodigoProcesador(String codigoProcesador) {
        this.codigoProcesador = codigoProcesador;
    }

    public Integer getAnioFuncionamiento() {
        return anioFuncionamiento;
    }

    public void setAnioFuncionamiento(Integer anioFuncionamiento) {
        this.anioFuncionamiento = anioFuncionamiento;
    }

    public Boolean getRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(Boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Integer tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<Tarea> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public Integer getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Integer tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }
}
