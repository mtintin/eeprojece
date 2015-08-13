/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;


import cn.net.domain.vo.ScheduleInfo;
import cn.net.domain.vo.ScheduleValue;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author y
 */
@Remote
public interface ScheduleBeanRemote {
  public List<ScheduleInfo> allScheduleForTeacher(String teacherName,int tag);
  public List<ScheduleInfo> scheduleByParameter(ScheduleValue value) ;
  public List<ScheduleInfo> scheduleWeek(int num,int week);
  public Map<String, List<String>> scheduleParameters(ScheduleValue value) ;
  public List<ScheduleInfo> scheduleForStudent(List<Long> courseNums,int dwNum,int weekNum);
  public List<ScheduleInfo> todayScheduleForStudent(List<Long> courseNums);
}
