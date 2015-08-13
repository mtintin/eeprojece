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
public enum LessonStateEnum {
    PREPARE(0,"prepare") ,START(1,"start"),FINISH(2,"finish"),CLOSE(3,"close");
    private int state;
    private String stateName;

    private LessonStateEnum(int state, String stateName) {
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
