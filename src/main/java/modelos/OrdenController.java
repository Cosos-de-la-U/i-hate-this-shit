/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import controlador.ControllerPersistenceOrden;

import java.util.List;

/**
 *
 * @author jenni
 */
public class OrdenController {
    ControllerPersistenceOrden controllOrd;

    public OrdenController() {
        this.controllOrd=new ControllerPersistenceOrden();
    }

    public Orden getOrden(int id){
        return this.controllOrd.getOrden(id);
    }
    public List<Orden> getAllOrdens(){
        return this.controllOrd.getAllOrdens();
    }

//    ADD, UPDATE & DELETE PARA ALUMNOS
    public void addOrden(Orden orden){
        this.controllOrd.addOrden(orden);
    }
    public void updateOrden(Orden orden) throws Exception{
        this.controllOrd.updateOrden(orden);
    }
    public void deleteOrden(int id) throws Exception{
        this.controllOrd.deleteOrden(id);
    }
    
}
