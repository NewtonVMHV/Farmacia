/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Conexion;
import Modelo.Medicamento;
import Modelo.Venta;
import Modelo.VentaPK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author victor
 */
public class VentaDaoMysql implements VentaDao {

    private Conexion  cn;
    List<Venta> ventas;
    Venta v;
    VentaPK vpk;
    Medicamento m;
    MedicamentoDaoMysql mm=new MedicamentoDaoMysql();

    public VentaDaoMysql() {
        this.cn =  Conexion.getConexion();
    }
    
    
    
    
    @Override
    public List<Venta> Listar() {
        
        String sql="select * from venta";
        ventas=new ArrayList<Venta>();
        
        try{
            ResultSet res=cn.query(sql);
            while(res.next()){
                v=new Venta();
                vpk=new VentaPK();
                m=new Medicamento();
                vpk.setCliente(res.getString(1));
                vpk.setCodigo(res.getString(2));
                vpk.setFecha(res.getDate(3));
                v.setVentaPK(vpk);
                v.setPrecioUnitario(4);
                v.setCantidad(5);
                v.setTotalPagar(6);
                m=mm.obtener(res.getString(7));
                v.setProducto(m); 
                ventas.add(v);
            }
            res.close();
        
        }
        catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace(); 
        }
        
        return ventas; 
        
    }

    @Override
    public Venta obtener(String cliente, String codigo, Date fecha) {
        
         try{
                ResultSet res=cn.query("SELECT * FROM venta where Cliente= "+cliente+" AND Codigo= "+codigo+" AND Fecha= "+fecha);
			while(res.next()){
                            v=new Venta();
                            vpk=new VentaPK();
                            m=new Medicamento();
                                vpk.setCliente(res.getString("Cliente"));
                                vpk.setCodigo(res.getString("Codigo"));
                                vpk.setFecha(res.getDate("Fecha"));
                                v.setVentaPK(vpk);
                                v.setPrecioUnitario(res.getDouble("Precio_Unitario"));
                                v.setCantidad(res.getInt("Cantidad"));
                                v.setTotalPagar(res.getDouble("Total_Pagar"));
                                m=mm.obtener(res.getString("Producto"));
                                v.setProducto(m);
				
				return v;
			}
			 res.close();

	     	  
   	  } catch (Exception e) {
   		  System.out.println(e.getMessage());
   	   //JOptionPane.showMessageDialog(null, "no se pudo consultar\n"+e);
   	  }
		return null;
    }

    @Override
    public String insertar(Venta v) {
        try {
	    String consulta ="INSERT INTO venta (Cliente, Codigo, Fecha, Precio_Unitario, Cantidad, Total_Pagar, Producto) VALUES ('"+
	    v.getVentaPK().getCliente()+"','"+v.getVentaPK().getCodigo()+"','"+v.getVentaPK().getFecha()+"','"+v.getPrecioUnitario()+"','"+v.getCantidad()+"','"
                    +v.getTotalPagar()+"','"+v.getProducto().getCodigo()+"')";
	    System.out.println(consulta);
            cn.insert(consulta);
            return "..";
 		    
 		  } catch (SQLException e) {
 		            System.out.println(e.getMessage());
                            return "er";
 		   //JOptionPane.showMessageDialog(null, "No se Registro la persona");
 		  }
        
    }

    @Override
    public String actualizar(Venta v) {
        String sql="UPDATE venta SET Cliente='"+v.getVentaPK().getCliente()+
				"', Codigo='"+v.getVentaPK().getCodigo()+"', Fecha='"+
				v.getVentaPK().getFecha()+"', Precio_Unitario='"+
                                v.getPrecioUnitario()+"', Total_Pagar='"+v.getTotalPagar()+"', Procducto='"+
                                v.getProducto().getCodigo()+"' WHERE Codigo="+v.getVentaPK().getCodigo();
				try {
					cn.insert(sql);
                                        return ".";
				} catch (SQLException e) {
					e.printStackTrace();
                                        return "er";
				}
    }

    @Override
    public void eliminar(Venta v) {
        
    }
    
}
