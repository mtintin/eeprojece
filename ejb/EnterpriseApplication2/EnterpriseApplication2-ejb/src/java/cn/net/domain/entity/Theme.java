/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.vo.ThemeStateEnum;
import cn.net.infrastructure.Lesscahe;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author y
 */
@Entity
//
public class Theme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Question> questions;
    @ElementCollection
    private List<Float> scoreList;
    private ThemeStateEnum themeState;
    private long durationSecond;
    private long startSecond;
    private long second;
    @OneToMany(mappedBy = "theme",fetch = FetchType.LAZY)
    private Set<ThemeReport> themeReportSet;
    @Transient
    private Timer  timeSchedule;
    private Long schedule;
   
    
    
    public Theme(){}
    
   public boolean isPrepare(){
      return ThemeStateEnum.PREPARE.equals(themeState);
   }
   public boolean isFinish(){
      return ThemeStateEnum.FINISH.equals(themeState);
   }
    
    public void reStart(){
       themeState=ThemeStateEnum.PREPARE;
      themeReportSet.clear();
       start();         
    }
  
    
    public void start(){
        // Future futrue = Executors.newSingleThreadExecutor().submit(new CountTheard());
        if(!isPrepare())return;   
           Lesscahe.putTheme(this);
          second=durationSecond;
         timeSchedule=new Timer();
        timeSchedule.schedule( new TimerTask() {
            @Override
            public void run() {
             if(second==durationSecond){
                  themeState=ThemeStateEnum.START;
              }else if(second==0){
                  themeState=ThemeStateEnum.FINISH;
                    finish();
              }
               second--;
             
            }
        },0,1000);   
        
    }
    
    
    
    public void close(){
        finish();
    }
    
    private void finish(){
       this.timeSchedule.cancel();       
       second=0;
       
    }
    
    
    private boolean countDown(long second){
       
        
        return true;
    }

    public void submitReport( ThemeReport report){
        if(isFinish())return;
        themeReportSet.add(report);
        
    }

    
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Float> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Float> scoreList) {
        this.scoreList = scoreList;
    }

    public ThemeStateEnum getThemeState() {
        return themeState;
    }

    public void setThemeState(ThemeStateEnum themeState) {
        this.themeState = themeState;
    }

    public long getDurationSecond() {
        return durationSecond;
    }

    public void setDurationSecond(long durationSecond) {
        this.durationSecond = durationSecond;
    }

    public long getStartSecond() {
        return startSecond;
    }

    public void setStartSecond(long startSecond) {
        this.startSecond = startSecond;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public Set<ThemeReport> getThemeReportSet() {
        return themeReportSet;
    }

    public void setThemeReportSet(Set<ThemeReport> themeReportSet) {
        this.themeReportSet = themeReportSet;
    }

    public Long getSchedule() {
        return schedule;
    }

    public void setSchedule(Long schedule) {
        this.schedule = schedule;
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
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.exam.Theme[ id=" + id + " ]";
    }
    
}
