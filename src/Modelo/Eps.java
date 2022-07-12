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
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e")
    , @NamedQuery(name = "Eps.findByIDEps", query = "SELECT e FROM Eps e WHERE e.iDEps = :iDEps")
    , @NamedQuery(name = "Eps.findByNombre", query = "SELECT e FROM Eps e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Eps.findByTelefono", query = "SELECT e FROM Eps e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Eps.findByDireccion", query = "SELECT e FROM Eps e WHERE e.direccion = :direccion")})
public class Eps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Eps")
    private String iDEps;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eps")
    private Collection<Clientes> clientesCollection;

    public Eps() {
    }

    public Eps(String iDEps) {
        this.iDEps = iDEps;
    }

    public Eps(String iDEps, String nombre, String telefono, String direccion) {
        this.iDEps = iDEps;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getIDEps() {
        return iDEps;
    }

    public void setIDEps(String iDEps) {
        this.iDEps = iDEps;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEps != null ? iDEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.iDEps == null && other.iDEps != null) || (this.iDEps != null && !this.iDEps.equals(other.iDEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Eps[ iDEps=" + iDEps + " ]";
    }
    
}
