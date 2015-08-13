/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.infrastructure;

import cn.net.domain.entity.Schedule;
import cn.net.domain.entity.Theme;
import cn.net.domain.entity.ThemeReport;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author y
 */
public class Lesscahe {
    public static  MemCachedClient client;
    public static Map<Long,Schedule> scheduleCache=new ConcurrentHashMap<Long, Schedule>();
    public static Map<Long,Theme> themeCache=new ConcurrentHashMap<Long, Theme>();
    public static void putSchedule(Schedule schedule){
        if(!scheduleCache.containsKey(schedule.hashCode())){
            scheduleCache.put((long)schedule.hashCode(), schedule);   
        }
    }
    public static Schedule getSchedule(Schedule schedule){  
     return scheduleCache.get(schedule.hashCode());
    }
    public static Schedule removeSchedule(Schedule schedule){
     return scheduleCache.remove(schedule.hashCode());
    }
    
    
    public static void putTheme(Theme aThis) {
          themeCache.put(Long.MIN_VALUE, aThis);
    }
    
    
    
    
    
    
    public static Schedule meCache(Schedule schedule){
        if(client==null){
            initClient();
        }
    
        client.set("schedule:"+schedule.hashCode(), schedule);
        return (Schedule) client.get("chedule:"+schedule.hashCode());
    }
    private static void initClient(){       
        client=new MemCachedClient();
        String[] servers = { "127.0.0.1:11211" };  
        Integer[] weights = { 80000 };  
        SockIOPool pool=SockIOPool.getInstance();
        pool.setServers(servers);  
        pool.setWeights(weights);  
        pool.setInitConn(5);  
        pool.setMinConn(5);  
        pool.setMinConn(200);
        pool.setMaxIdle(1000 * 60 * 60 * 5);  
        pool.setMaintSleep( 30 );  
        pool.setNagle( false );  
        pool.setSocketTO(5000);   
        pool.setSocketConnectTO( 0 );  
        pool.initialize();        
          
    }

 

   
}
