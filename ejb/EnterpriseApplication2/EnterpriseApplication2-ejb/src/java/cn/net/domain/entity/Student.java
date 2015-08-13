/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.application.load.MyLogger;
import cn.net.domain.vo.UseInfo;
import cn.net.domain.repositories.StudentDao;
import cn.net.domain.vo.UserStateEnum;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author y
 */
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UseInfo info;
    private String schoolNum;      //院系号
    private String schoolClassNum;       //班级号
    
    private UserStateEnum userStateEnumm=UserStateEnum.LOGINOUT;
    @Transient
    private StudentCourseTake courseTake;    
    @Transient
    public StringBuilder builder;
     @Transient
     @EJB
    private StudentDao studentDao;
    
    public Student(){
        
        info=new UseInfo();
        builder=new StringBuilder();
    }
    
    public UserStateEnum login(Student student){
        
        
        
           if(student.info.getPassword().equals(this.info.getPassword()))
            userStateEnumm=UserStateEnum.LOGON;
         
      
        return userStateEnumm;
    }
    public  UserStateEnum logout(){
         if(UserStateEnum.LOGON.equals(userStateEnumm)){
            userStateEnumm=UserStateEnum.LOGINOUT;
        }
        return userStateEnumm;
    }
    public List<Long> getCourseTake(Long teachPlan) {
        if(courseTake!=null){
         courseTake = studentDao.getCourseTake(teachPlan);
        }
       return courseTake.getCourseNums();
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UseInfo getInfo() {
        return info;
    }

    public void setInfo(UseInfo info) {
        this.info = info;
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum;
    }

    public String getSchoolClassNum() {
        return schoolClassNum;
    }

    public void setSchoolClassNum(String schoolClassNum) {
        this.schoolClassNum = schoolClassNum;
    }

    

    public UserStateEnum getUserStateEnumm() {
        return userStateEnumm;
    }

    public void setUserStateEnumm(UserStateEnum userStateEnumm) {
        this.userStateEnumm = userStateEnumm;
    }

  
    public void setCourseTake(StudentCourseTake courseTake) {
        this.courseTake = courseTake;
    }

 
       

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.user.Student[ id=" + id + " ]";
    }

    public void setInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
