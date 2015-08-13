/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import cn.net.domain.entity.Student;
import cn.net.domain.vo.UseInfo;
import javax.ejb.Remote;

/**
 *
 * @author y
 */
@Remote
public interface CustomerBeanRemote {
public Student login(UseInfo info);    
}
