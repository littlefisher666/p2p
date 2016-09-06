package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.GenericDao;

public class GenericDaoImpl<E extends Serializable,PK extends Serializable > extends HibernateDaoSupport implements GenericDao<E,PK>{

	protected Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		entityClass = (Class<E>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}
	
	
	@Override
	public void delete(E e) {
		getHibernateTemplate().delete(e);
	}

	@Override
	public void deleteById(PK id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(entityClass, id));
	}

	@Override
	public void insert(E e) {
		getHibernateTemplate().save(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> selectAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E selectById(PK id) {
		return (E) getHibernateTemplate().load(entityClass, id);
	}

	@Override
	public void update(E e) {
		getHibernateTemplate().update(e);
	}

}
