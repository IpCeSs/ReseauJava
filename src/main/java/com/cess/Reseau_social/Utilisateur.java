package com.cess.Reseau_social;

public class Utilisateur {

	private String nom;
	private String prenom;
	private String pays;
	private String dateNaissance;
	// TODO Auto-generated method stub

	// constructeur de classe tous les new auront ces caractéristiques constructeur
	// n'a pas de type de retour + même nom que classe
	// Constructeur par défaut, chaque new user devra avoir ces infos
	public Utilisateur() {

		System.out.println("Création d'un utilisateur");
		nom = "Inconnu";
		prenom = "Inconnu";
		pays = "INCONNU";
		dateNaissance = "Inconnu";

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
	
	
	

}
