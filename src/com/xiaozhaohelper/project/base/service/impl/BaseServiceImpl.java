package com.xiaozhaohelper.project.base.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaozhaohelper.project.base.dao.BaseDao;
import com.xiaozhaohelper.project.base.service.BaseService;
import com.xiaozhaohelper.project.base.util.HQLConditionQuery;
import com.xiaozhaohelper.project.base.util.HQLOrderBy;

@Transactional
public abstract class BaseServiceImpl<E extends java.io.Serializable, PK extends java.io.Serializable> implements BaseService<E,PK>{

	protected BaseDao<E,PK> baseDao;
	
	public abstract void setBaseDao(BaseDao<E,PK> baseDao);
	
	@Override
	public PK save(E entity) {
		return this.baseDao.save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		this.baseDao.saveOrUpdate(entity);
	}

	@Override
	public void deleteByPK(PK pk) {
		this.baseDao.deleteByPK(pk);
	}

	@Override
	public void delete(E entity) {
		this.baseDao.delete(entity);
	}

	@Override
	public void update(E entity) {
		this.baseDao.update(entity);
	}

	@Override
	public E getByPK(PK pk) {
		return this.baseDao.getByPK(pk);
	}

	@Override
	public E loadByPK(PK pk) {
		return this.baseDao.loadByPK(pk);
	}

	@Override
	public boolean exists(PK pk) {
		return this.baseDao.exists(pk);
	}

	@Override
	public List<E> list() {
		return this.baseDao.list();
	}

	@Override
	public List<E> list(boolean cacaheable) {
		return this.baseDao.list(cacaheable);
	}

	@Override
	public <T> T count() {
		return this.baseDao.count();
	}
	
	@Override
	public <T> T count(boolean cacheable) {

		return this.baseDao.count(cacheable);
	}

	@Override
	public <T> T count(List<HQLConditionQuery> conditions) {
		return this.baseDao.count(conditions);
	}

	@Override
	public <T> T count(List<HQLConditionQuery> conditions, boolean cacheable) {
		return this.baseDao.count(conditions, cacheable);
	}

	@Override
	public <T> T count(String hql, List<HQLConditionQuery> querys) {
		return this.baseDao.count(hql, querys);
	}

	@Override
	public <T> T count(String hql, List<HQLConditionQuery> querys,
			boolean cacheable) {
		// TODO Auto-generated method stub
		return this.baseDao.count(hql, querys, cacheable);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys) {
		return this.baseDao.list(querys, orderBys);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, boolean cacheable) {
		return this.baseDao.list(querys, orderBys, cacheable);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys) {
		return this.baseDao.list(hql, querys, orderBys);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, boolean cacheable) {
		return this.baseDao.list(hql, querys, orderBys, cacheable);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize) {
		return this.baseDao.list(querys, orderBys, pageNum, pageSize);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize,
			boolean cacheable) {
		return this.baseDao.list(querys, orderBys, pageNum, pageSize, cacheable);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize) {
		return this.baseDao.list(hql, querys, orderBys, pageNum, pageSize);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize,
			boolean cacheable) {
		return this.baseDao.list(hql, querys, orderBys, pageNum, pageSize, cacheable);
	}

	@Override
	public <T> List<T> find(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys) {
		return this.baseDao.find(hql, querys, orderBys);
	}

	@Override
	public <T> List<T> find(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize) {
		return this.baseDao.find(hql, querys, orderBys, pageNum, pageSize);
	}
}