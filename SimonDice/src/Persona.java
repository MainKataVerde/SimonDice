/**
 * Clase que representa a todos los jugadores que van a jugar al juego con todas sus caracteristicas
 * @author Oscar Nzabarinda Mukeshiamana
 */

public class Persona {
	
	 private int puntuacion;
	 private String name;
	 
	 public Persona(String _name) {
		 this.name = _name;
		 this.puntuacion = 0;
	 }
	 
	 /**
	  * Metodo que nos da el nombre que hemos puesto al jugador 
	  * @return el nombre del jugador que hemos puesto con el metodo setNombre
	  */
	 
	 public String getNombre() {		 
		 return name ;
	 }
	 
	 /**
	  * Metodo que pone nombre a nuestro jugador un nombre 
	  * @param _nombre este parametro representa el nombre que quieremos ponerle a nuestro jugador
	  */
	 
	 public void setNombre(String _nombre) {
		 this.name = _nombre;	 
	 }
	 
	 /**
	  * Metodo que nos perdimete ponerle una puntuacion al jugador
	  * @param _puntos
	  */
	 
	 public void setPuntuacion(int _puntos) {
		 this.puntuacion = _puntos;
	 }
	 
	 
	 /**
	  * Metodo que nos permite saber la puntuacion del jugador;
	  * @return
	  */
	 public int getPuntuacion() {
		 return this.puntuacion;
	 }
}