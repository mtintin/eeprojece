/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 *
 * @author y
 */
public class NewClass {
    public static void main(String ages[]){
       initClient();
        System.out.println("pppppppp");
    }
    private static void initClient(){       
      MemCachedClient  client=new MemCachedClient();
        String[] servers = { "127.0.0.1:11211" };  
        Integer[] weights = { 3000 };  
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
       client.set("s", "499999999998");
        System.out.println( client.get("s"));
    }
    
}
