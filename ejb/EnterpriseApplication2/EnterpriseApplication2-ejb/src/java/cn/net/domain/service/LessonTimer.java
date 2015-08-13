/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.service;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author y
 */
public class LessonTimer {
   
    private static  Timer timer=new Timer();
    private static boolean state;
    public static void start(final ScheduleService service,Long peroid){
        if(state)return;
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
           service.loop();
        }
    },0, peroid-20);
        state=true;
    }
    public static void stop(){
        timer.cancel();
        state=false;
    }

}
