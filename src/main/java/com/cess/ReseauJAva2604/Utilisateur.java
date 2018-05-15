package com.cess.ReseauJAva2604;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 
 * @author Utilisateur
 * Utilisateur etend la classe abstraite Personne et réecrit les méthodes abstraites
 * de Personne setUser(), getUsers(), isModerateur()
 *
 */

public class Utilisateur extends Personne implements Relation{

	/**
	 * Les attribiuts sont en private, si on souhaite les modifier dasn une autre
	 * classe, c'est cette classe qui en prendra la "responsabilité" en lesmodifiant
	 * via les methodes publiques de la première classe Ainsi, les valeurs de base
	 * des attributs ne seront jamais exposées à des changements
	 */
	private static int userId = 0;
	String users[][] = new String[10][5];
	private String nom;
	private String prenom;
	private String pays;
	private String dateNaissance;

	// TODO Auto-generated method stub

	/** constructeur de classe tous les new auront ces caractéristiques constructeur
	* n'a pas de type de retour + même nom que classe
	* Constructeur par défaut, chaque new user devra avoir ces infos
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

	public static void sauverEnBase(String nom, String prenom, String dateNaissance, String pays) {
		/**
		 * infos d'accès à la BDD
		 */
		String url = "jdbc:mysql://localhost/java";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn = null;
		java.sql.Statement st = null;
		try {
			/**
			 * Chargement du driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * récupération de la connexion
			 */
			cn = DriverManager.getConnection(url, login, passwd);
			/**
			 * Création d'un statement
			 */
			st = cn.createStatement();
			String sql = "INSERT INTO `user` (`nom`,`prenom`,`dateNaissance`,`pays`) VALUES ('" + nom + "','" + prenom + "','" + dateNaissance + "','" + pays + "')";
			/**
			 * exercution requete
			 */
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				/**
				 * libérer ressource memoire, fermeture connection
				 */
				cn.close();
				st.close();
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		Utilisateur.userId = userId;
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

	public String[][] getUsers() {
		return this.users;
	}

	public boolean isModerateur() {
		return false;
	}

	public void ajouterAmi() {
		// TODO Auto-generated method stub
		
	}
	
	

}
