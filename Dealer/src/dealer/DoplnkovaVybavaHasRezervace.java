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
@Table(name = "doplnkova_vybava_has_rezervace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoplnkovaVybavaHasRezervace.findAll", query = "SELECT d FROM DoplnkovaVybavaHasRezervace d"),
    @NamedQuery(name = "DoplnkovaVybavaHasRezervace.findByDoplnkovaVybavaId", query = "SELECT d FROM DoplnkovaVybavaHasRezervace d WHERE d.doplnkovaVybavaHasRezervacePK.doplnkovaVybavaId = :doplnkovaVybavaId"),
    @NamedQuery(name = "DoplnkovaVybavaHasRezervace.findByRezervaceId", query = "SELECT d FROM DoplnkovaVybavaHasRezervace d WHERE d.doplnkovaVybavaHasRezervacePK.rezervaceId = :rezervaceId"),
    @NamedQuery(name = "DoplnkovaVybavaHasRezervace.findByPocet", query = "SELECT d FROM DoplnkovaVybavaHasRezervace d WHERE d.pocet = :pocet")})
public class DoplnkovaVybavaHasRezervace implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DoplnkovaVybavaHasRezervacePK doplnkovaVybavaHasRezervacePK;
    @Column(name = "pocet")
    private Integer pocet;
    @JoinColumn(name = "rezervace_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rezervace rezervace;
    @JoinColumn(name = "doplnkova_vybava_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DoplnkovaVybava doplnkovaVybava;

    public DoplnkovaVybavaHasRezervace() {
    }

    public DoplnkovaVybavaHasRezervace(Integer pocet, Rezervace rezervace, DoplnkovaVybava doplnkovaVybava) {
        this.doplnkovaVybavaHasRezervacePK = new DoplnkovaVybavaHasRezervacePK(doplnkovaVybava.getId(),rezervace.getId());
        this.pocet = pocet;
        this.rezervace = rezervace;
        this.doplnkovaVybava = doplnkovaVybava;
    }
    
    public DoplnkovaVybavaHasRezervace(DoplnkovaVybavaHasRezervacePK doplnkovaVybavaHasRezervacePK) {
        this.doplnkovaVybavaHasRezervacePK = doplnkovaVybavaHasRezervacePK;
    }

    public DoplnkovaVybavaHasRezervace(int doplnkovaVybavaId, int rezervaceId) {
        this.doplnkovaVybavaHasRezervacePK = new DoplnkovaVybavaHasRezervacePK(doplnkovaVybavaId, rezervaceId);
    }

    public DoplnkovaVybavaHasRezervacePK getDoplnkovaVybavaHasRezervacePK() {
        return doplnkovaVybavaHasRezervacePK;
    }

    public void setDoplnkovaVybavaHasRezervacePK(DoplnkovaVybavaHasRezervacePK doplnkovaVybavaHasRezervacePK) {
        this.doplnkovaVybavaHasRezervacePK = doplnkovaVybavaHasRezervacePK;
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

    public DoplnkovaVybava getDoplnkovaVybava() {
        return doplnkovaVybava;
    }

    public void setDoplnkovaVybava(DoplnkovaVybava doplnkovaVybava) {
        this.doplnkovaVybava = doplnkovaVybava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doplnkovaVybavaHasRezervacePK != null ? doplnkovaVybavaHasRezervacePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoplnkovaVybavaHasRezervace)) {
            return false;
        }
        DoplnkovaVybavaHasRezervace other = (DoplnkovaVybavaHasRezervace) object;
        if ((this.doplnkovaVybavaHasRezervacePK == null && other.doplnkovaVybavaHasRezervacePK != null) || (this.doplnkovaVybavaHasRezervacePK != null && !this.doplnkovaVybavaHasRezervacePK.equals(other.doplnkovaVybavaHasRezervacePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.DoplnkovaVybavaHasRezervace[ doplnkovaVybavaHasRezervacePK=" + doplnkovaVybavaHasRezervacePK + " ]";
    }
    
}
