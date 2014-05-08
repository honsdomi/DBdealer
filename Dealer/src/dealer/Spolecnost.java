/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dealer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "spolecnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spolecnost.findAll", query = "SELECT s FROM Spolecnost s"),
    @NamedQuery(name = "Spolecnost.findByNazev", query = "SELECT s FROM Spolecnost s WHERE s.nazev = :nazev")})
public class Spolecnost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @JoinColumn(name = "adresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adresa adresaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spolecnostNazev")
    private Collection<Pobocka> pobockaCollection;

    public Spolecnost() {
    }

    public Spolecnost(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Adresa getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Adresa adresaId) {
        this.adresaId = adresaId;
    }

    @XmlTransient
    public Collection<Pobocka> getPobockaCollection() {
        return pobockaCollection;
    }

    public void setPobockaCollection(Collection<Pobocka> pobockaCollection) {
        this.pobockaCollection = pobockaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazev != null ? nazev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spolecnost)) {
            return false;
        }
        Spolecnost other = (Spolecnost) object;
        if ((this.nazev == null && other.nazev != null) || (this.nazev != null && !this.nazev.equals(other.nazev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.Spolecnost[ nazev=" + nazev + " ]";
    }
    
}
