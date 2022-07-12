/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCliente", query = "SELECT v FROM Venta v WHERE v.ventaPK.cliente = :cliente")
    , @NamedQuery(name = "Venta.findByCodigo", query = "SELECT v FROM Venta v WHERE v.ventaPK.codigo = :codigo")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.ventaPK.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByPrecioUnitario", query = "SELECT v FROM Venta v WHERE v.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Venta.findByTotalPagar", query = "SELECT v FROM Venta v WHERE v.totalPagar = :totalPagar")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaPK ventaPK;
    @Basic(optional = false)
    @Column(name = "Precio_Unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Total_Pagar")
    private double totalPagar;
    @JoinColumn(name = "Cliente", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "Producto", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Medicamento producto;

    public Venta() {
    }

    public Venta(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Venta(VentaPK ventaPK, double precioUnitario, int cantidad, double totalPagar) {
        this.ventaPK = ventaPK;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.totalPagar = totalPagar;
    }

    public Venta(String cliente, String codigo, Date fecha) {
        this.ventaPK = new VentaPK(cliente, codigo, fecha);
    }

    public VentaPK getVentaPK() {
        return ventaPK;
    }

    public void setVentaPK(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Medicamento getProducto() {
        return producto;
    }

    public void setProducto(Medicamento producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaPK != null ? ventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventaPK == null && other.ventaPK != null) || (this.ventaPK != null && !this.ventaPK.equals(other.ventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Venta[ ventaPK=" + ventaPK + " ]";
    }
    
}
