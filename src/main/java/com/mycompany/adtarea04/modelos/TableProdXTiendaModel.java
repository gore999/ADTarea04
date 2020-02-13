/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04.modelos;

import com.mycompany.adtarea04.Producto;
import com.mycompany.adtarea04.Tienda;
import com.mycompany.adtarea04.TiendaProducto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Carlos
 */
public class TableProdXTiendaModel implements TableModel {

    Tienda tiendaAnalizada;
    List<TiendaProducto> tp;
    
    public TableProdXTiendaModel(Tienda t) {
        if (t != null) {
            this.tiendaAnalizada = t;
            tp = t.getProductosXTienda();
        }
        else t=new Tienda();
    }
    
    @Override
    public int getRowCount() {
        if (tp != null) {
            return tp.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
//Nombres de las columnas
    @Override
    public String getColumnName(int columnIndex) {
        String salida = null;
        switch (columnIndex) {
            case 0:
                salida = "Id.";
                break;
            case 1:
                salida = "Nome";
                break;
            case 2:
                salida = "Descripcion";
                break;
            case 3:
                salida = "Prezo";
                break;
            case 4:
                salida = "Cantidade";
                break;
        }
        return salida;
    }
//clase de las columnas
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Float.class;
            case 4:
                return Integer.class;
        }
        return null;//Para cerrar sin error. 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No se van a poder editar.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = tp.get(rowIndex).getProducto();
        switch (columnIndex) {
            case 0:
                return p.getIdentificador();
            case 1:
                return p.getNombre();
            case 2:
                return p.getDescripcion();
            case 3:
                return p.getPrecio();
            case 4:
                return tp.get(rowIndex).getCantidad();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Producto p = this.tp.get(rowIndex).getProducto();
        switch (columnIndex) {
            case 0:
                p.setIdentificador((Long) aValue);
                break;
            case 1:
                p.setDescripcion((String) aValue);
                break;
            case 2:
                p.setDescripcion((String) aValue);
                break;
            case 3:
                p.setPrecio((Float) aValue);
                break;
            case 4:
                tp.get(rowIndex).setCantidad((Integer)aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    public void cambiarTienda(Tienda t){
        this.tiendaAnalizada=t;
        this.tp=this.tiendaAnalizada.getProductosXTienda();
    }
    
    
    public Tienda getTiendaAnalizada() {
        return tiendaAnalizada;
    }

    public void setTiendaAnalizada(Tienda tiendaAnalizada) {
        this.tiendaAnalizada = tiendaAnalizada;
        setTp(tiendaAnalizada.getProductosXTienda());
    }

    public List<TiendaProducto> getTp() {
        return tp;
    }

    public void setTp(List<TiendaProducto> tp) {
        this.tp = tp;
    }

}
