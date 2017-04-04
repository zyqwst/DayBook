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
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void update(T t) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> T findEntityById(Class<T> clazz, Long id) throws BookException {
		return (T) em.find(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntity(String hql, List<Object> params) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
