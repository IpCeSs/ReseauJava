package com.cess.ReseauJAva2604;

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

public class Utilisateur extends Personne implements Relation {

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
	private int i;

	// TODO Auto-generated method stub
	/**
	 * 
	 * @return getId permet de récupérer l'id d'un utilisateur quel qu'il soit
	 */
	public int getId() {

		try {

			/**
			 * Création d'un statement
			 */
			Statement st = Connexion.getInstance().createStatement();
			String sql = "SELECT id FROM `user` WHERE nom='" + this.nom + "' AND prenom='" + this.prenom + "'";

			/**
			 * exercution requete
			 */

			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return -1;

	}

	/**
	 * constructeur de classe tous les new auront ces caractéristiques constructeur
	 * n'a pas de type de retour + même nom que classe Constructeur par défaut,
	 * chaque new user devra avoir ces infos
	 */
	public Utilisateur() {

	}

	public void setUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre nom");
		nom = sc.nextLine();

		System.out.println("Entrez votre prénom");
		prenom = sc.nextLine();

		System.out.println("Entrez votre pays de résidence");
		pays = sc.nextLine();

		System.out.println("Entrez votre date de naissance");
		dateNaissance = sc.nextLine();

		sauverEnBase(nom, prenom, dateNaissance, pays);

	}

	public void sauverEnBase(String nom, String prenom, String dateNaissance, String pays) {
		
		try {

			/**
			 * Création d'un statement qui appelle la méthode get instance de la classe connexion
			 * qui instancie la connexion SINGLETON
			 */
			Statement st = Connexion.getInstance().createStatement();
			String sql = "INSERT INTO `user` (`nom`,`prenom`,`dateNaissance`,`pays`) VALUES ('" + nom + "','" + prenom
					+ "','" + dateNaissance + "','" + pays + "')";
			/**
			 * exercution requete
			 */
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

		}
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

	public void ajouterAmi() {
		// TODO Auto-generated method stub

	}

	@Override
	String[][] getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
