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
public enum CheckStateEnum {
    LATE(5,"late") ,LEAVE(4,"leave"),ASKLEAVE(3,"askleave"),INIT(2,"init"),ON(1,"on");
    private int state;
    private String stateName;

    private CheckStateEnum(int state, String stateName) {
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
