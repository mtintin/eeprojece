/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.repositories;

import cn.net.domain.entity.Teacher;
import cn.net.infrastructure.BaseImpl;
import java.util.List;

/**
 *
 * @author y
 */
public class TeacherDao extends BaseImpl{
    
	public Teacher createPet(Teacher teacher)  {

		List list = createQuery(
						" SELECT p FROM PetEO p WHERE p.name = :name AND p.category.id = :categoryId ")
				.setParameter("name", "").setParameter(
						"categoryId", 2)
				.getResultList();

		
		return null;

	}

	public void deletePet(Teacher teacher) {

		this.remove(teacher);

	}

	public Teacher savePet(Teacher teacher) {

		List list = this
				.createQuery(
						" SELECT p FROM PetEO p "
						+ " WHERE p.name = :name AND p.category.id = :categoryId AND p.id <> :id ")
				.setParameter("name", "").setParameter(
						"categoryId", 2)
				.setParameter("id", 3).getResultList();

	

		return (Teacher) merge(teacher);

	}

	@SuppressWarnings("unchecked")
	public List<Teacher> listCategoryPet(String categoryName) {

		return this.createQuery(
				" SELECT p FROM PetEO p WHERE p.category.name = :name ")
				.setParameter("name", categoryName).getResultList();
	}
}
