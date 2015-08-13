/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.entity.Theme;
import cn.net.domain.vo.Ware;
import cn.net.domain.vo.Ware;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author y
 */
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  // @OneToMany(mappedBy = "question")
    private List<Ware> wareSet;
    private int type;
    @Length( max = 1000)
    private String title;
    private String checka;
    private String checkb;
    private String checkc;
    private String checkd;
    private String checke;
    private String answer;
    private String note;   
    private Long questionCategory;
    @ManyToMany(mappedBy = "questions")
    private Set<Theme> themeSet;
    
   public boolean checkAnswer(String answer){
      return answer.equals(this.answer);
   }
   public void addMedia(Ware ware){
       wareSet.add(ware);
   }
      
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ware> getWareSet() {
        return wareSet;
    }

    public void setWareSet(List<Ware> wareSet) {
        this.wareSet = wareSet;
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

    public Long getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(Long questionCategory) {
        this.questionCategory = questionCategory;
    }

 

  

    public Set<Theme> getThemeSet() {
        return themeSet;
    }

    public void setThemeSet(Set<Theme> themeSet) {
        this.themeSet = themeSet;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if (this.getTitle().equals(other.getTitle())&&this.getChecka().equals(other.getChecka())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.togres.Question[ id=" + id + " ]";
    }
    
}
