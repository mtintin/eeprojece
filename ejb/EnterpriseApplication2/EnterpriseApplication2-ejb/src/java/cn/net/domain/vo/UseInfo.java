/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author y
 */
@Embeddable

        
public class UseInfo implements Serializable {
  private static final long serialVersionUID = 1L;
  private String sId;          //身份标识号
  private String password;      //密码
  
private String school;
private String major;         //专业
private String politics;       //政治面貌      
private String name;         //姓名
private String gender;         //性别
private String bordPlace;      //籍贯
private String bordDate;      //出生
private String phoneNum;     //电话 
private String homePhone;     //家庭电话
private String email;        //邮件
private String qqNum;        //qq

private String job;    	//职务
private String position;//职称
private String education;//学历
private String office;
private String teachGrouop;


    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBordPlace() {
        return bordPlace;
    }

    public void setBordPlace(String bordPlace) {
        this.bordPlace = bordPlace;
    }

    public String getBordDate() {
        return bordDate;
    }

    public void setBordDate(String bordDate) {
        this.bordDate = bordDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTeachGrouop() {
        return teachGrouop;
    }

    public void setTeachGrouop(String teachGrouop) {
        this.teachGrouop = teachGrouop;
    }





    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.sId != null ? this.sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UseInfo)) {
            return false;
        }
        UseInfo other = (UseInfo) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.user.Info[ id=" + sId + " ]";
    }
    
}
