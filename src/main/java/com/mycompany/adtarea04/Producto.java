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
@Table(name="productos")
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",updatable=false,nullable=false)
    private Long identificador;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="precio")
    private double precio;
    //Constructor vacio para hibernate

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
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

    @Override
    public String toString() {
        return "Producto{" + "identificador=" + identificador + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    @Override
    public boolean equals(Object obj) {
        //Dos productos son iguales si tienen la misma id.
        return ((Producto) obj).identificador == this.identificador; //To change body of generated methods, choose Tools | Templates.
    }
    
}
