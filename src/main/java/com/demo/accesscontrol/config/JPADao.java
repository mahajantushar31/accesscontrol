package com.demo.accesscontrol.config;
/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.accesscontrol.entity.RoleTab;
/**
 * @author Tushar mahajan
 *
 */
/*
public class JPADao {

	private static final EntityManagerFactory emFactoryObj;
	private static final String PERSISTENCE_UNIT_NAME="JPADao";
	
	static {
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	// this Method is used to retrieve the 'entityManager' Object
	public static EntityManager getEntityManager() {
		return emFactoryObj.createEntityManager();
	}
	
	public static void main(String[] args) {
		EntityManager entityMgr= getEntityManager();
		entityMgr.getTransaction().begin();
		
		
		RoleTab roletab=new RoleTab();
		roletab.setRoleName("Admin"); 
		entityMgr.persist(roletab);
		entityMgr.getTransaction().commit();
		entityMgr.clear();
		System.out.println(" Reords Succesfully inserted in the Data");
	}
}
*/