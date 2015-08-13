
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import sun.applet.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author y
 */
public class NewClass {
    public String str="2322";
    public static void main(String ages[]) throws ParseException{
       NewClass ne=  new NewClass();
        Map<Integer,NewClass> map=new HashMap<Integer,NewClass>();
        map.put(1,ne);
       //   System.out.println(map.get(1).str);
        ne.str="45544";
      //  ne=null;
        //System.out.println(map.get(1).str);
      // format();
       NewClass ne1=ne;
       ne=null;
        System.out.println(ne1);
    }
    public  static  void format() throws ParseException{
     SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd.hh.ss");   
     String dateTime="20140626123300";

   Calendar c = Calendar.getInstance();
  
c.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(dateTime));

System.out.println("毫秒数为："+c.getTimeInMillis());

        System.out.println(System.currentTimeMillis());
    }
}
