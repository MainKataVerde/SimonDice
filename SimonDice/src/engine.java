import java.util.Scanner;
/**
 * Proyecto de segunda evaluacion , Simon Dice 
 * @author Oscar Nzabarinda Mukeshiamana
 */
public class engine {
	
	Scanner scanner = new Scanner(System.in);
	
	final private int MAX_COLORES_SEQ = 12;
	
	private int z = 0 ;
	
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
				case 0:
					System.out.println("Gracias por jugar");
					break;
				case 1:
					if (z <= 0) {
						Scanner sc3 = new Scanner(System.in);
						System.out.println("Welcome To Simon dice !");
						System.out.print("What is your name? ");
						String nombre = sc3.nextLine();

						System.out.println();

						Persona jugador = new Persona("", 0);

						jugador.setNombre(nombre);

						System.out.println("Hello " + jugador.getNombre(nombre) + ", press ENTER to start playing");
				}
				z++;
				play();
				break;
			}
		}
	}
	/**
	 * Metodo que ejecuta todo el juego en si mismo
	 */
	public void play() {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);


        if (scanner.hasNextLine()) {
            String s = sc.nextLine();
        }        
    	generarSecuencia(4);
        
    	int i = 0 ;
    	
    	boolean fallo = false;
    	
		
		String regex = "^[a-zA-Z]$";

    	
		do {
			
			mostrarSecuencia(3+i);

			System.out.println();

			System.out.println("Pulsa ENTER cuando hayas memorizado todo");

			if (scanner.hasNextLine()) {
				String s = sc.nextLine();
			}

			for (int k = 0; k < 50; k++) {
				System.out.println();
			}

			System.out.print("Introduce los colores : ");

			char letra = sc2.next().charAt(0);

			fallo = false;
			
			int v = 0;
			
			if (String.valueOf(letra).matches("^[a-zA-Z]$")) {
				if (comprobarColor(0, charColores(letra)) == false) {
					v++;
					while (v < (3 + i) && fallo != true) {
						System.out.print("Introduce el siguiente color : ");
						letra = sc2.next().charAt(0);
						if (comprobarColor(v, charColores(letra)) == false) {
							v++;
						} else {
							fallo = true;
							System.out.println("Fallaste");
							start();
						}
					}
				} else {
					System.out.println("Fallaste");
					fallo = true;
					start();
				}
				i++;
			} else {
				System.out.println("Error introduce un caracter");
				start();
			}

			if (i >= this.MAX_COLORES_SEQ - 2) {
				System.out.println();
				System.out.println("HAS GANADO ENHORABUENAAAAA!!!!!!!");
				start();
			}
		}while (i < this.MAX_COLORES_SEQ -2 && fallo != true);
		
		
	}
	
	
	/**
	 * Metodo que nos muestra las secuencias antes dichas generadas en el metodo generarsecuencia
	 * @param _numero
	 * @param secuenciaColores
	 */
	public void mostrarSecuencia (int _numero) {
		System.out.print("Secuencia : ");
		for (int i = 0; i < _numero ; i++) {
			System.out.print(motrarColores(this.secuenciaColores[i])+ " ");
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
	
	/**
	 * Metodo que genera una suencia aleatoria de nuemero y la introduce dentro de una array
	 * @param _numColores
	 */
	
	public void generarSecuencia(int _numColores) {	
        for (int i = 0; i < this.secuenciaColores.length; i++) {
            this.secuenciaColores[i] = intToColor((int)Math.floor(Math.random()*_numColores+1));
		}
		
	}
	
	/**
	 * Metodo que comrueba si el color introducido es igual al que hemos introducido en la array
	 * @param _index
	 * @param _color
	 * @return
	 */
	
	public boolean comprobarColor(int _index , tColores _color) {
		
		Boolean compr = false ;
		if (_color != this.secuenciaColores[_index]) {
			compr = true;
		}
		
		return compr;
	}
	
	/**
	 * Metodo que nos muestra un menu basico con 3 opciones 2 de ellas funcionales
	 */
	
	public void menu() {
		System.out.println("0 - SALIR || 1 - JUGAR || 2 - COMMING SOON"); 
	}
	
}
