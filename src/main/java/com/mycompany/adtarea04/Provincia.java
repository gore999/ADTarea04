/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class Provincia implements Serializable{
    int id;
    String nome;
    
    //Constructor vacio para hibernate
    public Provincia() {
    }

    public Provincia(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
     
    @Override
    public String toString() {
        return "Provincia{" + "id=" + id + ", nome=" + nome + '}';
    }
     
}
