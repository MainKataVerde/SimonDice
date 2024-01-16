import java.util.Scanner;

public class engine {
	
	Scanner scanner = new Scanner(System.in);
	
	final private int MAX_COLORES_SEQ = 12;
	
	private tColores[] secuenciaColores = new tColores [MAX_COLORES_SEQ];

	public enum tColores { ROJO , VERDE , AZUL , DORADO }
	
	
	/**
	 * metodo que empieza la secuencia del juego
	 */
	
	public void start() {
		menu();
		
		int seleccion = scanner.nextInt();
		
		if(seleccion !=1 && seleccion !=0 && seleccion !=2) {
			do {
				System.out.println("Seleccione un numero del menu");
				seleccion = scanner.nextInt();
			}while(seleccion !=1 || seleccion !=0 || seleccion !=2);
		}else {
			switch (seleccion) {
			case 0 :
					System.out.println("Gracias por jugar");
				break;
			case 1:
					play();
				break;
			}
		}
	}
	/**
	 * Metodo que ejecuta todo el juego en si mismo
	 */
	public void play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome To Simon dice !");
        System.out.print("What is your name? ");
        String nombre = scanner.nextLine();
        
        System.out.println();
        
        Persona jugador = new Persona(nombre,0);
        
        System.out.println("Hello "+jugador.getNombre(nombre)+", press ENTER to start playing");

        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
        }        
    	generarSecuencia(4);
        
        
        for (int i = 0; i < 12; i++) {
    		mostrarSecuencia(3+i);
    		
        	System.out.println();
    		
    		System.out.println("Pulsa ENTER cuando hayas memorizado todo");

            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
            }
            
           for (int k = 0; k < 50; k++)
            	System.out.println();
            
    		System.out.print("Introduce los colores : ");
    		
    		char letra = scanner.next().charAt(0);
    								
    		int v = 0 ;
    		
    		boolean fallo = false ;
    		
    		if (comprobarColor(0, charColores(letra))==false) {
    			v++;
    			while (v<3+i && fallo != true) {
    				System.out.print("Introduce el siguiente color : ");
    				letra = scanner.next().charAt(0);
    				if (comprobarColor(v, charColores(letra))==false) {
    					v++;
    				}else {
    					fallo = true;
    					System.out.println("Fallaste");
    					i= 13;
    				}
    			}
    		}else {
    			i = 13;
    			System.out.println("Fallaste");
      		}
		}
	}
	
	/**
	 * Metodo que nos muestra las secuencias antes dichas generadas en el metodo generarsecuencia
	 * @param _numero
	 * @param secuenciaColores
	 */
	public void mostrarSecuencia (int _numero) {
		System.out.print("Secuencia : ");
		for (int i = 0; i < _numero; i++) {
			System.out.print(this.secuenciaColores[i] + " ");
		}
	}
	
	
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
	
	/**
	 * Metodo para pasar un tipo enum a string para hacer mas ameno el texto 
	 * @param _color
	 * @return
	 */
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
	
	public void menu() {
		System.out.println("0 - SALIR || 1 - JUGAR || 2 - COMMING SOON"); 
	}
	
}
