            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.net.domain.entity;

import cn.net.domain.entity.EvalueGroup;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author y
 */
@Entity
public class Rvalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int itemId;
    private String title;
    private Float score;
    @ManyToOne
    private EvalueGroup evalueGroup;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }



    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public EvalueGroup getEvalueGroup() {
        return evalueGroup;
    }

    public void setEvalueGroup(EvalueGroup evalueGroup) {
        this.evalueGroup = evalueGroup;
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
        if (!(object instanceof Rvalue)) {
            return false;
        }
        Rvalue other = (Rvalue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.net.domain.entity.scheduletog.Evalue[ id=" + id + " ]";
    }
    
}
