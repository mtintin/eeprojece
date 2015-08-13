/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author y
 */
public class ScheduleValue {
    private String teacherName;    //姓名
    private String office; 	//教研室
    private String subOffice; //亚科室
    private String amPm;       //时段
    private String place;      //地点
    private String courseName;  //课程名
    public String start;       //起止时间
    public String end;         //
    public String dwNum;           //星期
    public String weekNum;         //周次
    private Map<String,List<String>> map; //分类课程类别
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSubOffice() {
        return subOffice;
    }

    public void setSubOffice(String subOffice) {
        this.subOffice = subOffice;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDwNum() {
        return dwNum;
    }

    public void setDwNum(String dwNum) {
        this.dwNum = dwNum;
    }

    public String getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<String>> map) {
        this.map = map;
    }
    
    
  
}
