package main;

/**
 * Clase que representa a todos los jugadores que van a jugar al juego con todas sus caracteristicas
 * @author Oscar Nzabarinda Mukeshiamana
 */

public class Persona {
	
	 private int puntuacion;
	 private String name;
	 
	 public Persona(String _name , int _puntos) {
		 this.name = _name;
		 this.puntuacion = _puntos;
	 }
	 
	 /**
	  * Metodo que nos da el nombre que hemos puesto al jugador 
	  * 0(1)
	  * @return el nombre del jugador que hemos puesto con el metodo setNombre
	  */
	 
	 public String getNombre() {		 
		 return name ;
	 }
	 
	 /**
	  * Metodo que pone nombre a nuestro jugador un nombre 
	  * 0(1)
	  * @param _nombre este parametro representa el nombre que quieremos ponerle a nuestro jugador
	  */
	 
	 public void setNombre(String _nombre) {
		 this.name = _nombre;	 
	 }
	 
	 /**
	  * Metodo que nos perdimete ponerle una puntuacion al jugador
	  * 0(1)
	  * @param _puntos numero al que quieres igualar 
	  */
	 
	 public void setPuntuacion(int _puntos) {
		 this.puntuacion = _puntos;
	 }
	 
	 
	 /**
	  * Metodo que nos permite saber la puntuacion del jugador
	  * 0(1)
	  * @return
	  */
	 public int getPuntuacion() {
		 return this.puntuacion;
	 }
}