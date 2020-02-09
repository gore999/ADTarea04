/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Carlos
 */
@Entity
public class TiendaProducto implements Serializable{
    @EmbeddedId
    TiendaProducto tiendaProducto=new TiendaProducto();
    @ManyToOne
    @MapsId("tiendaId")
    private Tienda tienda;
    @ManyToOne
    @MapsId("productoId")
    private Producto producto;
    @Column(name="cantidad")
    private int cantidad;

    public TiendaProducto() {
    }

    public TiendaProducto(Tienda tienda, Producto producto, int cantidad) {
        this.tienda = tienda;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public TiendaProducto getTiendaProducto() {
        return tiendaProducto;
    }

    public void setTiendaProducto(TiendaProducto tiendaProducto) {
        this.tiendaProducto = tiendaProducto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
