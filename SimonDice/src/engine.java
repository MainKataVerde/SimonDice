import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que tiene toda la logica del juego aqui se va ejecutar todo la logica
 * en si misma del poyecto
 * 
 * @author Oscar Nzabarinda Mukeshiamana
 */
public class engine {

	Scanner scanner = new Scanner(System.in);

	final private int MAX_COLORES_SEQ = 15;

	private int contador = 0;

	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	public enum tColores {
		ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA
	}

	public enum tModo {
		FACIL, DIFICIL
	}


	int ayudas = 3;

	final private int MAX_COLORES_FACIL = 4;

	final private int MAX_COLORES_DIFICIL = 7;

	/**
	 * metodo que empieza la secuencia del juego
	 * @throws IOException 
	 */
	public void start() throws IOException {
		menu();
		int seleccion = scanner.nextInt();
		Record record = new Record();
		do {
			Persona jugador = new Persona(null);
			record.añadirJugador(jugador);
			if (contador >= 1) {
				menu();
				seleccion = scanner.nextInt();
			}
			contador++;
			if (contador <= 0 ) {
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Welcome To Simon dice !");
				System.out.print("What is your name? ");
				String nombre = sc3.nextLine();

				System.out.println();

				jugador.setNombre(nombre);

				System.out.println("Hello " + jugador.getNombre() + ", press ENTER to start playing");
			}
			switch (seleccion) {
				case 0:
					System.out.println("Gracias por jugar");
					break;
				case 1:
					play(tModo.FACIL);
					jugador.setPuntuacion(play(tModo.FACIL));
					break;

				case 2:
					play(tModo.DIFICIL);
					jugador.setPuntuacion(play(tModo.DIFICIL));
					break;

				case 3 :
					record.escribirRanking();
					record.cargarRanking();
					break;

				case 4 : 
					record.showBestRanking();
					break;

				default:
					System.out.println("No existe ningun modo " + seleccion);
					break;

			}
		} while (seleccion != 0);

	}

	/**
	 * Metodo que nos permite perdir una ayuda , cuando lo ejecutamos nos enseña el
	 * siguiente colo de la secuencia en la que estamos para que todo sea mas facil
	 * 
	 * @param index Numero en le que se encuentra el color
	 * @return booleano que nos dice , si es false es que no hay ayudas pero si es
	 *         true eso es que hay ayudas
	 */
	public boolean usarAyuda(int index) {

		if (ayudas > 0) {
			System.out.println("Dispones de " + this.ayudas + " ayudas");
			ayudas--;
			System.out.println("Te quedan " + ayudas + " ayudas ");
			System.out.println("El siguiente color es " + this.secuenciaColores[index]);
			System.out.print("Introduce color " + (index + 1) + ":");
			return true;
		} else {
			System.out.println("No tienes ayudas suficientes");
			System.out.print("Introduce color " + (index + 1) + ":");
			return false;
		}

	}

	/**
	 * Metodo que ejecuta todo el juego en si mismo
	 */
	public int play(tModo _modo) {

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		int puntos = 0 ; 

		if (_modo == tModo.FACIL) {
			generarSecuencia(MAX_COLORES_FACIL);
		} else {
			generarSecuencia(MAX_COLORES_DIFICIL);
		}

		int i = 0;

		boolean fallo = false;

		do {

			mostrarSecuencia(3 + i);

			System.out.println();

			System.out.println("Pulsa ENTER cuando hayas memorizado todo");

			if (scanner.hasNextLine()) {
				String s = sc.nextLine();
			}

			for (int k = 0; k < 50; k++) {
				System.out.println();
			}

			fallo = false;

			int vueltas = 0;

			while (vueltas < (3 + i) && fallo != true) {
				System.out.print("Introduce color " + (vueltas + 1) + " : ");
				char letra = sc2.next().charAt(0);
				if (String.valueOf(letra).matches("^[a-zA-Z]$")) {
					if (letra == 'x') {
						usarAyuda(vueltas);
						if (_modo == tModo.FACIL)
							puntos -= 8 ;
						else
							puntos -= 16 ; 
						letra = sc2.next().charAt(0);
					}
					if (comprobarColor(vueltas, charColores(letra)) == false) {
						vueltas++;
						if (_modo == tModo.FACIL) 
							puntos += 2;
						 else 
							puntos += 4;						
					} else {
						if (puntos < 0) 
							puntos = 0;
						
						fallo = true;
						System.out.println("Fallaste");
						System.out.println("Sus puntos son : " + puntos);

					}
				} else {
					if (puntos < 0) 
						puntos = 0;
					
					System.out.println("Error introduce un caracter");
					System.out.println("Sus puntos son : " + puntos);
				}

			}
			if (vueltas >= (3 + i)) {

				if (_modo == tModo.FACIL) 
					puntos += 5 ;
				 else 
					puntos += 15 ;
				

			}
			i++;
			if (i >= this.MAX_COLORES_SEQ - 2) {
				if (_modo == tModo.FACIL) {
					puntos += 40 ;
				} else {
					puntos += 80 ;
				}

				if (puntos < 0) {
					puntos = 0 ; 
				}
				System.out.println();
				System.out.println("HAS GANADO ENHORABUENAAAAA!!!!!!!");
				System.out.println("Sus puntos son : " + puntos);
			}
		} while (i < this.MAX_COLORES_SEQ - 2 && fallo != true);
		return puntos;
	}

	/**
	 * Metodo que nos muestra las secuencias antes dichas generadas en el metodo
	 * generarsecuencia
	 * 
	 * @param _numero Parametro que nos mide el numero de colores que queremos que
	 *                nos muestre en pantalla
	 */
	public void mostrarSecuencia(int _numero) {
		System.out.print("Secuencia : ");
		for (int i = 0; i < _numero; i++) {
			System.out.print(motrarColores(this.secuenciaColores[i]) + " ");
		}
	}

	/**
	 * Metodo en el que le proporcionamos un char(primer caracter del color) y nos
	 * devuelve el tipo color corespondiente
	 * 
	 * @param _color este va ha ser el char que introduzca el jugador para que nos
	 *               lo pase a un color y posteriormente comprobarlo con las funcion
	 *               comprobarcolor
	 * @return color seleccionado por el usuario este mismo pero pasado a tipo
	 *         tcolores
	 */
	public tColores charColores(char _color) {
		tColores eleccionColores = null;
		switch (Character.toLowerCase(_color)) {
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
			case 'b':
				eleccionColores = tColores.BLANCO;
				break;
			case 'm':
				eleccionColores = tColores.MARRON;
				break;
			case 'n':
				eleccionColores = tColores.NARANJA;
				break;
		}
		return eleccionColores;
	}

	/**
	 * Metodo en el que le proporcionamos un tipo int (numero) y nos devuelve un
	 * tipo color de la list enumerada
	 * 
	 * @param _numero numero que introduciremos para que nos devulva un color
	 * @return nos devuelve su equivalente
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
			case 5:
				posicionColores = tColores.BLANCO;
				break;
			case 6:
				posicionColores = tColores.MARRON;
				break;
			case 7:
				posicionColores = tColores.NARANJA;
				break;
		}
		return posicionColores;
	}

	/**
	 * Metodo para pasar un tipo enum a string para hacer mas ameno el texto
	 * 
	 * @param _color aqui pondremos el color para que nos de su equivalente en
	 *               string
	 * @return nos devuelve la equivalencia de un color a una string en el que esta
	 *         escrito mas amigable
	 */
	public String motrarColores(tColores _color) {
		String stringcolor = null;
		switch (_color) {
			case ROJO:
				stringcolor = "Rojo";
				break;
			case VERDE:
				stringcolor = "Verde";
				break;
			case AZUL:
				stringcolor = "Azul";
				break;
			case DORADO:
				stringcolor = "Dorado";
				break;
			case BLANCO:
				stringcolor = "Blanco";
				break;
			case MARRON:
				stringcolor = "Marron";
				break;
			case NARANJA:
				stringcolor = "Naranja";
				break;
		}
		return stringcolor;
	}

	/**
	 * Metodo que genera una suencia aleatoria de nuemero y la introduce dentro de
	 * una array
	 * 
	 * @param _numColores el parametro nos indica el rango maximo de numeros que
	 *                    quiere que salga al generar los numeros
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < this.secuenciaColores.length; i++) {
			this.secuenciaColores[i] = intToColor((int) Math.floor(Math.random() * _numColores + 1));
		}
	}

	/**
	 * Metodo que comrueba si el color introducido es igual al que hemos introducido
	 * en la array
	 * 
	 * @param _index el indice de la array
	 * @param _color el color par comprar
	 * @return debuelve falso si la comparacion es igual y cuando es diferente
	 *         devuelve true ya que es correcto que has fallado
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		Boolean compr = false;
		if (_color != this.secuenciaColores[_index]) {
			compr = true;
		}
		return compr;
	}

	/**
	 * Metodo que nos muestra un menu basico con 3 opciones 2 de ellas funcionales
	 */
	public void menu() {
		System.out.println("0 - SALIR || 1 - MODO FACIL || 2 - MODO DIFICIL || 3 - TOP 10 MEJORES JUGADORES || 4 - EL MEJOR JUGADOR");
	}
}
