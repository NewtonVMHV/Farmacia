/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Laboratorio;
import java.util.List;

/**
 *
 * @author victor
 */
public interface LaboratorioDao {
    
        public List<Laboratorio> Listar();
	public Laboratorio obtener(String rut);
	public String insertar(Laboratorio c);
	public String actualizar(Laboratorio c);
	public void eliminar(Laboratorio c);
    
}
