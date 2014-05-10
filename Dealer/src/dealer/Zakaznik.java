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
@Table(name = "zakaznik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zakaznik.findAll", query = "SELECT z FROM Zakaznik z"),
    @NamedQuery(name = "Zakaznik.findById", query = "SELECT z FROM Zakaznik z WHERE z.id = :id"),
    @NamedQuery(name = "Zakaznik.findByJmeno", query = "SELECT z FROM Zakaznik z WHERE z.jmeno = :jmeno")})
public class Zakaznik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "jmeno")
    private String jmeno;
    @JoinColumn(name = "id_adresa", referencedColumnName = "id")
    @ManyToOne
    private Adresa idAdresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zakaznikId")
    private Collection<Smlouva> smlouvaCollection;

    public Zakaznik() {
    }

    public Zakaznik(String jmeno, Adresa idAdresa) {
        this.jmeno = jmeno;
        this.idAdresa = idAdresa;
    }
    

    public Zakaznik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public Adresa getIdAdresa() {
        return idAdresa;
    }

    public void setIdAdresa(Adresa idAdresa) {
        this.idAdresa = idAdresa;
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
        if (!(object instanceof Zakaznik)) {
            return false;
        }
        Zakaznik other = (Zakaznik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dealer.Zakaznik[ id=" + id + " ]";
    }
    
}
