package ProgramacionIII.tp3.entregable;

public class Main {

	public static void main(String[] args) {
		

		Ciudad ayacucho = new Ciudad(1,"Ayacucho");
		Ciudad tandil = new Ciudad(2,"Tandil");
		Ciudad bolivar = new Ciudad(3,"Bolivar");
		
		Mapa mapa = new Mapa();
		
		mapa.addCiudad(ayacucho); // Agrego ayacucho
		mapa.addCiudad(tandil); // Agrego tandil
		mapa.addCiudad(bolivar); // Agrego bolivar
		
		mapa.addRuta(ayacucho, tandil, 70); // Agrego la ruta entre ayacucho-tandil de 70km
		
		
		mapa.encontrarCamino(ayacucho, bolivar); // Busco el mejor camino entre ayacucho y bolivar
		
		mapa.borrarCiudad(ayacucho); // Borro la ciudad ayacucho
		mapa.borrarRuta(ayacucho, tandil); // Borro la ruta entre ayacucho-tandil

	}

}
