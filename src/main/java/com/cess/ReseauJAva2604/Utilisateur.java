package com.cess.ReseauJAva2604;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * @author Utilisateur Utilisateur etend la classe abstraite Personne et réecrit
 *         les méthodes abstraites de Personne setUser(), getUsers(),
 *         isModerateur()
 *
 */

public class Utilisateur {

	/**
	 * Les attribiuts sont en private, si on souhaite les modifier dasn une autre
	 * classe, c'est cette classe qui en prendra la "responsabilité" en lesmodifiant
	 * via les methodes publiques de la première classe Ainsi, les valeurs de base
	 * des attributs ne seront jamais exposées à des changements
	 */

	private String nom;
	private String prenom;
	private String pays;
	private String dateNaissance;
	private int id;
	
	/**
	 * constructeur de classe tous les new auront ces caractéristiques constructeur
	 * n'a pas de type de retour + même nom que classe Constructeur par défaut,
	 * chaque new user devra avoir ces infos
	 */
	public Utilisateur() {

	}
	/**
	 * 
	 * @return getId permet de récupérer l'id d'un utilisateur quel qu'il soit
	 */
	public int getId() {
		return id;
		
		
		
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isModerateur() {
		return false;
	}


	

}
