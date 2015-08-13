/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import cn.net.application.load.MyLogger;
import cn.net.domain.entity.Student;
import cn.net.domain.vo.UseInfo;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author y
 */
public class CustomerBeanTest {
    
      @Test
    public void testStudentLogin() throws Exception {
      
    InitialContext ctx = new InitialContext(); 
 
   CustomerBeanRemote schedule=(CustomerBeanRemote)ctx.lookup("ejb/CustomerBean");
   Student student=new Student();
   UseInfo info=new UseInfo();
   info.setsId("1142052039");
   info.setPassword("123");
   student.setInfo(info);
   
   Student stu= schedule.login(null);
          MyLogger.e("testStudentLogin", "--"+stu.login(student));
          MyLogger.e("testStudentLogin", "--"+stu.getInfo().getSchool());
    

    }
    
}
