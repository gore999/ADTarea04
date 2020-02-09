/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import java.util.Properties;
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
            Configuration conf=new Configuration();
            Properties props=new Properties();
            //Propiedades de conexion red
            props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            props.put(Environment.URL, "jdbc:mysql://localhost:3306/TiendasAD04?serverTimezone=UTC&createDatabaseIfNotExist=TRUE");
            //Conectar a la bd 
            props.put(Environment.USER, "root");
            props.put(Environment.PASS, "");
            //Otras caracteristicas:
            props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            props.put(Environment.HBM2DDL_AUTO, "create-drop");
            //Este ya sobra, pero sirve para ver lo que hibernate va haciendo.
            props.put(Environment.SHOW_SQL, "true");
            //Añadimos las propiedades al objeto configuracion
            conf.setProperties(props);
            //Que clases vamos a persistir
            
            
            conf.addAnnotatedClass(Provincia.class);
            conf.addAnnotatedClass(Tienda.class);
            conf.addAnnotatedClass(Producto.class);
            conf.addAnnotatedClass(Empleado.class);
            conf.addAnnotatedClass(Cliente.class);
            //Obtener los servicios base. 
            ServiceRegistry serviceRegistry;
            // Se crea un nuevo constructor, al que le tenemos que pasar un objeto Map de las propiedades. Este se obtiene de conf.getProperties. Luego, consrtruimos el serviceRegistry
            serviceRegistry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory=conf.buildSessionFactory(serviceRegistry);
            
        }
        return sessionFactory;
    }
}
