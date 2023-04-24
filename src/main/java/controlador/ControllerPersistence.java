/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.RollbackFailureException;
import modelos.Producto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenni
 */
public class ControllerPersistence {
    ProductoJpaController ProcdJPA;

    public ControllerPersistence() {
        this.ProcdJPA = new ProductoJpaController();
    }
    
    public List<Producto> getAllProductos() {
        return this.ProcdJPA.findProductoEntities();
    }

    public Producto getProducto(int id) {
        return this.ProcdJPA.findProducto(id);
    }
    
    public void addProducto(Producto producto) {
        try {
            this.ProcdJPA.create(producto);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProducto(Producto producto) throws Exception {
        try {
            this.ProcdJPA.edit(producto);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteProducto(int id) throws Exception {
        try {
            this.ProcdJPA.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, "NO puedes eliminar, el dato se esta usando en otra tabla!!!", ex);
        }
    }
    
    public List<Producto> getProductosLast(int i, int j) {
        int total = this.ProcdJPA.getProductoCount()- 4;
        return this.ProcdJPA.findProductoEntities(i, total);
    }
}
