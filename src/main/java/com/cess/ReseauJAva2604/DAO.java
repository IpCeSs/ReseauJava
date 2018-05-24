package com.cess.ReseauJAva2604;

public abstract class DAO<T> {

		   
	  public DAO(){
	   
	  }
	   
	  /**
	  * Méthode de création
	  * @param obj
	  * @return boolean 
	  */
	  public abstract T create(T obj);
	  

	  /**
	  * Méthode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public abstract void delete(int id);

	  /**
	  * Méthode de mise à jour
	  * @param obj
	  * @return boolean
	  */
	  public abstract boolean update(T obj);

	  /**
	  * Méthode de recherche des informations
	  * @param id
	  * 
	  */
	  /**
	   * find partie de tout ex amis partie de users
	   * @param obj
	   */
	  
	  public abstract T find(int id);
	 

	  
	  
	  
	
	}

