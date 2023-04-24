/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import controlador.ControllerPersistence;

import java.util.List;

/**
 *
 * @author jenni
 */
public class ProductoController {
    ControllerPersistence controllProd;
    
    public ProductoController() {
        this.controllProd=new ControllerPersistence();
    }
    
    //    CONSULTAS PARA ALUMNOS
    public Producto getProducto(int id){
        return this.controllProd.getProducto(id);
    }
    public List<Producto> getProductosLast(int max, int last){
        return this.controllProd.getProductosLast(max, last);
    }
    public List<Producto> getAllProductos(){
        return this.controllProd.getAllProductos();
    }
    
//    ADD, UPDATE & DELETE PARA ALUMNOS
    public void addProducto(Producto producto){
        this.controllProd.addProducto(producto);
    }
    public void updateProducto(Producto producto) throws Exception{
        this.controllProd.updateProducto(producto);
    }
    public void deleteProducto(int id) throws Exception{
        this.controllProd.deleteProducto(id);
    }
    
}
