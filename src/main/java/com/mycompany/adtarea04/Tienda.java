/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Carlos
 */
@Entity
public class Tienda implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",updatable=false,nullable=false)
    Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="provincia")
    private String provincia;
    //Empleados relacionados con la tienda
    @OneToMany(mappedBy="tienda",orphanRemoval = true)
    private List <TiendaEmpleado> empleadosXTienda=new ArrayList();
    //Productos relacionados con la tienda
    @OneToMany(mappedBy="tienda",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<TiendaProducto> productosXTienda=new ArrayList();
    
//Creamos 2 Maps
    //Productos: Relacion id del producto con su cantidad. 
    
   
    public Tienda() {
    }
    
    public Tienda(String nombre, String ciudad, String provincia) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.provincia=provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<TiendaEmpleado> getEmpleadosXTienda() {
        return empleadosXTienda;
    }

    public void setEmpleadosXTienda(List<TiendaEmpleado> empleadosXTienda) {
        this.empleadosXTienda = empleadosXTienda;
    }

    public List<TiendaProducto> getProductosXTienda() {
        return productosXTienda;
    }

    public void setProductosXTienda(List <TiendaProducto> productosXTienda) {
        this.productosXTienda = productosXTienda;
    }

    


    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", provincia=" + provincia + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        Tienda t=(Tienda)obj;
       if(this.nombre.equals(t.nombre)&& this.ciudad.equals(t.ciudad)&&this.provincia.equals(t.provincia)){
           return true;
       }else{
           return false;
       }        
    }
    
}
