/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import cn.net.domain.vo.Ware;
import java.util.List;

/**
 *
 * @author y
 */
public class Item {
  private Long id;
    private List<Ware> resourseList;
    private int type;
    private String title;
    private String checka;
    private String checkb;
    private String checkc;
    private String checkd;
    private String checke;
    private String answer;
    private String note;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChecka() {
        return checka;
    }

    public void setChecka(String checka) {
        this.checka = checka;
    }

    public String getCheckb() {
        return checkb;
    }

    public void setCheckb(String checkb) {
        this.checkb = checkb;
    }

    public String getCheckc() {
        return checkc;
    }

    public void setCheckc(String checkc) {
        this.checkc = checkc;
    }

    public String getCheckd() {
        return checkd;
    }

    public void setCheckd(String checkd) {
        this.checkd = checkd;
    }

    public String getChecke() {
        return checke;
    }

    public void setChecke(String checke) {
        this.checke = checke;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
   
}
