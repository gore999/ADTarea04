/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class Repositorio {//Clase singleton para operar con datos.

    private Session session;
    private Transaction trans;
    private static Repositorio repoInstancia;

    private Repositorio() {
        //El constructor inicia la sesion Hibernate
        System.out.println("Creada"
                + "");
        session = HibernateUtils.getSessionFactory().openSession();

    }

    public static Repositorio getInstance() {
        //DEvuelve la instancia del repositorio. Si no existe, se crea.
        if (repoInstancia == null) {
            repoInstancia = new Repositorio();
        }
        return repoInstancia;
    }

    /*
        Crea las tablas de datos de la app con la clausula IF NOT EXISTS, si ya existen, no tienen efecto.
     */
    public ArrayList<Tienda> getAllTiendas() {
        ArrayList<Tienda> tiendas = new ArrayList();
        Query q = session.createQuery("SELECT tienda FROM Tienda tienda");
        tiendas = (ArrayList<Tienda>) q.list();//Recuperamos las provincias de la base de datos (si está llena).
        for (Tienda t : tiendas) {
            System.out.println("Lista de tiendas:" + t.toString());
        }
        return tiendas;
    }

    public ArrayList<Producto> getAllProductos() {
        ArrayList<Producto> productos = new ArrayList();
        Query q = session.createQuery("SELECT p FROM Producto p");
        productos = (ArrayList<Producto>) q.list();
        return productos;
    }

    public ArrayList<Empleado> getAllEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList();
        Query q = session.createQuery("SELECT empleado FROM Empleado empleado");
        empleados = (ArrayList<Empleado>) q.list();//Recuperamos los empleados.
        for (Empleado e : empleados) {
            System.out.println("Lista de empleados:" + e.toString());
        }
        return empleados;
    }

    public ArrayList<Cliente> getAllClientes() {
        ArrayList<Cliente> clientes = new ArrayList();
        Query q = session.createQuery("SELECT cliente FROM Cliente cliente");
        clientes = (ArrayList<Cliente>) q.list();
        return clientes;
    }

/// OPERACIONES SOBRE TIENDAS 

    /*CREAR UNA TIENDA*/
    public void insertTienda(Tienda tienda, ArrayList<Tienda> tiendas) {
        trans = session.beginTransaction();
        session.save(tienda);
        trans.commit();
        tiendas.add(tienda);
    }

    /*ELIMINAR UNA TIENDA*/
    void deleteTienda(Tienda tienda, ArrayList<Tienda> tiendas) {
        trans = session.beginTransaction();
        tienda.getEmpleadosXTienda().clear();
        tienda.getProductosXTienda().clear();
        session.save(tienda);
        session.delete(tienda);
        trans.commit();
        tiendas.remove(tienda);
    }

    void insertProducto(Producto producto, ArrayList<Producto> productos) {
        boolean existeYa = false;
        for (Producto p : productos) {
            if (p.equals(producto)) {
                existeYa = true;//Si hay alguna 
            }
        }
        if (!existeYa) {//Si no existe, lo insertamos.
            trans.begin();
            session.save(producto);
            trans.commit();
            productos.add(producto);
        } else {
            JOptionPane.showMessageDialog(null, "El producto ya existe", "Error", 0);
        }
    }

    void deleteProducto(Producto p, ArrayList<Producto> productos) {
        trans = session.beginTransaction();

        List<TiendaProducto> tiendaProducto = p.getTiendasQueTienenElProducto();
        for(TiendaProducto tp:tiendaProducto){
            tp.getTienda().getProductosXTienda().remove(tp);//De cada tienda borramos la relacion.
            session.save(tp.getTienda());//Actualizamos la tienda
        }
        trans.commit();
        trans = session.beginTransaction();
        p.getTiendasQueTienenElProducto().clear();//Borrar todos los objetos de asociacion de producto a la tienda.
        session.save(p);
        session.delete(p);
        trans.commit();
        productos.remove(p);

    }

    void insertEmpleado(Empleado emp, ArrayList<Empleado> empleados) {
        boolean existeYa = false;
        for (Empleado e : empleados) {
            if (e.equals(emp)) {
                existeYa = true;//Si hay alguna 
            }
        }
        if (!existeYa) {//Si no existe, lo insertamos.
            trans = session.beginTransaction();
            session.save(emp);
            trans.commit();
            empleados.add(emp);
        } else {
            JOptionPane.showMessageDialog(null, "El empleado ya existe", "Error", 0);
        }
    }

    void deleteEmpleado(Empleado emp, ArrayList<Empleado> empleados) {
//        trans = session.beginTransaction();
//        Query q = session.createQuery("DELETE FROM Empleado where id= :id");
//        q.setLong("id", emp.getId());
//        q.executeUpdate();
//        trans.commit();
//        empleados.remove(emp);
        
        
        
        
        
        trans = session.beginTransaction();

        List<TiendaEmpleado> tiendaEmpleado = emp.getTiendasDelEmpleado();
        for(TiendaEmpleado te:tiendaEmpleado){
            te.getTienda().getEmpleadosXTienda().remove(te);//De cada tienda borramos la relacion con el empleado.
            session.save(te.getTienda());//Actualizamos la tienda
        }
        trans.commit();
        trans = session.beginTransaction();
        emp.getTiendasDelEmpleado().clear();//Borrar todos los objetos de asociacion de producto a la tienda.
        session.save(emp);
        session.delete(emp);
        trans.commit();
        empleados.remove(emp);
        
    }
// Actuar sobre tiendas concretas

    void insertProductoEnTienda(Tienda tiendaAux, Producto productoAux, int cantidad) {
        TiendaProducto tp = new TiendaProducto(tiendaAux, productoAux, cantidad);
        tiendaAux.getProductosXTienda().add(tp);
        productoAux.getTiendasQueTienenElProducto().add(tp);
        trans = session.beginTransaction();
        session.save(tiendaAux);
        session.save(productoAux);
        session.save(tp);
        trans.commit();
    }

    void removeProdFromTienda(TiendaProducto tiendaProd) {
        Tienda t = tiendaProd.getTienda();
        Producto p = tiendaProd.getProducto();
        //Eliminamos el objeto que contiene la relacion de la lista de la tienda y de la del producto.
        if (p.getTiendasQueTienenElProducto().remove(tiendaProd)) {
            System.out.println("Eliminado");
        };
        if (t.getProductosXTienda().remove(tiendaProd)) {
            System.out.println("elminado de empleados");
        };
        //Actualizamos la BD con Hibernate
        trans = session.beginTransaction();
        //Guardar tienda, produducto sin el objeto de relacion
        session.save(p);
        session.save(t);
        //Borrar el objeto relacion. 
        session.delete(tiendaProd);
        trans.commit();
    }

    void insertEmpleadoEnTienda(Tienda tiendaAux, Empleado empleadoAux, int horas) {
        //Crear Objeto TiendaEmpleado que guarda la relacion.
        TiendaEmpleado te = new TiendaEmpleado(tiendaAux, empleadoAux, horas);
        //Añadir el objeto a la tienda y al empleado
        tiendaAux.getEmpleadosXTienda().add(te);
        empleadoAux.getTiendasDelEmpleado().add(te);
        trans = session.beginTransaction();
        session.save(tiendaAux);
        session.save(empleadoAux);
        session.save(te);
        trans.commit();
//      
    }

    void removeEmpFromTienda(TiendaEmpleado tiendaEmp) {
//        //Recibimos el objeto que representa la relacion entre tienda y empleado y que contiene ambos objetos
        Tienda t = tiendaEmp.getTienda();
        Empleado e = tiendaEmp.getEmpleado();
        e.getTiendasDelEmpleado().remove(tiendaEmp);
        t.getEmpleadosXTienda().remove(tiendaEmp);
        trans = session.beginTransaction();
        session.save(e);
        session.save(t);
        session.delete(tiendaEmp);
        trans.commit();

    }
/// OPERACIONES SOBRE CLIENTES

    void addCliente(Cliente c, ArrayList<Cliente> clientes) {
        boolean existeYa = false;
        for (Cliente ca : clientes) {
            if (c.equals(ca)) {
                existeYa = true;//Si hay alguna 
            }
        }
        if (!existeYa) {
            trans = session.beginTransaction();
            session.save(c);
            trans.commit();
            clientes.add(c);
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error", 0);
        }
    }

    void deleteCliente(Cliente c, ArrayList<Cliente> clientes) {
        trans = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Cliente WHERE id= :id");
        q.setLong("id", c.getId());
        q.executeUpdate();
        trans.commit();
        clientes.remove(c);
    }

    provincias getProvinciasOBJ() {
        provincias provsOBJ = new provincias();
        //Recuperar las provincias desde base de datos.
        Query q = session.createQuery("SELECT prov FROM Provincia prov");

        provsOBJ.provincias = q.list();//Recuperamos las provincias de la base de datos (si está llena).
        if (provsOBJ.provincias.size() == 0) {//Si no hay datos en BD, los tomamos del JSON
            Gson gson = new Gson();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("provincias.json"), "UTF-8"));//Leer el archivo en utf
                provsOBJ = gson.fromJson(br, provincias.class);
                //FileReader f           f = new FileReader();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ADTarea04.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            insertProvincias(provsOBJ.provincias);
        }

        return provsOBJ;//Devuelve el objeto de la clase provincias
    }

    void insertProvincias(List<Provincia> prov) {

        trans = session.beginTransaction();// Iniciar transaccion
        for (Provincia p : prov) {//bucle para hacer todos los guardados
            session.save(p);
        }
        trans.commit();//Hacer el commit

    }

    TiendaProducto getTiendaProducto(Tienda tiendaAux, Producto productoAux) {
        Long tiendaId = tiendaAux.getId();
        Long productoId = productoAux.getId();
        System.out.println("id tienda" + tiendaId);
        System.out.println("id producto" + productoId);
        Query q = session.createQuery("SELECT tp FROM TiendaProducto tp WHERE tienda= :tid AND producto= :pid");
        q.setLong("tid", tiendaId);
        q.setLong("pid", productoId);
        TiendaProducto rtdo = (TiendaProducto) q.uniqueResult();

        return rtdo;
    }

    TiendaEmpleado getTiendaEmpleado(Tienda tiendaAux, Empleado empleadoAux) {
        Long tiendaId = tiendaAux.getId();
        Long empleadoId = empleadoAux.getId();
        Query q = session.createQuery("SELECT tp FROM TiendaEmpleado tp WHERE tienda= :tid AND empleado= :eid");
        q.setLong("tid", tiendaId);
        q.setLong("eid", empleadoId);
        TiendaEmpleado rtdo = (TiendaEmpleado) q.uniqueResult();

        return rtdo;
    }
}
