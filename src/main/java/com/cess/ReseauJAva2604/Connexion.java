package com.cess.ReseauJAva2604;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	/**
	 * On crée un singleton car l'objet connexion doit être instancié seulement une
	 * fois tout private
	 */

	private static String url = "jdbc:mysql://localhost/java";
	private static String login = "root";
	private static String passwd = "";
	private static Connection cn;

	public static Connection getInstance() {
		/**
		 * Si la connexion n'éxiste pas == null on la crée sous entendu si elle existe
		 * on ne l'instancie pas à nouveau
		 */
		if (cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				/**
				 * récupération de la connexion
				 */
				cn = DriverManager.getConnection(url, login, passwd);
				System.out.println("Connexion réussie!");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	/*	} else {
			System.out.println("Connexion à la base de données déjà existante");
		}*/
		}
		return cn;
	}

	public static void close() {
		try {
			cn.close();
			System.out.println("Base de donées déconnectée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
