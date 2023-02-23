package com.gtmarttiles.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gtmarttiles.entity.Tiles;

public class Test_107 {

	public static void main(String[] args) throws HibernateException {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			Configuration cfg = new Configuration();//.configure("/com/gtmarttiles/resources/hibernate.cfg.xml");
			cfg.configure("/com/gtmarttiles/resources/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Tiles tiles = new Tiles();
			tiles.setBoxSize("12X18");
			tiles.setDesignNo("125");
			tiles.setPrize(255);

			session.delete(tiles);
			transaction.commit();
			System.out.println("success");

		} catch (Exception e) {
			transaction.rollback();
			System.out.println("failed");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
