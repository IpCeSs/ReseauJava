package com.cess.ReseauJAva2604;

abstract class Personne {
	
	/**
	 * Les filles de la classe Personne (ndlr: Utilisateur) devront obligatoirement utiliser les
	 * fonctions abstraites contenues ici
	 */
	abstract void setUser();

	abstract String[][] getUsers();

	abstract boolean isModerateur();

}
