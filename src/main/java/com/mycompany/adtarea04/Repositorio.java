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

    //DE UNA TIENDA CONCRETA
    void getTiendaProductoData(Tienda tienda, ArrayList<Producto> productosTienda, ArrayList<Integer> cantProdTienda) {
//        //Vaciamos los arrays, para rellenarlos de nuevo. 
//        productosTienda.clear();
//        cantProdTienda.clear();
//        //Obtener datos de la BD.
//        String sql = "SELECT * FROM produtos,produtos_tendas WHERE produtos_tendas.idTenda=? AND produtos.id=produtos_tendas.idproduto";
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, tienda.id);//Obtener los productos y cantidades referentes a una tienda en concreto, por id de tienda. 
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {//Recuperar datos del resultset.
//                int id = rs.getInt("id");
//                String nome = rs.getString("nome");
//                String descripcion = rs.getString("descripcion");
//                Float prezo = rs.getFloat("prezo");
//                int cantidad = rs.getInt("cantidad");
//                Producto p = new Producto(id, nome, descripcion, prezo);
//                //Añadimos los datos a los arraylists.
//                productosTienda.add(p);
//                cantProdTienda.add(cantidad);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    void getTiendaEmpleadoData(Tienda tiendaAux, ArrayList<Empleado> empleadosTienda, ArrayList<Integer> horasEmpTienda) {
//        //Vaciamos los arrays, para rellenarlos de nuevo. 
//        empleadosTienda.clear();
//        horasEmpTienda.clear();
//        //Obtener datos de la BD.
//        String sql = "SELECT * FROM empregados,empleados_tendas WHERE empleados_tendas.idTenda=? AND empregados.id=empleados_tendas.idEmpregado";
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.setLong(1, tiendaAux.id);//Obtener los productos y cantidades referentes a una tienda en concreto, por id de tienda. 
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {//Recuperar datos del resultset.
//                int id = rs.getInt("id");
//                String nome = rs.getString("nombre");
//                String apelidos = rs.getString("apelidos");
//                int horas = rs.getInt("horas");
//                Empleado e = new Empleado(id, nome, apelidos);
//                //Añadimos los datos a los arraylists.
//                empleadosTienda.add(e);
//                horasEmpTienda.add(horas);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        Long id = tienda.getId();
        trans = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Tienda WHERE id= :id");
        q.setLong("id", id);
        q.executeUpdate();
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
        Long id = p.getIdentificador();
        trans = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Producto WHERE id= :id");
        q.setLong("id", id);
        q.executeUpdate();
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
        trans = session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Empleado where id= :id");
        q.setLong("id", emp.getId());
        q.executeUpdate();
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
//        int indiceProd = productosTienda.indexOf(productoAux);
//        if (indiceProd != -1) {//Si el producto existe ya en el listado, cambiamos el valor en el ArrayList de cantidades de 
//            cantProdTienda.set(indiceProd, cantidad);//usamos el indice del producto, cambiamos el valor a "cantidad".
//        } else {//Si aun no tiene el producto, lo añade al final de ambos arrays.
//            cantProdTienda.add(cantidad);
//            productosTienda.add(productoAux);
//        }
//        //Actualizamos en base de datos la tabla que recoge relaciones tienda-producto con REPLACE: Si ya existe, reemplaza, si no, inserta.
//        String sql = "REPLACE INTO produtos_tendas(idTenda,idproduto,cantidad) VALUES(?,?,?)";
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);//Necesitamos la key de insercion.
//            pstmt.setLong(1, tiendaAux.getId());
//            pstmt.setLong(2, productoAux.getIdentificador());
//            pstmt.setInt(3, cantidad);
//            pstmt.execute();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.getTiendaProductoData(tiendaAux, productosTienda, cantProdTienda);
    }

    void removeProdFromTienda(Producto p, ArrayList<Producto> productosTienda, Tienda tienda) {
        String sql2 = "DELETE FROM produtos_tendas WHERE idproduto=? and idTenda=?";//Borrar todas las relaciones de tiendas con el producto.
//        try {//Borrar de base de datos.
//            PreparedStatement pstmt = con.prepareStatement(sql2);
//            pstmt.setLong(1, p.getIdentificador());
//            pstmt.setLong(2, tienda.getId());
//            pstmt.execute();
//            //Borrar del ArrayList
//            productosTienda.remove(p);//Añadir la tienda al arraylist.
//        } catch (SQLException ex) {
//            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
//        //Recibimos la tienda y el empleado, hay que borrar el empleado de la tienda, la tienda del empleado y eliminar el objeto que los vincula
        Tienda t=tiendaEmp.getTienda();
        Empleado e=tiendaEmp.getEmpleado();
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
}
