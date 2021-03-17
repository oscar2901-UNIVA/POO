/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Hospital.findBySeguroDeGatosMedicos", query = "SELECT h FROM Hospital h WHERE h.seguroDeGatosMedicos = :seguroDeGatosMedicos"),
    @NamedQuery(name = "Hospital.findByOcupacion", query = "SELECT h FROM Hospital h WHERE h.ocupacion = :ocupacion")})
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
    private char seguroDeGatosMedicos;
    @Basic(optional = false)
    @Column(name = "ocupacion")
    private String ocupacion;
    @OneToMany(mappedBy = "idHospitales")
    private List<Paciente> pacienteList;
    @JoinColumn(name = "id_vacuna_hospitales", referencedColumnName = "ID")
    @ManyToOne
    private Vacunas idVacunaHospitales;

    public Hospital() {
    }

    public Hospital(Integer id) {
        this.id = id;
    }

    public Hospital(Integer id, String nombreHospital, char seguroDeGatosMedicos, String ocupacion) {
        this.id = id;
        this.nombreHospital = nombreHospital;
        this.seguroDeGatosMedicos = seguroDeGatosMedicos;
        this.ocupacion = ocupacion;
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

    public char getSeguroDeGatosMedicos() {
        return seguroDeGatosMedicos;
    }

    public void setSeguroDeGatosMedicos(char seguroDeGatosMedicos) {
        this.seguroDeGatosMedicos = seguroDeGatosMedicos;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Vacunas getIdVacunaHospitales() {
       
        return idVacunaHospitales;
    }

    public void setIdVacunaHospitales(Vacunas idVacunaHospitales) {
        this.idVacunaHospitales = idVacunaHospitales;
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
    
    public class ComboItem {
    private int id;
    private String descripcion;

    public ComboItem(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
}
