/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application.load;

import cn.net.domain.entity.StudentCourseTake;
import cn.net.domain.entity.Student;
import cn.net.domain.entity.TeachGroup;
import cn.net.domain.entity.Course;
import cn.net.domain.vo.TeachPlans;
import cn.net.infrastructure.BaseImpl;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 *
 * @author y
 */
@Stateless(name = "studentBean",mappedName = "ejb/StudentBean")
@Remote
public class StudentLoadBean extends BaseImpl implements StudentLoadBeanRemote {
      public static String exPath="K:\\\\移动教学项目资料\\\\华西提供文件\\\\必修课选课名单（贺老师）0";
    // 学生导入
	public void insertStudent(String path) {
		try {
			Map<String, Student> map=getStudent(this.exPath);
			int i=0;                
			for(Entry<String, Student> enty:map.entrySet()){
				Student stu=enty.getValue();
				i++;
                              StudentCourseTake courseTake =  new StudentCourseTake();
                              String[] cou=stu.builder.toString().split(",");
                              Set<Course> set=new HashSet<Course>();
                              
                             for(String courseId:cou){
                             List<Course> listCourse= list("select c from Course c where c.courseNum="+courseId);
                             if(listCourse!=null&&listCourse.size()>0)
                             set.add(listCourse.get(0));
                                      }
                              persist(stu);    
                              courseTake.setCourseSet(set);
                               List<TeachPlans> list= list("select c from TeachPlans c order by c.id DESC");
                                if(list!=null&&list.size()>0)
                              courseTake.setTeachPlan(list.get(0).getId());
                              courseTake.setStudent(stu);
                              persist(courseTake);
                                                      
			}
                       
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
       public Map<String, Student> getStudent(String exPath) throws Exception {
		File excelFile = new File(exPath);
        File[] files = excelFile.listFiles();
       HSSFRow row = null;
       Map<String, Student> map = new HashMap<String, Student>();
        for (int i = 0; i < files.length; i++) {
	    String couid = files[i].getName().split("@")[1];
	      couid =  couid.substring(0,couid.indexOf('.')).replace("-", "");
	   HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
			files[i]), true);
	  HSSFSheet sheet = workbook.getSheet("Sheet1      ");
	for (int j = 7; j < sheet.getLastRowNum(); j++) {
		row = sheet.getRow(j);
		Student stu = getStu();
		stu.getInfo().setName(row.getCell(2).getStringCellValue().trim());
		stu.setSchoolNum(row.getCell(3).getStringCellValue());
		stu.getInfo().setsId( row.getCell(4).getStringCellValue().trim());
		stu.setSchoolClassNum(row.getCell(6).getStringCellValue());
	        stu.getInfo().setSchool(row.getCell(7).getStringCellValue());
		if (map.containsKey(stu.getInfo().getsId())) {
			stu=map.get(stu.getInfo().getsId());
		
                    stu.builder.append(couid).append(",").toString();
	
		} else {
		
		   stu.builder.append(couid).append(",").toString();
			map.put(stu.getInfo().getsId(), stu);
		}
	}
	}
	return map;
	}
    Student getStu() {
		return new Student();
	}


}
