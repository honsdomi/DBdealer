/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dealer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class DoplnkovaVybavaHasRezervacePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "doplnkova_vybava_id")
    private int doplnkovaVybavaId;
    @Basic(optional = false)
    @Column(name = "rezervace_id")
    private int rezervaceId;

    public DoplnkovaVybavaHasRezervacePK() {
    }

    public DoplnkovaVybavaHasRezervacePK(int doplnkovaVybavaId, int rezervaceId) {
        this.doplnkovaVybavaId = doplnkovaVybavaId;
        this.rezervaceId = rezervaceId;
    }

    public int getDoplnkovaVybavaId() {
        return doplnkovaVybavaId;
    }

    public void setDoplnkovaVybavaId(int doplnkovaVybavaId) {
        this.doplnkovaVybavaId = doplnkovaVybavaId;
    }

    public int getRezervaceId() {
        return rezervaceId;
    }

    public void setRezervaceId(int rezervaceId) {
        this.rezervaceId = rezervaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) doplnkovaVybavaId;
        hash += (int) rezervaceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoplnkovaVybavaHasRezervacePK)) {
            return false;
        }
        DoplnkovaVybavaHasRezervacePK other = (DoplnkovaVybavaHasRezervacePK) object;
        if (this.doplnkovaVybavaId != other.doplnkovaVybavaId) {
            return false;
        }
        if (this.rezervaceId != other.rezervaceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.DoplnkovaVybavaHasRezervacePK[ doplnkovaVybavaId=" + doplnkovaVybavaId + ", rezervaceId=" + rezervaceId + " ]";
    }
    
}
