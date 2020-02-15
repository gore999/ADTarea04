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
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @OneToMany(mappedBy="empleado",orphanRemoval = true)
    private List<TiendaEmpleado> tiendasDelEmpleado=new ArrayList();

//    Constructor vacio para hibernate
    public Empleado() {
    }

    public Empleado(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

    public List<TiendaEmpleado> getTiendasDelEmpleado() {
        return tiendasDelEmpleado;
    }

    public void setTiendasDelEmpleado(List<TiendaEmpleado> tiendasDelEmpleado) {
        this.tiendasDelEmpleado = tiendasDelEmpleado;
    }

    /**/
    @Override
    public boolean equals(Object obj) {
        Empleado emp = (Empleado) obj; //To change body of generated methods, choose Tools | Templates.
        if (emp.nombre.equals(this.nombre) && emp.apellidos.equals(this.apellidos)) {
            return true;
        } else {
            return false;
        }
    }

}
