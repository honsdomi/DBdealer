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
@Table(name = "rezervace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervace.findAll", query = "SELECT r FROM Rezervace r"),
    @NamedQuery(name = "Rezervace.findById", query = "SELECT r FROM Rezervace r WHERE r.id = :id"),
    @NamedQuery(name = "Rezervace.findByZnacka", query = "SELECT r FROM Rezervace r WHERE r.znacka = :znacka"),
    @NamedQuery(name = "Rezervace.findByModel", query = "SELECT r FROM Rezervace r WHERE r.model = :model"),
    @NamedQuery(name = "Rezervace.findByBarva", query = "SELECT r FROM Rezervace r WHERE r.barva = :barva"),
    @NamedQuery(name = "Rezervace.findByRokVyroby", query = "SELECT r FROM Rezervace r WHERE r.rokVyroby = :rokVyroby")})
public class Rezervace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;    
    @Column(name = "znacka")
    private String znacka;
    @Column(name = "model")
    private String model;
    @Column(name = "barva")
    private String barva;
    @Column(name = "rok_vyroby")
    private Short rokVyroby;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezervace")
    private Collection<DoplnkovaVybavaHasRezervace> doplnkovaVybavaHasRezervaceCollection;
    @JoinColumn(name = "auto_vin", referencedColumnName = "vin")
    @ManyToOne(optional = false)
    private Auto autoVin;
    @OneToMany(mappedBy = "rezervaceId")
    private Collection<Smlouva> smlouvaCollection;

    public Rezervace() {
    }

    public Rezervace(String znacka, String model, String barva, Short rokVyroby) {
        this.znacka = znacka;
        this.model = model;
        this.barva = barva;
        this.rokVyroby = rokVyroby;
    }
    
    public Rezervace(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public Short getRokVyroby() {
        return rokVyroby;
    }

    public void setRokVyroby(Short rokVyroby) {
        this.rokVyroby = rokVyroby;
    }

    @XmlTransient
    public Collection<DoplnkovaVybavaHasRezervace> getDoplnkovaVybavaHasRezervaceCollection() {
        return doplnkovaVybavaHasRezervaceCollection;
    }

    public void setDoplnkovaVybavaHasRezervaceCollection(Collection<DoplnkovaVybavaHasRezervace> doplnkovaVybavaHasRezervaceCollection) {
        this.doplnkovaVybavaHasRezervaceCollection = doplnkovaVybavaHasRezervaceCollection;
    }

    public Auto getAutoVin() {
        return autoVin;
    }

    public void setAutoVin(Auto autoVin) {
        this.autoVin = autoVin;
    }

    @XmlTransient
    public Collection<Smlouva> getSmlouvaCollection() {
        return smlouvaCollection;
    }

    public void setSmlouvaCollection(Collection<Smlouva> smlouvaCollection) {
        this.smlouvaCollection = smlouvaCollection;
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
        if (!(object instanceof Rezervace)) {
            return false;
        }
        Rezervace other = (Rezervace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.Rezervace[ id=" + id + " ]";
    }
    
}
