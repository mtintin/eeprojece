/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import cn.net.domain.vo.ExamPaper;
import cn.net.domain.vo.Ware;
import cn.net.domain.vo.LessonReview;
import cn.net.domain.entity.Question;
import cn.net.domain.vo.QuestionCategory;
import cn.net.domain.entity.Student;
import cn.net.domain.entity.Teacher;
import cn.net.domain.entity.Theme;
import cn.net.domain.entity.ThemeReport;
import cn.net.domain.service.ScheduleService;
import cn.net.domain.util.VoTranslat;
import cn.net.domain.vo.CheckStateEnum;
import cn.net.domain.vo.LessonCheckin;
import cn.net.domain.vo.LessonCredit;
import cn.net.domain.vo.ScheduleInfo;
import cn.net.infrastructure.BaseImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * @author y
 */
@Stateless
public class LessonBean extends BaseImpl implements LessonBeanRemote {   
    @Resource
    ScheduleService scheduleService;
    public LessonBean(){  }
  
    @Override   
    //开启课堂
  public void openLesson(){
     scheduleService.openLessonAuto();
      
    }
   
    //上传课件
  public void putLessonResFile(ScheduleInfo info,Teacher teacher,Ware courseWare){
        scheduleService.getScheudle(info).putCourseWare(teacher, courseWare);
     
  }
  
  
    // 考勤
    public void checkLesson(ScheduleInfo info,Student student,CheckStateEnum state){
        scheduleService.getScheudle(info).check(student, state);
    }


    
    //  开始测试
   public void startExam(ScheduleInfo info,ExamPaper paper){
        Theme theme = scheduleService.getScheudle(info).getThemeWare(Long.MIN_VALUE);
        theme.start();
        
   }
    
      
   //获取试卷
   public List<ExamPaper> getExamPapers(ScheduleInfo info,Student student,Teacher teacher){
      Map<Long,Theme>  themes=  scheduleService.getScheudle(info).getThemeWithOpen();
      return VoTranslat.getExamPapers(themes);
      
   }
   
   // 交卷
   public void submitPaper(ScheduleInfo info,ExamPaper paper){
  Theme theme = scheduleService.getScheudle(info).removeThemeWare(Long.MIN_VALUE);
  ThemeReport report=VoTranslat.getExamPage(paper);
        theme.submitReport(report);
       
   }
  
    
    // 结束测试 
     public void closeExam(ScheduleInfo info,ExamPaper paper){
        Theme theme = scheduleService.getScheudle(info).removeThemeWare(Long.MIN_VALUE);
        theme.close();
        
   }
    
    // 给学生打分
    public void putStudentScore(ScheduleInfo info,Student student,List<Float> creditList){
        scheduleService.getScheudle(info).putCredit(student, creditList);
    }

    
    // 评价
      public void putReview(ScheduleInfo info,Student student,Teacher teacher,Teacher toTeacher,List<Float> reviewList){
        scheduleService.getScheudle(info).putReview(student, teacher,toTeacher,reviewList);
    }
      
    // 评价回复
       public void putReviewReplay(ScheduleInfo info,LessonReview review){
        scheduleService.getScheudle(info).putReviewPeplay(review);
    }
      
     //关闭课堂
     public void closeLesson(ScheduleInfo info){
     scheduleService.closeLesson(info);
      
    }
     
  // 获取课件
  public Set<Ware> getLessonResourses(ScheduleInfo info){

     return scheduleService.getScheudle(info).getCourseWareSet();
  }
  // 获取考勤
  public Set<LessonCheckin> getLessonCheck(ScheduleInfo info){

    return  scheduleService.getScheudle(info).getCheckinSet();
    
  }
  // 获取得分
  public Set<LessonCredit> getLessonScore(ScheduleInfo info){

     return scheduleService.getScheudle(info).getClassCreditSet();
  }
   // 获取评价
  public Set<LessonReview> getLessonReview(ScheduleInfo info){

      return scheduleService.getScheudle(info).getClassReviewSet();
  }
 // 获取题目分类
  public List<QuestionCategory> getQuestionCategory(){   
      return list("select g from QuestionCategory g where g.name='exam'");
  }
  
 // 题目列表	
  public List<Question> getQuestionByCategory(QuestionCategory category){     
       return list("select q from Question q where q.questionCategory="+category.getId());
  }

 // 手动出卷
 public List<ExamPaper> putExamPaper(ExamPaper paper,ScheduleInfo info){   
          Theme theme=VoTranslat.getTheme(paper);         
           List<Question> intems=theme.getQuestions();
         for (Iterator<Question> it = intems.iterator(); it.hasNext();) {
           Question question = it.next();
           if(question.getId()==0)
           persist(question);
         }  
         scheduleService.getScheudle(info).putThemeWare(null,theme); 
       Map<Long,Theme>  themes=  scheduleService.getScheudle(info).getThemeMap();
      return VoTranslat.getExamPapers(themes);
      
 } 

   
  // 删除试卷
 public void deleteExamPager(ExamPaper paper,ScheduleInfo info){
       Theme theme=VoTranslat.getTheme(paper);
    scheduleService.getScheudle(info).removeThemeWare(33l);
    
 }
    
 //自动出卷
   public List<ExamPaper> generateExamPaper(ExamPaper paper){  
     return null;
 }   
    
    
}
