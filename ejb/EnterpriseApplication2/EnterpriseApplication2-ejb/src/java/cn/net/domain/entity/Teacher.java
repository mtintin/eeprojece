/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.vo.UseInfo;
import cn.net.domain.entity.AuthoLevel;
import cn.net.domain.vo.UserStateEnum;
import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author y
 */
@Entity
public class Teacher  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long officeId;
    private Long teachGroup;
    @Embedded
    private UseInfo info;
    private AuthoLevel level;
    private UserStateEnum userStateEnumm;
    
    public Teacher(){
        info=new UseInfo();
    }
    public UserStateEnum login(Teacher teacher){
        if(UserStateEnum.LOGINOUT.equals(userStateEnumm)){
           if(teacher.info.getPassword().equals(this.info.getPassword()))
            userStateEnumm=UserStateEnum.LOGON;
        }
        return userStateEnumm;
    }
    public  UserStateEnum logout(){
         if(UserStateEnum.LOGON.equals(userStateEnumm)){
            userStateEnumm=UserStateEnum.LOGINOUT;
        }
        return userStateEnumm;
    }
    
    
    public void setLevel(AuthoLevel level){
        this.level=level;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

   
    public Long getTeachGroup() {
        return teachGroup;
    }

    public void setTeachGroup(Long teachGroup) {
        this.teachGroup = teachGroup;
    }


    public UseInfo getInfo() {
        return info;
    }

    public void setInfo(UseInfo info) {
        this.info = info;
    }

    public UserStateEnum getUserStateEnumm() {
        return userStateEnumm;
    }

    public void setUserStateEnumm(UserStateEnum userStateEnumm) {
        this.userStateEnumm = userStateEnumm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.user.Teacher[ id=" + id + " ]";
    }
    
}
