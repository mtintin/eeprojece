/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.entity.Course;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
/**
 *
 * @author y
 */
@Entity
public class StudentCourseTake implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany 
    private Set<Course> courseSet;
    private Long teachPlan;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    
    
    
    
    public List<Long> getCourseNums(){
       List<Long> nums=new ArrayList<Long>();              
       for (Iterator<Course> it = courseSet.iterator(); it.hasNext();) {
                Course course = it.next();
                nums.add(course.getCourseNum());
        }
        return nums;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Long getTeachPlan() {
        return teachPlan;
    }

    public void setTeachPlan(Long teachPlan) {
        this.teachPlan = teachPlan;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        if (!(object instanceof StudentCourseTake)) {
            return false;
        }
        StudentCourseTake other = (StudentCourseTake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.togcourse.CourseChoose[ id=" + id + " ]";
    }
    
}
