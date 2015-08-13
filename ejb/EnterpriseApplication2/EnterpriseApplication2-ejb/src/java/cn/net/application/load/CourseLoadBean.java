/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application.load;

import cn.net.domain.vo.ScheduleInfo;
import cn.net.domain.vo.Office;
import cn.net.domain.entity.TeachGroup;
import cn.net.domain.entity.Schedule;
import cn.net.domain.entity.Course;
import cn.net.domain.vo.TeachPlans;
import cn.net.domain.util.FileUtil;
import cn.net.infrastructure.BaseImpl;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author y
 */
@Stateless(name="courseBean", mappedName="ejb/CourseBean") 
public class CourseLoadBean extends BaseImpl implements CourseBeanRemote {

    @Override
    public void move() {
        try {
            String path="C:\\Users\\y\\Desktop\\hxdb.xls";
           insertTeachGroup(path);
           insertOffice(path);
            inserCourse(path,"spring2014");
        } catch (Exception ex) {
            Logger.getLogger(CourseLoadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    
  
     public void inserCourse(String exPath,String name) throws Exception{
         TeachPlans plan=new TeachPlans(name);
         persist(plan);
         persistAll( getSchedules(exPath,plan));         
       
    }
    
    
      
    public void insertTeachGroup(String exPath) throws IOException{
        HSSFSheet sheet = FileUtil.getHss(exPath);
		HSSFRow row = null;
               Set set = new HashSet();
               List listAll = new ArrayList();
		for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                        row = sheet.getRow(j);
                     String groupName=row.getCell((short) 0).getStringCellValue();
                      getTeachGroup(groupName, set);       
                }
         listAll.addAll(set);
         persistAll(listAll);
         
    }
    
    
    public void insertOffice(String exPath) throws IOException{
          HSSFSheet sheet = FileUtil.getHss(exPath);
		HSSFRow row = null;
                Set set = new HashSet();
                List listAll = new ArrayList();
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                     row = sheet.getRow(j);
                String officeName=row.getCell((short) 21).getStringCellValue();
                getOffice(officeName, set);
                }
         listAll.addAll(set);
         persistAll(listAll);
                
    }
    
   
    
    
   public List getSchedules(String exPath,TeachPlans plan) throws Exception {		
		HSSFSheet sheet = FileUtil.getHss(exPath);
		HSSFRow row = null;	                                  
		List<Schedule> list = new ArrayList<Schedule>();
                List listAll = new ArrayList();
                Set<Course> set = new HashSet<Course>();
		for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                        row = sheet.getRow(j);
                        ScheduleInfo course = new ScheduleInfo();
                        course.setTeachPlan(plan.getId());
                        
                    	course.setCourseName(row.getCell((short) 1).getStringCellValue());
			course.setGrade(row.getCell((short) 2).getStringCellValue());
                        course.setMajor(row.getCell((short) 3).getStringCellValue());			
			course.setStuNum((int) row.getCell((short) 4).getNumericCellValue()
					+ "");        
			course.setTotCount((int) row.getCell((short) 7)
					.getNumericCellValue()
					+ "");
			course.setBigCount((int) row.getCell((short) 8)
					.getNumericCellValue()
					+ "");
			course.setPreNum((int) row.getCell((short) 9).getNumericCellValue()
					+ "");
			course.setGroNum((int) row.getCell((short) 10)
					.getNumericCellValue()
					+ "");
                        course.setWeekNum((int) row.getCell((short) 11)
					.getNumericCellValue()
					+ "");                        
			course.setScheduleDate(new Date(row.getCell((short) 12).getDateCellValue()
					.getTime()));
			
			course.setDwNum(row.getCell((short) 13).getStringCellValue());
			course.setAmPm(row.getCell((short) 14).getStringCellValue());
			course.setTimeStr(row.getCell((short) 15).getStringCellValue());
			course.setPlace(row.getCell((short) 16).getStringCellValue());
			course.setPart(row.getCell((short) 17).getStringCellValue());
			course.setTmode(row.getCell((short) 18).getStringCellValue());
			course.setTeacherName(row.getCell((short) 19).getStringCellValue());                        
			course.setPosition(row.getCell((short) 20).getStringCellValue());
                        String officeName=row.getCell((short) 21).getStringCellValue();
                        course.setSubOffice(officeName);
                      
			course.setClassHour(row.getCell((short) 22).getStringCellValue());
                        course.setCode((long)course.hashCode());
                        split(course,row.getCell((short) 5).getStringCellValue(),list);                       
                        String groupName=row.getCell((short) 0).getStringCellValue();
                        course.setOffice(groupName);
                       getCourse(course,set,plan,groupName);           
		}
               for (Iterator<Course> it = set.iterator(); it.hasNext();) {
                   Course course = it.next();   
                   persist(course);
              }
        	return list;
	}

    
   private void getCourse(ScheduleInfo info,Set set,  TeachPlans plan,String name){
        Course course=new Course();     
        course.setTeachPlan(plan.getId());
       List<TeachGroup> listGroup= list("select t from TeachGroup t where t.name='"+name+"'");
        course.setTeachGroup(listGroup.get(0).getId());
        course.setCourseNum(info.getCourseNum());
        course.setCourseName(info.getCourseName());
        course.setMajor(info.getMajor());
        course.setTotCount(info.getTotCount());
        course.setBigCount(info.getBigCount());
        course.setPreNum(info.getPreNum()); 

        set.add(course);
    }
   
    private void getTeachGroup(String groupName,Set set){
        TeachGroup group=new TeachGroup();
        group.setName(groupName);
        set.add(group);
        
    }
    
    private void getOffice(String officeName,Set set){
        Office office=new Office();
        office.setOfficeName(officeName);
        set.add(office);
        
    }
   
    private void split(ScheduleInfo course, String stringCellValue, List list) {
     String[] nums = stringCellValue.split(",");
     if(nums.length>1){
         course.setCourseNum(Long.parseLong(nums[0]));
         list.add(new Schedule(course));
         course.setCourseNum(Long.parseLong(nums[1]));
        list.add(new Schedule(course));
     }else{   
         if(stringCellValue!=null&&!"".equals(stringCellValue))
         course.setCourseNum(Long.parseLong(stringCellValue));
       list.add(new Schedule(course));
    }
     
    }

   
}
