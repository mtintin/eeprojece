/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.net.domain.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Embeddable;
/**
 *
 * @author y
 */
@Embeddable
public class ScheduleInfo implements Serializable {

  private Long teachPlan;
    private String partTime;
    private Date scheduleDate;
    private Long courseNum;
    private String courseName;

private String stuNum; //学生数总

private String totCount; //总课时
private String bigCount; //大课时
private String preNum;  //实践课时
private String groNum;  //分组数
private String weekNum;  //周次

    private String grade;
    private String major;
    private String dwNum;	 //星期
    private String amPm;     //上下午
    private String timeStr;  //时间
    private String place;	 //地点
    private String tmode;     //教学形式
    private String part;      //上课内容
    private String teacherName;//讲师
    private String position;   //讲师职称
    private String office;
    private String subOffice;  //亚科室
    private String classHour;  //课时数
    private String lesson;     //上课
    private String iconPath;
     private Long code; 
    public Long getTeachPlan() {
        return teachPlan;
    }

    public void setTeachPlan(Long teachPlan) {
        this.teachPlan = teachPlan;
    }


    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

   

    public Long getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Long courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDwNum() {
        return dwNum;
    }

    public void setDwNum(String dwNum) {
        this.dwNum = dwNum;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTmode() {
        return tmode;
    }

    public void setTmode(String tmode) {
        this.tmode = tmode;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }


    public String getTotCount() {
        return totCount;
    }

    public void setTotCount(String totCount) {
        this.totCount = totCount;
    }

    public String getBigCount() {
        return bigCount;
    }

    public void setBigCount(String bigCount) {
        this.bigCount = bigCount;
    }

    public String getPreNum() {
        return preNum;
    }

    public void setPreNum(String preNum) {
        this.preNum = preNum;
    }

    public String getGroNum() {
        return groNum;
    }

    public void setGroNum(String groNum) {
        this.groNum = groNum;
    }

    public String getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.scheduleDate)+ Objects.hashCode(this.partTime)+ Objects.hashCode(this.courseName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScheduleInfo other = (ScheduleInfo) obj;
        if (!Objects.equals(this.partTime, other.partTime)) {
            return false;
        }

        if (!Objects.equals(this.scheduleDate, other.scheduleDate)) {
            return false;
        }
        if (!Objects.equals(this.courseName, other.courseName)) {
            return false;
        }
        return true;
    }

}
