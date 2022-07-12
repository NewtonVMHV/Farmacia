/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Venta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author victor
 */
public interface VentaDao {
    
        public List<Venta> Listar();
	public Venta obtener(String cliente, String codigo, Date fecha);
	public String insertar(Venta v);
	public String actualizar(Venta v);
	public void eliminar(Venta v);
    
}
