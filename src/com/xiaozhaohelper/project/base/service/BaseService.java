package com.xiaozhaohelper.project.base.service;

import java.io.Serializable;
import java.util.List;

import com.xiaozhaohelper.project.base.util.HQLConditionQuery;
import com.xiaozhaohelper.project.base.util.HQLOrderBy;

@org.springframework.transaction.annotation.Transactional
public interface BaseService<E extends Serializable, PK extends Serializable> {
	public PK save(E entity);

	public void saveOrUpdate(E entity);

	public void deleteByPK(PK pk);

	public void delete(E entity);

	public void update(E entity);

	public E getByPK(PK pk);

	public E loadByPK(PK pk);

	public boolean exists(PK pk);

	public List<E> list();

	public List<E> list(boolean cacaheable);

	public <T> T count();

	public <T> T count(boolean cacheable);

	public <T> T count(List<HQLConditionQuery> conditions);

	public <T> T count(List<HQLConditionQuery> conditions, boolean cacheable);

	public <T> T count(String hql, List<HQLConditionQuery> querys);

	public <T> T count(String hql, List<HQLConditionQuery> querys,
			boolean cacheable);

	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys);

	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, boolean cacheable);

	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys);

	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, boolean cacheable);

	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);

	public List<E> list(List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize,
			boolean cacheable);

	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);

	public List<E> list(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize,
			boolean cacheable);

	public <T> List<T> find(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys);

	public <T> List<T> find(String hql, List<HQLConditionQuery> querys,
			List<HQLOrderBy> orderBys, final int pageNum, final int pageSize);
}
