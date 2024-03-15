package main;

import java.io.IOException;

/**
 * Proyecto de segunda evaluacion , Simon Dice 
 * @author Oscar Nzabarinda Mukeshiamana
 */

public class Main {
	
	/** 
	 * @param args
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
			engine engine = new engine();
			
			engine.start();
	}
}