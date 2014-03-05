package edu.mcm.cas757.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseDao<T> {

	/**
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param);

    public Object avg(String hql, Object[] param);


	public List<T> find(String hql, Object[] param, Integer page, Integer rows);


	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);


	public T get(Class<T> c, Serializable id);


	public T get(String hql, Object[] param);


	public T get(String hql, List<Object> param);


	public Long count(String hql);


	public Long count(String hql, Object[] param);


	public Long count(String hql, List<Object> param);


	public Integer executeHql(String hql);


	public Integer executeHql(String hql, Object[] param);


	public Integer executeHql(String hql, List<Object> param);
	

	public List<T> findBySql(String sql, Class tclass);
	

	public List<Map> findMapListBySql(String sql);
}
