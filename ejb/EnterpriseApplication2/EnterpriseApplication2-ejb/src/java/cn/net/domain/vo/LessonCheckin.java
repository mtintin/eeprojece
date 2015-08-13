/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import cn.net.domain.vo.CheckStateEnum;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author y
 */
@Entity
public class LessonCheckin implements Serializable,Comparable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long scheduleCode;
    private Long schedule;
    private Long student;
    private CheckStateEnum checkState;     
    public LessonCheckin(){}
    public LessonCheckin(Long student, CheckStateEnum checkState) {
       
    }
    
  
    
    public void getClassCheckin(){
        
    }
    
  
    
    public void classCheckinTotal(){
        
    }
    
    public void courseCheckinTotal(){
        
    }
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof LessonCheckin)) {
            return false;
        }
        LessonCheckin other = (LessonCheckin) object;
        if ((this.schedule.equals( other.schedule) &&this.student.equals(other.student))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.Checkin[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Object o) {
        
           LessonCheckin check =(LessonCheckin)o;
           int result;
           result= check.checkState.getState()>this.checkState.getState()?1:0;
           return result;
    }
       
    
}
