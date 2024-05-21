package tpe;

public class Procesador {

    private Integer  id;
    private Integer codigoProcesador;
    private Integer anioFuncionamiento;
    private Boolean refrigerado;

    public Procesador(Integer id, Integer codigoProcesador, Integer anioFuncionamiento, Boolean refrigerado) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoProcesador() {
        return codigoProcesador;
    }

    public void setCodigoProcesador(Integer codigoProcesador) {
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
