/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application.load;

import cn.net.domain.vo.Office;
import cn.net.domain.entity.TeachGroup;
import cn.net.domain.entity.Teacher;
import cn.net.domain.entity.Course;
import cn.net.domain.entity.Question;
import cn.net.domain.vo.QuestionCategory;

import cn.net.domain.util.FileUtil;
import cn.net.domain.util.WordQuestion;
import cn.net.infrastructure.BaseImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author y
 */
@Stateless(name = "teacherBean",mappedName = "ejb/TeacherBean")
public class TeacherLoadBean extends BaseImpl implements TeacherLoadBeanRemote {
   @Override
    public void loadQuestion() {
       try {
         //  persistAll( getTeacher("C:\\Users\\y\\Desktop\\hxteacher.xls"));
           insertQueType("C:\\Users\\y\\Desktop\\examItem1");
                   
       } catch (Exception ex) {
           Logger.getLogger(TeacherLoadBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }  
     //导入题目分类
      public String insertQueType(String path) {
                persist(WordQuestion.getQuestionTypecal(path));		
		//WordQuestion.getQuestionTypecal(path);
		insertQuestions();
		return "";
	}
	//导入题目
	@SuppressWarnings("unchecked")
	public String insertQuestions() {
		// QuestionCategory typecal=(QuestionCategory)find(QuestionCategory.class,1501l);
		persistAll((List<Question>)WordQuestion.getQuestions());
		
		return "";
	}
    
    private List<Teacher> getTeacher(String exPath) throws Exception {
		HSSFSheet sheet = FileUtil.getHss(exPath);
		HSSFRow row = null;
	
		List<Teacher> list = new ArrayList<Teacher>();
		for (int j = 1; j <= sheet.getLastRowNum(); j++) {
			row = sheet.getRow(j);
			Teacher teacher = new Teacher();
			teacher.getInfo().setName(row.getCell((short) 0).getStringCellValue());
			teacher.getInfo().setPosition(row.getCell((short) 1).getStringCellValue());
			teacher.getInfo().setEducation(row.getCell((short) 2).getStringCellValue());
			teacher.getInfo().setsId(row.getCell((short) 3).getStringCellValue());
                        String office=row.getCell((short) 4).getStringCellValue();
                        String teachGroup=row.getCell((short) 5).getStringCellValue();
                        teacher.getInfo().setOffice(office);
			teacher.getInfo().setTeachGrouop(teachGroup);
			    
                         List<Office> listo= list("select o from Office o where o.officeName='"+office.trim()+"'");
                        if(listo!=null&&listo.size()>0)
			  teacher.setOfficeId(listo.get(0).getId());
                        
                        List<TeachGroup> listt= list("select g from TeachGroup g where g.name='"+teachGroup.trim()+"'");
                             if(listt!=null&&listt.size()>0)
                        teacher.setTeachGroup(listt.get(0).getId());
                      

			list.add(teacher);

		}
		return list;

	}

    @Override
    public void loadTeacher() {
       try {
           for (Teacher teacher : getTeacher("C:\\Users\\y\\Desktop\\hxteacher.xls") ){
               persist(teacher);
           }
       } catch (Exception ex) {
           Logger.getLogger(TeacherLoadBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

   
}
