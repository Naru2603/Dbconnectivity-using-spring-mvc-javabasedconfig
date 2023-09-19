package com.infosys.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveEmployeeToDb(Employee emp) {

		boolean result = false;
		try {
			Session session = sessionFactory.openSession();

			Transaction txn = session.beginTransaction();
			session.save(emp);
			txn.commit();
			session.close();
			result = true;
		} catch (Exception e) {
			System.out.println("Exception occuered while storing employee : " + e.getMessage());
		}

		return result;
	}

	public List<Employee> viewEmployee() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Employee> Emplist = null;
		try {

			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery("from Employee");
			Emplist = query.list();
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace(System.err);
		} finally {
			session.close();
			return Emplist;
		}
	}
}
