/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
public class EpsDaoMysql implements EpsDao{
    
    private Conexion cn;
    List<Eps> eps;
    Eps ep;

    public EpsDaoMysql() {
        this.cn = Conexion.getConexion();
    }
    
    

    @Override
    public List<Eps> Listar() {
        String sql="select * from eps";
        eps=new ArrayList<Eps>();
        
        try{
            ResultSet res=cn.query(sql);
            while(res.next()){
                ep=new Eps();
                ep.setIDEps(res.getString(1));
                ep.setNombre(res.getString(2));
                ep.setTelefono(res.getString(3));
                ep.setDireccion(res.getString(4));
                eps.add(ep);
                
            }
            res.close();
         
        } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
        }
         
        return eps;
        
    }

    @Override
    public Eps obtener(String id_eps) {
        
                try{
			ResultSet res=cn.query("SELECT * FROM eps where ID_Eps= "+id_eps);
			while(res.next()){
                            ep=new Eps();
				ep.setIDEps(res.getString("ID_Eps"));
                                ep.setNombre(res.getString("Nombre"));
                                ep.setTelefono(res.getString("Telefono"));
                                ep.setDireccion(res.getString("Direccion"));
				return ep;
			}
			 res.close();

	     	  
   	  } catch (Exception e) {
   		  System.out.println(e.getMessage());
   	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
   	  }
		return null;
    }

    @Override
    public String insertar(Eps ep) {
        try {
	    String consulta ="INSERT INTO eps (ID_Eps,Nombre, Telefono, Direccion) VALUES ('"+
	    ep.getIDEps()+"','"+ep.getNombre()+"','"+ep.getTelefono()+"','"+ep.getDireccion()+"')";
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
    public String actualizar(Eps ep) {
        
        String sql="UPDATE eps SET ID_Eps='"+ep.getIDEps()+
				"', Nombre='"+ep.getNombre()+"', Telefono='"+
				ep.getTelefono()+"', Direccion='"+ep.getDireccion()+"' WHERE ID_Eps="+ep.getIDEps();
				try {
					cn.insert(sql);
                                        return ".";
				} catch (SQLException e) {
					e.printStackTrace();
                                        return "er";
				}	
    }

    @Override
    public void eliminar(Eps ep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
