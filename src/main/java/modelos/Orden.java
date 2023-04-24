package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Orden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_orden;
    private int cantidad;
    @Temporal(TemporalType.DATE)
    private Date fecha_orden;
    private String direccion_entrega;
    @OneToOne
    private Producto producto;

    public Orden() {
    }

    public Orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public Orden(int id_orden, int cantidad, Date fecha_orden, String direccion_entrega, Producto producto) {
        this.id_orden = id_orden;
        this.cantidad = cantidad;
        this.fecha_orden = fecha_orden;
        this.direccion_entrega = direccion_entrega;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }
    @Override
    public String toString() {
        return "Orden{" + "id=" + id_orden + ", cantidad=" + cantidad + ", fecha=" + fecha_orden + ", direccion=" + direccion_entrega + '}';
    }
}
