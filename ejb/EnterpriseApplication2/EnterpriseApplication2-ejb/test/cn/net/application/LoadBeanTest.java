/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import cn.net.application.load.CourseBeanRemote;
import cn.net.application.load.StudentLoadBeanRemote;
import cn.net.application.load.TeacherLoadBeanRemote;

import javax.naming.InitialContext;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author y
 */
public class LoadBeanTest {
    
    public LoadBeanTest() {
    }
    

      @Test
    public void testCourse() throws Exception {

    InitialContext ctx = new InitialContext(); 
   CourseBeanRemote course=(CourseBeanRemote)ctx.lookup("ejb/CourseBean");
 //course.move();
    }
    
    @Test
    public void testStudent() throws Exception {

    InitialContext ctx = new InitialContext(); 
   StudentLoadBeanRemote student=(StudentLoadBeanRemote)ctx.lookup("ejb/StudentBean");
  // student.insertStudent(null);
    }
    
     @Test
    public void testTeacher() throws Exception {

    InitialContext ctx = new InitialContext(); 
   TeacherLoadBeanRemote teacher=(TeacherLoadBeanRemote)ctx.lookup("ejb/TeacherBean");
  //  teacher.load();
    teacher.loadTeacher();
    }
    
}
