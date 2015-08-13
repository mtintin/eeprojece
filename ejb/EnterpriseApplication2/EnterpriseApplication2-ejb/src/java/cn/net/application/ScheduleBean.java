/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.net.application;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.domain.vo.ScheduleValue;
import cn.net.application.load.MyLogger;
import cn.net.domain.entity.Schedule;
import cn.net.infrastructure.BaseImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author y
 */
@Stateless(name = "scheduleBean",mappedName = "ejb/ScheduleBean")
@Remote 
public class ScheduleBean extends BaseImpl implements ScheduleBeanRemote {   
    // 教师名课课程 
    @Override
    public List<ScheduleInfo> allScheduleForTeacher(String teacherName, int tag) {
        String jpql="";       
        switch(tag){
            case -1:
        jpql="select p from Schedule p where p.info.scheduleDate < CURRENT_DATE and p.info.teacherName='"+teacherName+"' order by p.info.scheduleDate,p.info.timeStr";	
                break;
            case 0:
        jpql="select p from Schedule p where p.info.teacherName='"+teacherName+"' order by p.info.scheduleDate,p.info.timeStr";        
                break;
            case 1:
        jpql="select p from Schedule p where p.info.scheduleDate >=CURRENT_DATE and p.info.teacherName='"+teacherName+"' order by p.info.scheduleDate,p.info.timeStr";
                break;               
               }       
        return getScheduleInfo(jpql);
    }
    // 课程查询 
     @Override
    public List<ScheduleInfo> scheduleByParameter(ScheduleValue value) {
		StringBuilder builder=new StringBuilder();
		builder.append("selece s from Schedule s where ");
		  if(value.getStart()!=null&&value.getEnd()!=null){
					builder.append("s.info.scheduleDate between '").append(value.getStart()).append("' and '");
                                        builder.append(value.getEnd());
					}else{
                                        builder.append("1=1");
                                        }                               
					if(value.getOffice()!=null){
						builder.append("' and s.info.office='").append(value.getOffice());
					}
					if(value.getSubOffice()!=null){
						builder.append("' and s.info.subOffice='").append(value.getSubOffice());
					}
					if(value.getPlace()!=null){
						builder.append("' and s.info.place='").append(value.getPlace());
					}
					if(value.getAmPm()!=null){
						builder.append("' and s.info.amPm='").append(value.getAmPm());
					}
					if(value.getCourseName()!=null){
						builder.append("' and s.info.courseName='").append(value.getCourseName());
					}
					if(!"".equals(value.getTeacherName())&&value.getTeacherName()!=null){
                                                builder.append("' and s.info.teacherName='").append(value.getTeacherName());
					}
					if(value.getDwNum()!=null){
						builder.append("' and s.info.dwNum='").append(value.getDwNum());
					}
					if(value.getWeekNum()!=null){
						builder.append("' and s.info.weekNum='").append(value.getWeekNum());
					}
		builder.append("' order by s.info.scheduleDate,s.info.timeStr");
		return  getScheduleInfo(builder.toString());
	}
    // 课程 
     @Override
    public List<ScheduleInfo> scheduleWeek(int num,int week) {		
			String dw="一二三四五六日".substring(num-1,num);	
			String jpql="selece s from Schedule s where s.info.weekNum='"+week+"' and s.info.dwNum='"+dw+"' order by s.info.scheduleDate,s.info.timeStr";
		return  getScheduleInfo(jpql);
		}     
    // 课程查询选项
     @Override
    public Map<String, List<String>> scheduleParameters(ScheduleValue value) {
		Map<String,List<String>> map=new HashMap<String,List<String>> ();	
		Set<String> set=initQuery();			
		removeCname(set,value.getCourseName());
		removeCname(set,value.getOffice());
		removeCname(set,value.getSubOffice());
		removeCname(set,value.getTeacherName());
		removeCname(set,value.getPlace());
		removeCname(set,value.getAmPm());
		removeCname(set,value.getStart());
		removeCname(set,value.getDwNum());
		removeCname(set,value.getWeekNum());
		for(String str:set) {
			if(str!=null){
				StringBuilder builder=new StringBuilder();
				builder.append("select distinct ").append(str).append(" from Schedule s where ");				
                                        if(value.getStart()!=null&&value.getEnd()!=null){
					builder.append("s.info.scheduleDate between '").append(value.getStart()).append("' and '");
                                        builder.append(value.getEnd());
					}else{
                                        builder.append("1=1");
                                        }
                               
					if(value.getOffice()!=null){
						builder.append("' and s.info.office='").append(value.getOffice());
					}
					if(value.getSubOffice()!=null){
						builder.append("' and s.info.subOffice='").append(value.getSubOffice());
					}
					if(value.getPlace()!=null){
						builder.append("' and s.info.place='").append(value.getPlace());
					}
					if(value.getAmPm()!=null){
						builder.append("' and s.info.amPm='").append(value.getAmPm());
					}
					if(value.getCourseName()!=null){
						builder.append("' and s.info.courseName='").append(value.getCourseName());
					}
					if(!"".equals(value.getTeacherName())&&value.getTeacherName()!=null){
					builder.append("' and s.info.teacherName='").append(value.getTeacherName());
					}
					if(value.getDwNum()!=null){
						builder.append("' and s.info.dwNum='").append(value.getDwNum());
					}
					if(value.getWeekNum()!=null){
						builder.append("' and s.info.weekNum='").append(value.getWeekNum());
					}
					builder.append("'");					
				map.put(str,list(builder.toString()));
			}
		}
		       value.setMap(map);
		         return map;
	}
    
    // 学生周课程
     @Override
    public List<ScheduleInfo> scheduleForStudent(List<Long> courseNums,int dwNum,int weekNum){
        StringBuilder builder=new StringBuilder();
        builder.append("select p from Schedule p where ")
                .append("p.info.weekNum ='").append(weekNum)
                .append("' and p.info.dwNum='").append(dwNum)
                .append("' and p.info.courseNum in (");
        for (Iterator<Long> it = courseNums.iterator(); it.hasNext();) {
            builder.append(it.next()).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")  order by p.info.scheduleDate,p.info.timeStr");
      return getScheduleInfo(builder.toString());  
    }  
    // 学生今日课程
     @Override
     public List<ScheduleInfo> todayScheduleForStudent(List<Long> courseNums){
        StringBuilder builder=new StringBuilder();
        builder.append("select p from Schedule p where ")
                .append("p.info.scheduleDate = CURRENT_DATE")       
                .append("' and p.info.courseNum in (");
        for (Iterator<Long> it = courseNums.iterator(); it.hasNext();) {
            builder.append(it.next()).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")  order by p.info.scheduleDate,p.info.timeStr");
      return getScheduleInfo(builder.toString());  
    }
        
    private void removeCname( Set<String> set,String cname){
		if(cname!=null){
			set.remove(cname);
		}		
	}
    private Set<String> initQuery(){		
		Set<String> set=new HashSet<String>();
		set.add("courseName");		
		set.add("office");
		set.add("subOffice");
		set.add("teacherName");
		set.add("place");
		set.add("amPm");
		set.add("scheduleDate");
		set.add("dwNum");//星期
		set.add("weekNum");		
		return set;
	}
    private List<ScheduleInfo> getScheduleInfo(String jpql) {
         List<Schedule> schedules=  list(jpql);
        List<ScheduleInfo> list=new ArrayList<ScheduleInfo>();
        for (Schedule scheduleInfo : schedules) {
            MyLogger.d( scheduleInfo.getInfo().getCourseNum());
            list.add(scheduleInfo.getInfo());      }
        return list;
    }
   
}
