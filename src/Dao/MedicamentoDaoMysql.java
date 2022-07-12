/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Conexion;
import Modelo.Laboratorio;
import Modelo.Medicamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class MedicamentoDaoMysql implements MedicamentoDao {

    
    private Conexion  cn;
    List<Medicamento> medicamentos;
    Medicamento m;
    Laboratorio lb;
    LaboratorioDaoMysql epd=new LaboratorioDaoMysql();

    public MedicamentoDaoMysql() {
        this.cn = Conexion.getConexion();
    }

    @Override
    public List<Medicamento> Listar() {
        String sql="select * from medicamento";
        medicamentos=new ArrayList<Medicamento>();
        
        try{
            ResultSet res=cn.query(sql);
            while(res.next()){
                m=new Medicamento();
                m.setNombre(res.getString(1));
                m.setCodigo(res.getString(2));
                m.setCantidad(res.getInt(3));
                m.setPrecioUnitario(res.getDouble(4));
                lb=epd.obtener(res.getString(5));
                m.setLaboratorio(lb);
                medicamentos.add(m);
            }
            res.close();
        
        }
        catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace(); 
        }
        
        return medicamentos; 
    }

    @Override
    public Medicamento obtener(String codigo) {
       
        try{
			ResultSet res=cn.query("SELECT * FROM medicamento where Codigo= "+codigo);
			while(res.next()){
                             m=new Medicamento();
				m.setNombre(res.getString("Nombre"));
                                m.setCodigo(res.getString("Codigo"));
                                m.setCantidad(res.getInt("Cantidad"));
                                m.setPrecioUnitario(res.getDouble("Precio_Unitario"));
                                lb=epd.obtener(res.getString("Laboratorio"));
                                m.setLaboratorio(lb);
				return m;
			}
			 res.close();

	     	  
   	  } catch (Exception e) {
   		  System.out.println(e.getMessage());
   	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
   	  }
		return null;
    }

    @Override
    public String insertar(Medicamento m) {
        try {
	    String consulta ="INSERT INTO medicamento (Nombre, Codigo, Cantidad, Precio_Unitario, Laboratorio) VALUES ('"+
	    m.getNombre()+"','"+m.getCodigo()+"','"+m.getCantidad()+"','"+m.getPrecioUnitario()+"','"+m.getLaboratorio().getRut()+"')";
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
    public String actualizar(Medicamento m) {
        String sql="UPDATE medicamento SET Nombre='"+m.getNombre()+
				"', Codigo='"+m.getCodigo()+"', Cantidad='"+
				m.getCantidad()+"', Precio_Unitario='"+m.getPrecioUnitario()+"', Laboratorio='"+m.getLaboratorio().getRut()+"' WHERE Codigo="+m.getCodigo();
				try {
					cn.insert(sql);
                                        return ".";
				} catch (SQLException e) {
					e.printStackTrace();
                                        return "er";
				}	
    }

    @Override
    public void eliminar(String codigo) {                                   
        String sql="DELETE FROM medicamento WHERE Codigo='"+codigo+"'";
        try{
            
            if(cn.eliminar(sql)){
                System.out.println("Correcto");
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
