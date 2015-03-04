package com.xiaozhaohelper.project.base.dao;

import java.io.Serializable;

public interface BaseDao<E extends Serializable, PK extends Serializable>{
		public PK save(E entity);
		
		public void saveOrUpdate(E entity);
		
		public void deleteByPK(PK pk);
		
		public void delete(E entity);
		
}
