/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

/**
 *
 * @author Carlos
 */
public class Configuracion {
    hibernate hibernate;
    dbConnection dbConnection;
    String c="Configuracion creada";

    public Configuracion() {
        hibernate=new hibernate();
        dbConnection=new dbConnection();
    }

    public Configuracion(hibernate hb, dbConnection dbc) {
        this.hibernate = hb;
        this.dbConnection = dbc;
    }

    public hibernate getHb() {
        return hibernate;
    }

    public void setHb(hibernate hb) {
        this.hibernate = hb;
    }

    public dbConnection getDbc() {
        return dbConnection;
    }

    public void setDbc(dbConnection dbc) {
        this.dbConnection = dbc;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    
    
    
    
}
