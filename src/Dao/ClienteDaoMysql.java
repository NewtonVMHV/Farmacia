/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Clientes;
import Modelo.Conexion;
import Modelo.Eps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class ClienteDaoMysql implements ClienteDao{
    
    private Conexion  cn;
    List<Clientes> clientes;
    Clientes c;
    Eps ep;
    EpsDaoMysql epd = new EpsDaoMysql();
    
    public ClienteDaoMysql() {
        this.cn = Conexion.getConexion();
    }
    
    @Override
    public List<Clientes> Listar() {
        String sql="select * from clientes";
        clientes=new ArrayList<Clientes>();
        
        EpsDaoMysql epd=new EpsDaoMysql();
        try{
            ResultSet res=cn.query(sql);
            while(res.next()){
                c=new Clientes();
                c.setNombre(res.getString(1));
                c.setApellidos(res.getString(2));
                c.setCedula(res.getString(3));
                c.setTelefono(res.getString(4));
                c.setDireccion(res.getString(5));
                ep=epd.obtener(res.getString(6));
                c.setEps(ep);
                clientes.add(c);
            }
            res.close();
        
        }
        catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace(); 
        }
        
        return clientes; 
        
    }

    @Override
    public Clientes obtener(String cedula) {
        
         try{
			ResultSet res=cn.query("SELECT * FROM clientes where Cedula= "+cedula);
			while(res.next()){
                            c=new Clientes();
				c.setNombre(res.getString("Nombre"));
                                c.setApellidos(res.getString("Apellidos"));
                                c.setCedula(res.getString("Cedula"));
                                c.setTelefono(res.getString("Telefono"));
                                c.setDireccion(res.getString("Direccion"));
                                ep=epd.obtener(res.getString("Eps"));
                                c.setEps(ep);
				return c;
			}
			 res.close();

	     	  
   	  } catch (Exception e) {
   		  System.out.println(e.getMessage());
   	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
   	  }
		return null;
    }

    @Override
    public String insertar(Clientes c) {
         try {
	    String consulta ="INSERT INTO clientes (Nombre, Apellidos, Cedula, Telefono, Direccion, Eps) VALUES ('"+
	    c.getNombre()+"','"+c.getApellidos()+"','"+c.getCedula()+"','"+c.getTelefono()+"','"+c.getDireccion()+"','"+c.getEps().getIDEps()+"')";
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
    public String actualizar(Clientes c) {
        String sql="UPDATE clientes SET Nombre='"+c.getNombre()+
				"', Apellidos='"+c.getApellidos()+"', Cedula='"+
				c.getCedula()+"', Telefono='"+c.getTelefono()+"', Direccion='"+c.getDireccion()+"',Eps='"+c.getEps().getIDEps()+"' WHERE Cedula="+c.getCedula();
				try {
					cn.insert(sql);
                                        return ".";
				} catch (SQLException e) {
					e.printStackTrace();
                                        return "er";
				}
    }

    @Override
    public void eliminar(Clientes c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
