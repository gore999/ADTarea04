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
public class TiendaEmpleado implements Serializable{
    @EmbeddedId
    private TiendaEmpleadoId tiendaEmpleadoId=new TiendaEmpleadoId();
    @ManyToOne
    @MapsId("tiendaId")//Mapea en la clase TiendaEmpleadoId
    private Tienda tienda;
    @ManyToOne
    @MapsId("empleadoId")//Mapea en la clase TiendaEmpleadoId
    private Empleado empleado;
    @Column(name="horas")
    private int horas;

    public TiendaEmpleado() {
    }

    public TiendaEmpleado(Tienda tienda, Empleado empleado, int horas) {
        this.tienda = tienda;
        this.empleado = empleado;
        this.horas = horas;
    }

    public TiendaEmpleadoId getTiendaEmpleadoId() {
        return tiendaEmpleadoId;
    }

    public void setTiendaEmpleadoId(TiendaEmpleadoId tiendaEmpleadoId) {
        this.tiendaEmpleadoId = tiendaEmpleadoId;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
}
