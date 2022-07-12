/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Eps;
import java.util.List;


/**
 *
 * @author victor
 */
public interface EpsDao {
    
        public List<Eps> Listar();
	public Eps obtener(String id_eps);
	public String insertar(Eps ep);
	public String actualizar(Eps ep);
	public void eliminar(Eps ep);
    
}
