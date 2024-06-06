package ProgramacionIII.tpe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Procesador {

    private String  id;
    private String codigoProcesador;
    private Integer anioFuncionamiento;
    private Boolean refrigerado;
    private Integer tiempoEjecucion;
    private Integer tiempoMaximo;
    private List<Tarea> tareasAsignadas;
    private static Integer MAXTAREASCRITICAS = 2;

    @Override
    public String toString() {
        return "Procesador{" +
                "id='" + id + '\'' +
                ", esta refrigerado='" + refrigerado + '\'' +
                ", codigoProcesador='" + codigoProcesador + '\'' +
                ", tiempo ejecucion='" + tiempoEjecucion + '\'' +
                ", tareasAsignadas=\n" + tareasAsignadas.toString() +
                "}\n";
    }

    public Procesador(String id, String codigoProcesador, Integer anioFuncionamiento, Boolean refrigerado) {
        this.id = id;
        this.codigoProcesador = codigoProcesador;
        this.anioFuncionamiento = anioFuncionamiento;
        this.refrigerado = refrigerado;
        this.tiempoEjecucion = 0;
        this.tiempoMaximo = -1;
        this.tareasAsignadas = new ArrayList<>();
    }

    public Procesador(String id, String codigoProcesador, Integer anioFuncionamiento, Boolean refrigerado, Integer tiempoEjecucion, Integer tiempoMaximo, List<Tarea> tareasAsignadas) {
        this.id = id;
        this.codigoProcesador = codigoProcesador;
        this.anioFuncionamiento = anioFuncionamiento;
        this.refrigerado = refrigerado;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoMaximo = tiempoMaximo;
        this.tareasAsignadas = new ArrayList<>(tareasAsignadas);
    }

    public boolean puedeAgregarTarea(Tarea t) {
        if( (!t.getEsCritica() || this.hayCupoParaTareaCritica()) && this.tieneTiempo(t.getTiempoEjecucion() )){
          return true;
        }
        return false;
    }

    public void addTarea(Tarea t){
        this.tareasAsignadas.add(t);
        this.tiempoEjecucion += t.getTiempoEjecucion();
    }

    public boolean tieneTiempo(Integer tiempoTarea){
        if(!this.refrigerado){
            return  (this.tiempoEjecucion + tiempoTarea <= this.getTiempoMaximo());
        }else{
            return true;
        }
    }

    public void removeTarea (Tarea tarea){
        this.tareasAsignadas.remove(tarea);
    }

    public boolean hayCupoParaTareaCritica(){
        List<Tarea> cupo = this.tareasAsignadas.stream().filter(tarea -> tarea.getEsCritica()).collect(Collectors.toList());
        if(cupo.size() < MAXTAREASCRITICAS){
            return true;
        }else{
            return false;
        }
    }

    public void reiniciar(){
        this.setTiempoEjecucion(0);
        this.tareasAsignadas = new ArrayList<>();
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
