package com.albert.dao;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.albert.domain.EntityBase;
import com.albert.utils.BookException;
import com.albert.utils.Page;
@Repository
@SuppressWarnings("unchecked")
public  class  CommonDaoImpl  implements CommonDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public <T extends EntityBase> void save(T t) throws BookException {
		em.persist(t);
	}

	@Override
	public <T extends EntityBase> void update(T t) throws BookException {
		em.merge(t);
		em.flush();
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
				if(i%30==0){
					em.flush();em.clear();
				}
			}
		}
		query.executeUpdate();
	}

	public <T extends EntityBase> Page<T> findPage(Class<T> clazz,Page<T> page) {
		Query query = em.createQuery(" from " + clazz.getName()+page.getRequestMap().getJpql().toString());
		query.setFirstResult(page.getPageNumber()*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List<Object> params = page.getRequestMap().getParams();
		if(page.getRequestMap().getParams()!=null && params.size()>0){
			for(int i = 1;i<=params.size();i++){
				query.setParameter(i, params.get(i-1));
			}
		}
		List<T> results = query.getResultList();
		page.setResults(results);
		return page;
	}
	       


}
