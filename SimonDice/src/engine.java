
public class engine {
	
	final private int MAX_COLORES_SEQ = 12;
	
	private tColores[] secuenciaColores = new tColores [MAX_COLORES_SEQ];

	public enum tColores { ROJO , VERDE , AZUL , DORADO }
	
	
	/**
	 * Metodo en el que le proporcionamos un char(primer caracter del color) y nos devuelve el tipo color corespondiente
	 * @param _color
	 * @return
	 */
	
	public tColores charColores (char _color) {
        tColores eleccionColores = null;

        char letraColores = Character.toLowerCase(_color);
        
        	switch (letraColores) {
			case 'r':
                eleccionColores = tColores.ROJO;
				break;
			case 'v':
                eleccionColores = tColores.VERDE;
				break;
			case 'a':
                eleccionColores = tColores.AZUL;
				break;
			case 'd':
                eleccionColores = tColores.DORADO;
				break;
			default:
				System.out.println("No conincide con ningun color");
		
			}
            return eleccionColores;
		}
	
	
	/**
	 * Metodo en el que le proporcionamos un tipo int (numero) y nos devuelve un tipo color de la list enumerada
	 * @param _numero
	 * @return
	 */
	
	public tColores intToColor(int _numero) {
        tColores posicionColores = null;
		switch (_numero) {
		case 1:
            posicionColores = tColores.ROJO;
			break;
		case 2:
			posicionColores = tColores.VERDE;
			break;
		case 3:
			posicionColores = tColores.AZUL;
			break;
		case 4:
			posicionColores = tColores.DORADO;
			break;
		default:
			System.out.println("Numero fuera del rango");
		}
		
			return posicionColores;
	}
	
	public String motrarColores(tColores _color) {
		
		String stringcolor = null ;
		
		switch(_color) {
			case ROJO : 
					stringcolor = "Rojo";
				break;
			case VERDE :
					stringcolor = "Verde";
				break;
			case AZUL :
					stringcolor = "Azul";
				break;
			case DORADO :
					stringcolor = "Dorado";
				break;
		}
		
		return stringcolor;
	}
	
	public void generarSecuencia(int _numColores) {	
		
        for (int i = 0; i < this.secuenciaColores.length; i++) {
        	int valorDado = (int)Math.floor(Math.random()*_numColores+1);            
            this.secuenciaColores[i] = intToColor(valorDado);
		}
		
	}
	
	public boolean comprobarColor(int _index , tColores _color) {
		
		Boolean compr = false ;
		if (_color != this.secuenciaColores[_index]) {
			compr = true;
		}
		
		return compr;
	}
	
}
