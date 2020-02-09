/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import javax.persistence.*;

/**
 *
 * @author Carlos
 */
@Embeddable
public class TiendaProductoId {
    @Column(name="tiendaId")
    protected Long tiendaId;
    @Column(name="productoId")
    protected Long productoId;

    public TiendaProductoId() {
    }

    public TiendaProductoId(Long tiendaId, Long productoId) {
        this.tiendaId = tiendaId;
        this.productoId = productoId;
    }

    public Long getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Long tiendaId) {
        this.tiendaId = tiendaId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

   
    
//Sobreescribir los metodos hashcode y equals. 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tiendaId == null) ? 0 : tiendaId.hashCode());
        result = prime * result + ((productoId == null) ? 0 : productoId.hashCode());
        return result;
    }
    @Override
        public boolean equals(Object obj) {
           if(this==obj) return true;// Son el mismo objeto?
           if(obj==null) return false;// El onbjeto recibido es nulo, no pueden ser iguales.
           if(this.getClass()!=obj.getClass())return false;//Si no son de la misma clase, no son iguales.
           TiendaEmpleadoId otro=(TiendaEmpleadoId)obj;//Casteamos obj a un objeto BookEditorId
           if(tiendaId==null){//Si el tiendaId de este objeto es nulo  
               if(otro.tiendaId!=null)return false;//El del otro no es nulo, sera false.
           }else if(!tiendaId.equals(otro.tiendaId)){//Si no es nulo y no son iguales, devuelve false.
               return false;
           }
           
           if (this.productoId==null){
               if(otro.empleadoId!=null) return false;
           }else if(!this.productoId.equals(otro.empleadoId))return false;
           
           return true;// En cualquier otro caso devovlemos true.
           
        }
}
