package ProgramacionIII.tpe;

public class Procesador {

    private String  id;
    private String codigoProcesador;
    private Integer anioFuncionamiento;
    private Boolean refrigerado;

    public Procesador(String id, String codigoProcesador, Integer anioFuncionamiento, Boolean refrigerado) {
        this.id = id;
        this.codigoProcesador = codigoProcesador;
        this.anioFuncionamiento = anioFuncionamiento;
        this.refrigerado = refrigerado;
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
}
