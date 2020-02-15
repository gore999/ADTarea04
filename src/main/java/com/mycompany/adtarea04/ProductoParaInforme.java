/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

/**
 *Clase creada para evitar referencias circulares a la hora de elaborar informes de stock
 * @author Carlos
 */
public class ProductoParaInforme {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;

    public ProductoParaInforme() {
    }

    public ProductoParaInforme(Long id, String nombre, String descripcion, Double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
