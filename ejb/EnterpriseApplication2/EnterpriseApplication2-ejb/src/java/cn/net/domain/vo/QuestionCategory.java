/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author y
 */
@Entity
public class QuestionCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int type;
    @Transient
    public String wordnames;
    @Transient
    public boolean flag=false;
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionCategory qcategory;
    @OneToMany(mappedBy = "qcategory",cascade = CascadeType.ALL)
    private List<QuestionCategory> qcategorys=new ArrayList<QuestionCategory>();
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public QuestionCategory getQcategory() {
        return qcategory;
    }

    public void setQcategory(QuestionCategory qcategory) {
        this.qcategory = qcategory;
    }

    public List<QuestionCategory> getQcategorys() {
        return qcategorys;
    }

    public void setQcategorys(List<QuestionCategory> qcategorys) {
        this.qcategorys = qcategorys;
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
        if (!(object instanceof QuestionCategory)) {
            return false;
        }
        QuestionCategory other = (QuestionCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.togres.Typecal[ id=" + id + " ]";
    }
    
}
