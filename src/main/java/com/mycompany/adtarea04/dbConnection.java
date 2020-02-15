/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Carlos
 */
public class dbConnection {

    @SerializedName("address")
    String address = "localhost";
    @SerializedName("port")
    String port = "3306";
    @SerializedName("name")
    String name = "hibernate";
    @SerializedName("user")
    String user = "root";
    @SerializedName("password")
    String password = "";
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "dbConnection{" + "address=" + address + ", port=" + port + ", name=" + name + ", user=" + user + ", password=" + password + '}';
    }
}
