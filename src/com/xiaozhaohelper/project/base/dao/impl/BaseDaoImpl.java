package com.xiaozhaohelper.project.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaozhaohelper.project.base.dao.BaseDao;
import com.xiaozhaohelper.project.base.util.HQLConditionQuery;
import com.xiaozhaohelper.project.base.util.HQLOrderBy;

public class BaseDaoImpl<E extends Serializable, PK extends Serializable>
		implements BaseDao<E, PK> {

	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class); 
	
	@Autowired
	private SessionFactory sessionFactory;

	private Class<E> entityClass = null;
	private String pkName = null;
	private String HQL_ALL = null;
	private String HQL_COUNT_ALL = null;

	public BaseDaoImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}
		HQL_ALL = " select " + entityClass.getSimpleName() + " from "
				+ entityClass.getSimpleName() + " "
				+ entityClass.getSimpleName();
		HQL_COUNT_ALL = " select count(*) from  " + entityClass.getSimpleName()
				+ " " + entityClass.getSimpleName();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public PK save(E entity) {
		// TODO Auto-generated method stub
		return (PK) getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void deleteByPK(PK pk) {
		// TODO Auto-generated method stub
		getSession().delete(pk);
	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub
		getSession().delete(entity);
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

	@Override
	public E getByPK(PK pk) {
		// TODO Auto-generated method stub
		return (E) getSession().get(entityClass, pk);
	}

	@Override
	public E loadByPK(PK pk) {
		// TODO Auto-generated method stub
		return (E) getSession().get(entityClass, pk);
	}

	@Override
	public boolean exists(PK pk) {
		// TODO Auto-generated method stub
		return (this.getByPK(pk)==null);
	}

	@Override
	public void evict(E entity) {
		// TODO Auto-generated method stu
		getSession().evict(entity);
	}

	@Override
	public List<E> list() {
		// TODO Auto-generated method stub
		return this.list(false);
	}

	@Override
	public List<E> list(boolean cacheable) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(this.entityClass);
		return criteria.setCacheable(cacheable).list();
	}

	@Override
	public <T> T count() {
		// TODO Auto-generated method stub
		return (T) this.count(false);
	}

	@Override
	public <T> T count(boolean cacheable) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(this.entityClass);
		criteria.setProjection(Projections.rowCount());
		return (T) criteria.setCacheable(cacheable).uniqueResult();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		getSession().flush();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		getSession().clear();
	}

	@Override
	public <T> T count(List<HQLConditionQuery> query) {
		// TODO Auto-generated method stub
		return this.count(this.HQL_COUNT_ALL, query );
	}
	
	@Override
	public <T> T count(List<HQLConditionQuery> query, boolean cacheable) {
		// TODO Auto-generated method stub
		return this.count(this.HQL_COUNT_ALL, query, cacheable);
	}

	@Override
	public <T> T count(String hql, List<HQLConditionQuery> query) {
		// TODO Auto-generated method stub
		return this.count(this.HQL_COUNT_ALL, query, false);
	}

	@Override
	public <T> T count(String hql, List<HQLConditionQuery> query,
			boolean cacheable) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer(hql);
		if(query != null && query.size() > 0) {
			this.appendConditions(buffer, query);
		}
		Query q = getSession().createQuery(buffer.toString());
		if(query != null && query.size() >0) {
			this.setParameters(q, query);
		}
		return (T) q.setCacheable(cacheable).uniqueResult();
	}

	@Override
	public List<E> list(List<HQLConditionQuery> query, List<HQLOrderBy> orderBy) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBy);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, boolean cacheable) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBys, cacheable);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBys, false);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, boolean cacheable) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuffer = new StringBuffer(hql);
		if(query!= null && query.size()>0) {
			this.appendConditions(hqlBuffer, query);
		}
		if(orderBys!=null && orderBys.size()>0) {
			this.appendOrderBys(hqlBuffer, orderBys);
		}
		
		Query q = getSession().createQuery(hqlBuffer.toString());
		
		if(query!=null && query.size()> 0) {
			this.setParameters(q, query);
		}
		return q.setCacheable(cacheable).list();
	}

	@Override
	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBys, pageNum, pageSize);
	}

	@Override
	public List<E> list(List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize,
			boolean cacheable) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBys, pageNum, pageSize, cacheable);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return this.list(this.HQL_ALL, query, orderBys, pageNum, pageSize, false);
	}

	@Override
	public List<E> list(String hql, List<HQLConditionQuery> query,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize,
			boolean cacheable) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuffer = new StringBuffer(hql);
		if(query != null && query.size()> 0) {
			this.appendConditions(hqlBuffer, query);
		}
		if(orderBys!=null && orderBys.size() >0 ) {
			this.appendOrderBys(hqlBuffer, orderBys);
		}
		Query  q = getSession().createQuery(hqlBuffer.toString());
		if(query!=null && query.size() >0 ) {
			this.setParameters(q, query);
		}
		
		if(pageNum < 1 || pageSize <1) {
			return q.setCacheable(cacheable).list();
		} else {
			return q.setCacheable(cacheable).setFirstResult(pageSize*(pageNum-1)).setMaxResults(pageSize).list();
		}
	}

	@Override
	public <T> List<T> find(String hql, List<HQLConditionQuery> conditions,
			List<HQLOrderBy> orderBys) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuffer = new StringBuffer(hql);
		if(conditions != null && conditions.size() > 0) {
			this.appendConditions(hqlBuffer, conditions);
		}
		if(orderBys != null && orderBys.size() > 0) {
			this.appendOrderBys(hqlBuffer, orderBys);
		}
		
		Query query = getSession().createQuery(hqlBuffer.toString());
		
		if(conditions != null && conditions.size() > 0) {
			this.setParameters(query, conditions);
		}
		return query.setCacheable(false).list();	}

	@Override
	public <T> List<T> find(String hql, List<HQLConditionQuery> conditions,
			List<HQLOrderBy> orderBys, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuffer = new StringBuffer(hql);
		if(conditions != null && conditions.size() > 0) {
			this.appendConditions(hqlBuffer, conditions);
		}
		if(orderBys != null && orderBys.size() > 0) {
			this.appendOrderBys(hqlBuffer, orderBys);
		}
		Query query = getSession().createQuery(hqlBuffer.toString());
		
		if(conditions != null && conditions.size() > 0) {
			this.setParameters(query, conditions);
		}
		
		if(pageNum < 1 || pageSize < 1) {
			return query.setCacheable(false).list();
		} else {
			return query.setCacheable(false).setFetchSize(pageSize * (pageNum - 1)).setMaxResults(pageSize).list();
		}
	}
	
	private void appendConditions(StringBuffer sql, List< ? extends HQLConditionQuery> conditions) {
		int i = 0;
		for(HQLConditionQuery condition : conditions) {
			if(i == 0) {
				sql.append(" where ");
				sql.append(condition.getCondition());
			} else {
				sql.append(" and ");
				sql.append(condition.getCondition());
			}
			i++;
		}
	}
	
	private void setParameters(Query query, List<? extends HQLConditionQuery> conditions) {
		for(HQLConditionQuery condition : conditions) {
			if(condition.getValue() instanceof Date) {
				query.setTimestamp(condition.getName(), (Date)condition.getValue());
			} else if(condition.getValue() instanceof Collection) {
				query.setParameterList(condition.getName(),(Collection)condition.getValue());
			} else {
				query.setParameter(condition.getName(), condition.getValue());
			}
		}
	}
	
	private void appendOrderBys(StringBuffer sql, List< ? extends HQLOrderBy> orderBys) {
		int i = 0;
		for(HQLOrderBy orderBy : orderBys) {
			if(i == 0) {
				sql.append(" order by ");
				sql.append(orderBy.getOrder());
			} else {
				sql.append(" , ");
				sql.append(orderBy.getOrder());
			}
			i++;
		}
	}

}
