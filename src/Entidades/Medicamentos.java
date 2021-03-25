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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "medicamentos")
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findById", query = "SELECT m FROM Medicamentos m WHERE m.id = :id"),
    @NamedQuery(name = "Medicamentos.findByNombreDeMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.nombreDeMedicamento = :nombreDeMedicamento"),
    @NamedQuery(name = "Medicamentos.findByPrecio", query = "SELECT m FROM Medicamentos m WHERE m.precio = :precio"),
    @NamedQuery(name = "Medicamentos.findByCantidad", query = "SELECT m FROM Medicamentos m WHERE m.cantidad = :cantidad")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreDeMedicamento")
    private String nombreDeMedicamento;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @OneToMany(mappedBy = "idMedicamento")
    private List<Paciente> pacienteList;

    public Medicamentos() {
    }

    public Medicamentos(Integer id) {
        this.id = id;
    }

    public Medicamentos(Integer id, String nombreDeMedicamento, float precio, int cantidad) {
        this.id = id;
        this.nombreDeMedicamento = nombreDeMedicamento;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDeMedicamento() {
        return nombreDeMedicamento;
    }

    public void setNombreDeMedicamento(String nombreDeMedicamento) {
        this.nombreDeMedicamento = nombreDeMedicamento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
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
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Medicamentos[ id=" + id + " ]";
    }
    
}
