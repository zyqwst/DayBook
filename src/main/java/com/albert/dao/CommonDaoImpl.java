package com.albert.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.albert.domain.EntityBase;
import com.albert.utils.BookException;
@Repository
@SuppressWarnings("unchecked")
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
	public <T extends EntityBase> T findEntity(Class<T> clazz ,String hql, List<Object> params) throws BookException {
		Query  query = em.createQuery(" FROM " + clazz.getName() + hql );
		if(params!=null && params.size()>0){
			for(int i = 1;i<=params.size();i++){
				query.setParameter(i, params.get(i-1));
			}
		}
		return  (T) query.getSingleResult();  
	}
	@Override
	public <T extends EntityBase> List<T> findAll(Class<T> clazz ,String hql, List<Object> params) throws BookException {
		Query  query = em.createQuery(" FROM " + clazz.getName() + hql );
		if(params!=null && params.size()>0){
			for(int i = 1;i<=params.size();i++){
				query.setParameter(i, params.get(i-1));
			}
		}
		return  (List<T>) query.getResultList();  
	}
	@Override
	public <T extends EntityBase> void delete(T t) throws BookException {
		em.remove(t);
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public <T extends EntityBase> void update(Class<T> clazz, String hql, List<Object> params) throws BookException {
		Query  query = em.createQuery(" update " + clazz.getName() + hql );
		if(params!=null && params.size()>0){
			for(int i = 1;i<=params.size();i++){
				query.setParameter(i, params.get(i-1));
			}
		}
		query.executeUpdate();
	}

	

	
	
	
}
