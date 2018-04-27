package com.cess.ReseauJAva2604;

/**
 * 
 * @author Utilisateur
 *
 */
public class Moderateur extends Utilisateur {

	private static int modo;

	/**
	 * On donne une valeur à modo dasn le constructeur pour qu'il soit toujours modo au moins niveau 1
	 */
	public Moderateur() {
		/*if (modo == 1) {
			moderateur();
		} else if (modo == 2) {
			superModerateur();
		}*/
		modo=1;
// J'aime les chats :) 
	}

	/**
	 * 
	 * @return
	 */

	public static int getModo() {
		return modo;
	}

	/**
	 * 
	 * @param modo
	 */

	public void setModo(int modo) {
		this.modo = modo;
	}
// Pourquoi les blondes mettent elles des bouteilles vides au frigo ? (réponse Menu.java)
	public static boolean isModerateur() {
		return true;
	}

}
