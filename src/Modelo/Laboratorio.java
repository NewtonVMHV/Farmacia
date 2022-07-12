/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "laboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l")
    , @NamedQuery(name = "Laboratorio.findByNombre", query = "SELECT l FROM Laboratorio l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Laboratorio.findByRut", query = "SELECT l FROM Laboratorio l WHERE l.rut = :rut")
    , @NamedQuery(name = "Laboratorio.findByTelefono", query = "SELECT l FROM Laboratorio l WHERE l.telefono = :telefono")
    , @NamedQuery(name = "Laboratorio.findByDireccion", query = "SELECT l FROM Laboratorio l WHERE l.direccion = :direccion")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratorio")
    private Collection<Medicamento> medicamentoCollection;

    public Laboratorio() {
    }

    public Laboratorio(String rut) {
        this.rut = rut;
    }

    public Laboratorio(String rut, String nombre, String telefono, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Laboratorio[ rut=" + rut + " ]";
    }
    
}
