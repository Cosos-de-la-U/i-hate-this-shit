/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import modelos.Producto;
import modelos.ProductoController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenni
 */
@WebServlet(name = "ProductoS", urlPatterns = {"/ProductoS"})
public class ProductoS extends HttpServlet {

    ProductoController productoC=new ProductoController();
    Producto produc=new Producto();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
        
        try {
            
            String accion=request.getParameter("accion");
            int id=0;
            if(request.getParameter("id")!=null) id=Integer.parseInt(request.getParameter("id"));
            
            List<Producto> listProduc=this.productoC.getAllProductos();
            
            int countProdA;
            int countProdD;
            
            if(accion==null){
                request.setAttribute("listProduc", listProduc);
                request.getRequestDispatcher("?pag=views/productos.jsp").forward(request, response);
            }else switch (accion) {
                case "queryProduc":
                    request.setAttribute("listProduc", listProduc);
                    request.getRequestDispatcher("?pag=views/productos.jsp").forward(request, response);
                    break;
                case "updateProduc":
                    Producto product=this.productoC.getProducto(id);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("?pag=views/updateProducto.jsp").forward(request, response);
                    break;
                case "deleteProduc":
                    countProdA=this.productoC.getAllProductos().size();
                    this.productoC.deleteProducto(id);
                    countProdD=this.productoC.getAllProductos().size();
                    
                    if(countProdA==countProdD) request.setAttribute("msjError", "NoSeElimino");
                    
                    listProduc=this.productoC.getAllProductos();
                    request.setAttribute("listProduc", listProduc);
                    request.getRequestDispatcher("?pag=views/productos.jsp").forward(request, response);
                    break;
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
        
        String btnAdd=request.getParameter("btnAdd");
        String btnUpdate=request.getParameter("btnUpdate");
        
        String nom=request.getParameter("nom");
        String descri=request.getParameter("descri");
        double prec=Double.parseDouble(request.getParameter("prec"));
        String cat=request.getParameter("cat");

        
        
        produc.setNombre(nom);
        produc.setDescripcion(descri);
        produc.setPrecio_unitario(prec);
        produc.setCategoria(cat);
        
        if(btnAdd!=null && !btnAdd.isEmpty()){
            this.productoC.addProducto(produc);
            doGet(request, response);
        }else if(btnUpdate!=null && !btnUpdate.isEmpty()){
            int id=Integer.parseInt(request.getParameter("id"));
            produc.setId_producto(id);
            try {
                this.productoC.updateProducto(produc);
            } catch (Exception ex) {
                Logger.getLogger(ProductoS.class.getName()).log(Level.SEVERE, null, ex);
            }
            doGet(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
