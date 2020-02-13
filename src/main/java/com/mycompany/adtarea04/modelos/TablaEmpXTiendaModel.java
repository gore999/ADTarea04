/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04.modelos;

import com.mycompany.adtarea04.Empleado;
import com.mycompany.adtarea04.Tienda;
import com.mycompany.adtarea04.TiendaEmpleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Carlos
 */
public class TablaEmpXTiendaModel implements TableModel {

    Tienda tiendaAnalizada;
    List<TiendaEmpleado> te;

    public TablaEmpXTiendaModel(Tienda t) {
    if (t != null) {
            this.tiendaAnalizada = t;
            te = t.getEmpleadosXTienda();
        }
        else t=new Tienda();
    }

    @Override
    public int getRowCount() {
        if (te != null) {
            return te.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String salida = null;
        switch (columnIndex) {
            case 0:
                salida = "Nome";
                break;
            case 1:
                salida = "Apelidos";
                break;
            case 2:
                salida = "Horas";
                break;
        }
        return salida;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex < 2) {
            return String.class; //todos son cadenas.
        }
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No se van a poder editar.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado emp = this.te.get(rowIndex).getEmpleado();
        switch (columnIndex) {
            case 0:
                return emp.getNombre();
            case 1:
                return emp.getApellidos();
            case 2:
                return this.te.get(rowIndex).getHoras();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Empleado e = te.get(rowIndex).getEmpleado();
        switch (columnIndex) {
            case 0:
                e.setNombre((String) aValue);
                break;
            case 1:
                e.setApellidos((String) aValue);
                break;
            case 2:
                te.get(rowIndex).setHoras((Integer) aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    public void setTiendaAnalizada(Tienda tiendaAnalizada) {
        this.tiendaAnalizada = tiendaAnalizada;
        setTe(tiendaAnalizada.getEmpleadosXTienda());
    }

    public List<TiendaEmpleado> getTe() {
        return te;
    }

    public void setTe(List<TiendaEmpleado> te) {
        this.te = te;
    }
 
}
