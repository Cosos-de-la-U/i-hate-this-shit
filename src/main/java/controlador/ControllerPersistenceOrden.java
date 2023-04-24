/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.RollbackFailureException;
import modelos.Orden;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenni
 */
public class ControllerPersistenceOrden {
    OrdenJpaController OrdJPA;

    public ControllerPersistenceOrden() {
        this.OrdJPA = new OrdenJpaController();
    }
    
    public List<Orden> getAllOrdens(){
        return this.OrdJPA.findOrdenEntities();
    }
    public Orden getOrden(int id){
        return this.OrdJPA.findOrden(id);
    }
    
    public void addOrden(Orden orden){
        try {
            this.OrdJPA.create(orden);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistenceOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateOrden(Orden orden){
        try {
            this.OrdJPA.edit(orden);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControllerPersistenceOrden.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistenceOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteOrden(int id){
        try {
            this.OrdJPA.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControllerPersistenceOrden.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistenceOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
