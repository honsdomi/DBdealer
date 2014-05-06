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
@Table(name = "Auto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auto.findAll", query = "SELECT a FROM Auto a"),
    @NamedQuery(name = "Auto.findByVin", query = "SELECT a FROM Auto a WHERE a.vin = :vin"),
    @NamedQuery(name = "Auto.findByZnacka", query = "SELECT a FROM Auto a WHERE a.znacka = :znacka"),
    @NamedQuery(name = "Auto.findByModel", query = "SELECT a FROM Auto a WHERE a.model = :model"),
    @NamedQuery(name = "Auto.findByBarva", query = "SELECT a FROM Auto a WHERE a.barva = :barva"),
    @NamedQuery(name = "Auto.findByRokVyroby", query = "SELECT a FROM Auto a WHERE a.rokVyroby = :rokVyroby"),
    @NamedQuery(name = "Auto.findByTypKaroserie", query = "SELECT a FROM Auto a WHERE a.typKaroserie = :typKaroserie")})
public class Auto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VIN")
    private String vin;
    @Basic(optional = false)
    @Column(name = "znacka")
    private String znacka;
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    @Column(name = "barva")
    private String barva;
    @Basic(optional = false)
    @Column(name = "rok_vyroby")
    private short rokVyroby;
    @Basic(optional = false)
    @Column(name = "typ_karoserie")
    private String typKaroserie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autoVIN")
    private Collection<Rezervace> rezervaceCollection;
    @JoinColumn(name = "Pobocka_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pobocka pobockaID;

    public Auto() {
    }

    public Auto(String vin) {
        this.vin = vin;
    }

    public Auto(String vin, String znacka, String model, short rokVyroby, String typKaroserie) {
        this.vin = vin;
        this.znacka = znacka;
        this.model = model;
        this.rokVyroby = rokVyroby;
        this.typKaroserie = typKaroserie;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public short getRokVyroby() {
        return rokVyroby;
    }

    public void setRokVyroby(short rokVyroby) {
        this.rokVyroby = rokVyroby;
    }

    public String getTypKaroserie() {
        return typKaroserie;
    }

    public void setTypKaroserie(String typKaroserie) {
        this.typKaroserie = typKaroserie;
    }

    @XmlTransient
    public Collection<Rezervace> getRezervaceCollection() {
        return rezervaceCollection;
    }

    public void setRezervaceCollection(Collection<Rezervace> rezervaceCollection) {
        this.rezervaceCollection = rezervaceCollection;
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
        hash += (vin != null ? vin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auto)) {
            return false;
        }
        Auto other = (Auto) object;
        if ((this.vin == null && other.vin != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Auto[ vin=" + vin + " ]";
    }
    
}
