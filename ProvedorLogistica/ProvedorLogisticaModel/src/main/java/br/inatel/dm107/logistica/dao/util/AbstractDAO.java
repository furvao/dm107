package br.inatel.dm107.logistica.dao.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDAO<T> {
	private Class classe;
	private Session session;
	
	private Transaction tx;

	public AbstractDAO() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		setSession(new HibernateUtil().getSessionFactory());
	}

	public void setSession(SessionFactory sf) {
		this.session = sf.openSession();
	}

	public void save(T t) {
		tx = this.session.beginTransaction();
		this.session.save(t);
		tx.commit();
		this.session.close();
	}

	public void delete(T t) {
		tx = this.session.beginTransaction();
		this.session.delete(t);
		tx.commit();
		this.session.close();
	}

	public void update(T t) {
		tx = this.session.beginTransaction();
		this.session.update(t);
		tx.commit();
		this.session.close();
	}

	public List<T> findAll() {
		tx = this.session.beginTransaction();
		return this.session.createCriteria(this.classe).list();
	}
	
	 public <T> T findById(final Class<T> type, final Integer id){
		 tx = this.session.beginTransaction();
	      return (T)  this.session.get(type, id);
	    }

}
