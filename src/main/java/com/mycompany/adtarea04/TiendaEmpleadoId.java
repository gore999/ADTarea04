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
@Embeddable
class TiendaEmpleadoId implements Serializable {
    @Column(name = "tiendaId")
    protected Long tiendaId;
    @Column(name = "empleadoId")
    protected Long empleadoId;

    public TiendaEmpleadoId() {
    }

    public TiendaEmpleadoId(Long tiendaId, Long empleadoId) {
        this.tiendaId = tiendaId;
        this.empleadoId = empleadoId;
    }

    public Long getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Long tiendaId) {
        this.tiendaId = tiendaId;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }
//Sobreescribir los metodos hashcode y equals. 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tiendaId == null) ? 0 : tiendaId.hashCode());
        result = prime * result + ((empleadoId == null) ? 0 : empleadoId.hashCode());
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
           if (this.empleadoId==null){
               if(otro.empleadoId!=null) return false;
           }else if(!this.empleadoId.equals(otro.empleadoId))return false;
           
           return true;// En cualquier otro caso devovlemos true.
           
        }
}
