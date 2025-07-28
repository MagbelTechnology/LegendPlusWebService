package com.magbel.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConnectionDAO {

    /**
     * getConnection
     *
     * @param jndiName String
     * @return Connection
     */
    public Connection getConnection(String jndiName);

    /**
     * closeConnection
     *
     * @param con Connection
     * @param rs ResultSet
     * @param ps PreparedStatement
     */
    public void closeConnection(Connection con, PreparedStatement ps,ResultSet rs);
    /**
    * closeConnection
    *
    * @param con Connection
    * @param ps PreparedStatement
    */
   public void closeConnection(Connection con,PreparedStatement ps);


    /**
     * executeQueryString
     *
     * @param query String
     */
    public void executeQueryString(String query,String jndiName);

}
