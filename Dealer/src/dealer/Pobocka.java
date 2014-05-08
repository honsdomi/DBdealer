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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "pobocka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pobocka.findAll", query = "SELECT p FROM Pobocka p"),
    @NamedQuery(name = "Pobocka.findById", query = "SELECT p FROM Pobocka p WHERE p.id = :id"),
    @NamedQuery(name = "Pobocka.findByTelefon", query = "SELECT p FROM Pobocka p WHERE p.telefon = :telefon")})
public class Pobocka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "telefon")
    private Integer telefon;
    @JoinTable(name = "prodejce_has_pobocka", joinColumns = {
        @JoinColumn(name = "pobocka_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "prodejce_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Prodejce> prodejceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pobockaId")
    private Collection<Kapacita> kapacitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pobockaId")
    private Collection<Auto> autoCollection;
    @JoinColumn(name = "spolecnost_nazev", referencedColumnName = "nazev")
    @ManyToOne(optional = false)
    private Spolecnost spolecnostNazev;
    @JoinColumn(name = "adresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adresa adresaId;

    public Pobocka() {
    }

    public Pobocka(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public Collection<Prodejce> getProdejceCollection() {
        return prodejceCollection;
    }

    public void setProdejceCollection(Collection<Prodejce> prodejceCollection) {
        this.prodejceCollection = prodejceCollection;
    }

    @XmlTransient
    public Collection<Kapacita> getKapacitaCollection() {
        return kapacitaCollection;
    }

    public void setKapacitaCollection(Collection<Kapacita> kapacitaCollection) {
        this.kapacitaCollection = kapacitaCollection;
    }

    @XmlTransient
    public Collection<Auto> getAutoCollection() {
        return autoCollection;
    }

    public void setAutoCollection(Collection<Auto> autoCollection) {
        this.autoCollection = autoCollection;
    }

    public Spolecnost getSpolecnostNazev() {
        return spolecnostNazev;
    }

    public void setSpolecnostNazev(Spolecnost spolecnostNazev) {
        this.spolecnostNazev = spolecnostNazev;
    }

    public Adresa getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Adresa adresaId) {
        this.adresaId = adresaId;
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
        if (!(object instanceof Pobocka)) {
            return false;
        }
        Pobocka other = (Pobocka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.Pobocka[ id=" + id + " ]";
    }
    
}
