/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

/**
 *
 * @author y
 */
public enum UserStateEnum {
    LOGINOUT(2,"loginout") ,LOGON(1,"logon");
    private int state;
    private String stateName;

    private UserStateEnum(int state, String stateName) {
        this.state = state;
        this.stateName = stateName;
    }
   

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
}
