package com.xiaozhaohelper.project.base.dao;

import java.io.Serializable;
import java.util.List;

import com.xiaozhaohelper.project.base.util.HQLConditionQuery;
import com.xiaozhaohelper.project.base.util.HQLOrderBy;

public interface BaseDao<E extends Serializable, PK extends Serializable> {
	public PK save(E entity);

	public void saveOrUpdate(E entity);

	public void deleteByPK(PK pk);

	public void delete(E entity);

	public void update(E entity);

	public E getByPK(PK pk);

	public E loadByPK(PK pk);

	public boolean exists(PK pk);

	/*
	 * 删除指定的缓存对象
	 */
	public void evict(E entity);

	public List<E> list();

	public List<E> list(boolean cacheable);

	public <T> T count();

	public <T> T count(boolean cacheable);

	/*
	 * 把缓存对象存入数据库
	 */
	public void flush();

	/**
	 * 清空缓存
	 */
	public void clear();

	public <T> T count(List<HQLConditionQuery> query);

	public <T> T count(List<HQLConditionQuery> query, boolean cacheable);

	public <T> T count(String hql, List<HQLConditionQuery> query);

	public <T> T count(String hql, List<HQLConditionQuery> query,
			boolean cacheable);

	public List<E> list(List<HQLConditionQuery> query, List<HQLOrderBy> orderBy);

	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, boolean cacheable);

	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys);

	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, boolean cacheable);

	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);

	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize,
			boolean cacheable);

	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);

	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize,
			boolean cacheable);

	public <T> List<T> find(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys);

	public <T> List<T> find(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);

}
