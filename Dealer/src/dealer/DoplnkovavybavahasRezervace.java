/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dealer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "Doplnkova_vybava_has_Rezervace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoplnkovavybavahasRezervace.findAll", query = "SELECT d FROM DoplnkovavybavahasRezervace d"),
    @NamedQuery(name = "DoplnkovavybavahasRezervace.findByDoplnkovavybavaID", query = "SELECT d FROM DoplnkovavybavahasRezervace d WHERE d.doplnkovavybavahasRezervacePK.doplnkovavybavaID = :doplnkovavybavaID"),
    @NamedQuery(name = "DoplnkovavybavahasRezervace.findByRezervaceID", query = "SELECT d FROM DoplnkovavybavahasRezervace d WHERE d.doplnkovavybavahasRezervacePK.rezervaceID = :rezervaceID"),
    @NamedQuery(name = "DoplnkovavybavahasRezervace.findByPocet", query = "SELECT d FROM DoplnkovavybavahasRezervace d WHERE d.pocet = :pocet")})
public class DoplnkovavybavahasRezervace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DoplnkovavybavahasRezervacePK doplnkovavybavahasRezervacePK;
    @Column(name = "pocet")
    private Integer pocet;
    @JoinColumn(name = "Rezervace_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rezervace rezervace;
    @JoinColumn(name = "Doplnkova_vybava_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Doplnkovavybava doplnkovavybava;

    public DoplnkovavybavahasRezervace() {
    }

    public DoplnkovavybavahasRezervace(DoplnkovavybavahasRezervacePK doplnkovavybavahasRezervacePK) {
        this.doplnkovavybavahasRezervacePK = doplnkovavybavahasRezervacePK;
    }

    public DoplnkovavybavahasRezervace(int doplnkovavybavaID, int rezervaceID) {
        this.doplnkovavybavahasRezervacePK = new DoplnkovavybavahasRezervacePK(doplnkovavybavaID, rezervaceID);
    }

    public DoplnkovavybavahasRezervacePK getDoplnkovavybavahasRezervacePK() {
        return doplnkovavybavahasRezervacePK;
    }

    public void setDoplnkovavybavahasRezervacePK(DoplnkovavybavahasRezervacePK doplnkovavybavahasRezervacePK) {
        this.doplnkovavybavahasRezervacePK = doplnkovavybavahasRezervacePK;
    }

    public Integer getPocet() {
        return pocet;
    }

    public void setPocet(Integer pocet) {
        this.pocet = pocet;
    }

    public Rezervace getRezervace() {
        return rezervace;
    }

    public void setRezervace(Rezervace rezervace) {
        this.rezervace = rezervace;
    }

    public Doplnkovavybava getDoplnkovavybava() {
        return doplnkovavybava;
    }

    public void setDoplnkovavybava(Doplnkovavybava doplnkovavybava) {
        this.doplnkovavybava = doplnkovavybava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doplnkovavybavahasRezervacePK != null ? doplnkovavybavahasRezervacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoplnkovavybavahasRezervace)) {
            return false;
        }
        DoplnkovavybavahasRezervace other = (DoplnkovavybavahasRezervace) object;
        if ((this.doplnkovavybavahasRezervacePK == null && other.doplnkovavybavahasRezervacePK != null) || (this.doplnkovavybavahasRezervacePK != null && !this.doplnkovavybavahasRezervacePK.equals(other.doplnkovavybavahasRezervacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.DoplnkovavybavahasRezervace[ doplnkovavybavahasRezervacePK=" + doplnkovavybavahasRezervacePK + " ]";
    }
    
}
