package com.albert.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.albert.dao.CommonDao;
import com.albert.domain.EntityBase;
import com.albert.service.CommonService;
import com.albert.utils.BookException;
import com.albert.utils.Page;

@Service
@Transactional
public class CommonServiceImpl implements CommonService{
	@Resource
	private  CommonDao  commonDao;

	@Override
	public <T extends EntityBase> void save(T t) throws BookException {
		commonDao.save(t);
	}

	@Override
	public <T extends EntityBase> void update(T t) throws BookException {
		commonDao.update(t);
	}

	@Override
	public <T extends EntityBase>  void delete(Class<T> clazz,Long id) throws BookException {
		commonDao.deleteById(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntityById(Class<T> clazz, Long id) throws BookException {
		return commonDao.findEntityById(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntity(Class<T> clazz ,String hql, List<Object> params) throws BookException {
		return commonDao.findEntity(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase> List<T> findAll(Class<T> clazz, String hql, List<Object> params)
			throws BookException {
		return commonDao.findAll(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase>void updateByHql(Class<T> clazz, String hql, List<Object> params)
			throws BookException {
		commonDao.update(clazz, hql, params);
	}

	/* (non-Javadoc)
	 * @see com.albert.service.CommonService#findPage(java.lang.Class, com.albert.utils.Page)
	 */
	@Override
	public <T extends EntityBase> Page<T> findPage(Class<T> clazz, Page<T> page) throws BookException {
		return commonDao.findPage(clazz, page);
	}

	
	
}
