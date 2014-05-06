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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Doplnkova_vybava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doplnkovavybava.findAll", query = "SELECT d FROM Doplnkovavybava d"),
    @NamedQuery(name = "Doplnkovavybava.findById", query = "SELECT d FROM Doplnkovavybava d WHERE d.id = :id"),
    @NamedQuery(name = "Doplnkovavybava.findByNazev", query = "SELECT d FROM Doplnkovavybava d WHERE d.nazev = :nazev"),
    @NamedQuery(name = "Doplnkovavybava.findByCena", query = "SELECT d FROM Doplnkovavybava d WHERE d.cena = :cena")})
public class Doplnkovavybava implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "cena")
    private Integer cena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doplnkovavybava")
    private Collection<DoplnkovavybavahasRezervace> doplnkovavybavahasRezervaceCollection;

    public Doplnkovavybava() {
    }

    public Doplnkovavybava(Integer id) {
        this.id = id;
    }

    public Doplnkovavybava(Integer id, String nazev) {
        this.id = id;
        this.nazev = nazev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    @XmlTransient
    public Collection<DoplnkovavybavahasRezervace> getDoplnkovavybavahasRezervaceCollection() {
        return doplnkovavybavahasRezervaceCollection;
    }

    public void setDoplnkovavybavahasRezervaceCollection(Collection<DoplnkovavybavahasRezervace> doplnkovavybavahasRezervaceCollection) {
        this.doplnkovavybavahasRezervaceCollection = doplnkovavybavahasRezervaceCollection;
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
        if (!(object instanceof Doplnkovavybava)) {
            return false;
        }
        Doplnkovavybava other = (Doplnkovavybava) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Doplnkovavybava[ id=" + id + " ]";
    }
    
}
