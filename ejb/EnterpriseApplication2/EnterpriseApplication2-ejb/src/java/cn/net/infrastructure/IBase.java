package cn.net.infrastructure;


import java.util.List;
import javax.persistence.Query;

public interface IBase<T> {

	/**
��
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Class<? extends T> clazz, long id);

	/**

	 * @param t
	 * @return
	 */
	public T persist(T t);

	/**
	 * �������
	 * 
	 * @param t
	 * @return
	 */
	public T merge(T t);

	/**

	 * @param clazz
	 * @param id
	 * @return
	 */
	public T remove(Class<? extends T> clazz, long id);

	/**
	 * 
	 * @param t
	 * @return
	 */
	public T remove(T t);

	/**

	 * 
	 * @param clazz
	 * @return
	 */
	public List<T> listAll(Class<? extends T> clazz);

	public List<T> list(String jpql);

	/**
��
	 * 
	 * @param clazz
	 * @return
	 */
	public int getTotalCount(Class<? extends T> clazz);

	/**
����
	 * 
	 * @param clazz
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(Class<? extends T> clazz, int firstResult, int maxResult);

	/**
��
	 * 
	 * @param jpql
	 * @return
	 */
	public int getTotalCount(String jpql);

	/**
�����
	 * 
	 * @param jpql
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(String jpql, int firstResult, int maxResult);

	/**
	 * ���� Query ����
	 * 
	 * @param jpql
	 * @return
	 */
	public Query createQuery(String jpql);
        
        
        public T findUnique(String jpql);

}
