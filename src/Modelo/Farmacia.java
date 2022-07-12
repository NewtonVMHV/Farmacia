/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Dao.*;
/**
 *
 * @author victor
 */
public class Farmacia {
    
    MedicamentoDaoMysql md=new MedicamentoDaoMysql();
    
    LaboratorioDaoMysql lb=new LaboratorioDaoMysql();
    
    EpsDaoMysql ep=new EpsDaoMysql();
    
    ClienteDaoMysql cl=new ClienteDaoMysql();

    public Farmacia() {
    }

    public void agregarMedicamento(Medicamento m){
        md.insertar(m);
    }
    
    public void agregarLaboratorio(Laboratorio l){
        lb.insertar(l);
    }
    
    public void agregarEps(Eps e){
        ep.insertar(e);
    }
    
    public void agregarCliente(Clientes c){
        cl.insertar(c);
    }
    
    public void buscarMedicamento(String cd){
        md.obtener(cd);
    }
    
    public void buscarCliente(String cc){
        cl.obtener(cc);
    }

}
