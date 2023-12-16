import java.util.Scanner;
public class Main {
	
	public enum tColores { Rojo , Verde , Azul , Dorado }

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		final int MAX_COLORES_SEQ = 4;
		
		
		
		System.out.println("Welcome To Simon dice !");
		System.out.print("What is your name? ");
		String nombre = scanner.nextLine();
		System.out.println("Hello "+nombre+", press ENTER to start playing");
		
		if (scanner.hasNextLine()) {
			String s = scanner.nextLine();
      }
		
		System.out.print("Secuancia numero 1 : ");
		
		
		tColores array_colores[] = new tColores [MAX_COLORES_SEQ];
		array_colores = tColores.values();
				
		for (int i = 0; i < array_colores.length -1; i++) {	
			int valorDado = (int)Math.floor(Math.random()*3+0);
			System.out.print(array_colores[valorDado] + " ");
		}
		
		System.out.println();
		
		
		System.out.print("Escribe : ");

	char eleccolor = scanner.next().charAt(0);
	
	
	}
	
	tColores charColores (char _color) {
		
		tColores eleccionColores = tColores.Dorado;
		
		char letraColores = Character.toLowerCase(_color);
	
		if (letraColores == 'r') {
			eleccionColores = tColores.Rojo;
		}else if (letraColores == 'v') {
			eleccionColores = tColores.Verde;
		}else if (letraColores == 'a') {
			eleccionColores = tColores.Azul;
		}
		
		
		return eleccionColores;
		
	}

}
