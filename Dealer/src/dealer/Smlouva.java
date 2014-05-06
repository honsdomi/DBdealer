/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dealer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "Smlouva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smlouva.findAll", query = "SELECT s FROM Smlouva s"),
    @NamedQuery(name = "Smlouva.findById", query = "SELECT s FROM Smlouva s WHERE s.id = :id"),
    @NamedQuery(name = "Smlouva.findByDatumSplatnosti", query = "SELECT s FROM Smlouva s WHERE s.datumSplatnosti = :datumSplatnosti"),
    @NamedQuery(name = "Smlouva.findByJeZaplacena", query = "SELECT s FROM Smlouva s WHERE s.jeZaplacena = :jeZaplacena")})
public class Smlouva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "datum_splatnosti")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumSplatnosti;
    @Basic(optional = false)
    @Column(name = "je_zaplacena")
    private boolean jeZaplacena;
    @JoinColumn(name = "Zakaznik_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Zakaznik zakaznikID;
    @JoinColumn(name = "Rezervace_ID", referencedColumnName = "ID")
    @ManyToOne
    private Rezervace rezervaceID;
    @JoinColumn(name = "Prodejce_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Prodejce prodejceID;

    public Smlouva() {
    }

    public Smlouva(Integer id) {
        this.id = id;
    }

    public Smlouva(Integer id, Date datumSplatnosti, boolean jeZaplacena) {
        this.id = id;
        this.datumSplatnosti = datumSplatnosti;
        this.jeZaplacena = jeZaplacena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(Date datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public boolean getJeZaplacena() {
        return jeZaplacena;
    }

    public void setJeZaplacena(boolean jeZaplacena) {
        this.jeZaplacena = jeZaplacena;
    }

    public Zakaznik getZakaznikID() {
        return zakaznikID;
    }

    public void setZakaznikID(Zakaznik zakaznikID) {
        this.zakaznikID = zakaznikID;
    }

    public Rezervace getRezervaceID() {
        return rezervaceID;
    }

    public void setRezervaceID(Rezervace rezervaceID) {
        this.rezervaceID = rezervaceID;
    }

    public Prodejce getProdejceID() {
        return prodejceID;
    }

    public void setProdejceID(Prodejce prodejceID) {
        this.prodejceID = prodejceID;
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
        if (!(object instanceof Smlouva)) {
            return false;
        }
        Smlouva other = (Smlouva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dscviceni10a.Smlouva[ id=" + id + " ]";
    }
    
}
