package cn.net.infrastructure;

import cn.net.domain.entity.Schedule;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;



public class BaseImpl<T> implements IBase<T> {
        
	@PersistenceContext(unitName = "EnterpriseApplication2-ejbPU")
	protected EntityManager em;
      
	public T persist(T t) {
		em.persist(t);
                
		return t;
	}
        

	public T remove(Class<? extends T> clazz, long id) {
		T t = em.find(clazz, id);
		return remove(t);
	}

	public T remove(T t) {
		em.remove(t);
		return t;
	}

	public T find(Class<? extends T> clazz, long id) {
		T t = em.find(clazz, id);
		return t;
	}

	public T merge(T t) {
            
		em.merge(t);
		return t;
	}

	public List<T> listAll(Class<? extends T> clazz) {
		return list(" from " + clazz.getSimpleName());
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String jpql) {
		return em.createQuery(jpql).getResultList();
	}
       

	public int getTotalCount(Class<? extends T> clazz) {
		return (Integer) em.createQuery(
				" SELECT COUNT(t) FROM " + clazz.getSimpleName() + " t ")
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Class<? extends T> clazz, int firstResult, int maxResult) {
		return em.createQuery(" SELECT t FROM " + clazz.getSimpleName() + " t ").setFirstResult(
				firstResult).setMaxResults(maxResult).getResultList();
	}

	public int getTotalCount(String jpql) {
		return (Integer) em.createQuery(jpql).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String jpql, int firstResult, int maxResult) {
		return em.createQuery(jpql).setFirstResult(firstResult).setMaxResults(
				maxResult).getResultList();
	}

	public Query createQuery(String jpql) {
		return em.createQuery(jpql);
	}
        
        public void persistAll(List<T> list){
  
             for (Iterator<T> it = list.iterator(); it.hasNext();) {
                T t = it.next();
                  em.persist(t);
            }
          
        }
          public void persistAll(Set<T> set){
              for (Iterator<T> it = set.iterator(); it.hasNext();) {
                  T t = it.next();
                    em.persist(t);
              }
        }

    @Override
    public T findUnique(String jpql) {
     return  (T)em.createQuery(jpql).getSingleResult();
    }
}
