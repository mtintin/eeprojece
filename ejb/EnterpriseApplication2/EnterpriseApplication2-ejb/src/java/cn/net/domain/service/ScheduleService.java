/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.service;
import cn.net.domain.entity.Schedule;
import cn.net.domain.repositories.ScheduleDao;
import cn.net.domain.vo.LessonStateEnum;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.infrastructure.Lesscahe;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;

/**
 *
 * @author y
 */
@Resource(name = "scheduleService")
  public class ScheduleService {
  @EJB
  private ScheduleDao scheduleDao;
  private Long  peroid=3*60*60l;
  private Long delay=6*60*60l;
  public Schedule getScheudle(ScheduleInfo scheduleInfo){    
    Schedule schedule =  Lesscahe.getSchedule(new Schedule(scheduleInfo));
    if(schedule==null){
        schedule= scheduleDao.findScheduleByCode(scheduleInfo.getTeachPlan(),scheduleInfo.getCode());
          schedule.setClassState(LessonStateEnum.START);
          Lesscahe.putSchedule(schedule);
    }
    return schedule;
  }
 
  public void openLessonAuto(){
   LessonTimer.start(this,peroid);  
  }
  public void closeLessonAuto(){
    LessonTimer.stop();     
  }
   public void closeLesson(ScheduleInfo scheduleInfo) {
   Schedule schedule=Lesscahe.getSchedule(new Schedule(scheduleInfo));
   schedule.setClassState(LessonStateEnum.CLOSE);
   scheduleDao.mergeSchedule(schedule);
   
   }

  private void load(){
     List<Schedule> schedules = scheduleDao.getRecentlySchedules();
     //    for (Schedule schedule : schedules) {
  
     schedules.stream().forEach((schedule) -> {
          ScheduleInfo info=schedule.getInfo();
          Long openTime=getTime(info,-1);
          Long currentTime=System.currentTimeMillis();
          if (currentTime>=openTime-peroid*1000) {
              schedule.setClassState(LessonStateEnum.START);
              Lesscahe.putSchedule(schedule);
          }
      });
  }

    public void loop() {
        load();
        // for (Map.Entry<Long, Schedule> entry : Lesscahe.scheduleCache.entrySet())
        Lesscahe.scheduleCache.entrySet().stream().map((entry) -> entry.getValue()).forEach((schedule) -> {
          ScheduleInfo info=schedule.getInfo();
          Long closeTime=getTime(info,1);
          Long currentTime=System.currentTimeMillis();
          if(currentTime>=closeTime){
              schedule.setClassState(LessonStateEnum.FINISH);
          }
          if (currentTime>=closeTime+delay*1000) {
              Schedule  schedulePer = Lesscahe.removeSchedule(schedule);
              if (schedulePer!=null) {
                  schedulePer.setClassState(LessonStateEnum.CLOSE);
                  scheduleDao.mergeSchedule(schedulePer);
              }
          }
      });  
       
    }
    
  private Long getTime(ScheduleInfo info,int per){
       Long second=info.getScheduleDate().getTime();
       String[] times = info.getTimeStr().split("-");
       try {
       if(per>0){
          String btime= times[0].split(":")[0];      
          second+=Long.parseLong(btime)*60*60*1000;
       }else{
          String etime= times[1].split(":")[0];    
          second+=Long.parseLong(etime)*60*60*1000;
       }
        } catch (NumberFormatException e) {
      }finally{
       return second;
      }

  }

   
  
  
  
}
