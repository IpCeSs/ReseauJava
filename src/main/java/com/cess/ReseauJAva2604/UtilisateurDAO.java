package com.cess.ReseauJAva2604;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilisateurDAO extends DAO<Utilisateur> {

	int friend;

	Scanner sc=new Scanner(System.in);

	@Override
	public Utilisateur create(Utilisateur user) {
		
		Utilisateur returnUser = user;
		try {

			/**
			 * Création d'un statement qui appelle la méthode get instance de la classe
			 * connexion qui instancie la connexion SINGLETON
			 */
			PreparedStatement prSt = (PreparedStatement) Connexion.getInstance()
					.prepareStatement("INSERT INTO `user` (`nom`,`prenom`,`dateNaissance`,`pays`) VALUES (?,?,?,?)");

			prSt.setString(1, user.getNom());
			prSt.setString(2, user.getPrenom());
			prSt.setString(3, user.getDateNaissance());
			prSt.setString(4, user.getPays());

			prSt.executeUpdate();

			returnUser.setId(this.getId(user));

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return returnUser;
	}

	public Utilisateur createMod(Utilisateur mod, int level) {
		Utilisateur moderation = create(mod);
	
		return moderation;

	}

	public ArrayList<Utilisateur> showAllUsers() {

		ArrayList<Utilisateur> userList = new ArrayList<Utilisateur>();
		try {
			Statement st = Connexion.getInstance().createStatement();
			String sql = "SELECT * FROM user";
			ResultSet rs = st.executeQuery(sql);
			/**
			 * on parcours le result set rs NB : on est obligé de faire une ligne pour
			 * chaque colonne du tableau
			 */
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setDateNaissance(rs.getString("dateNaissance"));
				utilisateur.setPays(rs.getString("pays"));
				/**
				 * On ajoute l'utilisateur à la liste de tous les utilisateurs userList
				 */
				userList.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}

	public ArrayList<Utilisateur> getAllFriends(Utilisateur user) {

		ArrayList<Utilisateur> amiList = new ArrayList<Utilisateur>();
		try {

			/**
			 * On specifie amigo qui correspond à l'user ami pour dire que ce sont ses
			 * données à lui que l'on veut et non celles du current user
			 */
			String sql = "SELECT amigo.* FROM user current JOIN ami a ON a.user_id=current.id JOIN user amigo ON amigo.id=a.friend_id WHERE current.id =?";

			PreparedStatement pstat = Connexion.getInstance().prepareStatement(sql);
			/**
			 * on set une valeur pour le ? si on avait plusieurs point d'interogations, on
			 * accederai au prenmier avec 1 au second avec 2 etc
			 */
			pstat.setInt(1, user.getId());
			ResultSet rs = pstat.executeQuery();

			/**
			 * on parcours le result set rs
			 */

			while (rs.next()) {
				Utilisateur ami = new Utilisateur();
				ami.setId(rs.getInt("id"));
				ami.setNom(rs.getString("nom"));
				ami.setPrenom(rs.getString("prenom"));
				ami.setDateNaissance(rs.getString("dateNaissance"));
				ami.setPays(rs.getString("pays"));
				/**
				 * On ajpute l'utilisateur à la liste
				 */
				amiList.add(ami);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amiList;
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement pstat = (PreparedStatement) Connexion.getInstance()
					.prepareStatement("DELETE FROM user WHERE id = ?");
			pstat.setInt(1, id);
			// execute delete SQL statement
			pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteFriend(Utilisateur user, int ami) {
		try {
			PreparedStatement pstat = (PreparedStatement) Connexion.getInstance()
					.prepareStatement("DELETE FROM ami WHERE user_id = ? AND friend_id = ?");
			pstat.setInt(1, user.getId());
			pstat.setInt(2, ami);
			// execute delete SQL statement
			pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addOneFriend(Utilisateur user, int ami) {
		try {

			/**
			 * Création d'un statement
			 */
			PreparedStatement pStat = (PreparedStatement) Connexion.getInstance()
					.prepareStatement("INSERT INTO `ami` (`user_id`,`friend_id`) VALUES (?,?)");
			pStat.setInt(1, user.getId());
			pStat.setInt(2, ami);
			/**
			 * execution requete
			 */
			pStat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId(Utilisateur user) {
		try {

			/**
			 * Création d'un statement
			 */
			PreparedStatement prSt = (PreparedStatement) Connexion.getInstance()
					.prepareStatement("SELECT id FROM `user` WHERE nom=? AND prenom=?");
			prSt.setString(1, user.getNom());
			prSt.setString(2, user.getPrenom());

			/**
			 * exercution requete
			 */

			ResultSet rs = prSt.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return -1;

	}

}
