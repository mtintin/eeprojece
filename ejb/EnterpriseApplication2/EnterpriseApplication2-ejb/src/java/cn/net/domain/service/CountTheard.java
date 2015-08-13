/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

/**
 *
 * @author y
 */
public class CountTheard implements Callable{
    private long second;
 public CountTheard(){}
 
    @Override
    public Object call() throws Exception {
       return 1;
    }
    public void timer(){
     
    }
    
}
