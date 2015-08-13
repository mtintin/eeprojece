/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.repositories.ScheduleDao;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
/**
 *
 * @author y
 */
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private Long teachGroup;
    private Long teachPlan;
    private String courseName;
    private Long courseNum; 
    private String major;
    @ManyToMany (mappedBy = "courseSet" )
    private Set<StudentCourseTake> StudentCourseTakeSet;   
    @Transient
    private List<Schedule> schedules;   
    private String totCount; //总课时
    private String bigCount; //大课时
    private String preNum;  //实践课时
    @Transient
    @EJB
    private ScheduleDao scheduleDao;
   
    
    public Course(){}
   public List<Schedule> getSchedules() {
       if(schedules==null){
          schedules = scheduleDao.getSchedules(this.courseNum);
       }
        return schedules;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseNum == null && other.courseNum != null) || (this.courseNum != null && !this.courseNum.equals(other.courseNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.user.Course[ id=" + id + " ]";
    }

    public Set<StudentCourseTake> getStudentCourseTakeSet() {
        return StudentCourseTakeSet;
    }

    public void setStudentCourseTakeSet(Set<StudentCourseTake> StudentCourseTakeSet) {
        this.StudentCourseTakeSet = StudentCourseTakeSet;
    }

  
    public Long getTeachGroup() {
        return teachGroup;
    }

    public void setTeachGroup(Long teachGroup) {
        this.teachGroup = teachGroup;
    }

    public Long getTeachPlan() {
        return teachPlan;
    }

    public void setTeachPlan(Long teachPlan) {
        this.teachPlan = teachPlan;
    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Long courseNum) {
        this.courseNum = courseNum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

  

    public String getTotCount() {
        return totCount;
    }

    public void setTotCount(String totCount) {
        this.totCount = totCount;
    }

    public String getBigCount() {
        return bigCount;
    }

    public void setBigCount(String bigCount) {
        this.bigCount = bigCount;
    }

    public String getPreNum() {
        return preNum;
    }

    public void setPreNum(String preNum) {
        this.preNum = preNum;
    }
}