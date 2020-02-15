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
public class hibernate{
    
    @SerializedName("driver")
        String driver="com.mysql.cj.jdbc.Driver";
    
    @SerializedName("dialect")
        String dialect="org.hibernate.dialect.MySQL5Dialect";
    
    @SerializedName("HBM2DDL_AUTO")
        String HBM2DDL_AUTO="update";
    
    @SerializedName("SHOW_SQL")
        boolean SHOW_SQL= true;

        public hibernate() {
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getDialect() {
            return dialect;
        }

        public void setDialect(String dialect) {
            this.dialect = dialect;
        }

        public String getHBM2DDL_AUTO() {
            return HBM2DDL_AUTO;
        }

        public void setHBM2DDL_AUTO(String HBM2DDL_AUTO) {
            this.HBM2DDL_AUTO = HBM2DDL_AUTO;
        }

        public boolean isSHOW_SQL() {
            return SHOW_SQL;
        }

        public void setSHOW_SQL(boolean SHOW_SQL) {
            this.SHOW_SQL = SHOW_SQL;
        }

    @Override
    public String toString() {
        return "hibernate{" + "driver=" + driver + ", dialect=" + dialect + ", HBM2DDL_AUTO=" + HBM2DDL_AUTO + ", SHOW_SQL=" + SHOW_SQL + '}';
    }
        
    }
