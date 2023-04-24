/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import modelos.Orden;
import modelos.OrdenController;
import modelos.Producto;
import modelos.ProductoController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OrdenS", urlPatterns = {"/OrdenS"})
public class OrdenS extends HttpServlet {
    OrdenController ordenC=new OrdenController();
    Orden ord=new Orden();
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

            List<Orden> listOrd=this.ordenC.getAllOrdens();
            List<Producto> listProduc=this.productoC.getAllProductos();

            if(accion==null){
                request.setAttribute("listOrd", listOrd);
                request.setAttribute("listProduc", listProduc);
                request.getRequestDispatcher("?pag=views/ordenes.jsp").forward(request, response);
            }else switch (accion) {
                case "queryOrd":
                    request.setAttribute("listOrd", listOrd);
                    request.setAttribute("listProduc", listProduc);
                    request.getRequestDispatcher("?pag=views/ordenes.jsp").forward(request, response);
                    break;
                case "updateOrd":
                    request.setAttribute("listProduc", listProduc);
                    Orden ord=this.ordenC.getOrden(id);
                    request.setAttribute("ord", ord);
                    request.getRequestDispatcher("?pag=views/updateOrden.jsp").forward(request, response);
                    break;
                case "deleteOrd":
                    this.ordenC.deleteOrden(id);
                    listOrd=this.ordenC.getAllOrdens();
                    request.setAttribute("listOrd", listOrd);
                    request.getRequestDispatcher("?pag=views/ordenes.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoS.class.getName()).log(Level.SEVERE, " Error en el Servlet OrdenS", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
        String btnAdd=request.getParameter("btnAdd");
        String btnUpdate=request.getParameter("btnUpdate");

        int idProd=Integer.parseInt(request.getParameter("idProd"));
        int cant=Integer.parseInt(request.getParameter("cant"));
        String fchU=request.getParameter("fchU");
        String dir=request.getParameter("dir");

        DateTimeFormatter fchFormato=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fch=LocalDate.parse(fchU, fchFormato);
        Date dateU=java.sql.Date.valueOf(fch);

        produc.setId_producto(idProd);
        ord.setProducto(produc);
        ord.setCantidad(cant);
        ord.setFecha_orden(dateU);
        ord.setDireccion_entrega(dir);

        if(btnAdd!=null && !btnAdd.isEmpty()){
            this.ordenC.addOrden(ord);
            doGet(request, response);
        }else if(btnUpdate!=null && !btnUpdate.isEmpty()){
            int id=Integer.parseInt(request.getParameter("id"));
            ord.setId_orden(id);
            try {
                this.ordenC.updateOrden(ord);
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
