/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "farmacia")
@NamedQueries({
    @NamedQuery(name = "Farmacia.findAll", query = "SELECT f FROM Farmacia f"),
    @NamedQuery(name = "Farmacia.findById", query = "SELECT f FROM Farmacia f WHERE f.id = :id"),
    @NamedQuery(name = "Farmacia.findByNombreFarmacia", query = "SELECT f FROM Farmacia f WHERE f.nombreFarmacia = :nombreFarmacia"),
    @NamedQuery(name = "Farmacia.findByMunicipio", query = "SELECT f FROM Farmacia f WHERE f.municipio = :municipio"),
    @NamedQuery(name = "Farmacia.findByCantidadVacuna", query = "SELECT f FROM Farmacia f WHERE f.cantidadVacuna = :cantidadVacuna")})
public class Farmacia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreFarmacia")
    private String nombreFarmacia;
    @Basic(optional = false)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "cantidadVacuna")
    private int cantidadVacuna;
    @JoinColumn(name = "id_vacuna_farmacia", referencedColumnName = "ID")
    @ManyToOne
    private Vacunas idVacunaFarmacia;

    public Farmacia() {
    }

    public Farmacia(Integer id) {
        this.id = id;
    }

    public Farmacia(Integer id, String nombreFarmacia, String municipio, int cantidadVacuna) {
        this.id = id;
        this.nombreFarmacia = nombreFarmacia;
        this.municipio = municipio;
        this.cantidadVacuna = cantidadVacuna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCantidadVacuna() {
        return cantidadVacuna;
    }

    public void setCantidadVacuna(int cantidadVacuna) {
        this.cantidadVacuna = cantidadVacuna;
    }

    public Vacunas getIdVacunaFarmacia() {
        return idVacunaFarmacia;
    }

    public void setIdVacunaFarmacia(Vacunas idVacunaFarmacia) {
        this.idVacunaFarmacia = idVacunaFarmacia;
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
        if (!(object instanceof Farmacia)) {
            return false;
        }
        Farmacia other = (Farmacia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Farmacia[ id=" + id + " ]";
    }
    
}
