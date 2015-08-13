/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.repositories;

import cn.net.domain.entity.Student;
import cn.net.domain.entity.StudentCourseTake;
import cn.net.infrastructure.AbsBase;
import cn.net.infrastructure.BaseImpl;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author y
 */
@Stateless
@LocalBean
public class StudentDao extends  BaseImpl<Student>{

   

    public Student getStuBySid(String sid){
       return  findUnique("select s from Student s where s.info.sId='"+sid+"'");
    }

    public StudentCourseTake getCourseTake(Long teachPlan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
 
    
}
