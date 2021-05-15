package ProgramacionIII.tp3.entregable;

public class Ciudad {

	private int id;
	private String nombre;
	private int estacionesDeServicio;
	private boolean tieneBalanza;
	private boolean tieneRadar;
	private int tallerMecanicos;

	public Ciudad(int id, String nombre) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public boolean isTieneBalanza() {
		return tieneBalanza;
	}

	public void setTieneBalanza(boolean tieneBalanza) {
		this.tieneBalanza = tieneBalanza;
	}

	public int getEstacionesDeServicio() {
		return estacionesDeServicio;
	}

	public void setEstacionesDeServicio(int estacionesDeServicio) {
		this.estacionesDeServicio = estacionesDeServicio;
	}

	public boolean isTieneRadar() {
		return tieneRadar;
	}

	public void setTieneRadar(boolean tieneRadar) {
		this.tieneRadar = tieneRadar;
	}

	public int getTallerMecanicos() {
		return tallerMecanicos;
	}

	public void setTallerMecanicos(int tallerMecanicos) {
		this.tallerMecanicos = tallerMecanicos;
	}

	public int getId() {
		return id;
	}

}
