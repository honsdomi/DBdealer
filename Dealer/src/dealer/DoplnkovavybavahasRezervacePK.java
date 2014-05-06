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
public class DoplnkovavybavahasRezervacePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Doplnkova_vybava_ID")
    private int doplnkovavybavaID;
    @Basic(optional = false)
    @Column(name = "Rezervace_ID")
    private int rezervaceID;

    public DoplnkovavybavahasRezervacePK() {
    }

    public DoplnkovavybavahasRezervacePK(int doplnkovavybavaID, int rezervaceID) {
        this.doplnkovavybavaID = doplnkovavybavaID;
        this.rezervaceID = rezervaceID;
    }

    public int getDoplnkovavybavaID() {
        return doplnkovavybavaID;
    }

    public void setDoplnkovavybavaID(int doplnkovavybavaID) {
        this.doplnkovavybavaID = doplnkovavybavaID;
    }

    public int getRezervaceID() {
        return rezervaceID;
    }

    public void setRezervaceID(int rezervaceID) {
        this.rezervaceID = rezervaceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) doplnkovavybavaID;
        hash += (int) rezervaceID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoplnkovavybavahasRezervacePK)) {
            return false;
        }
        DoplnkovavybavahasRezervacePK other = (DoplnkovavybavahasRezervacePK) object;
        if (this.doplnkovavybavaID != other.doplnkovavybavaID) {
            return false;
        }
        if (this.rezervaceID != other.rezervaceID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.DoplnkovavybavahasRezervacePK[ doplnkovavybavaID=" + doplnkovavybavaID + ", rezervaceID=" + rezervaceID + " ]";
    }
    
}
