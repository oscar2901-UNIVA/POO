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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "hospital")
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findById", query = "SELECT h FROM Hospital h WHERE h.id = :id"),
    @NamedQuery(name = "Hospital.findByNombreHospital", query = "SELECT h FROM Hospital h WHERE h.nombreHospital = :nombreHospital"),
    @NamedQuery(name = "Hospital.findBySeguroDeGatosMedicos", query = "SELECT h FROM Hospital h WHERE h.seguroDeGatosMedicos = :seguroDeGatosMedicos")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreHospital")
    private String nombreHospital;
    @Basic(optional = false)
    @Column(name = "SeguroDeGatosMedicos")
    private String seguroDeGatosMedicos;

    public Hospital() {
    }

    public Hospital(Integer id) {
        this.id = id;
    }

    public Hospital(Integer id, String nombreHospital, String seguroDeGatosMedicos) {
        this.id = id;
        this.nombreHospital = nombreHospital;
        this.seguroDeGatosMedicos = seguroDeGatosMedicos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getSeguroDeGatosMedicos() {
        return seguroDeGatosMedicos;
    }

    public void setSeguroDeGatosMedicos(String seguroDeGatosMedicos) {
        this.seguroDeGatosMedicos = seguroDeGatosMedicos;
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
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Hospital[ id=" + id + " ]";
    }
    
}
