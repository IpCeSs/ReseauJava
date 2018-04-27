package com.cess.ReseauJAva2604;

/**
 * 
 * @author Utilisateur
 *
 */
public class Moderateur extends Utilisateur {

	private int modo;

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

	}

	/**
	 * 
	 * @return
	 */

	public int getModo() {
		return modo;
	}

	/**
	 * 
	 * @param modo
	 */

	public void setModo(int modo) {
		this.modo = modo;
	}

	

}
