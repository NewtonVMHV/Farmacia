/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Medicamento;
import java.util.List;

/**
 *
 * @author victor
 */
public interface MedicamentoDao {
    
        public List<Medicamento> Listar();
	public Medicamento obtener(String codigo);
	public String insertar(Medicamento m);
	public String actualizar(Medicamento m);
	public void eliminar(String nombre);
    
}
