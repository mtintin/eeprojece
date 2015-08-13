/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import cn.net.domain.entity.Student;
import cn.net.domain.repositories.StudentDao;
import cn.net.domain.vo.UseInfo;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author y
 */

@Stateless(name = "CustomerBean",mappedName = "ejb/CustomerBean")
@Remote 
public class CustomerBean implements CustomerBeanRemote {
    @EJB 
    public StudentDao studentDao;
    // 登录
    @Override
    public Student login(UseInfo stu) {
        
     return studentDao.getStuBySid("1142052039");
    }
     // 用户信息设置
    public void setUseInfo(UseInfo info){
        
    }
  
    // 学生课程科目
    public void getStudentCourse(){
               
    }
    
    // 教师 课程科目
    
    // 教研室-教师
				
     // 教研室- 课程科目	
       	
     // 科室 -教师	
	
    // 发送消息 删消息
}
