/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name="productos")
public class Producto implements Serializable{
    @Id
    @Column(name="id",updatable=false,nullable=false)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="precio")
    private double precio;
    //Constructor vacio para hibernate
    @OneToMany(mappedBy="producto",orphanRemoval = true)
    private List<TiendaProducto> tiendasQueTienenElProducto=new ArrayList();

    public Producto() {
    }

    public Producto(Long id,String nombre, String descripcion, double precio) {
        this.id=id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getIdentificador() {
        return id;
    }

    public void setIdentificador(Long identificador) {
        this.id = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TiendaProducto> getTiendasQueTienenElProducto() {
        return tiendasQueTienenElProducto;
    }

    public void setTiendasQueTienenElProducto(List<TiendaProducto> tiendasQueTienenElProducto) {
        this.tiendasQueTienenElProducto = tiendasQueTienenElProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "identificador=" + id + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    @Override
    public boolean equals(Object obj) {
        //Dos productos son iguales si tienen la misma id.
        return ((Producto) obj).id == this.id; //To change body of generated methods, choose Tools | Templates.
    }
    
}
