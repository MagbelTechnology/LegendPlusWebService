package com.magbel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.magbel.impl.ChartCreatorImpl;
import com.magbel.model.Chart;

public class ChartCreator implements ChartCreatorImpl {
	
	public List<Chart> getChart(String branchCode) {
		String Category_Code = "";
		String TotalCostPrice = "";
		List<Chart> list = new ArrayList<Chart>();
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
		    String sql = "select a.Category_code,SUM(cost_price) as TotalCostPrice from AM_ASSET a, \r\n" + 
		    		"am_ad_category c where a.category_code = c.category_code and substring(c.category_acronym,1,1) "
		    		+ "not in ('U','F') \r\n" + 
		    		"and asset_status='ACTIVE' and a.branch_Code = ? Group by a.Category_code";
		    con = getConnection("legendPlusService");
		    st = con.prepareStatement(sql);
		    st.setString(1, branchCode);
		    rs = st.executeQuery();
		    while (rs.next()) {
		        Chart chart = new Chart(Category_Code,TotalCostPrice);
		        chart.setCategory_Code(rs.getString("Category_Code"));
		        chart.setTotalCostPrice(rs.getString("TotalCostPrice"));
		        list.add(chart);

		    }
		}catch (Exception e){
		    e.getMessage();
		}
		finally {
			closeConnection(con, st, rs);
		}
		return list;
	}
	
	
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
