import java.util.Scanner;
/**
 * Proyecto de segunda evaluacion , Simon Dice 
 * @author Oscar Nzabarinda Mukeshiamana
 */

public class Main {
	
    public enum tColores { Rojo , Verde , Azul , Dorado }

	public static void main(String[] args) {
		play();
		
	}
	
	/**
	 * Metodo en el que le proporcionamos un char(primer caracter del color) y nos devuelve el tipo color corespondiente
	 * @param _color
	 * @return
	 */
	
	public static tColores charColores (char _color) {
        tColores eleccionColores = null;

        char letraColores = Character.toLowerCase(_color);
        
        	switch (letraColores) {
			case 'r':
                eleccionColores = tColores.Rojo;
				break;
			case 'v':
                eleccionColores = tColores.Verde;
				break;
			case 'a':
                eleccionColores = tColores.Azul;
				break;
			case 'd':
                eleccionColores = tColores.Dorado;
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
	
	public static tColores intToColor(int _numero) {
        tColores posicionColores = null;
		switch (_numero) {
		case 1:
            posicionColores = tColores.Rojo;
			break;
		case 2:
			posicionColores = tColores.Verde;
			break;
		case 3:
			posicionColores = tColores.Azul;
			break;
		case 4:
			posicionColores = tColores.Dorado;
			break;
		default:
			System.out.println("Numero fuera del rango");
		}
		
			return posicionColores;
	}
	
	/**
	 * Metodo para generar una secuencia aleatoria en la array de colores
	 * @param _numColores
	 */
	
	public static void generarSecuencia(int _numColores , tColores secuenciaColores[]) {	
		
        for (int i = 0; i < secuenciaColores.length; i++) {
        	int valorDado = (int)Math.floor(Math.random()*_numColores+1);            
            secuenciaColores[i] = intToColor(valorDado);
		}
		
	}
	
	/**
	 * Metodo que comprueba si el color que hemos introducido es el correcto en comparacion a la posicion en la array
	 * @param _index
	 * @param _color
	 * @param secuenciaColores
	 * @return
	 */
	
	public static boolean comprobarColor(int _index , tColores _color , tColores secuenciaColores[]) {
		
			Boolean compr = null ;
			if (_color == secuenciaColores[_index]) {
				compr = false;
			} else if (_color != secuenciaColores[_index]) {
				compr = true;
			}
			return compr;
		}
	
	/**
	 * Metodo que imprime la secuencia en pantalla
	 * @param _numero
	 * @param secuenciaColores
	 */
	
	public static void mostrarSecuencia (int _numero , tColores secuenciaColores[] ) {
		System.out.print("Secuencia : ");
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}
	
	/**
	 * Metodo para ejecutar el juego 
	 */
	
	public static void play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome To Simon dice !");
        System.out.print("What is your name? ");
        String nombre = scanner.nextLine();
        System.out.println("Hello "+nombre+", press ENTER to start playing");

        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
        }
        
        final int MAX_COLORES_SEQ = 12;
		
        tColores secuenciaColores[] = new tColores[MAX_COLORES_SEQ];
        
    	generarSecuencia(4 , secuenciaColores);
        
        
        for (int i = 0; i < 12; i++) {
        	
        	

        	
    		
    		mostrarSecuencia(3+i, secuenciaColores);
    		
        	System.out.println();
    		
    		System.out.println("Pulsa ENTER cuando hayas memorizado todo");

            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
            }
            
           /* for (int k = 0; k < 50; k++)
            	System.out.println();*/
            
    		System.out.print("Introduce los colores : ");
    		
    		char letra = scanner.next().charAt(0);
    								
    		int v = 0 ;
    		
    		if (comprobarColor(0, charColores(letra), secuenciaColores)==false) {
    			v++;
    			while (v<3+i) {
    				System.out.print("Introduce el siguiente color : ");
    				letra = scanner.next().charAt(0);
    				if (comprobarColor(v, charColores(letra), secuenciaColores)==false) {
    					v++;
    				}else {
    					v = secuenciaColores.length;
    					System.out.println("Fallaste");
    				}
    			}
    		}else {
    			i = 13;
<<<<<<< HEAD
    			System.out.println("Fallaste");//
=======
    			System.out.println("Fallaste");//intento
>>>>>>> branch 'main' of https://github.com/MainKataVerde/SimonDice.git
    		}
		}
		
	}
}