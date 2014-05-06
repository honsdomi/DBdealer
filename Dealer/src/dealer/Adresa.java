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
@Table(name = "Adresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findById", query = "SELECT a FROM Adresa a WHERE a.id = :id"),
    @NamedQuery(name = "Adresa.findByMesto", query = "SELECT a FROM Adresa a WHERE a.mesto = :mesto"),
    @NamedQuery(name = "Adresa.findByUlice", query = "SELECT a FROM Adresa a WHERE a.ulice = :ulice"),
    @NamedQuery(name = "Adresa.findByCp", query = "SELECT a FROM Adresa a WHERE a.cp = :cp"),
    @NamedQuery(name = "Adresa.findByPsc", query = "SELECT a FROM Adresa a WHERE a.psc = :psc")})
public class Adresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "mesto")
    private String mesto;
    @Column(name = "ulice")
    private String ulice;
    @Column(name = "CP")
    private Integer cp;
    @Column(name = "PSC")
    private Integer psc;
    @OneToMany(mappedBy = "iDAdresa")
    private Collection<Zakaznik> zakaznikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresaID")
    private Collection<Spolecnost> spolecnostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresaID")
    private Collection<Pobocka> pobockaCollection;

    public Adresa() {
    }

    public Adresa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    @XmlTransient
    public Collection<Zakaznik> getZakaznikCollection() {
        return zakaznikCollection;
    }

    public void setZakaznikCollection(Collection<Zakaznik> zakaznikCollection) {
        this.zakaznikCollection = zakaznikCollection;
    }

    @XmlTransient
    public Collection<Spolecnost> getSpolecnostCollection() {
        return spolecnostCollection;
    }

    public void setSpolecnostCollection(Collection<Spolecnost> spolecnostCollection) {
        this.spolecnostCollection = spolecnostCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Adresa[ id=" + id + " ]";
    }
    
}
