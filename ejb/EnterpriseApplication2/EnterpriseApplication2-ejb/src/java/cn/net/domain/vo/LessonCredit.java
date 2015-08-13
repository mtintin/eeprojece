/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author y
 */
@Entity
public class LessonCredit implements Serializable ,Comparable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long scheduleCode;
    private Long schedule;
    private Long student;
    private float totalCredit;
    @ElementCollection 
   private  List<Float> creditList=new ArrayList<Float>();
  

   public  LessonCredit(Long student, List<Float> creditList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LessonCredit() {
        
    }

    public void setCreditSet(List<Float> creditList) {
        this.creditList = creditList;
    }

    

            
    private float getCredit(){
        float count=0;
        for (Float credit : creditList) {
            count+=credit;
        }
        return count;
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
       if (!(object instanceof LessonCredit)) {
            return false;
        }
        LessonCredit other = (LessonCredit) object;
        if ((this.schedule.equals( other.schedule) &&this.student.equals(other.student))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.ClassCredit[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Object o) {
      LessonCredit credit=(LessonCredit)o;
      if(credit==null)return 0;
      int result=credit.getCredit()>this.getCredit()?1:0;
      return result;
    }
    
}
