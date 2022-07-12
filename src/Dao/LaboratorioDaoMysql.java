/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Conexion;
import Modelo.Laboratorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class LaboratorioDaoMysql implements LaboratorioDao {
    private Conexion cn;
    List<Laboratorio> lab;
    Laboratorio lb;
    

    public LaboratorioDaoMysql() {
        this.cn = Conexion.getConexion();
    }

    @Override
    public List<Laboratorio> Listar() {
         String sql="select * from laboratorio";
        lab=new ArrayList<Laboratorio>();
        
        try{
            ResultSet res=cn.query(sql);
            while(res.next()){
                lb=new Laboratorio();
                lb.setNombre(res.getString(1));
                lb.setRut(res.getString(2));
                lb.setTelefono(res.getString(3));
                lb.setDireccion(res.getString(4));
                lab.add(lb);
                
            }
            res.close();
         
        } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
        }
         
        return lab;
    }

    @Override
    public Laboratorio obtener(String rut) {
        
         try{
                ResultSet res=cn.query("SELECT * FROM laboratorio where rut= "+rut);
			while(res.next()){
                            lb=new Laboratorio();
				lb.setNombre(res.getString("Nombre"));
                                lb.setRut(res.getString("rut"));
                                lb.setTelefono(res.getString("Telefono"));
                                lb.setDireccion(res.getString("Direccion"));
				return lb;
			}
			 res.close();

	     	  
   	  } catch (Exception e) {
   		  System.out.println(e.getMessage());
   	   
   	  }
		return null;
    }
   

    @Override
    public String insertar(Laboratorio c) {
         try {
	    String consulta ="INSERT INTO laboratorio (Nombre,rut, Telefono, Direccion) VALUES ('"+
	    c.getNombre()+"','"+c.getRut()+"','"+c.getTelefono()+"','"+c.getDireccion()+"')";
	    System.out.println(consulta);
            cn.insert(consulta);
            return "..";
 		    
 		  } catch (SQLException e) {
 		            System.out.println(e.getMessage());
                            return "er";
 		  }
    }

    @Override
    public String actualizar(Laboratorio c) {
         String sql="UPDATE laboratorio SET Nombre='"+c.getNombre()+
				"', rut='"+c.getRut()+"', Telefono='"+
				c.getTelefono()+"', Direccion='"+c.getDireccion()+"' WHERE rut="+c.getRut();
				try {
					cn.insert(sql);
                                        return ".";
				} catch (SQLException e) {
					e.printStackTrace();
                                        return "er";
				}	
    }

    @Override
    public void eliminar(Laboratorio c) {

    }
    
}
