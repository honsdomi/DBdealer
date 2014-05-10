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
@Table(name = "doplnkova_vybava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoplnkovaVybava.findAll", query = "SELECT d FROM DoplnkovaVybava d"),
    @NamedQuery(name = "DoplnkovaVybava.findById", query = "SELECT d FROM DoplnkovaVybava d WHERE d.id = :id"),
    @NamedQuery(name = "DoplnkovaVybava.findByNazev", query = "SELECT d FROM DoplnkovaVybava d WHERE d.nazev = :nazev"),
    @NamedQuery(name = "DoplnkovaVybava.findByCena", query = "SELECT d FROM DoplnkovaVybava d WHERE d.cena = :cena")})
public class DoplnkovaVybava implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String findByNazev = "DoplnkovaVybava.findByNazev";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "cena")
    private Integer cena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doplnkovaVybava")
    private Collection<DoplnkovaVybavaHasRezervace> doplnkovaVybavaHasRezervaceCollection;

    public DoplnkovaVybava() {
    }

    public DoplnkovaVybava(Integer id) {
        this.id = id;
    }

    public DoplnkovaVybava(Integer id, String nazev) {
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
    public Collection<DoplnkovaVybavaHasRezervace> getDoplnkovaVybavaHasRezervaceCollection() {
        return doplnkovaVybavaHasRezervaceCollection;
    }

    public void setDoplnkovaVybavaHasRezervaceCollection(Collection<DoplnkovaVybavaHasRezervace> doplnkovaVybavaHasRezervaceCollection) {
        this.doplnkovaVybavaHasRezervaceCollection = doplnkovaVybavaHasRezervaceCollection;
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
        if (!(object instanceof DoplnkovaVybava)) {
            return false;
        }
        DoplnkovaVybava other = (DoplnkovaVybava) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.DoplnkovaVybava[ id=" + id + " ]";
    }
    
}
