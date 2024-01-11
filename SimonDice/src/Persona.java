
public class Persona {
	 private int puntuacion = 0;
	 private String name;
	 
	 public Persona(String _name ,int _puntuacion ) {
		 this.name = _name;
		 this.puntuacion = _puntuacion;
	 }
	 
	 public void getNombre(String _nombre) {
		 this.name = _nombre;
	 }
	 
	 public void setNombre(String _nombre) {
		 System.out.print(_nombre);		 
	 }
}
