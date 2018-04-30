package com.cess.ReseauJAva2604;

/**
 * 
 * @author Utilisateur
 *
 */
public class Moderateur extends Utilisateur {

	private int modo;
	private int modId;

	/**
	 * @info On donne une valeur à modo dans le constructeur pour qu'il soit
	 *       toujours modo au moins niveau 1
	 */
	public Moderateur() {

		modo = 1;
	}

	/**
	 * 
	 * @return
	 */

	public int getModo() {
		return this.modo;
	}

	/**
	 * @param modo
	 */

	/*
	 * @info setModo permet de créer un utilisateur modo avec setUser et en plus il
	 * est modo
	 */
	public void setModo(int modo) {
		setUser();
		this.modo = modo;
	}

	public boolean isModerateur() {
		return true;
	}

}
