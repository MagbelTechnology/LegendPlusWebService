package com.magbel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MagmaDBConnection {
	
	  public static Connection getConnection(String jndi) {
	        Connection con = null;
	        try {
	            Context initContext = new InitialContext();
	            String dsJndi = "java:/legendPlusService";
	            //System.out.println("Hello!!!");
	            DataSource ds = (DataSource) initContext.lookup(
	            		dsJndi);
	            con = ds.getConnection();
	            //System.out.println("The con is : " + con);

	        } catch (Exception e) {
	            System.out.println("WARNING:Error closing Connection ->" +
	                               e.getMessage());
	        }

	        return con;
	    }
	    
	    public static void closeConnection(Connection con, PreparedStatement ps,
             ResultSet rs) {
try {
if (rs != null) {
rs.close();
}
if (ps != null) {
ps.close();
}
if (con != null) {
con.close();
}
} catch (Exception e) {
System.out.println("WARNING:Error closing Connection ->" +
            e.getMessage());
}

}
public void closeConnection(Connection con, Statement ps,
                ResultSet rs) {
try {
if (rs != null) {
rs.close();
}
if (ps != null) {
ps.close();
}
if (con != null) {
con.close();
}
} catch (Exception e) {
System.out.println("WARNING:Error closing Connection ->" +
               e.getMessage());
}

}

public void closeConnection(Connection con, PreparedStatement ps) {
 try {
     if (ps != null) {
         ps.close();
     }
     if (con != null) {
         con.close();
     }
 } catch (Exception e) {
     System.out.println("WARNING:Error closing Connection ->" +
                        e.getMessage());
 }

}

}
