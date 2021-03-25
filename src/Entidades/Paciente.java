/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellidoPaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Paciente.findByApellidoMaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Paciente.findByGenero", query = "SELECT p FROM Paciente p WHERE p.genero = :genero"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByCurp", query = "SELECT p FROM Paciente p WHERE p.curp = :curp"),
    @NamedQuery(name = "Paciente.findByCiudad", query = "SELECT p FROM Paciente p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Paciente.findByCodigoPostal", query = "SELECT p FROM Paciente p WHERE p.codigoPostal = :codigoPostal")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ApellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "ApellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "Genero")
    private Character genero;
    @Basic(optional = false)
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "CURP")
    private String curp;
    @Basic(optional = false)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "CodigoPostal")
    private int codigoPostal;
    @JoinColumn(name = "id_hospitales", referencedColumnName = "ID")
    @ManyToOne
    private Hospital idHospitales;
    @JoinColumn(name = "id_vacuna_paciente", referencedColumnName = "ID")
    @ManyToOne
    private Vacunas idVacunaPaciente;
    @JoinColumn(name = "id_medicamento", referencedColumnName = "ID")
    @ManyToOne
    private Medicamentos idMedicamento;

    public Paciente() {
    }

    public Paciente(Integer id) {
        this.id = id;
    }

    public Paciente(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, Character genero, Date fechaNacimiento, String curp, String ciudad, int codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Hospital getIdHospitales() {
        return idHospitales;
    }

    public void setIdHospitales(Hospital idHospitales) {
        this.idHospitales = idHospitales;
    }

    public Vacunas getIdVacunaPaciente() {
        return idVacunaPaciente;
    }

    public void setIdVacunaPaciente(Vacunas idVacunaPaciente) {
        this.idVacunaPaciente = idVacunaPaciente;
    }

    public Medicamentos getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamentos idMedicamento) {
        this.idMedicamento = idMedicamento;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paciente[ id=" + id + " ]";
    }
    
}
