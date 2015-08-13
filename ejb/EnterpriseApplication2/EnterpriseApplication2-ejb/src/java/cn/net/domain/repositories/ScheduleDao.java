/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.net.domain.repositories;
import cn.net.domain.entity.Schedule;
import cn.net.domain.entity.Theme;
import cn.net.domain.vo.LessonStateEnum;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.infrastructure.BaseImpl;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
/**
*
 * @author y
 */
@Stateless
@LocalBean
public class ScheduleDao extends BaseImpl{

    public List<Schedule> getSchedules(Long courseNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        HttpSession
    }
    public List<Schedule> getRecentlySchedules(){
       
        return list("select p from Schedule p where p.info.scheduleDate = CURRENT_DATE");
    }
    public Schedule getSchedule(ScheduleInfo scheduleInfo) {
       return (Schedule) find(Schedule.class, scheduleInfo.getCode());
    }
    
    public Schedule findScheduleByCode(Long teachPlan, Long code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mergeSchedule(Schedule schedule){ 
            if(LessonStateEnum.FINISH.equals(schedule.getClassState())){
                persistSchedule(schedule); 
            }
            merge(schedule);
    }
    private void persistSchedule(Schedule schedule){

        persistAll(schedule.getCheckinSet());
        persistAll(schedule.getClassCreditSet());
        persistAll(schedule.getClassReviewSet());
        persistAll(schedule.getCourseWareSet());
        persistTheme(schedule.getThemeMap());
        
        
    }

    private void persistTheme(Map<Long, Theme> themeMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
