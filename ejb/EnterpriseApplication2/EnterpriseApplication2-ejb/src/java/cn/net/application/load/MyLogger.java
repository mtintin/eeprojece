/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.application.load;

import java.io.IOException;

/**
 *
 * @author y
 */
public class MyLogger {
//C:\Users\y\AppData\Roaming\NetBeans\7.4\config\GF_4.0\domain1\config
   public  static void e(String fileUtil, String zip_file_io_error, IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void e(String TAG, String string) {
        System.out.println(TAG+"--------------"+string);
    }
     public static void d( Object obj) {
         System.out.println("-------------------------"+obj);
    }
      public static void d(String str) {
         System.out.println("-------------------------"+str);
    }
}
