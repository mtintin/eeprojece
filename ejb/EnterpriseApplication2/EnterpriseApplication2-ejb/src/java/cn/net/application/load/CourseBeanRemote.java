/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application.load;

import javax.ejb.Remote;

/**
 *
 * @author y
 */
@Remote
public interface CourseBeanRemote {
    public void move();
}
