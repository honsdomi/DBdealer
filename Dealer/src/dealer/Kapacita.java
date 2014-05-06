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
@Table(name = "Kapacita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kapacita.findAll", query = "SELECT k FROM Kapacita k"),
    @NamedQuery(name = "Kapacita.findByTypkaroserie", query = "SELECT k FROM Kapacita k WHERE k.typkaroserie = :typkaroserie"),
    @NamedQuery(name = "Kapacita.findByHodnota", query = "SELECT k FROM Kapacita k WHERE k.hodnota = :hodnota")})
public class Kapacita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Typ_karoserie")
    private String typkaroserie;
    @Column(name = "hodnota")
    private Integer hodnota;
    @JoinColumn(name = "Pobocka_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pobocka pobockaID;

    public Kapacita() {
    }

    public Kapacita(String typkaroserie) {
        this.typkaroserie = typkaroserie;
    }

    public String getTypkaroserie() {
        return typkaroserie;
    }

    public void setTypkaroserie(String typkaroserie) {
        this.typkaroserie = typkaroserie;
    }

    public Integer getHodnota() {
        return hodnota;
    }

    public void setHodnota(Integer hodnota) {
        this.hodnota = hodnota;
    }

    public Pobocka getPobockaID() {
        return pobockaID;
    }

    public void setPobockaID(Pobocka pobockaID) {
        this.pobockaID = pobockaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typkaroserie != null ? typkaroserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kapacita)) {
            return false;
        }
        Kapacita other = (Kapacita) object;
        if ((this.typkaroserie == null && other.typkaroserie != null) || (this.typkaroserie != null && !this.typkaroserie.equals(other.typkaroserie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Kapacita[ typkaroserie=" + typkaroserie + " ]";
    }
    
}
