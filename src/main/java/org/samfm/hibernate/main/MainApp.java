package org.samfm.hibernate.main;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.samfm.hibernate.model.Address;
import org.samfm.hibernate.model.UserDetails;
import org.samfm.hibernate.model.Vehicle;

public class MainApp {

	public static void main(String[] args) {
		Address address1 = new Address();
		address1.setCity("Beasain");
		address1.setCountry("Spain");
		address1.setPostcode("20200");
		address1.setStreet("Zaldizurreta");
		
		Address address2 = new Address();
		address2.setCity("Urretxu");
		address2.setCountry("Spain");
		address2.setPostcode("20700");
		address2.setStreet("Zero");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVechicleName("Jeep");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVechicleName("Opel");

		UserDetails user1 = new UserDetails();
		user1.setUserName("Jorge");
		user1.getListOfAddress().add(address1);
		user1.getListOfAddress().add(address2);
		user1.addVehicle(vehicle1);
		user1.addVehicle(vehicle2);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user1);
		
		session.getTransaction().commit();
		session.close();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
		criteria.
		
		
	}

}
