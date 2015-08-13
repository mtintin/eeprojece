/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.net.domain.entity;

import cn.net.domain.vo.LessonCheckin;
import cn.net.domain.vo.LessonCredit;
import cn.net.domain.vo.LessonReview;
import cn.net.domain.vo.Ware;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.domain.vo.LessonStateEnum;
import cn.net.domain.vo.CheckStateEnum;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author y
 */
@Entity
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    private LessonStateEnum classState =LessonStateEnum.PREPARE;  
    @Transient
    private Set<LessonCheckin> checkinSet;  
    @Transient
    private Set<LessonCredit> classCreditSet;
    @Transient
    private Set<LessonReview> classReviewSet;    
  // @OneToMany(mappedBy = "schedule")
   private Set<Ware> courseWareSet=new HashSet<Ware>() ;
    @Transient
   private Map<Long,Theme> themeMap=new HashMap<Long,Theme>();
   private Long evaluePlan;  
    
   @Embedded
    private ScheduleInfo info;
   
   
    public Schedule(){};
    public Schedule(ScheduleInfo info){
        this.info=info;
    }
      
 
            
    public LessonStateEnum getClassState() {
        return classState;
    }
    
    public void init(){   
      checkinSet=new TreeSet<LessonCheckin>();  
      classCreditSet=new TreeSet<LessonCredit>();
      classReviewSet=new HashSet<LessonReview>();    
  
    }
    
    public void startClass(){
        classState=LessonStateEnum.START;
        init();
    }
    
    
    public void finishClass(){
        classState=LessonStateEnum.FINISH;
    }
    
    public void closeClass(){
      classState=LessonStateEnum.CLOSE;   
    }
    
    public boolean check(Student student,CheckStateEnum checkState){
        if(!LessonStateEnum.START.equals(classState))return false;
        LessonCheckin checkin=new LessonCheckin(student.getId(),checkState);
        checkinSet.add(checkin);
        return true;
    }
    
    public boolean putCredit(Student student,List<Float> creditList){
        classState();
        LessonCredit classCredit=new LessonCredit(student.getId(),creditList);
        classCreditSet.add(classCredit);
        return true;
        
    }
 
    public boolean putReview(Student student,Teacher teacher,Teacher toTeacher,List<Float> reviewList){
        classState();
        LessonReview classReview=new LessonReview(student.getId(),teacher.getId(),toTeacher.getId(),reviewList);       
        classReviewSet.add(classReview);
        return true;    
    }
    public void putReviewPeplay(LessonReview review) {
            classReviewSet.add(review);

    }
 
    public boolean putCourseWare(Teacher teacher,Ware courseWare){
        if(classState())return false;
       courseWareSet.add(courseWare);
        return true;
    } 

     public void putThemeWare(Long key,Theme theme) {
        if(themeMap.containsKey(key)){
           themeMap.remove(key);
        }
        themeMap.put(key, theme);
        
    }
    
    public Theme removeThemeWare(Long key) {
         return themeMap.remove(key);
    }
    
    public Theme getThemeWare(Long key){
         return themeMap.remove(key); 
    }
  
    public Map<Long, Theme> getThemeWithOpen() {
        Map<Long, Theme> map=new HashMap<Long, Theme>();
      for (Map.Entry<Long, Theme> entry : themeMap.entrySet()) {
            Theme theme = entry.getValue();
           if(!theme.isPrepare()){
               map.put(entry.getKey(), theme);
           }
        }
      return map;

    }

    
    private boolean classState() {
        if (!LessonStateEnum.CLOSE.equals(classState)) {
            return true;
        }
        
        return false;
    }

    public Set<LessonCheckin> getCheckinSet() {
        return checkinSet;
    }

    public void setCheckinSet(Set<LessonCheckin> checkinSet) {
        this.checkinSet = checkinSet;
    }

    public Set<LessonCredit> getClassCreditSet() {
        return classCreditSet;
    }

    public void setClassCreditSet(Set<LessonCredit> classCreditSet) {
        this.classCreditSet = classCreditSet;
    }

    public Set<LessonReview> getClassReviewSet() {
        return classReviewSet;
    }

    public void setClassReviewSet(Set<LessonReview> classReviewSet) {
        this.classReviewSet = classReviewSet;
    }

    public Long getEvaluePlan() {
        return evaluePlan;
    }

    public void setEvaluePlan(Long evaluePlan) {
        this.evaluePlan = evaluePlan;
    }

    
    public void setClassState(LessonStateEnum classState) {
        this.classState = classState;
    }

    public Set<Ware> getCourseWareSet() {
        return courseWareSet;
    }

    public void setCourseWareSet(Set<Ware> courseWareSet) {
        this.courseWareSet = courseWareSet;
    }

    public Map<Long, Theme> getThemeMap() {
        return themeMap;
    }



   
  

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleInfo getInfo() {
        return info;
    }

    public void setInfo(ScheduleInfo info) {
        this.info = info;
    }
    

    @Override
    public int hashCode() {
      
        return this.info.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        return other.info.equals(this.info);   
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.HxClass[ id=" + id + " ]";
    }

    


    
}
