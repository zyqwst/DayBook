package com.albert.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.albert.domain.EntityBase;
import com.albert.utils.BookException;
@Repository
public  class  CommonDaoImpl implements CommonDao{
	@PersistenceContext
	EntityManager em;

	@Override
	public <T extends EntityBase> void save(T t) throws BookException {
		em.persist(t);
	}

	@Override
	public <T extends EntityBase> void update(T t) throws BookException {
		em.merge(t);
	}

	@Override
	public  <T extends EntityBase>  void deleteById(Class<T> clazz,Long id) throws BookException {
		em.remove(findEntityById(clazz, id));
	}

	@Override
	public <T extends EntityBase> T findEntityById(Class<T> clazz, Long id) throws BookException {
		return (T) em.find(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntity(String hql, List<Object> params) throws BookException {
		return null;
	}

	@Override
	public <T extends EntityBase> void delete(T t) throws BookException {
		em.remove(t);
	}

	

	
	
	
}
