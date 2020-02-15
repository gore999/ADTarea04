/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Carlos
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Gson gson=new Gson();
            
            Configuracion jsonConf=null;
            jsonConf=new Configuracion();
            System.out.println(gson.toJson(jsonConf));
            jsonConf=null;
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream("provincias.json"), "UTF-8")); //Leer el archivo en utf
                jsonConf = gson.fromJson(br, Configuracion.class);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            Configuration conf = new Configuration();
            Properties props = new Properties();
            //Propiedades de conexion red
            props.put(Environment.DRIVER, jsonConf.hibernate.driver);
            props.put(Environment.URL, "jdbc:mysql://localhost:3306/"+jsonConf.dbConnection.name+"?serverTimezone=UTC&createDatabaseIfNotExist=TRUE");
            //Conectar a la bd 
            props.put(Environment.USER, jsonConf.dbConnection.user);
            props.put(Environment.PASS, jsonConf.dbConnection.password);
            //Otras caracteristicas:
            props.put(Environment.DIALECT, jsonConf.hibernate.dialect);
            props.put(Environment.HBM2DDL_AUTO, jsonConf.hibernate.HBM2DDL_AUTO);
            //Este ya sobra, pero sirve para ver lo que hibernate va haciendo.
            props.put(Environment.SHOW_SQL,jsonConf.hibernate.SHOW_SQL);
            //Añadimos las propiedades al objeto configuracion
            conf.setProperties(props);
            //Que clases vamos a persistir

            conf.addAnnotatedClass(Provincia.class);
            conf.addAnnotatedClass(Tienda.class);
            conf.addAnnotatedClass(Empleado.class);
            conf.addAnnotatedClass(Producto.class);
            conf.addAnnotatedClass(TiendaEmpleado.class);
            conf.addAnnotatedClass(TiendaProducto.class);

            conf.addAnnotatedClass(TiendaProductoId.class);
            conf.addAnnotatedClass(Cliente.class);

            //Obtener los servicios base. 
            ServiceRegistry serviceRegistry;
            // Se crea un nuevo constructor, al que le tenemos que pasar un objeto Map de las propiedades. Este se obtiene de conf.getProperties. Luego, consrtruimos el serviceRegistry
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory = conf.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory;
    }
    
    
}
