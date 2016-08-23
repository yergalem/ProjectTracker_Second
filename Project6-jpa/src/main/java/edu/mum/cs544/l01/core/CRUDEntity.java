package edu.mum.cs544.l01.core;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.mum.cs544.l01.database.DataAccess;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.repository.BaseRepositoryDAO;

public class CRUDEntity implements BaseRepositoryDAO {

	protected SessionFactory sessionFactory = DataAccess.getSessionFactory();
	protected Class<Project> clazz;
	protected Session session;

	Transaction tx;
	
	public CRUDEntity() {

        session = sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	public void setupEntityClass(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public void insert(CustomEntity object) {
		tx = session.beginTransaction();

		session.saveOrUpdate(object); /// persist
		tx.commit();
		//session.close();

	}

	@Override
	public void update(CustomEntity object) {

		tx = session.beginTransaction();

		session.merge(object);

		tx.commit();
	}

	@Override
	public void insertOrUpdate(CustomEntity object) {

	}

	@Override
	public void delete(CustomEntity object) {

		tx = session.beginTransaction();

		sessionFactory.getCurrentSession().delete(object);

		tx.commit();
	}

	@Override
	public CustomEntity findById( long id) {

		session.beginTransaction();
		    CustomEntity anEntity = (CustomEntity) session.get( clazz, id);			
	    session.getTransaction().commit();

        session.close();
        
		return anEntity;
	}

}
