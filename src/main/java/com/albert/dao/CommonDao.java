package com.albert.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.albert.domain.EntityBase;
import com.albert.utils.BookException;
@NoRepositoryBean  
public interface  CommonDao{
	public<T extends EntityBase> void save(T t) throws BookException;
	
	public<T extends EntityBase>  void update(T t) throws BookException;
	
	public  <T extends EntityBase>  void deleteById(Class<T> clazz,Long id) throws BookException;
	
	public <T extends EntityBase> void delete(T t) throws BookException;
	
	public<T extends EntityBase>  T findEntityById(Class<T> clazz,Long id) throws BookException;
	
	public<T extends EntityBase> T findEntity(String hql,List<Object> params) throws BookException;
	
	
}
