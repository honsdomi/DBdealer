/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dealer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "kapacita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kapacita.findAll", query = "SELECT k FROM Kapacita k"),
    @NamedQuery(name = "Kapacita.findByTypKaroserie", query = "SELECT k FROM Kapacita k WHERE k.typKaroserie = :typKaroserie"),
    @NamedQuery(name = "Kapacita.findByHodnota", query = "SELECT k FROM Kapacita k WHERE k.hodnota = :hodnota")})
public class Kapacita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "typ_karoserie")
    private String typKaroserie;
    @Column(name = "hodnota")
    private Integer hodnota;
    @JoinColumn(name = "pobocka_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pobocka pobockaId;

    public Kapacita() {
    }

    public Kapacita(String typKaroserie) {
        this.typKaroserie = typKaroserie;
    }

    public String getTypKaroserie() {
        return typKaroserie;
    }

    public void setTypKaroserie(String typKaroserie) {
        this.typKaroserie = typKaroserie;
    }

    public Integer getHodnota() {
        return hodnota;
    }

    public void setHodnota(Integer hodnota) {
        this.hodnota = hodnota;
    }

    public Pobocka getPobockaId() {
        return pobockaId;
    }

    public void setPobockaId(Pobocka pobockaId) {
        this.pobockaId = pobockaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typKaroserie != null ? typKaroserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kapacita)) {
            return false;
        }
        Kapacita other = (Kapacita) object;
        if ((this.typKaroserie == null && other.typKaroserie != null) || (this.typKaroserie != null && !this.typKaroserie.equals(other.typKaroserie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.Kapacita[ typKaroserie=" + typKaroserie + " ]";
    }
    
}
