/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Clientes;
import java.util.List;

/**
 *
 * @author victor
 */
public interface ClienteDao {
    
        public List<Clientes> Listar();
	public Clientes obtener(String cedula);
	public String insertar(Clientes c);
	public String actualizar(Clientes c);
	public void eliminar(Clientes c);
    
}
