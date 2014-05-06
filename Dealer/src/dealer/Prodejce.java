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
import javax.persistence.ManyToMany;
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
@Table(name = "Prodejce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodejce.findAll", query = "SELECT p FROM Prodejce p"),
    @NamedQuery(name = "Prodejce.findById", query = "SELECT p FROM Prodejce p WHERE p.id = :id"),
    @NamedQuery(name = "Prodejce.findByJmeno", query = "SELECT p FROM Prodejce p WHERE p.jmeno = :jmeno"),
    @NamedQuery(name = "Prodejce.findByMzda", query = "SELECT p FROM Prodejce p WHERE p.mzda = :mzda")})
public class Prodejce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "jmeno")
    private String jmeno;
    @Basic(optional = false)
    @Column(name = "mzda")
    private int mzda;
    @ManyToMany(mappedBy = "prodejceCollection")
    private Collection<Pobocka> pobockaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodejceID")
    private Collection<Smlouva> smlouvaCollection;

    public Prodejce() {
    }

    public Prodejce(Integer id) {
        this.id = id;
    }

    public Prodejce(Integer id, String jmeno, int mzda) {
        this.id = id;
        this.jmeno = jmeno;
        this.mzda = mzda;
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

    public int getMzda() {
        return mzda;
    }

    public void setMzda(int mzda) {
        this.mzda = mzda;
    }

    @XmlTransient
    public Collection<Pobocka> getPobockaCollection() {
        return pobockaCollection;
    }

    public void setPobockaCollection(Collection<Pobocka> pobockaCollection) {
        this.pobockaCollection = pobockaCollection;
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
        if (!(object instanceof Prodejce)) {
            return false;
        }
        Prodejce other = (Prodejce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Prodejce[ id=" + id + " ]";
    }
    
}
